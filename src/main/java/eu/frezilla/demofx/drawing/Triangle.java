package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
    
    @Override
    public Color getColor() {
        return polygon.getColor();
    }
    
    @Override
    public int getZIndex() {
        return polygon.getZIndex();
    }

    @Override
    public Image toImage(GContext gContext) {
        int height = gContext.getHeight();
        int width = gContext.getWidth();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.drawImage(polygon.toImage(gContext), 0, 0, null);
        return image;
    }
    
}
