package com.nhlstenden.jabberpoint.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DemoPresentationTest
{

    private DemoPresentation demoPresentation;
    private Presentation presentation;

    @BeforeEach
    public void setUp()
    {
        demoPresentation = new DemoPresentation();
        presentation = new Presentation();
    }

    @Test
    public void testLoadFile_validPresentation_titleSet()
    {
        demoPresentation.loadFile(presentation, "unused");
        assertEquals("Demo Presentation", presentation.getTitle());
    }

    @Test
    public void testLoadFile_validPresentation_slidesAdded()
    {
        demoPresentation.loadFile(presentation, "unused");
        assertEquals(3, presentation.getSize());
    }

    @Test
    public void testLoadFile_validPresentation_firstSlideContentCorrect()
    {
        demoPresentation.loadFile(presentation, "");
        Slide firstSlide = presentation.getSlide(0);

        assertNotNull(firstSlide);
        assertEquals("JabberPoint", firstSlide.getTitle());
        assertEquals(10, firstSlide.getSize());
        assertInstanceOf(TextItem.class, firstSlide.getSlideItem(0));
    }

    @Test
    public void testLoadFile_validPresentation_thirdSlideContainsBitmap()
    {
        demoPresentation.loadFile(presentation, null);
        Slide thirdSlide = presentation.getSlide(2);

        assertNotNull(thirdSlide);
        assertEquals("De derde slide", thirdSlide.getTitle());
        assertEquals(5, thirdSlide.getSize());
        assertInstanceOf(BitmapItem.class, thirdSlide.getSlideItem(4));
        BitmapItem bitmapItem = (BitmapItem) thirdSlide.getSlideItem(4);
        assertEquals("JabberPoint.jpg", bitmapItem.getName());
    }
}
