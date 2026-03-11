package com.nhlstenden.jabberpoint;

public class NewCommand implements Command
{

    private final PresentationReceiver presentation;
    private final NavigationReceiver parent;

    public NewCommand(
            PresentationReceiver presentation,
            NavigationReceiver parent
    )
    {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        parent.repaint();
    }
}
