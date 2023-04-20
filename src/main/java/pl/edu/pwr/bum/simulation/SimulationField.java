package pl.edu.pwr.bum.simulation;

import java.util.List;
import java.util.Map;

public class SimulationField {

    private final List<SimulationField> neighbors;
    private final FieldType fieldType;

    public SimulationField(List<SimulationField> neighbors, FieldType fieldType) {
        this.neighbors = neighbors;
        this.fieldType = fieldType;
    }

    public enum FieldType{
        ACTION_FIELD,
        EMTPY_FIELD,
        LIQUOR_STORE,
        SOBERING_STATION
    }
}
