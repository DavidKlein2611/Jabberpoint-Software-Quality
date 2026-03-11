package com.nhlstenden.jabberpoint;

import javax.swing.*;
import java.io.IOException;

public class SaveCommand implements Command
{

    private final AccessorReceiver presentation;
    private final NavigationReceiver parent;

    public SaveCommand(
            AccessorReceiver presentation,
            NavigationReceiver parent
    )
    {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        Accessor xmlAccessor = new XMLAccessor();
        try
        {
            xmlAccessor.saveFile(presentation, MenuController.SAVEFILE);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(
                    null,
                    MenuController.IOEX + exc,
                    MenuController.SAVEERR,
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
