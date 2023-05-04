package pl.edu.pwr.bum.simulation.app;

import pl.edu.pwr.bum.simulation.filedType.FieldType;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;

import java.util.Map;

public class SimulationStats {
    private Map<RandomEvent,FieldType> randomEventMap;


    public SimulationStats(Map<RandomEvent, FieldType> randomEventMap) {
        this.randomEventMap = randomEventMap;
    }
}
