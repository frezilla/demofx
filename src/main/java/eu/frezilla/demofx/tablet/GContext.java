package eu.frezilla.demofx.tablet;

import java.awt.Graphics2D;

/**
 * La classe {@code GContext} contient les informations liées au contexte
 * graphiqur courant.
 */
public final class GContext {
    
    private final Graphics2D g2d;
    private final int height;
    private final int width;
    
    GContext(Graphics2D g2d, int width, int height) {
        this.g2d = g2d;
        this.height = height;
        this.width = width;
    }
    
    /**
     * Retourne le contexte graphique Java.
     * 
     * @return Contexte graphique
     * @see Graphics2D
     */
    public Graphics2D getG2d() {
        return g2d;
    }
    
    /**
     * Retourne la hauteur de la zone d'affichage utile de la tablette.
     * 
     * @return Hauteur
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Retourne la largeur de la zone d'affichage utile de la tablette.
     * 
     * @return  Largeur
     */
    public int getWidth() {
        return width;
    }
    
}
