package eu.frezilla.demofx.fx.configuration;

public class Builder {
    
    private int refreshRate;
    private eu.frezilla.demofx.tablet.configuration.Configuration tabletConfiguration;
    
    Builder() {
        refreshRate = 24;
        tabletConfiguration = eu.frezilla.demofx.tablet.configuration.Configuration.getBuilder().build();
    }
    
    public Configuration build() {
        return new Configuration(refreshRate, tabletConfiguration);
    }
    
    public Builder refreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
        return this;
    }
    
    public Builder tabletConfiguration(eu.frezilla.demofx.tablet.configuration.Configuration tabletConfiguration) {
        this.tabletConfiguration = tabletConfiguration;
        return this;
    }
    
}
