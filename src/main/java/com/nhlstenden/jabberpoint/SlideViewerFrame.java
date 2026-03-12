package com.nhlstenden.jabberpoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>Het applicatiewindow voor een slideviewcomponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerFrame extends JFrame
{

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    private static final long serialVersionUID = 3227L;
    private static final String JABTITLE = "Jabberpoint 1.6 - OU";

    public SlideViewerFrame(String title, Presentation presentation)
    {
        super(title);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(
                presentation,
                this
        );
        presentation.addObserver(slideViewerComponent);
        setupWindow(slideViewerComponent, presentation);
    }

    // De GUI opzetten
    public void setupWindow(
            SlideViewerComponent slideViewerComponent,
            Presentation presentation
    )
    {
        setTitle(JABTITLE);
        addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
                }
        );
        getContentPane().add(slideViewerComponent);
        addKeyListener(new KeyController(presentation));
        setMenuBar(new MenuController(this, presentation));
        setSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
    }
}
