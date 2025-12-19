package eu.frezilla.demofx.screen;

import eu.frezilla.demofx.tablet.Size;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public final class JScreen extends JComponent {
    
    private BufferedImage image;
    private final Size size;
    
    public JScreen(Size size) {
        this.size = size;
        setPreferredSize(new Dimension(size.getWidth(), size.getHeight()));
        image = createImage(size);
    }
    
    private BufferedImage createImage(Size size) {
        return new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    
    public void drawLine(int x1, int y1, int x2, int y2) {
        image.createGraphics().drawLine(x1, y1, x2, y2);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
        image = createImage(size);
    }
    
}
