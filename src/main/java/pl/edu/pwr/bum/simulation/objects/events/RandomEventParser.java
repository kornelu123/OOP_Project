package pl.edu.pwr.bum.simulation.objects.events;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.edu.pwr.bum.simulation.objects.type.FieldType;

import static pl.edu.pwr.bum.simulation.objects.type.FieldTypeParser.fieldTypeParser;

public class RandomEventParser {

    public static List<RandomEvent> parseJSONFile() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        Path path = Path.of("src/main/java/pl/edu/pwr/bum/simulation/resources/randomEvents.json");
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
        int id=0;
        while(iterator.hasNext()){
            JSONObject jsonObject = iterator.next();
            String description = (String) jsonObject.get("description");
            Long bottleAmount = (Long) jsonObject.get("bottles");
            RandomEvent randomEvent = new RandomEvent(id,description, bottleAmount);
            randomEventList.add(randomEvent);
            id++;
        }
        return randomEventList;
    }

    private static boolean booleanParser(String bool) {
        if(bool == "true"){
            return true;
        }
        return false;
    }



    public RandomEventParser() throws FileNotFoundException {
            System.out.println("File Not Found ;[");
        }
    }

