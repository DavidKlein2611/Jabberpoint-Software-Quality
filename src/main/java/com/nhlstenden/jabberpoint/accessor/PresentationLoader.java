package com.nhlstenden.jabberpoint.accessor;

import com.nhlstenden.jabberpoint.model.Presentation;
import java.io.IOException;

public interface PresentationLoader
{
    void loadFile(Presentation presentation, String filename) throws IOException;
}