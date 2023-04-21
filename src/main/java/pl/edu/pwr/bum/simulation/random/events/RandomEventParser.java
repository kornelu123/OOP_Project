package pl.edu.pwr.bum.simulation.random.events;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.edu.pwr.bum.simulation.app.SimulationStats;

public class RandomEventParser {

    public static List<RandomEvent> parseJSONFile() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        Path path = Path.of("src/main/JSONFiles/randomEvents.json");
        File jsonFile = new File(path.toUri());
        JSONArray jsonArray = null;
        try (Reader reader = new FileReader(jsonFile)) {
            try {
                jsonArray = (JSONArray) parser.parse(reader);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<RandomEvent> randomEventList = new ArrayList<RandomEvent>();

        Iterator<JSONObject> iterator = jsonArray.iterator();
        while(iterator.hasNext()){
            JSONObject jsonObject = iterator.next();
            Long id =(Long) jsonObject.get("id");
            boolean hasBeen = booleanParser((String) jsonObject.get("hasBeen"));
            SimulationStats.FieldType fieldType = fieldTypeParser((String) jsonObject.get("fieldType"));
            String description = (String) jsonObject.get("description");
            System.out.println(fieldType);
            if(fieldType == SimulationStats.FieldType.NULL){
                System.out.println("Bad JSON file , ID : " + id);
                break;
            }
            RandomEvent randomEvent = new RandomEvent(id ,hasBeen,fieldType,description);
            randomEventList.add(randomEvent);
        }
        return randomEventList;
    }

    private static boolean booleanParser(String bool) {
        if(bool == "true"){
            return true;
        }
        return false;
    }

    private static SimulationStats.FieldType fieldTypeParser(String fieldTypeString) {
        if(fieldTypeString .equals("ACTION_FIELD")){
            return SimulationStats.FieldType.ACTION_FIELD;
        }
        if(fieldTypeString.equals("EMPTY_FIELD")){
            return SimulationStats.FieldType.EMTPY_FIELD;
        }
        if(fieldTypeString.equals("SLODOWA")){
            return SimulationStats.FieldType.SLODOWA;
        }
        if(fieldTypeString.equals("LIQUOR_STORE")){
            return SimulationStats.FieldType.LIQUOR_STORE;
        }
        if(fieldTypeString.equals("SOBERING_STATION")){
            return SimulationStats.FieldType.SOBERING_STATION;
        }
        return SimulationStats.FieldType.NULL;
    }

    public RandomEventParser() throws FileNotFoundException {
            System.out.println("File Not Found ;[");
        }
    }

