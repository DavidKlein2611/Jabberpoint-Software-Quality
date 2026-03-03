package com.nhlstenden.jabberpoint;

import java.awt.*;

public class NewCommand implements Command
{
    private final Presentation presentation;
    private final Frame parent;

    public NewCommand(Presentation p, Frame parent)
    {
        this.presentation = p;
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        presentation.clear();
        parent.repaint();
    }
}
