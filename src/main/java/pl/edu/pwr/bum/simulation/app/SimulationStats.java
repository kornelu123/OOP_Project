package pl.edu.pwr.bum.simulation.app;

import pl.edu.pwr.bum.simulation.random.events.RandomEvent;

import java.util.Map;

public class SimulationStats {
    private Map<RandomEvent,SimulationStats.FieldType> randomEventMap;
    public enum FieldType{
        MINUS_30,
        ACTION_FIELD,
        EMTPY_FIELD,
        LIQUOR_STORE,
        SOBERING_STATION,
        SLODOWA,
        NULL
    }

    public SimulationStats(Map<RandomEvent,SimulationStats.FieldType> randomEventMap) {
        this.randomEventMap = randomEventMap;
    }
}
