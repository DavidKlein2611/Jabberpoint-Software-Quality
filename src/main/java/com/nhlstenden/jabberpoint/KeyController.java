package com.nhlstenden.jabberpoint;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <p>This is the KeyController (KeyListener)</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter
{

    private final Command nextSlideCommand;
    private final Command prevSlideCommand;
    private final Command exitCommand;

    public KeyController(PresentationReceiver presentation)
    {
        nextSlideCommand = new NextSlideCommand(presentation);
        prevSlideCommand = new PrevSlideCommand(presentation);
        exitCommand = new ExitCommand(presentation);
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
