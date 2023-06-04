package pl.edu.pwr.bum.simulation.objects.type;

public class FieldTypeParser {
    public static FieldType fieldTypeParser(String fieldTypeString) {
        if(fieldTypeString.equals("ACTION_FIELD")){
            return FieldType.ACTION_FIELD;
        }
        if(fieldTypeString.equals("EMPTY_FIELD")){
            return FieldType.EMTPY_FIELD;
        }
        if(fieldTypeString.equals("SLODOWA")){
            return FieldType.SLODOWA;
        }
        if(fieldTypeString.equals("LIQUOR_STORE")){
            return FieldType.LIQUOR_STORE;
        }
        if(fieldTypeString.equals("SOBERING_STATION")){
            return FieldType.SOBERING_STATION;
        }
        return FieldType.NULL;
    }
}
