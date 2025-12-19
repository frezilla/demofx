package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.screen.JScreen;

public final class Plot extends Shape {
    
    private final int x;
    private final int y;
    
    public Plot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected void drawShape(JScreen screen) {
        if (x < 0 || x >= getScreenSize().getWidth()) return;
        if (y < 0 || y >= getScreenSize().getHeight()) return;
        screen.drawLine(x, y, x, y);
    }
    
}