package pl.edu.pwr.bum.simulation.app;

import pl.edu.pwr.bum.simulation.random.events.RandomEvent;

import java.util.Map;

public class SimulationStats {
    private int x;
    private int y;
    private Map<RandomEvent,SimulationStats.FieldType> randomEventMap;
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

    public SimulationStats(Map<RandomEvent, FieldType> randomEventMap) {
        this.x = 7;
        this.y = 8;
        this.randomEventMap = randomEventMap;
    }
}
