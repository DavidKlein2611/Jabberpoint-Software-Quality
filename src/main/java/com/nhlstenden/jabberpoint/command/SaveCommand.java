package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.accessor.Savable;
import com.nhlstenden.jabberpoint.accessor.XMLAccessor;
import com.nhlstenden.jabberpoint.controller.MenuController;
import com.nhlstenden.jabberpoint.model.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveCommand implements Command
{

    private final Presentation presentation;
    private final Frame parent;

    public SaveCommand(Presentation p, Frame parent)
    {
        this.presentation = p;
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        Savable xmlAccessor = new XMLAccessor();
        try
        {
            xmlAccessor.saveFile(presentation, MenuController.SAVEFILE);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(
                    parent,
                    MenuController.IOEX + exc,
                    MenuController.SAVEERR,
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
