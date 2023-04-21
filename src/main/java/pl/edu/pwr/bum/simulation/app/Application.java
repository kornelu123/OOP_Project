package pl.edu.pwr.bum.simulation.app;
import com.acidmanic.consoletools.table.Table;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;
import pl.edu.pwr.bum.simulation.random.events.RandomEventParser;
import pl.edu.pwr.bum.simulation.table.TableHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        List<RandomEvent> randomEventsJSON = RandomEventParser.parseJSONFile();
        RandomEvent randomEvent = randomEventsJSON.get(0);
        TableHandler.printStatsTable(randomEvent);
    }
}
