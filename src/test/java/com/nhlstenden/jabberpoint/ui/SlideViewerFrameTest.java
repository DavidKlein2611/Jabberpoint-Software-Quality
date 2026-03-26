package com.nhlstenden.jabberpoint.ui;

import com.nhlstenden.jabberpoint.model.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class SlideViewerFrameTest
{

    private Presentation presentation;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
    }

    @Test
    public void testConstructor_validInputs_framePropertiesSet()
    {
        SlideViewerFrame frame = new SlideViewerFrame("Test Title", presentation);

        assertNotNull(frame);

        // The title passed in the constructor gets overwritten by JABTITLE in setupWindow()
        assertEquals("Jabberpoint 1.6 - OU", frame.getTitle());

        // Check if the size is set to the constants defined in the class
        assertEquals(new Dimension(SlideViewerFrame.WIDTH, SlideViewerFrame.HEIGHT), frame.getSize());

        // Check if the frame was made visible during setup
        assertTrue(frame.isVisible());

        // Check if KeyController and MenuController are initialized
        assertNotNull(frame.getKeyListeners());
        assertTrue(frame.getKeyListeners().length > 0);
        assertNotNull(frame.getMenuBar());

        // Cleanup the frame to avoid leaving floating windows during tests
        frame.dispose();
    }
}
