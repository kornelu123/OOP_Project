package pl.edu.pwr.bum.simulation.objects.location;

import pl.edu.pwr.bum.simulation.app.SimulationStats;

public interface Field {
    public String getName();
    public int getX();
    public int getY();
    public void handleFieldAction(SimulationStats simStat) throws InterruptedException;

    public void getCurrentField();
}
