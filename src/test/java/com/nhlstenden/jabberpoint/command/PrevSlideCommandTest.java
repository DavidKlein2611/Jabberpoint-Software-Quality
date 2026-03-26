package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrevSlideCommandTest
{

    private Presentation presentation;
    private PrevSlideCommand command;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
        command = new PrevSlideCommand(presentation);
    }

    @Test
    public void testExecute_notAtBeginning_slideNumberDecreases()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(1);

        command.execute();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testExecute_atBeginning_slideNumberUnchanged()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        command.execute();

        assertEquals(0, presentation.getSlideNumber());
    }
}
