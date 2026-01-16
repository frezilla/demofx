package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;

public interface Drawing  {
    
    void draw(GContext gContext);
    
    default Color getColor() { return Color.BLACK; }
    
    default int getZIndex() { return 0; }
    
}
