package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.controller.MenuController;
import com.nhlstenden.jabberpoint.model.Presentation;

import javax.swing.*;

public class GotoCommand implements Command
{
    private final Presentation presentation;

    public GotoCommand(Presentation p)
    {
        this.presentation = p;
    }

    @Override
    public void execute()
    {
        String pageNumberStr = JOptionPane.showInputDialog(MenuController.PAGENR);
        try
        {
            int pageNumber = Integer.parseInt(pageNumberStr);
            presentation.setSlideNumber(pageNumber - 1);
        }
        catch (NumberFormatException e)
        {
            // Ignore invalid input
        }
    }
}
