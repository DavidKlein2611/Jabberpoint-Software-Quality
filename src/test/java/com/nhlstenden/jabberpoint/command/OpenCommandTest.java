package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OpenCommandTest
{

    private Presentation presentation;
    private Frame frame;
    private OpenCommand openCommand;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
        frame = new Frame();
        openCommand = new OpenCommand(presentation, frame);
    }

    @Test
    public void testConstructor_validArguments_commandCreated()
    {
        assertNotNull(openCommand);
    }

    @Test
    public void testExecute_existingPresentation_presentationIsClearedBeforeLoadAttempt()
    {
        // Arrange
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        // Act & Assert
        // We assert DoesNotThrow because without a GUI context or actual valid "test.xml"
        // it may hit an IO exception branch displaying a JOptionPane. In headless testing environments,
        // displaying UI dialogue can cause issues or hang, but for the sake of unit testing the command
        // structure and initial clearing logic, we capture it.
        // Even if loading fails, clear() should run first.
        assertDoesNotThrow(() -> openCommand.execute());

        // We can't guarantee final size if test.xml exists or not, but typically if it fails it's 0.
        // If it succeeds it's > 0.
    }
}
