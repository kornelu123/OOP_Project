package pl.edu.pwr.bum.simulation;

import pl.edu.pwr.bum.simulation.stats.locations.Location;
import java.util.List;

public class SimulationField {

    private final List<SimulationField> neighbors;
    private final Location currentLocation;

    public SimulationField(List<SimulationField> neighbors, Location location) {
        this.neighbors = neighbors;
        this.currentLocation = location;
    }
}
