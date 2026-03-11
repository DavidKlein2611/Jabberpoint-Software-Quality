package com.nhlstenden.jabberpoint;

import java.awt.*;

/**
 * <p>De controller voor het menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar
{

    public static final String ABOUT = "About";
    public static final String FILE = "File";
    public static final String EXIT = "Exit";
    public static final String GOTO = "Go to";
    public static final String HELP = "Help";
    public static final String NEW = "New";
    public static final String NEXT = "Next";
    public static final String OPEN = "Open";
    public static final String PAGENR = "Page number?";
    public static final String PREV = "Prev";
    public static final String SAVE = "Save";
    public static final String VIEW = "View";
    public static final String TESTFILE = "test.xml";
    public static final String SAVEFILE = "dump.xml";
    public static final String IOEX = "IO Exception: ";
    public static final String LOADERR = "Load Error";
    public static final String SAVEERR = "Save Error";
    private static final long serialVersionUID = 227L;

    public MenuController(Frame frame, PresentationReceiver pres)
    {
        MenuItem menuItem;
        NavigationReceiver navigationReceiver = (NavigationReceiver) frame;

        Command openCommand = new OpenCommand(
                (AccessorReceiver) pres,
                navigationReceiver
        );
        Command newCommand = new NewCommand(pres, navigationReceiver);
        Command saveCommand = new SaveCommand(
                (AccessorReceiver) pres,
                navigationReceiver
        );
        Command exitCommand = new ExitCommand(pres);
        Command nextSlideCommand = new NextSlideCommand(pres);
        Command prevSlideCommand = new PrevSlideCommand(pres);
        Command gotoCommand = new GotoCommand(pres);
        Command aboutCommand = new AboutCommand(frame);

        Menu fileMenu = new Menu(FILE);

        fileMenu.add(menuItem = mkMenuItem(OPEN));
        menuItem.addActionListener(e -> openCommand.execute());

        fileMenu.add(menuItem = mkMenuItem(NEW));
        menuItem.addActionListener(e -> newCommand.execute());

        fileMenu.add(menuItem = mkMenuItem(SAVE));
        menuItem.addActionListener(e -> saveCommand.execute());

        fileMenu.addSeparator();

        fileMenu.add(menuItem = mkMenuItem(EXIT));
        menuItem.addActionListener(e -> exitCommand.execute());

        add(fileMenu);

        Menu viewMenu = new Menu(VIEW);

        viewMenu.add(menuItem = mkMenuItem(NEXT));
        menuItem.addActionListener(e -> nextSlideCommand.execute());

        viewMenu.add(menuItem = mkMenuItem(PREV));
        menuItem.addActionListener(e -> prevSlideCommand.execute());

        viewMenu.add(menuItem = mkMenuItem(GOTO));
        menuItem.addActionListener(e -> gotoCommand.execute());

        add(viewMenu);

        Menu helpMenu = new Menu(HELP);
        helpMenu.add(menuItem = mkMenuItem(ABOUT));
        menuItem.addActionListener(e -> aboutCommand.execute());

        setHelpMenu(helpMenu); // nodig for portability (Motif, etc.).
    }

    // een menu-item aanmaken
    public MenuItem mkMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
