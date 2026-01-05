package eu.frezilla.demofx.tablet.configuration;

import java.util.Objects;

/**
 * La class {@code Configuration} stocke les informations nécessaires à la
 * configuration de la tablette.
 *
 * <p>
 * Les paramètres de la {@code Configuration} sont les suivants :
 * <ul>
 * <li>La taille (valeur non nulle)</li>
 * <li>Le titre (valeur non nulle)</li>
 * </ul>
 *
 * <p>
 * Une {@code Configuration} est immuable et est créée via l'utilisation d'un
 * {@code Builder} créé par l'appel à la méthode
 * {@link Configuration#getBuilder()}.
 *
 * @see Builder
 */
public final class Configuration {

    private final Size size;
    private final String title;

    Configuration(Size size, String title) {
        this.size = Objects.requireNonNull(size, "la taille n'est pas correctement définie");
        this.title = Objects.requireNonNull(title, "Le titre n'est pas correctement définie");
    }

    /**
     * Créé une instance {@code Builder} nécessaire à la création d'une
     * {@code Configuration}.
     *
     * @return {@code Builder}
     * @see Builder
     */
    public static Builder getBuilder() {
        return new Builder();
    }

    /**
     * Retourne la taille configuré.
     *
     * @return Taille
     * @see Size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Retourne le titre configuré.
     *
     * @return Titre
     */
    public String getTitle() {
        return title;
    }
}
