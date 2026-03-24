package com.nhlstenden.jabberpoint.accessor;

import com.nhlstenden.jabberpoint.model.Presentation;

import java.io.IOException;

/**
 * Interface for saving presentation data.
 * Applied SOLID Principle: Interface Segregation Principle (ISP)
 * By separating Loadable and Savable, classes like DemoPresentation
 * do not need to implement save logic that they don't support.
 */
public interface Savable
{
    void saveFile(Presentation p, String fn) throws IOException;
}
