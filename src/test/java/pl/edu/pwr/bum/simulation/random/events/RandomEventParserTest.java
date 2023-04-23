package pl.edu.pwr.bum.simulation.random.events;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.security.cert.TrustAnchor;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomEventParserTest {
    @Test
    void JsonParserTest() throws FileNotFoundException {
        List<RandomEvent> randomEventsJSON = RandomEventParser.parseJSONFile();
        System.out.println(randomEventsJSON);
        assertTrue(true);
    }
}