package pl.edu.pwr.bum.simulation.app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;
import pl.edu.pwr.bum.simulation.random.events.RandomEventParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        List<RandomEvent> randomEventsJSON = RandomEventParser.parseJSONFile();
    }
}
