package eu.frezilla.demofx.fx.circlefx;

import eu.frezilla.demofx.drawing.Circle;
import eu.frezilla.demofx.fx.Fx;
import eu.frezilla.demofx.fx.configuration.Configuration;
import java.awt.Color;

public class CircleFx extends Fx {

    private CircleFx(Configuration configuration) {
        super(configuration);
    }
    
    public static CircleFx newInstance() {
        return new CircleFx(
                Configuration
                        .getBuilder()
                        .refreshRate(60)
                        .tabletConfiguration(
                                eu.frezilla.demofx.tablet.configuration.Configuration
                                        .getBuilder()
                                        .title("CircleFx")
                                        .build()
                        )
                        .build()
        );
    }

    @Override
    protected void update() {
        getTablet().add(new Circle(320, 200, 50, Color.WHITE));
    }
    
    
}
