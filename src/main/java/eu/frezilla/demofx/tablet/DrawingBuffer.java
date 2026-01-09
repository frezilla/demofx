package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.drawing.Drawing;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class DrawingBuffer {
    
    private final Map<Integer, List<Drawing>> buffer;

    DrawingBuffer() {
        this.buffer = new TreeMap<>();
    }
    
    public void add(Drawing drawing) {
        if (drawing != null) {
            int zIndex = drawing.getZIndex();
            List<Drawing> list = buffer.getOrDefault(zIndex, new ArrayList<>());
            list.add(drawing);
            buffer.put(zIndex, list);
        }
    }
    
    public void clear() {
        buffer.clear();
    }
    
    public Iterable<Drawing> toIterable() {
        List<Drawing> list = new ArrayList<>();
        buffer.forEach((k, v) -> {
            list.addAll(v);
        });
        return list;
    }
    
    
    
    
    
}
