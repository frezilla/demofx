package eu.frezilla.demofx.fx;

import eu.frezilla.demofx.tablet.MagicTablet;
import eu.frezilla.demofx.tablet.Size;
import java.awt.event.KeyListener;
import static java.lang.System.Logger.Level.WARNING;

public abstract class AbstractFx implements KeyListener {
    
    private final long delay;
    private boolean isRunning;
    private final int refreshRate;
    private final MagicTablet tablet;
    
    protected AbstractFx(String title, int refreshRate, Size size) {
        if (refreshRate <= 0) throw new IllegalArgumentException("The refresh rate must be strictly positive.");
        this.delay = (long) ((1.0 / refreshRate) * 1000);
        this.refreshRate = refreshRate;
        this.tablet = new MagicTablet(title, size);
    }
    
    private void pause(long time) {
        if (time > 0) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.getLogger(AbstractFx.class.getName()).log(WARNING, "Pause exception detected", e);
            }
        }
    }

    public final int getRefreshRate() {
        return refreshRate;
    }
    
    protected final MagicTablet getTablet() {
        return tablet;
    }
    
    private void run() {
        while (isRunning) {
            long initialTime = System.currentTimeMillis();
            update();
            tablet.draw();
            long finalTime = System.currentTimeMillis();
            pause(delay - (finalTime - initialTime));
        }
    }
    
    protected abstract void update();
    
    public final synchronized void start() {
        if (!tablet.isVisible()) {
            tablet.show();
        }
        isRunning = true;
        run();
    }
    
    public final synchronized void stop() {
        isRunning = false;
    }
}