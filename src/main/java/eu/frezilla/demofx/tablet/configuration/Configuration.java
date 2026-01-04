package eu.frezilla.demofx.tablet.configuration;


public final class Configuration {

    private final Size size;
    private final String title;
    
    Configuration(Size size, String title) {
        this.size = size;
        this.title = title;
    }
    
    public static Builder getBuilder() {
        return new Builder();
    }
    
    public Size getSize() {
        return size;
    }
    
    public String getTitle() {
        return title;
    }
}
