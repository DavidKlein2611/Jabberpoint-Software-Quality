package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitCommandTest
{

    private Presentation presentation;
    private ExitCommand command;
    private int exitStatus = -1;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
        command = new ExitCommand(presentation)
        {
            @Override
            protected void systemExit(int status)
            {
                exitStatus = status;
            }
        };
    }

    @Test
    public void testExecute_called_systemExitInvoked()
    {
        command.execute();

        assertEquals(0, exitStatus);
    }
}
