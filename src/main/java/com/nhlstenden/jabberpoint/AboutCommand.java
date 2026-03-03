package com.nhlstenden.jabberpoint;

import java.awt.*;

public class AboutCommand implements Command
{
    private final Frame parent;

    public AboutCommand(Frame parent)
    {
        this.parent = parent;
    }

    @Override
    public void execute()
    {
        AboutBox.show(parent);
    }
}
