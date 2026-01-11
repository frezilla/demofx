package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.drawing.Drawing;
import eu.frezilla.demofx.tablet.configuration.Configuration;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public final class Tablet {

    private final DrawingBuffer buffer;
    private final Configuration configuration;
    private final Display display;
    private final JFrame frame;
    
    public Tablet(Configuration configuration) {
        this.configuration = Objects.requireNonNull(configuration, "La configuration n'est pas correctement définie");
        this.buffer = new DrawingBuffer();
        this.display = 
                new Display(
                        this.configuration.getSize().getWidth(),
                        this.configuration.getSize().getHeight(),
                        this.configuration.getImageType()
                );
        this.frame = new JFrame(this.configuration.getTitle());
        
        this.display.setPreferredSize(this.configuration.getSize().toDimension());
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.add(display);
    }
    
    /**
     * Ajoute un {@code Drawing} au buffer des dessins à afficher à l'écran.
     * @param drawing
     */
    public void add(Drawing drawing) {
        buffer.add(drawing);
    }
    
    /**
     * Efface le contenu de l'écran.
     */
    public void clear() {
        display.clear();
    }
    
    /**
     * Affiche les dessins du buffer.
     */
    public void display() {
        prepareDisplay();
        display.repaint();
        buffer.clear();
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
    
    private void prepareDisplay() {
        GContext context = display.getGContext();
        buffer.toIterable().forEach(d -> {
            d.draw(context);
        });
    }

    /**
     * Affiche ou masque la tablette en fonction de la valeur du booléen
     * ({@code True} : affichage; {@code False} : masquage)
     *
     * @param b booléen
     */
    public void setVisible(boolean b) {
        if (b && !frame.isVisible()) {
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } else if (!b && frame.isVisible()) {
            frame.setVisible(false);
        }
    }
}
