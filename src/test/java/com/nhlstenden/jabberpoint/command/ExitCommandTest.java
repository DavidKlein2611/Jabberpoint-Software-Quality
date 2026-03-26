package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitCommandTest
{

    private Presentation presentation;
    private ExitCommand command;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation()
        {
            @Override
            public void exit(int n)
            {
                // Prevent JVM exit and mark that it was called
                setSlideNumber(-999);
            }
        };
        command = new ExitCommand(presentation);
    }

    @Test
    public void testExecute_called_presentationExitInvoked()
    {
        presentation.setSlideNumber(0);

        command.execute();

        assertEquals(-999, presentation.getSlideNumber());
    }
}
