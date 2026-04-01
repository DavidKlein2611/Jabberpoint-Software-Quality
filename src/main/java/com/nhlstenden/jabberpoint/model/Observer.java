package com.nhlstenden.jabberpoint.model;

/**
 * Toegepaste SOLID Principles via het Observer Pattern:
 * - Dependency Inversion Principle (DIP): Het Subject (Presentation) is
 * afhankelijk van deze abstractie (Observer), niet van concrete UI-componenten.
 * - Open/Closed Principle (OCP): We kunnen nieuwe Observers (views)
 * toevoegen zonder de Presentation-klasse te wijzigen.
 */
public interface Observer
{
    void update(Presentation presentation, Slide data);
}
