package pl.edu.pwr.bum.simulation.objects.map;

import pl.edu.pwr.bum.simulation.objects.type.FieldType;

public class MapField {
    public int id;
    public int x;
    public int y;
    public String name;
    public FieldType fieldType;
    public MapField(int x, int y, String name, FieldType fieldType) {
        this.id = x + 15*y;
        this.x = x;
        this.y = y;
        this.name = name;
        this.fieldType = fieldType;
    }


}
