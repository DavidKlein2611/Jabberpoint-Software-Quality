package com.nhlstenden.jabberpoint.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class StyleTest
{

    @BeforeEach
    public void setUp()
    {
        // Ensure styles are created before each test that might rely on them
        Style.createStyles();
    }

    @Test
    public void testConstructor_validInputs_fieldsSetCorrectly()
    {
        Style style = new Style(10, Color.RED, 12, 14);
        assertEquals(10, style.indent);
        assertEquals(Color.RED, style.color);
        assertEquals(12, style.fontSize);
        assertEquals(14, style.leading);
        assertNotNull(style.font);
        assertEquals("Helvetica", style.font.getName());
        assertEquals(Font.BOLD, style.font.getStyle());
    }

    @Test
    public void testCreateStyles_whenCalled_stylesArrayInitialized()
    {
        Style.createStyles();
        assertNotNull(Style.getStyle(0));
        assertNotNull(Style.getStyle(4));
    }

    @Test
    public void testGetStyle_validLevel_returnsCorrectStyle()
    {
        Style style = Style.getStyle(1);
        assertEquals(20, style.indent);
        assertEquals(Color.blue, style.color);
        assertEquals(40, style.fontSize);
        assertEquals(10, style.leading);
    }

    @Test
    public void testGetStyle_levelTooHigh_returnsLastStyle()
    {
        Style expectedLastStyle = Style.getStyle(4);
        // Using a level higher than the array length (5)
        Style actualStyle = Style.getStyle(10);

        assertEquals(expectedLastStyle, actualStyle);
    }

    @Test
    public void testGetStyle_negativeLevel_throwsException()
    {
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        {
            Style.getStyle(-1);
        });
    }

    @Test
    public void testToString_validStyle_returnsFormattedString()
    {
        Style style = new Style(15, Color.BLACK, 12, 10);
        String expectedString = "[15,java.awt.Color[r=0,g=0,b=0]; 12 on 10]";

        assertEquals(expectedString, style.toString());
    }

    @Test
    public void testGetFont_validScale_returnsScaledFont()
    {
        Style style = new Style(0, Color.BLACK, 10, 10);
        Font scaledFont = style.getFont(2.5f);

        assertNotNull(scaledFont);
        assertEquals(25.0f, scaledFont.getSize2D());
    }
}
