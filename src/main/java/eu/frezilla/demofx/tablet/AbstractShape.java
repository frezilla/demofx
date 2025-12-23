package eu.frezilla.demofx.tablet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Objects;

public abstract class AbstractShape {
    
    private Color color;
    private Size tabletSize;

    protected abstract void draw(Graphics2D g2);

    public final Color getColor() {
        return color;
    }
    
    public final Size getTabletSize() {
        return tabletSize;
    }
    
    public final void setColor(Color c) {
        color = Objects.requireNonNullElse(c, Color.BLACK);
    }    
    
    final void setTabletSize(Size size) {
        tabletSize = Objects.requireNonNull(size);
    }
}   