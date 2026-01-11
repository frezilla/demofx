package eu.frezilla.demofx;

import eu.frezilla.demofx.fx.Stars;
import eu.frezilla.demofx.fx.configuration.Configuration;



public class DemoFx {
    
    public static void main(String[] args) {
        System.out.println("Hello World");
        Configuration configuration = Configuration.getBuilder().build();
        Stars starsFx = new Stars(configuration);
        starsFx.start();
    }
    
}
