package com.nhlstenden.jabberpoint.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class SlideTest
{

    private Slide slide;

    @BeforeEach
    public void setUp()
    {
        slide = new Slide();
    }

    @Test
    public void testGetTitle_initialState_returnsNull()
    {
        assertNull(slide.getTitle());
    }

    @Test
    public void testSetTitle_validString_titleSet()
    {
        String testTitle = "Test Title";
        slide.setTitle(testTitle);
        assertEquals(testTitle, slide.getTitle());
    }

    @Test
    public void testAppend_slideItem_itemAdded()
    {
        SlideItem item = new TextItem(1, "Test Item");
        slide.append(item);

        assertEquals(1, slide.getSize());
        assertEquals(item, slide.getSlideItem(0));
    }

    @Test
    public void testAppend_levelAndMessage_textItemAdded()
    {
        slide.append(2, "Test Message");

        assertEquals(1, slide.getSize());
        assertInstanceOf(TextItem.class, slide.getSlideItem(0));
        TextItem addedItem = (TextItem) slide.getSlideItem(0);
        assertEquals(2, addedItem.getLevel());
        assertEquals("Test Message", addedItem.getText());
    }

    @Test
    public void testGetSlideItem_validIndex_returnsItem()
    {
        SlideItem item1 = new TextItem(1, "Item 1");
        SlideItem item2 = new TextItem(2, "Item 2");
        slide.append(item1);
        slide.append(item2);

        assertEquals(item2, slide.getSlideItem(1));
    }

    @Test
    public void testGetSlideItem_invalidIndex_throwsException()
    {
        slide.append(new TextItem(1, "Item"));

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        {
            slide.getSlideItem(5);
        });
    }

    @Test
    public void testGetSlideItems_validState_returnsVector()
    {
        SlideItem item = new TextItem(1, "Item 1");
        slide.append(item);

        Vector<SlideItem> items = slide.getSlideItems();
        assertEquals(1, items.size());
        assertTrue(items.contains(item));
    }

    @Test
    public void testGetSize_emptySlide_returnsZero()
    {
        assertEquals(0, slide.getSize());
    }

    @Test
    public void testGetSize_slideWithItems_returnsCount()
    {
        slide.append(new TextItem(1, "Item 1"));
        slide.append(new TextItem(2, "Item 2"));

        assertEquals(2, slide.getSize());
    }

    @Test
    public void testDraw_validGraphicsAndArea_executesWithoutError()
    {
        // Create a dummy graphics context and area to test the draw method
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        Rectangle area = new Rectangle(0, 0, 800, 600);

        // Style needs to be initialized for TextItem to not throw an NPE
        Style.createStyles();

        slide.setTitle("Slide Title");
        slide.append(1, "Bullet Point 1");

        // The image observer is typically a Component, null is often safe for simple graphics operations
        assertDoesNotThrow(() ->
        {
            slide.draw(graphics, area, null);
        });
    }
}
