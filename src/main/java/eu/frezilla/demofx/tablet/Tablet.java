package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.tablet.configuration.Configuration;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public final class Tablet {

    private final Configuration configuration;
    private final Display display;
    private final JFrame frame;

    public Tablet(Configuration configuration) {
        this.configuration = Objects.requireNonNull(configuration, "La configuration n'est pas correctement définie");
        this.display = new Display();
        this.frame = new JFrame(this.configuration.getTitle());
        
        this.display.setPreferredSize(this.configuration.getSize().toDimension());
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.add(display);
    }

    /**
     * Retourne la {@code Configuration} liée à la tablette.
     *
     * @return {@code Configuration}
     * @see Configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Affiche ou masque la tablette en fonction de la valeur du booléen
     * ({@code True} : affichage; {@code False} : masquage)
     *
     * @param b booléen
     */
    public void setVisible(boolean b) {
        if (b) {
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
