package eu.frezilla.demofx.tablet;

import eu.frezilla.demofx.tablet.configuration.ImageType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

final class Display extends JPanel {
    
    private GContext gContext;
    private final int height;
    private final ImageType imageType;
    private BufferedImage img;
    private final int width;

    Display(int width, int height, ImageType imageType) {
        this.height = height;
        this.imageType = imageType;
        this.width = width;
        reset();
    }
    
    public void clear() {
        gContext.getG2d().setBackground(Color.BLACK);
        gContext.getG2d().clearRect(0, 0, width, height);
    }
    
    /**
     * Retourne le contexte graphique courant.
     * 
     * @return Contexte graphique
     * @see GContext
     */
    public GContext getGContext() {
        return gContext;
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    
    /**
     * Initialise l'écran pour prépaprer un nouvel affichage.
     */
    public void reset() {
        img = new BufferedImage(width, height, imageType.intValue());
        gContext = new GContext(img.createGraphics(), width, height);
    }
}
