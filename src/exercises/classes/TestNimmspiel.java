package exercises.classes;

public class TestNimmspiel {
    public static void main(String[] args) {
        var nimmspiel = new Nimmspiel("1", "2");
        while (nimmspiel.next());
    }
}
