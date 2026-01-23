package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public final class Polygon implements Drawing {
    
    private final List<Line> lines;
    
    private Polygon(List<Point2D> points, Color color, int zIndex) {
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
                            secondPoint.getX(),
                            secondPoint.getY(),
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
    
    @Override
    public Color getColor() {
        return lines.get(0).getColor();
    }

    @Override
    public int getZIndex() {
        return lines.get(0).getZIndex();
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

    @Override
    public Image toImage(GContext gContext) {
        int height = gContext.getHeight();
        int width = gContext.getWidth();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        for (Line line : lines) {
            g.drawImage(line.toImage(gContext), 0, 0, null);
        }
        return image;
    }

}
