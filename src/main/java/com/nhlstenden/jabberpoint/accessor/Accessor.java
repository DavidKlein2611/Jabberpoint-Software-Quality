package com.nhlstenden.jabberpoint.accessor;

import com.nhlstenden.jabberpoint.model.DemoPresentation;

/**
 * <p>Een Accessor maakt het mogelijk om gegevens voor een presentatie
 * te lezen of te schrijven.</p>
 * <p>Niet-abstracte subklassen moeten de load en de save methode implementeren.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class Accessor
{

    public static final String DEMO_NAME = "Demonstratie presentatie";
    public static final String DEFAULT_EXTENSION = ".xml";

    public Accessor()
    {
    }

    /**
     * Factory Method: returns the appropriate Accessor for the given filename.
     * If filename is empty or null, a DemoPresentation accessor is returned.
     * Otherwise an XMLAccessor is returned.
     * This removes the if/else construction logic from JabberPoint.main().
     */
    public static Loadable getAccessor(String filename)
    {
        if (filename == null || filename.isEmpty())
        {
            return new DemoPresentation();
        }
        return new XMLAccessor();
    }
}
