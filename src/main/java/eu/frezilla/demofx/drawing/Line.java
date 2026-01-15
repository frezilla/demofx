package eu.frezilla.demofx.drawing;

import eu.frezilla.demofx.tablet.GContext;
import java.awt.Color;
import java.awt.Graphics2D;

public class Line extends Drawing {
    
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Line(int x1, int y1, int x2, int y2) {
        this(x1, y1, x2, y2, Color.BLACK, 0);
    }
    
    public Line(int x1, int y1, int x2, int y2, Color color) {
        this(x1, y1, x2, y2, color, 0);
    }
    
    public Line(int x1, int y1, int x2, int y2, Color color, int zIndex) {
        super(color, zIndex);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(GContext gContext) {
        Graphics2D g = gContext.getG2d();
        int height = gContext.getHeight();
        int width = gContext.getWidth();
        if ((x1 < 0 && x2 < 0) || (x1 >= width && x2 >= width)) return;
        if ((y1 < 0 && y2 < 0) || (y1 >= height && y2 >= height)) return;
        
        double a = ((double) y2 - (double) y1)/((double) x2 - (double) x1);
        double b = y1 - a * x1;
        
        int[] final1 = limit(x1, y1, width, height, a, b);
        int[] final2 = limit(x2, y2, width, height, a, b);
        
        g.setColor(getColor());
        g.drawLine(final1[0], final1[1], final2[0], final2[1]);
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }
    
    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
    
    private int[] limit(int x, int y, int width, int height, double a, double b) {
        int finalX = x;
        int finalY = y;
        
        if (finalX < 0) {
            finalX = 0;
            finalY = (int) (-b / a);
        }
        if (finalX >= width) {
            finalX = width;
            finalY = (int) (a * width + b);
        }
        if (finalY < 0) {
            finalX = (int) (-b / a);
            finalY = 0;
        } 
        if (finalY >= height) {
            finalX = (int) ((height - b) / a);
            finalY = height;
        }

        return new int[] { finalX, finalY };
    }
    
}
