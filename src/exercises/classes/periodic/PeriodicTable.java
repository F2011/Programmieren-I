package exercises.classes.periodic;

public class PeriodicTable {
    public static void main(String[] args) {
        PeriodicTable.addElement(new Element("Wasserstoff", "H", 1, 'K'));
        PeriodicTable.addElement(new Element("Helium", "He", 2, 'K'));
        PeriodicTable.addElement(new Metal("Natrium", "Na", 11, 'M', false, 21 * Math.pow(10, 6)));
        PeriodicTable.addElement(new Metal("Eisen", "Fe", 26, 'N', 1, false, false, 10.02 * Math.pow(10, 6)));
        PeriodicTable.addElement(new Metal("Germanium", "Ge", 32, 'N',1, false, true, 1.45));
        PeriodicTable.addElement(new Element("Brom", "Br", 35, 'N'));
        PeriodicTable.addElement(new Metal("Tellur", "Te", 52, 'O', true, 0.005));
        PeriodicTable.addElement(new Metal("Gold", "Au", 79, 'P', 1, true, false, 44 * Math.pow(10, 6)));

        for (Element element : periodicTable) {
            if (element != null) System.out.println(element);
        }
    }

    private static Element[] periodicTable = new Element[118];

    public static void addElement(Element e) {
        if (!hasElement(e.ordinal)) periodicTable[e.ordinal - 1] = e;
    }

    public static boolean hasElement(int o) {
        for (Element element : periodicTable) {
            if (element != null && element.ordinal == o) return true;
        }
        return false;
    }

    public static Element getElement(int o) {
        if (o < 1 || o > 118) return null;
        return periodicTable[o - 1];
    }

    public Element[] getMetals() {
        int n = 0;
        for (Element element : periodicTable) {
            if (element != null && element.getClass() == Metal.class) n++;
        }
        Element[] metals = new Metal[n];
        int idx = 0;
        for (Element element : periodicTable) {
            if (element != null && element.getClass() == Metal.class) {
                metals[idx] = element;
                idx++;
            }
        }
        return metals;
    }

}
