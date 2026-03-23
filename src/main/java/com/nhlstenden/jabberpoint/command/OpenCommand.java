package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.accessor.PresentationLoader;
import com.nhlstenden.jabberpoint.controller.MenuController;
import com.nhlstenden.jabberpoint.model.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenCommand implements Command
{
    private final Presentation presentation;
    private final Frame parent;
    private final PresentationLoader loader;

    public OpenCommand(Presentation p, Frame parent, PresentationLoader loader)
    {
        this.presentation = p;
        this.parent = parent;
        this.loader = loader;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        try
        {
            loader.loadFile(presentation, MenuController.TESTFILE);
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
