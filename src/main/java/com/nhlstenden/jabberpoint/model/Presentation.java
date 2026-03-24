package com.nhlstenden.jabberpoint.model;

import java.util.ArrayList;

/**
 * <p>Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts een instantie van deze klasse aanwezig.</p>
 * <p>
 * Applied SOLID Principles:
 * - Single Responsibility Principle (SRP): Presentation handles only state management of slides,
 * delegating UI updates to Observers.
 * - Dependency Inversion Principle (DIP): Presentation depends on the Observer interface
 * rather than concrete UI components.
 * </p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation
{

    private final ArrayList<Observer> observers = new ArrayList<Observer>();
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;

    public Presentation()
    {
        clear();
    }

    public int getSize()
    {
        return showList.size();
    }

    public String getTitle()
    {
        return showTitle;
    }

    public void setTitle(String nt)
    {
        showTitle = nt;
    }

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    // geef het nummer van de huidige slide
    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    // verander het huidige-slide-nummer en laat het aan alle observers weten.
    public void setSlideNumber(int number)
    {
        currentSlideNumber = number;
        for (Observer observer : observers)
        {
            observer.update(this, getCurrentSlide());
        }
    }

    // ga naar de vorige slide tenzij je aan het begin van de presentatie bent
    public void prevSlide()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    // Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
    public void nextSlide()
    {
        if (currentSlideNumber < (showList.size() - 1))
        {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    // Verwijder de presentatie, om klaar te zijn voor de volgende
    public void clear()
    {
        showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    // Voeg een slide toe aan de presentatie
    public void append(Slide slide)
    {
        showList.add(slide);
    }

    // Geef een slide met een bepaald slidenummer
    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return showList.get(number);
    }

    // Geef de huidige Slide
    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    public void exit(int n)
    {
        System.exit(n);
    }
}
