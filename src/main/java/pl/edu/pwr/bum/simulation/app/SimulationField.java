package pl.edu.pwr.bum.simulation.app;

import pl.edu.pwr.bum.simulation.objects.events.locations.Location;
import java.util.List;

public class SimulationField {

    private final List<SimulationField> neighbors;
    private final Location currentLocation;

    public SimulationField(List<SimulationField> neighbors, Location location) {
        this.neighbors = neighbors;
        this.currentLocation = location;
    }
}
