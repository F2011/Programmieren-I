package exercises.enums;

import java.time.Month;
import java.util.Calendar;

public enum Months {
    JANUARY("Januar", new String[]{"Hartung", "Eismond"}),
    FEBRUARY("Febraur", new String[]{"Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"}),
    MARCH("März", new String[]{"Lenzing", "Lenzmond"}),
    APRIL("April", new String[]{"Launing", "Ostermond"}),
    MAY("Mai", new String[]{"Winnemond", "Blumenmond"}),
    JUNE("Juni", new String[]{"Brachet", "Brachmond"}),
    JULY("Juli", new String[]{"Heuert", "Heumond"}),
    AUGUST("August", new String[]{"Ernting", "Erntemond", "Bisemond"}),
    SEPTEMBER("September", new String[]{"Scheiding", "Herbstmond"}),
    OCTOBER("Oktober", new String[]{"Gilbhart", "Gilbhard", "Weinmond"}),
    NOVEMBER("November", new String[]{"Nebelung", "Windmond", "Wintermond"}),
    DECEMBER("Dezember", new String[]{"Julmond", "Heilmond", "Christmond", "Dustermond"});

    private final String name;
    private final String[] alternativeNames;

    Months(String name, String[] alts) {
        this.name = name;
        this.alternativeNames = alts;
    }

    public static void main(String[] args) {
        System.out.println(Months.values()[Calendar.getInstance().get(Calendar.MONTH)]);
    }

    private int getMonthDays() {
        int days = 0;
        switch (this) {
            case Months.JANUARY, Months.MARCH, Months.MAY, Months.JULY, Months.AUGUST, Months.OCTOBER, Months.DECEMBER
                    -> days = 31;
            case Months.FEBRUARY -> {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                if (year % 400 == 0) {
                    return 29;
                } else if (year % 100 == 0) {
                    return 28;
                } else if (year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            }
            case Months.APRIL, Months.JUNE, Months.SEPTEMBER, Months.NOVEMBER
                    -> days = 30;
        }
        return days;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Der ");
        builder.append(this.name);
        builder.append(" hat ");
        builder.append(this.getMonthDays());
        builder.append(" Tage und hieß früher '");
        for (int i = 0; i < this.alternativeNames.length - 1; i++) {
            builder.append(this.alternativeNames[i]);
            builder.append(", ");
        }
        builder.append(this.alternativeNames[this.alternativeNames.length - 1]);
        builder.append("'");
        return builder.toString();
    }
}
