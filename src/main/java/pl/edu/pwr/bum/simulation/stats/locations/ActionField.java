package pl.edu.pwr.bum.simulation.stats.locations;


import pl.edu.pwr.bum.simulation.app.SimulationStats;

public class ActionField implements Location{
    private final SimulationStats.FieldType fieldType = SimulationStats.FieldType.ACTION_FIELD;
    private enum ActionType {}
    public SimulationStats.FieldType getFieldType() {
        return fieldType;
    }
}
