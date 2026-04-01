package com.nhlstenden.jabberpoint.command;

/**
 * Toegepaste SOLID Principles via het Command Pattern:
 * - Single Responsibility Principle (SRP): Elke implementatie van Command behandelt
 * alleen de uitvoering van één specifieke actie.
 * - Open/Closed Principle (OCP): We kunnen nieuwe Commands aan de applicatie
 * toevoegen zonder bestaande code voor het afhandelen van commando's te wijzigen.
 */
public interface Command
{
    void execute();
}
