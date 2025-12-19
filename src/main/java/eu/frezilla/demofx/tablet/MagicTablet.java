package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.screen.JScreen;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import javax.swing.JFrame;

public final class MagicTablet {
    
    private final JFrame frame;
    private final JScreen screen;
    private final List<Shape> shapes;
    private final Size size;
    
    public MagicTablet(String title, Size size) {
        this.size = Objects.requireNonNull(size);
        shapes = new LinkedList<>();
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = new JScreen(size);
        frame.getContentPane().add(screen);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void addShape(Shape shape) {
        Objects.requireNonNull(shape);
        shape.setTablet(this);
        shapes.addLast(shape);
    }
    
    public void addShapes(Shape...shape) {
        Stream.of(shape).forEach(s -> addShape(s));
    }
    
    public void clear() {
        shapes.clear();
    }
    
    public void draw() {
        shapes.forEach(s -> s.draw());
    }
    
    protected final JScreen getScreen() {
        return screen;
    }
    
    public Size getSize() {
        return size;
    }
    
    public void refresh() {
        draw();
        clear();
    }
}