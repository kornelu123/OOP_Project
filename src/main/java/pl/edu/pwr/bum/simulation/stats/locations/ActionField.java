package pl.edu.pwr.bum.simulation.stats.locations;
import pl.edu.pwr.bum.simulation.field.type.FieldType;

public class ActionField implements Location{
    private final FieldType fieldType = FieldType.ACTION_FIELD;
    public FieldType getFieldType() {
        return this.fieldType;
    }

}
