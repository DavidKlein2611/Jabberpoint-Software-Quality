package com.nhlstenden.jabberpoint.accessor;

import com.nhlstenden.jabberpoint.model.Presentation;

import java.io.IOException;

/**
 * Interface voor het opslaan van presentatiegegevens.
 * Toegepast SOLID Principle: Interface Segregation Principle (ISP)
 * Door Loadable en Savable te scheiden, hoeven klassen zoals DemoPresentation
 * geen opslaglogica te implementeren die ze niet ondersteunen.
 */
public interface Savable
{
    void saveFile(Presentation p, String fn) throws IOException;
}
