package com.nhlstenden.jabberpoint.ui;

import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class SlideViewerComponentTest
{

    private Presentation presentation;
    private JFrame frame;
    private SlideViewerComponent slideViewerComponent;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
        frame = new JFrame();
        slideViewerComponent = new SlideViewerComponent(presentation, frame);
    }

    @Test
    public void testGetPreferredSize_returnsSlideWidthAndHeight()
    {
        Dimension preferredSize = slideViewerComponent.getPreferredSize();
        assertNotNull(preferredSize);
        assertEquals(1200, preferredSize.width); // Slide.WIDTH
        assertEquals(800, preferredSize.height); // Slide.HEIGHT
    }

    @Test
    public void testUpdate_nullSlide_doesNotThrowException()
    {
        assertDoesNotThrow(() ->
        {
            slideViewerComponent.update(presentation, null);
        });
    }

    @Test
    public void testUpdate_validSlide_updatesFrameTitle()
    {
        presentation.setTitle("Test Presentation Title");
        Slide slide = new Slide();
        slide.setTitle("Slide Title");

        slideViewerComponent.update(presentation, slide);

        assertEquals("Test Presentation Title", frame.getTitle());
    }
}
