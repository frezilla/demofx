package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.screen.JScreen;

public final class Line extends Shape {
    
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void drawShape(JScreen screen) {
        Size s = getScreenSize();
        
        if ((x1 < 0 && x2 < 0) || (x1 >= s.getWidth() && x2 >= s.getWidth())) return;
        if ((y1 < 0 && y2 < 0) || (y1 >= s.getHeight()&& y2 >= s.getHeight())) return;
        if (x1 == x2 || y1 == y2) {
            screen.drawLine(Math.max(x1, Math.min(x1, s.getWidth())), 
                    Math.max(y1, Math.min(y1, s.getHeight())), 
                    Math.max(x2, Math.min(x2, s.getWidth())), 
                    Math.max(y2, Math.min(y2, s.getHeight()))
            );
            return;
        }
        
        var coeff = (double) ((double)(y2 - y1) / (double)(x2 - x1));
        var yIntercept = ((double)y1 - coeff * x1);
        int minX = Math.max((int)(-yIntercept / coeff), 0);
        int maxX = Math.min((int)((s.getWidth()- yIntercept) / coeff), s.getWidth());
        int minY = Math.max((int)yIntercept, 0);
        int maxY = Math.min((int)(s.getHeight() * coeff - yIntercept), s.getHeight());
        
        var newX1 = x1;
        var newY1 = y1;
        var newX2 = x2;
        var newY2 = y2;
        if (x1 < minX) {
            newX1 = minX;
            newY1 = (int)(newX1 * coeff + yIntercept);
        } else if (x1 >= maxX) {
            newX1 = maxX - 1;
            newY1 = (int)(newX1 * coeff + yIntercept);
        } else if (y1 < minY) {
            newY1 = minY;
            newX1 = (int)((newY1 - yIntercept)/coeff);
        } else if (y1 >= maxY) {
            newY1 = maxY - 1;
            newX1 = (int)((newY1 - yIntercept)/coeff);
        }
        
        if (x2 < minX) {
            newX2 = minX;
            newY2 = (int)(newX2 * coeff + yIntercept);
        } else if (x2 >= maxX) {
            newX2 = maxX - 1;
            newY2 = (int)(newX2 * coeff + yIntercept);
        } else if (y2 < minY) {
            newY2 = minY;
            newX2 = (int)((newY2 - yIntercept)/coeff);
        } else if (y2 >= maxY) {
            newY2 = maxY - 1;
            newX2 = (int)((newY2 - yIntercept)/coeff);
        }
        
        screen.drawLine(newX1, newY1, newX2, newY2); 
    }
}
