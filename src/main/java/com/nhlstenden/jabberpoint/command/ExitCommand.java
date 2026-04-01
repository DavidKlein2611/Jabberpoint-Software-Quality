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
        /**
         * System.exit() direct wordt aangeroepen vanuit het ExitCommand, omdat
         * de levenscyclus van de applicatie niet de verantwoordelijkheid van de Presentation is (SRP).
         */
        systemExit(0);
    }

    protected void systemExit(int status)
    {
        System.exit(status);
    }
}
