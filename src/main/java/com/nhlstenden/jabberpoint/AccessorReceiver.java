package com.nhlstenden.jabberpoint;

/**
 * <p>AccessorReceiver is the receiver interface for the Accessor classes.</p>
 * <p>It abstracts the Presentation methods that Accessor subclasses need
 * when loading or saving a presentation, decoupling Accessor from the
 * concrete Presentation class.</p>
 */
public interface AccessorReceiver
{
    void append(Slide slide);

    String getTitle();

    void setTitle(String title);

    int getSize();

    Slide getSlide(int number);
}
