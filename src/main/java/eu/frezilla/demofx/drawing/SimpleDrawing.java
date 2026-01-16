package eu.frezilla.demofx.drawing;

import java.awt.Color;
import java.util.Objects;

abstract class SimpleDrawing implements Drawing {
    
    private final Color color;
    private final int zIndex;
    
    protected SimpleDrawing(Color color, int zIndex) {
        super();
        this.color = Objects.requireNonNull(color);
        this.zIndex = zIndex;
    }
    
    @Override
    public final Color getColor() {
        return color;
    }
    
    @Override
    public final int getZIndex() {
        return zIndex;
    }
    
}
