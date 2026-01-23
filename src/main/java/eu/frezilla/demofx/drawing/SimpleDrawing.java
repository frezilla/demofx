package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Objects;

abstract class SimpleDrawing implements Drawing {
    
    private final Color color;
    private final int zIndex;
    
    protected SimpleDrawing(Color color, int zIndex) {
        super();
        this.color = Objects.requireNonNull(color);
        this.zIndex = zIndex;
    }
    
    abstract void draw(int width, int height, Graphics2D g);
    
    @Override
    public final Color getColor() {
        return color;
    }
    
    @Override
    public final int getZIndex() {
        return zIndex;
    }
    
    @Override
    public Image toImage(GContext gContext) {
        int height = gContext.getHeight();
        int width = gContext.getWidth();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        draw(width, height, image.createGraphics());
        return image;
    }
    
}
