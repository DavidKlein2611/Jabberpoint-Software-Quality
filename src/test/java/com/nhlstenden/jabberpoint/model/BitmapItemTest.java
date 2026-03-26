package com.nhlstenden.jabberpoint.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class BitmapItemTest
{
    @Test
    public void testConstructor_noArguments_throwsNullPointerException()
    {
        assertThrows(NullPointerException.class, () ->
        {
            new BitmapItem();
        });
    }

    @Test
    public void testConstructor_invalidImageName_imageIsNullAndNoExceptionThrown()
    {
        // Uses a non-existent file to hit the null/exception branches
        assertDoesNotThrow(() ->
        {
            BitmapItem item = new BitmapItem(1, "nonexistent_image.png");
            assertEquals(1, item.getLevel());
            assertEquals("nonexistent_image.png", item.getName());
        });
    }

    @Test
    public void testGetName_validName_returnsName()
    {
        String testName = "test_image.jpg";
        BitmapItem item = new BitmapItem(2, testName);
        assertEquals(testName, item.getName());
    }

    @Test
    public void testGetBoundingBox_nullImage_returnsZeroSizeRectangle()
    {
        BitmapItem item = new BitmapItem(1, "nonexistent_image.png");
        Style style = new Style(10, Color.BLACK, 12, 14);

        Rectangle bounds = item.getBoundingBox(null, null, 2.0f, style);

        assertNotNull(bounds);
        assertEquals(20, bounds.x); // indent(10) * scale(2.0f)
        assertEquals(0, bounds.y);
        assertEquals(0, bounds.width);
        assertEquals(0, bounds.height);
    }

    @Test
    public void testDraw_nullImage_doesNothingAndThrowsNoExceptions()
    {
        BitmapItem item = new BitmapItem(1, "nonexistent_image.png");
        Style style = new Style(10, Color.BLACK, 12, 14);

        // Even with null graphics and observer, draw should immediately return due to null bufferedImage
        assertDoesNotThrow(() ->
        {
            item.draw(0, 0, 1.0f, null, style, null);
        });
    }

    @Test
    public void testToString_validItem_returnsFormattedString()
    {
        BitmapItem item = new BitmapItem(3, "image.png");
        String expectedString = "BitmapItem[3,image.png]";

        assertEquals(expectedString, item.toString());
    }
}
