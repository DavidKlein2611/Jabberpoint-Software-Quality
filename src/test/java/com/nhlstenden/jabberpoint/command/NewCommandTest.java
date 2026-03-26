package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;
import com.nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewCommandTest
{

    private Presentation presentation;
    private Frame frame;
    private NewCommand newCommand;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
        frame = new Frame();
        newCommand = new NewCommand(presentation, frame);
    }

    @Test
    public void testExecute_existingPresentation_presentationIsCleared()
    {
        // Arrange
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        // Act
        newCommand.execute();

        // Assert
        assertEquals(0, presentation.getSize());
        assertEquals(-1, presentation.getSlideNumber());
    }
}
