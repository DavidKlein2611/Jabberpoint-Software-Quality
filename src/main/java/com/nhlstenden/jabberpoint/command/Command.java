package com.nhlstenden.jabberpoint.command;

/**
 * Applied SOLID Principles via the Command Pattern:
 * - Single Responsibility Principle (SRP): Each implementation of Command only handles the execution of one specific action.
 * - Open/Closed Principle (OCP): We can add new Commands to the application without modifying existing command-handling code.
 */
public interface Command
{
    void execute();
}
