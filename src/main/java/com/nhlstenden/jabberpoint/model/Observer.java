package com.nhlstenden.jabberpoint.model;

/**
 * Applied SOLID Principles via the Observer Pattern:
 * - Dependency Inversion Principle (DIP): The Subject (Presentation) depends on this abstraction (Observer), not on concrete UI components.
 * - Open/Closed Principle (OCP): We can add new Observers (views) without changing the Presentation class.
 */
public interface Observer
{
    void update(Presentation presentation, Slide data);
}
