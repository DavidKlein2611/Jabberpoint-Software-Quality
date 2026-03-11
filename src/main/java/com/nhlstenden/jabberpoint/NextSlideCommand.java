package com.nhlstenden.jabberpoint;

public class NextSlideCommand implements Command
{

    private final PresentationReceiver presentation;

    public NextSlideCommand(PresentationReceiver presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public void execute()
    {
        presentation.nextSlide();
    }
}
