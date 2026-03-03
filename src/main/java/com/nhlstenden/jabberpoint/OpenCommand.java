package com.nhlstenden.jabberpoint;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenCommand implements Command
{
    private final Presentation presentation;
    private final Frame parent;

    public OpenCommand(Presentation p, Frame parent)
    {
        this.presentation = p;
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try
        {
            xmlAccessor.loadFile(presentation, MenuController.TESTFILE);
            presentation.setSlideNumber(0);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(parent, MenuController.IOEX + exc,
                    MenuController.LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }
}
