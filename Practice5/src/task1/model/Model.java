package task1.model;

import task1.model.entity.Record;
import java.util.ArrayList;

public class Model {
    private ArrayList<Record> records;

    private final String[] REGEXP = {
            "[A-Z]([a-z]{1,16})",
            "[A-Z]([a-z]{1,16})",
            "[0-9]{4,4}[\\./]((0[1-9])|(1[0-2]))[\\./]((0[1-9])|([12][0-9])|(3[01]))",
            "\\+[1-9]\\d{2}\\(\\d{2}\\)(\\d{2}-){2}\\d{3}",
            "(([A-Z]?([a-z]{0,15})([ -]?))|([0-9]{1,5}([ -]?))){1,5}" + ", " + "([0-9]{1,4}([a-z]?))" + ", " + "([0-9]{1,4})"
    };

    public static final String[] RECORD_FIELDS = {
            "Name",
            "Surname",
            "Birthday",
            "Phone",
            "Address"
    };

    public Model() {
        records = new ArrayList<>();
    }

    public String[] getRecords() {
        String[] result = new String[records.size()];
        for(int i = 0; i < records.size(); i++) {
            result[i] = records.get(i).toString();
        }
        return result;
    }

    public int addRecord(String[] data) throws IndexOutOfBoundsException {
        for(int i = 0; i < REGEXP.length; i++) {
            if(!validateString(data[i], REGEXP[i]))
                return i;
        }
        records.add(new Record(data[0], data[1], data[2], data[3], data[4]));
        return -1;
    }

    private boolean validateString(String string, String regex) {
        return string.matches(regex);
    }
}