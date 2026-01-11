package eu.frezilla.demofx.fx;

import eu.frezilla.demofx.fx.configuration.Configuration;
import eu.frezilla.demofx.tablet.Tablet;
import static java.lang.System.Logger.Level.WARNING;

public abstract class Fx {
    
    private final long delay;
    private boolean isRunning;
    private final int refreshRate;
    private final Tablet tablet;
    
    protected Fx(Configuration configuration) {
        refreshRate = configuration.getRefreshRate();
        tablet = new Tablet(configuration.getTabletConfiguration());
        delay = (long) ((1.0 / refreshRate) * 1000);
    }
    
    public final int getRefreshRate() {
        return refreshRate;
    }
    
    private void run() {
        while (isRunning) {
            long initialTime = System.currentTimeMillis();
            tablet.clear();
            update();
            show();
            long finalTime = System.currentTimeMillis();
            pause(delay - (finalTime - initialTime));
        }
    }
    
    protected final Tablet getTablet() {
        return tablet;
    }
    
    protected abstract void update();
    
    public final synchronized void start() {
        tablet.setVisible(true);
        isRunning = true;
        run();
    }
    
    public final synchronized void stop() {
        isRunning = false;
    }

    private void pause(long pauseTime) {
        if (pauseTime > 0) {
            try {
                Thread.sleep(pauseTime);
            } catch (InterruptedException e) {
                System.getLogger(Fx.class.getName()).log(WARNING, "Une exception a été détectée à la mise en pause", e);
            }
        }
    }

    private void show() {
        tablet.display();
    }
    
}
