package JsonTests;

import org.junit.Test;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;
import pl.edu.pwr.bum.simulation.random.events.RandomEventParser;

import java.io.FileNotFoundException;
import java.util.List;

public class TestRandomEventParser {
    @Test
    public void TestJsonPatrser() throws FileNotFoundException {
        List<RandomEvent> randomEventsJSON = RandomEventParser.parseJSONFile();
        RandomEvent randomEvent = randomEventsJSON.get(0);
    }
}
