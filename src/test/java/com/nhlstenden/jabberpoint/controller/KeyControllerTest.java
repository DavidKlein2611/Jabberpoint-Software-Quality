package com.nhlstenden.jabberpoint.controller;

import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyControllerTest
{

    private Presentation presentation;
    private KeyController keyController;
    private Component dummyComponent;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation()
        {
            @Override
            public void exit(int n)
            {
                // Override exit to prevent terminating the test suite
                setSlideNumber(-999);
            }
        };
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.append(new Slide());

        keyController = new KeyController(presentation);

        dummyComponent = new Component()
        {
        };
    }

    private void simulateKeyPress(int keyCode, char keyChar)
    {
        KeyEvent keyEvent = new KeyEvent(dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar);
        keyController.keyPressed(keyEvent);
    }

    @Test
    public void testKeyPressed_pageDown_nextSlide()
    {
        presentation.setSlideNumber(0);
        simulateKeyPress(KeyEvent.VK_PAGE_DOWN, KeyEvent.CHAR_UNDEFINED);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_down_nextSlide()
    {
        presentation.setSlideNumber(0);
        simulateKeyPress(KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_enter_nextSlide()
    {
        presentation.setSlideNumber(0);
        simulateKeyPress(KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_plusChar_nextSlide()
    {
        presentation.setSlideNumber(0);
        simulateKeyPress('+', '+');
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_pageUp_prevSlide()
    {
        presentation.setSlideNumber(2);
        simulateKeyPress(KeyEvent.VK_PAGE_UP, KeyEvent.CHAR_UNDEFINED);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_up_prevSlide()
    {
        presentation.setSlideNumber(2);
        simulateKeyPress(KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_minusChar_prevSlide()
    {
        presentation.setSlideNumber(2);
        simulateKeyPress('-', '-');
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_qChar_exit()
    {
        simulateKeyPress('q', 'q');
        assertEquals(-999, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_QChar_exit()
    {
        simulateKeyPress('Q', 'Q');
        assertEquals(-999, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressed_unmappedKey_noAction()
    {
        presentation.setSlideNumber(1);
        simulateKeyPress(KeyEvent.VK_A, 'a');
        assertEquals(1, presentation.getSlideNumber());
    }
}
