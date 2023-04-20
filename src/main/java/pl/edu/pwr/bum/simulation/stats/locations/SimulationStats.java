package pl.edu.pwr.bum.simulation.stats.locations;

import java.util.List;

public class SimulationStats {
    private final List<StatsForSingleTurn> stats;
    public enum FieldType{
        ACTION_FIELD,
        EMTPY_FIELD,
        LIQUOR_STORE,
        SOBERING_STATION,
        SLODOWA,
        NULL
    }

    public SimulationStats(List<StatsForSingleTurn> stats) {
        this.stats = stats;
    }
}
