package pl.edu.pwr.bum.simulation.app;

import pl.edu.pwr.bum.simulation.objects.map.MapArray;
import pl.edu.pwr.bum.simulation.objects.map.MapField;
import pl.edu.pwr.bum.simulation.objects.events.RandomEvent;
import pl.edu.pwr.bum.simulation.objects.events.RandomEventParser;
import pl.edu.pwr.bum.simulation.objects.MainBum;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulationStats {
    private Integer decreaseAmount;

    private Integer currentRandomEvent = 1;
    private Integer MAX_RANDOM_EVENT = 29;
    private Map<Integer,RandomEvent> randomEventMap;

    private MapArray map;

    public MainBum kloszard;

    public MapField currentField ;
    public SimulationStats(Map<Integer, RandomEvent> randomEventMap, MainBum kloszard,Integer decreaseAmount) throws FileNotFoundException {
        this.map = new MapArray();
        this.currentField = map.getCurrentField(this.x, this.y);
        this.randomEventMap = randomEventMap;
        this.kloszard = kloszard;
        this.decreaseAmount = decreaseAmount;
    }

    public void handleLiquorStore() throws InterruptedException {
        this.kloszard.buyMaxAmountOfPiwo();
    }

    public int x = 8;
    public int y = 7;

    private void handleTurn() throws InterruptedException {
        this.kloszard.handleDrunkMeterOperation(this.decreaseAmount, MainBum.operation.REMOVE);
    }

    public void goUp() throws InterruptedException {
        if(y == 14){
            this.y--;
        }else {
            this.y++;
        }
        this.handleTurn();
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public void goDown() throws InterruptedException {
        if(y == 0){
            this.y++;
        }else {
            this.y--;
        }
        this.handleTurn();
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public void goLeft() throws InterruptedException {
        if(x == 0){
            this.x++;
        }else {
            this.x--;
        }
        this.handleTurn();
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public void goRight() throws InterruptedException {
        if(x == 14){
            this.x--;
        }else {
            this.x++;
        }
        this.handleTurn();
        this.currentField = map.getCurrentField(this.x,this.y);
    }

    public RandomEvent getRandomEvent(){
        return this.randomEventMap.get(currentRandomEvent%MAX_RANDOM_EVENT);
    }

    public void handleActionField(){
        RandomEvent randomEvent = getRandomEvent();
        this.kloszard.handleBottlesCountOperation(randomEvent.bottleCount, MainBum.operation.ADD);
        currentRandomEvent++;
    }
    static public SimulationStats initSimStats(String name, int strength, int drunkMeter, Long amoutOfBottles, Integer bottlesDecrease) throws FileNotFoundException {
        List<RandomEvent> randomEventsJSON = RandomEventParser.parseJSONFile();
        HashMap<Integer,RandomEvent> randomEventMap = new HashMap<Integer,RandomEvent>();
        for (RandomEvent randomEvent: randomEventsJSON) {
            randomEventMap.put(randomEvent.getRandomEventIndex(),randomEvent);
        }
        MainBum kloszard = new MainBum(name,strength, (long) drunkMeter,amoutOfBottles,bottlesDecrease);
        MapArray map = new MapArray();
        SimulationStats simStat = new SimulationStats(randomEventMap,kloszard,bottlesDecrease);
        return simStat;
    }

}
