package com.nhlstenden.jabberpoint.accessor;

import com.nhlstenden.jabberpoint.model.BitmapItem;
import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import com.nhlstenden.jabberpoint.model.TextItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class XMLAccessorTest
{

    private XMLAccessor xmlAccessor;
    private Presentation presentation;
    private String tempFilePath;
    private String dtdFilePath;

    @BeforeEach
    public void setUp() throws IOException
    {
        xmlAccessor = new XMLAccessor();
        presentation = new Presentation();
        Path tempFile = Files.createTempFile("testPresentation", ".xml");
        tempFilePath = tempFile.toAbsolutePath().toString();
        File dtdFile = new File(
                tempFile.getParent().toFile(),
                "jabberpoint.dtd"
        );
        if (!dtdFile.exists())
        {
            dtdFile.createNewFile();
        }
        dtdFilePath = dtdFile.getAbsolutePath();
    }

    @AfterEach
    public void tearDown()
    {
        File file = new File(tempFilePath);
        if (file.exists())
        {
            file.delete();
        }
        if (dtdFilePath != null)
        {
            File dtd = new File(dtdFilePath);
            if (dtd.exists())
            {
                dtd.delete();
            }
        }
    }

    @Test
    public void testSaveFile_validPresentation_fileCreatedAndContainsData()
            throws IOException
    {
        presentation.setTitle("Test Title");
        Slide slide = new Slide();
        slide.setTitle("Slide Title");
        slide.append(new TextItem(1, "Text Item"));
        slide.append(new BitmapItem(2, "image.jpg"));
        presentation.append(slide);

        xmlAccessor.saveFile(presentation, tempFilePath);

        File file = new File(tempFilePath);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        String content = Files.readString(file.toPath());
        assertTrue(content.contains("<showtitle>Test Title</showtitle>"));
        assertTrue(content.contains("<title>Slide Title</title>"));
        assertTrue(
                content.contains("kind=\"text\" level=\"1\">Text Item</item>")
        );
        assertTrue(
                content.contains("kind=\"image\" level=\"2\">image.jpg</item>")
        );
    }

    @Test
    public void testLoadFile_invalidFile_throwsNoExceptionButFailsSilently()
    {
        // Asserting that it doesn't throw because the method catches IOException
        assertDoesNotThrow(() ->
        {
            xmlAccessor.loadFile(presentation, "nonexistent_file_xyz_123.xml");
        });
        assertEquals(0, presentation.getSize());
    }

    @Test
    public void testSaveAndLoadFile_roundTrip_presentationMaintainsState()
            throws IOException
    {
        // 1. Create and Save
        presentation.setTitle("Round Trip Presentation");
        Slide slide = new Slide();
        slide.setTitle("Round Trip Slide");
        slide.append(new TextItem(1, "Hello World"));
        presentation.append(slide);

        xmlAccessor.saveFile(presentation, tempFilePath);

        // 2. Load into a new presentation
        Presentation newPresentation = new Presentation();
        xmlAccessor.loadFile(newPresentation, tempFilePath);

        // 3. Verify
        assertEquals("Round Trip Presentation", newPresentation.getTitle());
        assertEquals(1, newPresentation.getSize());

        Slide loadedSlide = newPresentation.getSlide(0);
        assertEquals("Round Trip Slide", loadedSlide.getTitle());
        assertEquals(1, loadedSlide.getSize());

        assertInstanceOf(TextItem.class, loadedSlide.getSlideItem(0));
        TextItem loadedItem = (TextItem) loadedSlide.getSlideItem(0);
        assertEquals(1, loadedItem.getLevel());
        assertEquals("Hello World", loadedItem.getText());
    }
}
