package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.tablet.configuration.Configuration;
import java.util.Objects;

public abstract class Tablet {

    private final Configuration configuration;

    Tablet(Configuration configuration) {
        this.configuration = Objects.requireNonNull(configuration, "La configuration n'est pas correctement définie");
    }

    /**
     * Retourne la {@code Configuration} liée à la tablette.
     *
     * @return {@code Configuration}
     * @see Configuration
     */
    public final Configuration getConfiguration() {
        return configuration;
    }

}
