package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;

public class NextSlideCommand implements Command
{
    private final Presentation presentation;

    public NextSlideCommand(Presentation p)
    {
        this.presentation = p;
    }

    @Override
    public void execute()
    {
        presentation.nextSlide();
    }
}
