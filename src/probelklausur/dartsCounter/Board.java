package probelklausur.dartsCounter;

import java.util.ArrayList;

public class Board {
    private Field[] fields;

    public Board() {
        fields = new Field[63];
        int counter = 0;
        for (int i = 1; i <= 20; i++) {
            fields[counter++] = new Field(String.format("%d", i), i, false);
            fields[counter++] = new Field(String.format("D%d", i), 2 * i, true);
            fields[counter++] = new Field(String.format("T%d", i), 3 * i, false);
        }
        fields[counter++] = new Field(String.format("%d", 25), 25, false);
        fields[counter++] = new Field("BULL", 50, true);
        fields[counter] = new Field("x", 0, false);
    }

    public Field parseField(String label) {
        label = label.toLowerCase();
        for (Field field : fields) {
            if (field.getLabel().toLowerCase().equals(label)) return field;
        }
        return null;
    }
}
