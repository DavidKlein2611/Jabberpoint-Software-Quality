package com.nhlstenden.jabberpoint;

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
