package pl.edu.pwr.bum.simulation.stats;

import pl.edu.pwr.bum.simulation.SimulationField;
import pl.edu.pwr.bum.simulation.unit.Unit;

import java.util.List;

public class SimulationStats {
    private final List<StatsForSingleTurn> stats;

    public SimulationStats(List<StatsForSingleTurn> stats) {
        this.stats = stats;
    }
}
