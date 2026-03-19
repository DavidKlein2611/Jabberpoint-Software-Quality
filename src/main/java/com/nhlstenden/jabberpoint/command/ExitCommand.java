package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;

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
