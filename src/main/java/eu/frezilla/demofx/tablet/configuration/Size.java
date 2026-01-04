package eu.frezilla.demofx.tablet.configuration;

public final class Size {

    private final int height;
    private final int width;

    /**
     * Constructeur de la classe. La largeur et la hauteur doivent être 
     * positifs
     * .
     * @param width Largeur
     * @param height Hauteur
     */
    public Size(int width, int height) {
        if (width <= 0) throw new IllegalArgumentException();
        if (height <= 0) throw new IllegalArgumentException();
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Size other = (Size) obj;
        if (this.height != other.height) {
            return false;
        }
        return this.width == other.width;
    }

    /**
     * Retourne la hauteur de la résolution.
     *
     * @return hauteur
     */
    public int getHeight() {
        return height;
    }

    /**
     * Retourne la largeur de la résolution.
     *
     * @return largeur
     */
    public int getWidth() {
        return width;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.height;
        hash = 53 * hash + this.width;
        return hash;
    }

    @Override
    public String toString() {
        return "Size{" + "height=" + height + ", width=" + width + '}';
    }
}
