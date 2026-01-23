package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class Ellipse implements Drawing {
    
    private final Polygon polygon;
    
    public Ellipse(int x, int y, int r1, int r2) {
        this(x, y, r1, r2, Color.BLACK, 0, 360);
    }
    
    public Ellipse(int x, int y, int r1, int r2, Color color) {
        this(x, y, r1, r2,color, 0, 360);
    }
    
    public Ellipse(int x, int y, int r1, int r2, Color color, int zIndex) {
        this(x, y, r1, r2,color, zIndex, 360);
    }
    
    public Ellipse(int x, int y, int r1, int r2, Color color, int zIndex, int nbSegments) {
        List<Point2D> points = new ArrayList<>(nbSegments);
        double step = 2.0 * Math.PI / nbSegments;
        double angle = 0.0;
        for (int i = 0; i < nbSegments; i++) {
            int a = x + (int) (r1 * Math.cos(angle));
            int b = y + (int) (r2 * Math.sin(angle));
            points.add(new Point2D(a, b));
            angle = angle + step;
        }
        this.polygon = Polygon.of(points, color, zIndex);
    }

    @Override
    public void draw(GContext gContext) {
        polygon.draw(gContext);
    }

    @Override
    public Color getColor() {
        return polygon.getColor();
    }

    @Override
    public int getZIndex() {
        return polygon.getZIndex();
    }
    
}
