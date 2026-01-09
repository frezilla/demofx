package eu.frezilla.demofx;

import eu.frezilla.demofx.drawing.Plot;
import eu.frezilla.demofx.tablet.Tablet;
import eu.frezilla.demofx.tablet.configuration.Configuration;

public class DemoFx {
    
    public static void main(String[] args) {
        System.out.println("Hello World");
        Configuration configuration = Configuration.getBuilder().build();
        Tablet tablet = new Tablet(configuration);
        tablet.add(new Plot());
        tablet.setVisible(true);
        tablet.display();
    }
    
}
