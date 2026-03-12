package com.nhlstenden.jabberpoint;

public class ExitCommand implements Command
{
    private final Presentation presentation;

    public ExitCommand(Presentation p)
    {
        this.presentation = p;
    }

    @Override
    public void execute()
    {
        presentation.exit(0);
    }
}
