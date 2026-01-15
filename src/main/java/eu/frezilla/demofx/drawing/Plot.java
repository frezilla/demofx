package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;

public class Plot extends Drawing {
    
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
        if ((x < 0 || x >= gContext.getWidth())) return;
        if ((y < 0 || y >= gContext.getHeight())) return;
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
