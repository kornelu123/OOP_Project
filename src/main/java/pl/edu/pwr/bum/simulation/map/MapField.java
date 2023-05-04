package pl.edu.pwr.bum.simulation.map;

import pl.edu.pwr.bum.simulation.filedType.FieldType;

public class MapField {
    private int x;
    private int y;
    String name;
    FieldType fieldType;
    public MapField(int x, int y, String name, FieldType fieldType) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.fieldType = fieldType;
    }


}
