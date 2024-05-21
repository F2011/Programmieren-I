package probelklausur.dartsCounter;

public class Visit {
    private Field[] fields;

    public Visit(Field[] fields) {
        if (fields.length > 3) throw new IllegalArgumentException();
        this.fields = fields;
    }

    public Field[] getFields() {
        return fields;
    }
    public int getValue() {
        int sum = 0;
        for (Field field : fields) {
            sum += field.getValue();
        }
        return sum;
    }
    public Field getLastField() {
        return fields[fields.length - 1];
    }
}
