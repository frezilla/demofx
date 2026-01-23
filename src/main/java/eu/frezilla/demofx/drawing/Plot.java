package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public final class Plot extends SimpleDrawing {
    
    private final int x;
    private final int y;
    
    public Plot(int x, int y) {
        this(x, y, Color.BLACK, 0);
    }
    
    public Plot(int x, int y, Color color) {
        this(x, y, color, 0);
    }
    
    public Plot(int x, int y, Color color, int zIndex) {
        super(color, zIndex);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GContext gContext) {
        Graphics2D g = gContext.getG2d();
        draw(gContext.getWidth(), gContext.getHeight(), g);
    }
    
    @Override
    void draw(int width, int height, Graphics2D g) {
        if ((x < 0 || x >= width)) return;
        if ((y < 0 || y >= height)) return;
        g.setColor(getColor());
        g.drawLine(x, y, x, y);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

}
