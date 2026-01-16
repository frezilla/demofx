package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class Polygon extends SimpleDrawing {
    
    private final List<Line> lines;
    
    private Polygon(List<Point2D> points, Color color, int zIndex) {
        super(color, zIndex);
        List<Point2D> pointsTmp = new ArrayList<>(points);
        lines = new ArrayList<>(pointsTmp.size());
        Point2D initialPoint = pointsTmp.getFirst();
        Point2D firstPoint = pointsTmp.getFirst();
        Point2D secondPoint;
        for (int i = 1; i < pointsTmp.size(); i++) {
            secondPoint = pointsTmp.get(i);
            lines.add(
                    new Line(
                            firstPoint.getX(),
                            firstPoint.getY(),
                            firstPoint.getX(),
                            firstPoint.getY(),
                            color,
                            zIndex
                    )
            );
            firstPoint = secondPoint;
        }
        lines.add(
                new Line(
                        firstPoint.getX(),
                        firstPoint.getY(),
                        initialPoint.getX(),
                        initialPoint.getY(),
                        color,
                        zIndex
                )
        );
    }
    
    @Override
    public void draw(GContext gContext) {
        for (Line line : lines) {
            line.draw(gContext);
        }
    }
    
    public static Polygon of(List<Point2D> points) {
        return of(points, Color.BLACK, 0);
    }
    
    public static Polygon of(List<Point2D> points, Color color) {
        return of(points, color, 0);
    }
    
    public static Polygon of(List<Point2D> points, Color color, int zIndex) {
        if (points == null) throw new IllegalArgumentException();
        if (points.size() < 3) throw new IllegalArgumentException();
        return new Polygon(points, color, zIndex);
    }
    
}
