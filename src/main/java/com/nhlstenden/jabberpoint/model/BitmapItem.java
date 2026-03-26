package com.nhlstenden.jabberpoint.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items hebben de verantwoordelijkheid om zichzelf te tekenen.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class BitmapItem extends SlideItem
{

    protected static final String FILE = "Bestand ";
    protected static final String NOTFOUND = " niet gevonden";
    private final String imageName;
    private BufferedImage bufferedImage;

    // level staat voor het item-level; name voor de naam van het bestand met de afbeelding
    public BitmapItem(int level, String name)
    {
        super(level);
        imageName = name;
        try
        {
            File file = new File(imageName);
            if (file.exists())
            {
                bufferedImage = ImageIO.read(file);
            }
            else
            {
                java.io.InputStream is = getClass()
                        .getClassLoader()
                        .getResourceAsStream(imageName);
                if (is != null)
                {
                    bufferedImage = ImageIO.read(is);
                }
                else
                {
                    System.err.println(FILE + imageName + NOTFOUND);
                }
            }
        }
        catch (IOException e)
        {
            System.err.println(FILE + imageName + NOTFOUND);
        }
    }

    // Een leeg bitmap-item
    public BitmapItem()
    {
        this(0, null);
    }

    // geef de bestandsnaam van de afbeelding
    public String getName()
    {
        return imageName;
    }

    // geef de bounding box van de afbeelding
    public Rectangle getBoundingBox(
            Graphics g,
            ImageObserver observer,
            float scale,
            Style myStyle
    )
    {
        if (bufferedImage == null)
        {
            return new Rectangle((int) (myStyle.indent * scale), 0, 0, 0);
        }
        return new Rectangle(
                (int) (myStyle.indent * scale),
                0,
                (int) (bufferedImage.getWidth(observer) * scale),
                ((int) (myStyle.leading * scale)) +
                        (int) (bufferedImage.getHeight(observer) * scale)
        );
    }

    // teken de afbeelding
    public void draw(
            int x,
            int y,
            float scale,
            Graphics g,
            Style myStyle,
            ImageObserver observer
    )
    {
        if (bufferedImage == null)
        {
            return;
        }
        int width = x + (int) (myStyle.indent * scale);
        int height = y + (int) (myStyle.leading * scale);
        g.drawImage(
                bufferedImage,
                width,
                height,
                (int) (bufferedImage.getWidth(observer) * scale),
                (int) (bufferedImage.getHeight(observer) * scale),
                observer
        );
    }

    public String toString()
    {
        return "BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}
