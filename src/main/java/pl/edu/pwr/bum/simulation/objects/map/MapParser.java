package pl.edu.pwr.bum.simulation.objects.map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.edu.pwr.bum.simulation.objects.location.ActionField;
import pl.edu.pwr.bum.simulation.objects.location.EmptyField;
import pl.edu.pwr.bum.simulation.objects.location.Field;
import pl.edu.pwr.bum.simulation.objects.location.LiquorStore;
import pl.edu.pwr.bum.simulation.objects.type.FieldType;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static pl.edu.pwr.bum.simulation.objects.type.FieldTypeParser.fieldTypeParser;


public class MapParser {
    public static List<Field> parseJSONFile() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        Path path = Path.of("src/main/java/resources/mapTiles.json");
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
        List<Field> MapFieldsList = new ArrayList<Field>();
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
            Field mapField = new EmptyField(x, y ,name);
            if(fieldType == FieldType.ACTION_FIELD){
                mapField = new ActionField(x, y, name);
            }
            if(fieldType == FieldType.LIQUOR_STORE){
                mapField = new LiquorStore(x, y, name);
            }

            MapFieldsList.add(mapField);
        }
        System.out.println(MapFieldsList);
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
