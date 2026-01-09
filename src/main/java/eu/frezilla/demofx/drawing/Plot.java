package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;

public class Plot extends Drawing {
    
    public Plot() {
        super(0);
    }

    @Override
    public void draw(GContext gContext) {
        gContext.getG2d().drawLine(10, 10, 20, 20);
    }
    
}
