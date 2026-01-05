package eu.frezilla.demofx.tablet.configuration;

/**
 * La classe {@code Builder} permet de créer une instance de la classe 
 * {@Configuration}.
 *
 * <p>Les valeurs par défaut sont les suivantes :
 * <ul>
 * <li>Taille : {@link Sizes#HIGH}</li>
 * <li>Titre : chaine vide</li>
 * </ul>
 * 
 * @see Configuration
 * @see Sizes
 */
public final class Builder {

    private Size size;
    private String title;

    Builder() {
        size = Sizes.HIGH.getSize();
        title = "";
    }

    /**
     * Créé une nouvelle {@code Configuration} à partir des paramètres définis.
     *
     * @return Nouvelle instance de la classe {@code Configuration}
     * @see Configuration
     */
    public Configuration build() {
        return new Configuration(size, title);
    }

    /**
     * Définit la taille.
     *
     * @param size Taille
     * @return {@code Builder} courant
     * @see Size
     */
    public Builder size(Size size) {
        this.size = size;
        return this;
    }

    /**
     * Définit le titre.
     *
     * @param title Titre
     * @return {@code Builder} courant
     */
    public Builder title(String title) {
        this.title = title;
        return this;
    }

}
