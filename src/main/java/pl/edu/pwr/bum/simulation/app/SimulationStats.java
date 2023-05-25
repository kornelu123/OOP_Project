package pl.edu.pwr.bum.simulation.app;

import pl.edu.pwr.bum.simulation.filedType.FieldType;
import pl.edu.pwr.bum.simulation.map.MapArray;
import pl.edu.pwr.bum.simulation.map.MapField;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;
import pl.edu.pwr.bum.simulation.random.events.RandomEventParser;
import pl.edu.pwr.bum.simulation.unit.MainBum;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulationStats {

    private Integer currentRandomEvent = 1;
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

    public void handleLiquorStore() throws InterruptedException {
        this.kloszard.buyMaxAmountOfPiwo();
    }

    public int x = 8;
    public int y = 7;
      
    public enum FieldType{
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
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public void goDown(){
        if(y == 0){
            this.y++;
        }else {
            this.y--;
        }
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public void goLeft(){
        if(x == 0){
            this.x++;
        }else {
            this.x--;
        }
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public void goRight(){
        if(x == 14){
            this.x--;
        }else {
            this.x++;
        }
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public RandomEvent getRandomEvent(){
        return this.randomEventMap.get(currentRandomEvent);
    }

    public void handleActionField(){
        RandomEvent randomEvent = randomEventMap.get(currentRandomEvent);
        this.kloszard.handleBottlesCountOperation(randomEvent.bottleCount, MainBum.operation.ADD);
        currentRandomEvent++;
    }

    public void handleBumDirection (){

    }

    static public SimulationStats initSimStats(String name, int strength, int drunkMeter, Long amoutOfBottles) throws FileNotFoundException {
        List<RandomEvent> randomEventsJSON = RandomEventParser.parseJSONFile();
        HashMap<Integer,RandomEvent> randomEventMap = new HashMap<Integer,RandomEvent>();
        for (RandomEvent randomEvent: randomEventsJSON) {
            randomEventMap.put(randomEvent.getRandomEventIndex(),randomEvent);
        }
        MainBum kloszard = new MainBum(name,strength, (long) drunkMeter,amoutOfBottles);
        MapArray map = new MapArray();
        SimulationStats simStat = new SimulationStats(randomEventMap,kloszard);
        return simStat;
    }

}
