package com.nhlstenden.jabberpoint.controller;

import com.nhlstenden.jabberpoint.command.Command;
import com.nhlstenden.jabberpoint.command.ExitCommand;
import com.nhlstenden.jabberpoint.command.NextSlideCommand;
import com.nhlstenden.jabberpoint.command.PrevSlideCommand;
import com.nhlstenden.jabberpoint.model.Presentation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <p>This is the KeyController (KeyListener)</p>
 * <p>
 * Applied SOLID Principles via the Command Pattern:
 * - Single Responsibility Principle (SRP): KeyController only handles mapping user input to Commands,
 * rather than executing the presentation logic.
 * - Open/Closed Principle (OCP): New input mappings and commands can be added without modifying the
 * core presentation framework.
 * </p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter
{

    private final Command nextSlideCommand;
    private final Command prevSlideCommand;
    private final Command exitCommand;

    public KeyController(Presentation p)
    {
        nextSlideCommand = new NextSlideCommand(p);
        prevSlideCommand = new PrevSlideCommand(p);
        exitCommand = new ExitCommand(p);
    }

    public void keyPressed(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                nextSlideCommand.execute();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                prevSlideCommand.execute();
                break;
            case 'q':
            case 'Q':
                exitCommand.execute();
                break;
            default:
                break;
        }
    }
}
