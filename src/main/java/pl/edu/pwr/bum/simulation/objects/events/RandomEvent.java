package pl.edu.pwr.bum.simulation.objects.events;

import pl.edu.pwr.bum.simulation.objects.type.FieldType;

public class RandomEvent implements Randoms {
    private Integer id;
    private Boolean hasBeen;
    FieldType fieldType;
    public String description;

    public Long bottleCount;


    public RandomEvent(Integer id,String description,Long bottleCount) {
        this.id = id;
        this.description = description;
        this.bottleCount = bottleCount;
    }

    @Override
    public Integer getRandomEventIndex() {
        return this.id;
    }

}
