package pl.edu.pwr.bum.simulation.app;

import pl.edu.pwr.bum.simulation.filedType.FieldType;
import pl.edu.pwr.bum.simulation.map.MapArray;
import pl.edu.pwr.bum.simulation.map.MapField;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;
import pl.edu.pwr.bum.simulation.unit.MainBum;

import java.io.FileNotFoundException;
import java.util.Map;

public class SimulationStats {

    private Integer currentRandomEvent = 0;
    private Map<Integer,RandomEvent> randomEventMap;

    private MapArray map;

    public MainBum kloszard;

    public MapField currentField ;
    public SimulationStats(Map<Integer, RandomEvent> randomEventMap, MainBum kloszard) throws FileNotFoundException {
        this.map = new MapArray();
        this.currentField = map.getCurrentField(this.x, this.y);
        this.randomEventMap = randomEventMap;
        this.kloszard = kloszard;
    }

    public int x = 8;
    public int y = 7;
      
    public enum FieldType{
        MINUS_30,
        ACTION_FIELD,
        EMTPY_FIELD,
        LIQUOR_STORE,
        SOBERING_STATION,
        SLODOWA,
        NULL
    }

    public void goUp(){
        if(y == 14){
            this.y--;
        }else {
            this.y++;
        }
    }

    public void goDown(){
        if(y == 0){
            this.y++;
        }else {
            this.y--;
        }
    }

    public void goLeft(){
        if(x == 0){
            this.x++;
        }else {
            this.x--;
        }
    }

    public void goRight(){
        if(x == 14){
            this.x--;
        }else {
            this.x++;
        }
    }

    public RandomEvent getRandomEvent(){
        this.currentRandomEvent++;
        return this.randomEventMap.get(currentRandomEvent);
    }

}
