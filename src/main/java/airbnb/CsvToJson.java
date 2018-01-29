package airbnb;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CsvToJson {

    //1. use a flag to remember if the current string is in quote
    //2. assume no trailing comma
    // case 1: "",
    // case 2: ,,, (empty field, trailing comma?)
    //
    private List<List<String>> parseCSV(@NonNull String csv) {
        List<List<String>> result = new ArrayList<>();
        List<String> fields = new ArrayList<>();
        boolean isQuoted = false;
        StringBuilder field = new StringBuilder();
        for (int i = 0; i < csv.length(); ++i) {
            char ch = csv.charAt(i);
            if(isQuoted) {
                if (ch == '"') {
                    if (i == csv.length()-1) {
                        fields.add(field.toString());
                        field.setLength(0); //clear field
                        isQuoted = false;
                    }
                    else if (csv.charAt(i+1) == '"'){
                        field.append('"');
                        ++i; //extra increment
                    }
                    else { //closing quote, also need to skip following comma
                        fields.add(field.toString());
                        field.setLength(0); //clear field
                        isQuoted = false;
                        ++i;
                    }
                }
                else {
                    field.append(ch);
                }
            }
            else {
                if (ch == '"') {
                    isQuoted = true;
                }
                else if (ch == ',') {
                    fields.add(field.toString());
                    field.setLength(0);

                }
                else if (ch == '\n') {
                    fields.add(field.toString());
                    field.setLength(0);
                    result.add(fields);
                    fields = new ArrayList<>();
                }
                else {
                    field.append(ch);
                }
            }
        }
        if (!fields.isEmpty()) {
            fields.add(field.toString());
            result.add(fields);
        }
        return result;
    }

    public  String toJson(String csv) {
        List<List<String>> csvRows = parseCSV(csv);
        StringBuilder json = new StringBuilder();
        json.append('[');
        for (int i = 1; i < csvRows.size(); ++i) {
            json.append('{');
            for (int j = 0; j < csvRows.get(0).size(); ++j) {
                json.append("\"").append(csvRows.get(0).get(j)).append("\":");
                json.append("\"").append(csvRows.get(i).get(j)).append("\"");
                if (j < csvRows.get(0).size()-1) {
                    json.append(',');
                }
            }
            json.append('}');
            if (i < csvRows.size()-1) {
                json.append(',');
            }
        }
        json.append(']');
        return json.toString();
    }
}
