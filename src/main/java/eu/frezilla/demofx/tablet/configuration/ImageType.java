package eu.frezilla.demofx.tablet.configuration;

import java.awt.image.BufferedImage;

/**
 * Enumération des types d'image.
 *
 * @see BufferedImage#TYPE_INT_RGB
 * @see BufferedImage#TYPE_INT_ARGB
 * @see BufferedImage#TYPE_INT_ARGB_PRE
 * @see BufferedImage#TYPE_INT_BGR
 * @see BufferedImage#TYPE_3BYTE_BGR
 * @see BufferedImage#TYPE_4BYTE_ABGR
 * @see BufferedImage#TYPE_4BYTE_ABGR_PRE
 * @see BufferedImage#TYPE_BYTE_GRAY
 * @see BufferedImage#TYPE_USHORT_GRAY
 * @see BufferedImage#TYPE_BYTE_BINARY
 * @see BufferedImage#TYPE_BYTE_INDEXED
 * @see BufferedImage#TYPE_USHORT_565_RGB
 * @see BufferedImage#TYPE_USHORT_555_RGB
 */
public enum ImageType {
    TYPE_INT_RGB(BufferedImage.TYPE_INT_RGB),
    TYPE_INT_ARGB(BufferedImage.TYPE_INT_ARGB),
    TYPE_INT_ARGB_PRE(BufferedImage.TYPE_INT_ARGB_PRE),
    TYPE_INT_BGR(BufferedImage.TYPE_INT_BGR),
    TYPE_3BYTE_BGR(BufferedImage.TYPE_3BYTE_BGR),
    TYPE_4BYTE_ABGR(BufferedImage.TYPE_4BYTE_ABGR),
    TYPE_4BYTE_ABGR_PRE(BufferedImage.TYPE_4BYTE_ABGR_PRE),
    TYPE_USHORT_565_RGB(BufferedImage.TYPE_USHORT_565_RGB),
    TYPE_USHORT_555_RGB(BufferedImage.TYPE_USHORT_555_RGB),
    TYPE_BYTE_GRAY(BufferedImage.TYPE_BYTE_GRAY),
    TYPE_USHORT_GRAY(BufferedImage.TYPE_USHORT_GRAY),
    TYPE_BYTE_BINARY(BufferedImage.TYPE_BYTE_BINARY),
    TYPE_BYTE_INDEXED(BufferedImage.TYPE_BYTE_INDEXED);

    private final int value;

    private ImageType(int value) {
        this.value = value;
    }

    /**
     * Retourne la valeur de l'énumération.
     * 
     * @return valeur
     */
    public int intValue() {
        return value;
    }

}
