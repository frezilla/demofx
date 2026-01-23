package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public final class Circle implements Drawing {
    
    private final Ellipse ellipse;
    
    public Circle(int x, int y, int r) {
        this(x, y, r, Color.BLACK, 0);
    }
    
    public Circle(int x, int y, int r, Color color) {
        this(x, y, r, color, 0);
    }
    
    public Circle(int x, int y, int r, Color color, int zIndex) {
        this.ellipse = new Ellipse(x, y, r, r, color, zIndex);
    }

    @Override
    public void draw(GContext gContext) {
        ellipse.draw(gContext);
    }

    @Override
    public Color getColor() {
        return ellipse.getColor();
    }

    @Override
    public int getZIndex() {
        return ellipse.getZIndex();
    }

    @Override
    public Image toImage(GContext gContext) {
        int height = gContext.getHeight();
        int width = gContext.getWidth();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.drawImage(ellipse.toImage(gContext), 0, 0, null);
        return image;
    }
    
}
