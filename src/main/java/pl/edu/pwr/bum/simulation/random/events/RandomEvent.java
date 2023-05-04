package pl.edu.pwr.bum.simulation.random.events;

import pl.edu.pwr.bum.simulation.app.SimulationStats;
import pl.edu.pwr.bum.simulation.filedType.FieldType;

public class RandomEvent implements Random {
    private Long id;
    private Boolean hasBeen;
    FieldType fieldType;
    public String description;

    public RandomEvent(Long id, Boolean hasBeen, FieldType fieldType, String description) {
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
