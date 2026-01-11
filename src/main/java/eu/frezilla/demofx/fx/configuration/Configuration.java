package eu.frezilla.demofx.fx.configuration;

import java.util.Objects;

public final class Configuration {
    
    private final int refreshRate;
    private final eu.frezilla.demofx.tablet.configuration.Configuration tabletConfiguration;
    
    Configuration(int refreshRate, eu.frezilla.demofx.tablet.configuration.Configuration tabletConfiguration) {
        this.tabletConfiguration = Objects.requireNonNull(tabletConfiguration, "La configuration de la tablette est absente");
        if (refreshRate <= 0) throw new IllegalArgumentException("Le taux de rafraichissement doit être un entier positif");
        this.refreshRate = refreshRate;
    }
    
    public static Builder getBuilder() {
        return new Builder();
    }
    
    public int getRefreshRate() {
        return refreshRate;
    }
    
    public final eu.frezilla.demofx.tablet.configuration.Configuration getTabletConfiguration() {
        return tabletConfiguration;
    }
    
}
