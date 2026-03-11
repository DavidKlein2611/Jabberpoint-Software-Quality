package com.nhlstenden.jabberpoint;

/**
 * <p>PresentationReceiver is the receiver interface for the Command pattern.</p>
 * <p>It abstracts all presentation navigation and lifecycle operations
 * that commands need to invoke, decoupling commands from the concrete
 * Presentation class.</p>
 */
public interface PresentationReceiver
{
    void nextSlide();

    void prevSlide();

    void setSlideNumber(int number);

    void clear();

    void exit(int status);
}
