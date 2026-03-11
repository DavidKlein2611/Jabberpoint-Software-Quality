package com.nhlstenden.jabberpoint;

public class ExitCommand implements Command
{

    private final PresentationReceiver presentation;

    public ExitCommand(PresentationReceiver presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        presentation.exit(0);
    }
}
