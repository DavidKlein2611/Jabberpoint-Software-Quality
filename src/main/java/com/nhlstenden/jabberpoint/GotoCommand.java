package com.nhlstenden.jabberpoint;

import javax.swing.*;

public class GotoCommand implements Command
{

    private final PresentationReceiver presentation;

    public GotoCommand(PresentationReceiver presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        String pageNumberStr = JOptionPane.showInputDialog(
                MenuController.PAGENR
        );
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
