package com.nhlstenden.jabberpoint.model;

import java.awt.*;
import java.awt.image.ImageObserver;

public class SlideRenderer
{
    public void draw(Slide slide, Graphics g, Rectangle area, ImageObserver view)
    {
        float scale = getScale(area);
        int y = area.y;

        // titel tekenen
        SlideItem slideItem = new TextItem(0, slide.getTitle());
        Style style = Style.getStyle(slideItem.getLevel());

        slideItem.draw(area.x, y, scale, g, style, view);

        y += slideItem.getBoundingBox(g, view, scale, style).height;

        for (int number = 0; number < slide.getSize(); number++)
        {
            slideItem = slide.getSlideItems().elementAt(number);
            style = Style.getStyle(slideItem.getLevel());

            slideItem.draw(area.x, y, scale, g, style, view);

            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    // geef de schaal om de slide te kunnen tekenen
    private float getScale(Rectangle area)
    {
        return Math.min(
                ((float) area.width) / ((float) Slide.WIDTH),
                ((float) area.height) / ((float) Slide.HEIGHT)
        );
    }
}