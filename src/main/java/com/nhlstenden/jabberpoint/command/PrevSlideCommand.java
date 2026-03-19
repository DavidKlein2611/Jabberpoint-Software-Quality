package com.nhlstenden.jabberpoint.command;

import com.nhlstenden.jabberpoint.model.Presentation;

public class PrevSlideCommand implements Command
{
    private final Presentation presentation;

    public PrevSlideCommand(Presentation p)
    {
        this.presentation = p;
    }

    @Override
    public void execute()
    {
        presentation.prevSlide();
    }
}
