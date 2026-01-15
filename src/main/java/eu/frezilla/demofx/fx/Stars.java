package eu.frezilla.demofx.fx;

import eu.frezilla.demofx.drawing.Line;
import eu.frezilla.demofx.drawing.Plot;
import eu.frezilla.demofx.fx.configuration.Configuration;
import java.awt.Color;

public class Stars extends Fx {
    
    private int x = 0;
    private int y = 0;

    public Stars(Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void update() {
        x++;
        y++;
        getTablet().add(new Line(x - 10, y + 10, x + 10, y - 10, Color.RED));
        getTablet().add(new Line(x - 10, y - 10, x + 10, y + 10, Color.GREEN));
        getTablet().add(new Plot(x, y, Color.CYAN));
    } 
    
}
