package com.nhlstenden.jabberpoint.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AboutCommandTest
{

    private Frame frame;
    private AboutCommand aboutCommand;

    @BeforeEach
    public void setUp()
    {
        frame = new Frame();
        aboutCommand = new AboutCommand(frame);
    }

    @Test
    public void testConstructor_validFrame_commandCreated()
    {
        assertNotNull(aboutCommand);
    }
}
