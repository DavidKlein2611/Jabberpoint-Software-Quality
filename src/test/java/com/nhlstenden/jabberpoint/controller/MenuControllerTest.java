package com.nhlstenden.jabberpoint.controller;

import com.nhlstenden.jabberpoint.model.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MenuControllerTest
{

    private MenuController menuController;
    private Presentation presentation;
    private Frame frame;

    @BeforeEach
    public void setUp()
    {
        presentation = new Presentation();
        frame = new Frame();
        menuController = new MenuController(frame, presentation);
    }

    @Test
    public void testMkMenuItem_validString_returnsMenuItemWithShortcut()
    {
        String itemName = "TestItem";
        MenuItem menuItem = menuController.mkMenuItem(itemName);

        assertNotNull(menuItem);
        assertEquals(itemName, menuItem.getLabel());

        MenuShortcut shortcut = menuItem.getShortcut();
        assertNotNull(shortcut);
        assertEquals('T', shortcut.getKey());
    }

    @Test
    public void testConstructor_validInputs_menusAreAdded()
    {
        // MenuBar should contain 2 menus (File, View) plus Help menu which is set separately
        assertEquals(3, menuController.getMenuCount());

        assertEquals(MenuController.FILE, menuController.getMenu(0).getLabel());
        assertEquals(MenuController.VIEW, menuController.getMenu(1).getLabel());

        assertNotNull(menuController.getHelpMenu());
        assertEquals(
                MenuController.HELP,
                menuController.getHelpMenu().getLabel()
        );
    }
}
