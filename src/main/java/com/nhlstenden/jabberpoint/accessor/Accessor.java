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
     * Factory Method: geeft de juiste Accessor terug voor de opgegeven bestandsnaam.
     * Als de bestandsnaam leeg of null is, wordt er een DemoPresentation accessor teruggegeven.
     * Anders wordt er een XMLAccessor teruggegeven.
     * Dit verwijdert de if/else-constructielogica uit JabberPoint.main().
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
