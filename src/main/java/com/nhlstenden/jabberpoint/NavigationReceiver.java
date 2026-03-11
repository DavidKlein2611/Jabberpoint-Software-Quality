package com.nhlstenden.jabberpoint;

/**
 * <p>NavigationReceiver is a receiver interface for the Command pattern.</p>
 * <p>It abstracts the repaint operation used by commands that need to
 * trigger a visual refresh of the application window, decoupling those
 * commands from the concrete Frame class.</p>
 */
public interface NavigationReceiver
{
    void repaint();
}
