package com.nhlstenden.jabberpoint.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextItemTest
{
    @Test
    public void testConstructor_noArguments_defaultValuesSet()
    {
        TextItem item = new TextItem();
        assertEquals(0, item.getLevel());
        assertEquals("No Text Given", item.getText());
    }

    @Test
    public void testConstructor_withArguments_valuesSet()
    {
        TextItem item = new TextItem(2, "Test String");
        assertEquals(2, item.getLevel());
        assertEquals("Test String", item.getText());
    }

    @Test
    public void testGetText_nullText_returnsEmptyString()
    {
        TextItem item = new TextItem(1, null);
        assertEquals("", item.getText());
    }

    @Test
    public void testGetText_validText_returnsText()
    {
        TextItem item = new TextItem(1, "Valid Text");
        assertEquals("Valid Text", item.getText());
    }

    @Test
    public void testToString_validItem_returnsFormattedString()
    {
        TextItem item = new TextItem(3, "ToString Test");
        assertEquals("TextItem[3,ToString Test]", item.toString());
    }

    @Test
    public void testDraw_emptyText_doesNothing()
    {
        TextItem item = new TextItem(1, "");
        // Should not throw any exception even with null graphics and style
        assertDoesNotThrow(() ->
        {
            item.draw(0, 0, 1.0f, null, null, null);
        });
    }

    @Test
    public void testDraw_nullText_doesNothing()
    {
        TextItem item = new TextItem(1, null);
        // Should not throw any exception even with null graphics and style
        assertDoesNotThrow(() ->
        {
            item.draw(0, 0, 1.0f, null, null, null);
        });
    }
}
