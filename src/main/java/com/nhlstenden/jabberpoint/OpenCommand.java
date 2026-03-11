package com.nhlstenden.jabberpoint;

import javax.swing.*;
import java.io.IOException;

public class OpenCommand implements Command
{

    private final AccessorReceiver accessorReceiver;
    private final PresentationReceiver presentationReceiver;
    private final NavigationReceiver parent;

    public OpenCommand(
            AccessorReceiver accessorReceiver,
            NavigationReceiver parent
    )
    {
        this.accessorReceiver = accessorReceiver;
        this.presentationReceiver = (PresentationReceiver) accessorReceiver;
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        presentationReceiver.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try
        {
            xmlAccessor.loadFile(accessorReceiver, MenuController.TESTFILE);
            presentationReceiver.setSlideNumber(0);
        }
        catch (IOException exc)
        {
            JOptionPane.showMessageDialog(
                    null,
                    MenuController.IOEX + exc,
                    MenuController.LOADERR,
                    JOptionPane.ERROR_MESSAGE
            );
        }
        parent.repaint();
    }
}
