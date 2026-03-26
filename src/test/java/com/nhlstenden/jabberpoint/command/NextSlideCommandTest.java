package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextSlideCommandTest
{

    private Presentation presentation;
    private NextSlideCommand command;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
        command = new NextSlideCommand(presentation);
    }

    @Test
    public void testExecute_notAtEnd_slideNumberIncreases()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        command.execute();

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testExecute_atEnd_slideNumberUnchanged()
    {
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        command.execute();

        assertEquals(0, presentation.getSlideNumber());
    }
}
