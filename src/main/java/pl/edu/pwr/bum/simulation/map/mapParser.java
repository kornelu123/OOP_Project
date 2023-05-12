package pl.edu.pwr.bum.simulation.map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.edu.pwr.bum.simulation.filedType.FieldType;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static pl.edu.pwr.bum.simulation.filedType.FieldTypeParser.fieldTypeParser;


public class mapParser {
    public static List<MapField> parseJSONFile() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        Path path = Path.of("src/main/JSONFiles/mapTiles.json");
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
        List<MapField> MapFieldsList = new ArrayList<MapField>();
        Iterator<JSONObject> iterator = jsonArray.iterator();
        while(iterator.hasNext()){
            JSONObject jsonObject = iterator.next();
            int x = parseInt((String) jsonObject.get("x"));
            int y = parseInt((String) jsonObject.get("y"));
            String name = (String) jsonObject.get("name");
            FieldType fieldType = fieldTypeParser((String) jsonObject.get("FieldType"));
            if(fieldType == FieldType.NULL){
                System.out.println("Bad JSON fieldType");
                break;
            }
            MapField mapField = new MapField(x, y, name, fieldType);
            MapFieldsList.add(mapField);
        }
        return MapFieldsList;
    }

    private static int parseInt(String str) {
        int number = 0;
        try{
            number = Integer.parseInt(str);
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return number;
    }
}
