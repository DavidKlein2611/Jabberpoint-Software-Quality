package com.nhlstenden.jabberpoint;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * <p>SlideRenderer is verantwoordelijk voor het tekenen van een enkele Slide.</p>
 * <p>Deze klasse bevat uitsluitend tekenlogica en heeft geen kennis van
 * Swing-componenten, Observer-state of presentatienavigatie.
 * Dit volgt het Single Responsibility Principle: renderen is de enige reden
 * waarom deze klasse zou veranderen.</p>
 *
 * @author Refactored from SlideViewerComponent
 */
public class SlideRenderer
{

    private static final Color BGCOLOR = Color.white;
    private static final Color LABEL_COLOR = Color.black;
    private static final String FONTNAME = "Dialog";
    private static final int FONTSTYLE = Font.BOLD;
    private static final int FONTHEIGHT = 10;
    private static final int SLIDE_COUNTER_X = 1100;
    private static final int SLIDE_COUNTER_Y = 20;

    private final Font labelFont;

    public SlideRenderer()
    {
        this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
    }

    /**
     * Renders the background, slide counter and slide content into the given
     * Graphics context.
     *
     * @param g            the Graphics context to draw into
     * @param presentation the current presentation, used for slide number and size
     * @param slide        the slide to render, may be null
     * @param size         the available drawing area (width and height)
     * @param observer     the ImageObserver used for image rendering in slide items
     */
    public void render(
            Graphics g,
            Presentation presentation,
            Slide slide,
            Dimension size,
            ImageObserver observer
    )
    {
        drawBackground(g, size);

        if (presentation.getSlideNumber() < 0 || slide == null)
        {
            return;
        }

        drawSlideCounter(g, presentation);
        drawSlide(g, slide, size, observer);
    }

    private void drawBackground(Graphics g, Dimension size)
    {
        g.setColor(BGCOLOR);
        g.fillRect(0, 0, size.width, size.height);
    }

    private void drawSlideCounter(Graphics g, Presentation presentation)
    {
        g.setFont(labelFont);
        g.setColor(LABEL_COLOR);
        g.drawString(
                "Slide " +
                        (1 + presentation.getSlideNumber()) +
                        " of " +
                        presentation.getSize(),
                SLIDE_COUNTER_X,
                SLIDE_COUNTER_Y
        );
    }

    private void drawSlide(
            Graphics g,
            Slide slide,
            Dimension size,
            ImageObserver observer
    )
    {
        Rectangle area = new Rectangle(
                0,
                SLIDE_COUNTER_Y,
                size.width,
                size.height - SLIDE_COUNTER_Y
        );
        slide.draw(g, area, observer);
    }
}
