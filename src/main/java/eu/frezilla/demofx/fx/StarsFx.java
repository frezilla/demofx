package eu.frezilla.demofx.fx;

import eu.frezilla.demofx.shape.Plot;
import eu.frezilla.demofx.tablet.Size;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class StarsFx extends AbstractFx {
    
    public static int REFRESH_RATE = 60;
    public static Size SIZE = new Size(640, 480);
    public static String TITLE = "Stars fx";

    public StarsFx() {
        super(TITLE, REFRESH_RATE, SIZE);
        Plot plot = new Plot(100, 100);
        plot.setColor(Color.RED);
        getTablet().addShape(plot);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void update() {
        
    }
    
}
