package pl.edu.pwr.bum.simulation.app;
import pl.edu.pwr.bum.simulation.map.MapArray;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;
import pl.edu.pwr.bum.simulation.random.events.RandomEventParser;
import pl.edu.pwr.bum.simulation.random.events.animation.DrinkBeerAnimation;
import pl.edu.pwr.bum.simulation.table.TableHandler;
import pl.edu.pwr.bum.simulation.unit.MainBum;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        List<RandomEvent> randomEventsJSON = RandomEventParser.parseJSONFile();
        HashMap<Integer,RandomEvent> randomEventMap = new HashMap<Integer,RandomEvent>();
        for (RandomEvent randomEvent: randomEventsJSON) {
            randomEventMap.put(randomEvent.getRandomEventIndex(),randomEvent);
        }
        MainBum kloszard = new MainBum("zulas",50,300,2);
        MapArray map = new MapArray();
        SimulationStats simStat = new SimulationStats(randomEventMap,kloszard);
        TableHandler.printStatsTable(simStat);
        Thread.sleep(5000);
        simStat.kloszard.handleDrunkMeterOperation(3*100, MainBum.operation.ADD);
        TableHandler.printStatsTable(simStat);
    }
}
