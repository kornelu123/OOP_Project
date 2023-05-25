package pl.edu.pwr.bum.simulation.map;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MapArray {
    private ArrayList<MapField> map;

    public MapArray() throws FileNotFoundException {
        this.map = (ArrayList<MapField>) MapParser.parseJSONFile();
    }

    public MapField getCurrentField(int x , int y){
        int spec = x + 15*y;
        MapField currentField = map.get(spec);
        System.out.println(currentField.id);
        return currentField;
    }
}
