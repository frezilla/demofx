package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.util.Objects;

public abstract class Drawing  {
    
    private final Color color;
    private final int zIndex;
        
    protected Drawing(Color color, int zIndex) {
        this.color = Objects.requireNonNull(color);
        this.zIndex = zIndex;
    }
    
    public abstract void draw(GContext gContext);
    
    public final Color getColor() {
        return color;
    }
    
    public final int getZIndex() {
        return zIndex;
    }
    
}
