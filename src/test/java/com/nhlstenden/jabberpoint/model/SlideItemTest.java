package com.nhlstenden.jabberpoint.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlideItemTest
{

    @Test
    public void testConstructor_noArguments_levelIsZero()
    {
        DummySlideItem item = new DummySlideItem();
        assertEquals(0, item.getLevel());
    }

    @Test
    public void testConstructor_withArgument_levelIsSet()
    {
        DummySlideItem item = new DummySlideItem(3);
        assertEquals(3, item.getLevel());
    }

    @Test
    public void testGetLevel_validLevel_returnsLevel()
    {
        DummySlideItem item = new DummySlideItem(5);
        assertEquals(5, item.getLevel());
    }

    // Concrete dummy implementation to test the abstract SlideItem class
    private static class DummySlideItem extends SlideItem
    {
        public DummySlideItem()
        {
            super();
        }

        public DummySlideItem(int level)
        {
            super(level);
        }

        @Override
        public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style)
        {
            return new Rectangle(0, 0, 0, 0);
        }

        @Override
        public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
        {
            // Do nothing
        }
    }
}
