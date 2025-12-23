package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.screen.JScreen;
import java.util.Objects;

public abstract class Shape {
    
    private boolean cacheInMemory;
    private MagicTablet tablet;
    
    protected Shape() {
        cacheInMemory = false;
        tablet = null;
    }
    
    public final boolean cacheInMemory() {
        return cacheInMemory;
    }
    
    public final void cacheInMemory(boolean b) {
        cacheInMemory = b;
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
    
    protected final void setTablet(MagicTablet tablet) {
        this.tablet = Objects.requireNonNull(tablet);
    }
    
    
}