package pl.edu.pwr.bum.simulation.random.events;

import pl.edu.pwr.bum.simulation.app.SimulationStats;
import pl.edu.pwr.bum.simulation.filedType.FieldType;

public class RandomEvent implements Random {
    private Integer id;
    private Boolean hasBeen;
    FieldType fieldType;
    public String description;

    public Long bottleCount;


    public RandomEvent(Integer id, Boolean hasBeen, FieldType fieldType, String description,Long bottleCount) {
        this.id = id;
        this.hasBeen = hasBeen;
        this.fieldType = fieldType;
        this.description = description;
        this.bottleCount = bottleCount;
    }

    @Override
    public Integer getRandomEventIndex() {
        return this.id;
    }

}
