package pl.edu.pwr.bum.simulation.random.events;

import pl.edu.pwr.bum.simulation.stats.locations.SimulationStats;

import java.util.ArrayList;

public class RandomEvent implements Random {
    private Long id;
    private Boolean hasBeen;
    SimulationStats.FieldType fieldType;
    public String description;

    public RandomEvent(Boolean hasBeen, SimulationStats.FieldType fieldType, String description) {
        this.id = id;
        this.hasBeen = hasBeen;
        this.fieldType = fieldType;
        this.description = description;
    }

    @Override
    public Random getRandomEvent() {
        return null;
    }

    @Override
    public Long getRandomEventIndex(Random random) {
        return this.id;
    }

}
