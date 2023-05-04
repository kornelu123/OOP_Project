package pl.edu.pwr.bum.simulation.map;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class mapParserTest {
    @Test
    void JSONmapParserTest() throws FileNotFoundException {
        List<MapField> MapJSON = mapParser.parseJSONFile();
        System.out.println(MapJSON);
        assertTrue(true);
    }

}