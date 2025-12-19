package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.screen.JScreen;
import java.util.Objects;

public abstract class Shape {
    
    private MagicTablet tablet;
    
    protected final void setTablet(MagicTablet tablet) {
        this.tablet = Objects.requireNonNull(tablet);
    }
    
    protected final void draw() {
        if (tablet != null) {
            drawShape(tablet.getScreen());
        }
    }
    
    protected abstract void drawShape(JScreen screen);
    
    protected final Size getScreenSize() {
        if (tablet == null) return null;
        return tablet.getSize();
    }
}