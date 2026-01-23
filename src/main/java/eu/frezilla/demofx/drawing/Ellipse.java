package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public final class Ellipse implements Drawing {
    
    private final Polygon polygon;
    
    public Ellipse(int x, int y, int r1, int r2) {
        this(x, y, r1, r2, Color.BLACK, 0, 379);
    }
    
    public Ellipse(int x, int y, int r1, int r2, Color color) {
        this(x, y, r1, r2,color, 0, 379);
    }
    
    public Ellipse(int x, int y, int r1, int r2, Color color, int zIndex) {
        this(x, y, r1, r2,color, zIndex, 379);
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
