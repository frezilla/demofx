package eu.frezilla.demofx.shape;

import eu.frezilla.demofx.tablet.AbstractShape;
import java.awt.Graphics2D;

public final class Plot extends AbstractShape {
    
    private final int x;
    private final int y;
    
    public Plot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected void draw(Graphics2D g2) {
        var s = getTabletSize();
        if (x < 0 || x >= s.getWidth()) return;
        if (y < 0 || y >= s.getHeight()) return;
        g2.drawLine(x, y, x, y);
    }
}