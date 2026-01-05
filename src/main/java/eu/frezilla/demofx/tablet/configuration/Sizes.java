package eu.frezilla.demofx.tablet.configuration;

/**
 * Enumération de {@code Size}.
 * 
 * @see Size
 */
public enum Sizes {
    LOW(new Size(320, 200)),
    MEDIUM(new Size(640, 480)),
    HIGH(new Size(800, 600));
    
    private final Size size;
    
    private Sizes(Size size) {
        this.size = size;
    }
    
    public Size getSize() {
        return size;
    }
    
}
