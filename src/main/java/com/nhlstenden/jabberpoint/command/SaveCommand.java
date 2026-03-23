package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.accessor.PresentationSaver;
import com.nhlstenden.jabberpoint.controller.MenuController;
import com.nhlstenden.jabberpoint.model.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveCommand implements Command
{
    private final Presentation presentation;
    private final Frame parent;
    private final PresentationSaver saver;

    public SaveCommand(Presentation p, Frame parent, PresentationSaver saver)
    {
        this.presentation = p;
        this.parent = parent;
        this.saver = saver;
    }

    @Override
    public void execute()
    {
        try
        {
            saver.saveFile(presentation, MenuController.SAVEFILE);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(parent, MenuController.IOEX + exc,
                    MenuController.SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
