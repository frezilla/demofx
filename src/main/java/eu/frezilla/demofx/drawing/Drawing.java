package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;

public abstract class Drawing  {
    
    private final int zIndex;
        
    protected Drawing(int zIndex) {
        this.zIndex = zIndex;
    }
    
    public abstract void draw(GContext gContext);
    
    public final int getZIndex() {
        return zIndex;
    }
    
}
