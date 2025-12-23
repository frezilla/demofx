package eu.frezilla.demofx.tablet;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class MagicTablet {
    
    private Color backgroundColor;
    private final MyJFrame frame;
    private final List<AbstractShape> shapes;
    private final Size size;
    
    public MagicTablet(String title, Size size) {
        this.size = Objects.requireNonNull(size);
        this.backgroundColor = Color.RED;
        this.frame = new MyJFrame(title, this);
        this.frame.setContentPaneSize(size);
        this.shapes = new LinkedList<>();
    }
    
    public void addShape(AbstractShape shape) {
        Objects.requireNonNull(shape);
        shape.setTabletSize(size);
        shapes.addLast(shape);
    }
    
    public void addShapes(AbstractShape...shape) {
        Stream.of(shape).forEach(s -> addShape(s));
    }
    
    public void clear() {
        shapes.clear();
    }
    
    public void draw() {
        frame.repaint();
    }
    
    public Size getContentSize() {
        return size;
    }
    
    List<AbstractShape> getShapes() {
        return shapes;
    }
    
    public void hide() {
        frame.setVisible(false);
    }
    
    public boolean isVisible() {
        return frame.isVisible();
    }

    public final Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public void setBackgroundColor(Color color) {
        backgroundColor = Objects.requireNonNull(color);
    }
    
    public void show() {
        frame.pack();
        frame.setVisible(true);
    }
}