package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Triangle implements Drawing {
    
    private final Polygon polygon;
    
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this(x1, y1, x2, y2, x3, y3, Color.BLACK, 0);
    }
    
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        this(x1, y1, x2, y2, x3, y3, color, 0);
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color, int zIndex) {
        List<Point2D> points = new ArrayList<>(3);
        points.add(new Point2D(x1, y1));
        points.add(new Point2D(x2, y2));
        points.add(new Point2D(x3, y3));
        this.polygon = Polygon.of(points, color, zIndex);
    }

    @Override
    public void draw(GContext gContext) {
        polygon.draw(gContext);
    }
    
}
