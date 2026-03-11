package com.nhlstenden.jabberpoint;

public class PrevSlideCommand implements Command
{

    private final PresentationReceiver presentation;

    public PrevSlideCommand(PresentationReceiver presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        presentation.prevSlide();
    }
}
