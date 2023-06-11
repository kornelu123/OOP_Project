package pl.edu.pwr.bum.simulation.objects.map;

import pl.edu.pwr.bum.simulation.objects.location.Field;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MapArray {
    private ArrayList<Field> map;

    public MapArray() throws FileNotFoundException {
        this.map = (ArrayList<Field>) MapParser.parseJSONFile();
    }

    public Field getCurrentField(int x , int y){
        int spec = x + 15*y;
        Field currentField = map.get(spec);
        return currentField;
    }
}
