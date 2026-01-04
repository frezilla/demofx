package eu.frezilla.demofx.tablet.configuration;

public final class Builder {
    
    private Size size;
    private String title;
    
    Builder() {
        size = Sizes.HIGH.getSize();
        title = "";
    }
    
    public Configuration build() {
        return new Configuration(size, title);
    }
    
    public Builder size(Size size) {
        this.size = size;
        return this;
    }
    
    public Builder title(String title) {
        this.title = title;
        return this;
    }
    
}
