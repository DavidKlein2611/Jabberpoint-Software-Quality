package com.nhlstenden.jabberpoint;

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
