package eu.frezilla.demofx.tablet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.image.BufferStrategy;
import java.util.Objects;
import javax.swing.JFrame;

final class MyJFrame extends JFrame {
    
    private BufferStrategy bs;
    private final MagicTablet tablet;
    

    MyJFrame(String title, MagicTablet tablet) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIgnoreRepaint(true);
        
        this.bs = null;
        this.tablet = Objects.requireNonNull(tablet);
    }
    
    void setContentPaneSize(Size size) {
        getContentPane().setPreferredSize(size.toDimension());
    }
    
    @Override
    public void paint(Graphics g) {
        if (bs != null) {
            do {
                final Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();
                g2.clearRect(0, 0, tablet.getContentSize().getWidth(), tablet.getContentSize().getHeight());
                tablet.getShapes().forEach(s -> {
                    g2.setColor(s.getColor());
                    s.draw(g2);
                });
                g2.dispose();
                bs.show();
            } while (bs.contentsLost());
        }
    }
    
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            createBufferStrategy(2);
            bs = getBufferStrategy();
        }
    }
}
