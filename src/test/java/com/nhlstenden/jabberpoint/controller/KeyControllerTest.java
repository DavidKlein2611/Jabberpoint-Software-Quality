package com.nhlstenden.jabberpoint.controller;

import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nhlstenden.jabberpoint.command.Command;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyControllerTest
{

    private Presentation presentation;
    private KeyController keyController;
    private Component dummyComponent;
    private boolean exitCommandExecuted = false;

    @BeforeEach
    public void setUp() throws Exception
    {
        presentation = new Presentation();
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.append(new Slide());

        keyController = new KeyController(presentation);

        // Vervang de exitCommand met een test double via reflection, om de JVM shutdown te voorkomen (SRP)
        Field exitCommandField = KeyController.class.getDeclaredField("exitCommand");
        exitCommandField.setAccessible(true);
        exitCommandField.set(keyController, (Command) () -> exitCommandExecuted = true);

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
        assertTrue(exitCommandExecuted);
    }

    @Test
    public void testKeyPressed_QChar_exit()
    {
        simulateKeyPress('Q', 'Q');
        assertTrue(exitCommandExecuted);
    }

    @Test
    public void testKeyPressed_unmappedKey_noAction()
    {
        presentation.setSlideNumber(1);
        simulateKeyPress(KeyEvent.VK_A, 'a');
        assertEquals(1, presentation.getSlideNumber());
    }
}
