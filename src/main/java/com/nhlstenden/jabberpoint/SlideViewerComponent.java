package com.nhlstenden.jabberpoint;

import javax.swing.*;
import java.awt.*;

/**
 * <p>SlideViewerComponent is een grafische component die Slides kan laten zien.</p>
 * <p>Deze klasse is verantwoordelijk voor twee dingen:</p>
 * <ol>
 *   <li>Het bijhouden van de huidige slide-state via de Observer interface.</li>
 *   <li>Het delegeren van alle tekenlogica naar SlideRenderer.</li>
 * </ol>
 * <p>De tekenlogica zelf is volledig verplaatst naar SlideRenderer, conform
 * het Single Responsibility Principle.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class SlideViewerComponent extends JComponent implements Observer
{

    private static final long serialVersionUID = 227L;
    private final JFrame frame;
    private final SlideRenderer slideRenderer;
    private Slide slide;
    private Presentation presentation;

    public SlideViewerComponent(Presentation pres, JFrame frame)
    {
        this.presentation = pres;
        this.frame = frame;
        this.slideRenderer = new SlideRenderer();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    @Override
    public void update(Presentation presentation, Slide data)
    {
        if (data == null)
        {
            repaint();
            return;
        }
        this.presentation = presentation;
        this.slide = data;
        frame.setTitle(presentation.getTitle());
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        slideRenderer.render(g, presentation, slide, getSize(), this);
    }
}
