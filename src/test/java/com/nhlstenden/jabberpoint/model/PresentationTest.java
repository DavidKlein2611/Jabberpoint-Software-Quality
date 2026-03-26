package com.nhlstenden.jabberpoint.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PresentationTest
{

    private Presentation presentation;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
    }

    @Test
    public void testGetSize_emptyPresentation_0()
    {
        assertEquals(0, presentation.getSize());
    }

    @Test
    public void testGetSize_oneSlideAdded_1()
    {
        presentation.append(new Slide());
        assertEquals(1, presentation.getSize());
    }

    @Test
    public void testSetTitle_validString_titleSet()
    {
        String testTitle = "Test Title";
        presentation.setTitle(testTitle);
        assertEquals(testTitle, presentation.getTitle());
    }

    @Test
    public void testAddObserver_validObserver_observerNotifiedOnUpdate()
    {
        TestObserver observer = new TestObserver();
        presentation.addObserver(observer);

        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        assertTrue(observer.isUpdated());
    }

    @Test
    public void testRemoveObserver_validObserver_observerNotNotifiedOnUpdate()
    {
        TestObserver observer = new TestObserver();
        presentation.addObserver(observer);
        presentation.removeObserver(observer);

        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        assertFalse(observer.isUpdated());
    }

    @Test
    public void testSetSlideNumber_validNumber_numberSet()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());

        presentation.setSlideNumber(1);

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testPrevSlide_notAtBeginning_slideNumberDecreased()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(1);

        presentation.prevSlide();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testPrevSlide_atBeginning_slideNumberUnchanged()
    {
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        presentation.prevSlide();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testNextSlide_notAtEnd_slideNumberIncreased()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        presentation.nextSlide();

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testNextSlide_atEnd_slideNumberUnchanged()
    {
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        presentation.nextSlide();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testClear_existingPresentation_listEmptiedAndNumberReset()
    {
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        presentation.clear();

        assertEquals(0, presentation.getSize());
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testAppend_validSlide_slideAdded()
    {
        Slide slide = new Slide();
        presentation.append(slide);

        assertEquals(slide, presentation.getSlide(0));
    }

    @Test
    public void testGetSlide_validIndex_returnsSlide()
    {
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);

        assertEquals(slide2, presentation.getSlide(1));
    }

    @Test
    public void testGetSlide_negativeIndex_returnsNull()
    {
        presentation.append(new Slide());

        assertNull(presentation.getSlide(-1));
    }

    @Test
    public void testGetSlide_outOfBoundsIndex_returnsNull()
    {
        presentation.append(new Slide());

        assertNull(presentation.getSlide(1));
    }

    @Test
    public void testGetCurrentSlide_validState_returnsCurrentSlide()
    {
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);

        assertEquals(slide2, presentation.getCurrentSlide());
    }

    @Test
    public void testGetCurrentSlide_initialState_returnsNull()
    {
        assertNull(presentation.getCurrentSlide());
    }

    // Helper class to test observer functionality
    private static class TestObserver implements Observer
    {
        private boolean updated = false;

        @Override
        public void update(Presentation presentation, Slide slide)
        {
            updated = true;
        }

        public boolean isUpdated()
        {
            return updated;
        }
    }
}
