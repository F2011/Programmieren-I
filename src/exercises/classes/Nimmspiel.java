package exercises.classes;

import java.util.Scanner;

public class Nimmspiel {
    private int[] haufen;
    private String[] spieler;
    private int spielerAnDerReihe = 0;

    private Scanner sc;

    public Nimmspiel(String spieler1, String spieler2) {
        this.haufen = new int[2];
        haufen[0] = (int) (Math.random() * 10);
        haufen[1] = (int) (Math.random() * 10);
        spieler = new String[3];
        int spieler1pos = (int) (Math.random() * 2);
        this.spieler[spieler1pos] = spieler1;
        this.spieler[1 - spieler1pos] = spieler2;
        this.sc = new Scanner(System.in);
        System.out.println(this);
    }

    public Nimmspiel(Nimmspiel old) {
        this(old.spieler[0], old.spieler[1]);
    }

    public boolean next() {
        String text;
        if (haufen[0] == 0 && haufen[1] == 0) {
            System.out.println("Spiel beendet.\nGewonnen hat Spieler " + spieler[2]);
            spielerAnDerReihe = -1;
            return false;
        } else {
            int haufenNr;
            while (true) {
                System.out.printf("Spieler %s: Vom welchem Haufen ziehen Sie Kugeln? ", spieler[spielerAnDerReihe]);
                haufenNr = sc.nextInt();
                if (this.haufen[haufenNr - 1] > 0) {
                    break;
                } else System.out.printf("Haufen %d ist bereits leer.\n", haufenNr);
            }
            System.out.printf(
                    "Spieler %s: Wie viele Kugeln ziehen Sie von Haufen %d? ", spieler[spielerAnDerReihe], haufenNr
            );
            int kugeln = sc.nextInt();
            if (setHaufen(haufenNr, kugeln)) {
                spieler[2] = spieler[spielerAnDerReihe];
            }
            System.out.println(this);
            spielerAnDerReihe = 1 - spielerAnDerReihe;
        }
        return true;
    }

    public boolean setHaufen(int haufenNr, int abzug) {
        if (abzug >= this.haufen[haufenNr - 1]) {
            this.haufen[haufenNr - 1] = 0;
            return true;
        } else {
            this.haufen[haufenNr - 1] -= abzug;
            return false;
        }
    }

    @Override
    public String toString() {
        if (spielerAnDerReihe < 0) return "Das Spiel ist zu Ende";
        else return "Spieler: " + spieler[0] + " und " + spieler[1] + "; Haufen 1: " + haufen[0] + " Kugel(n), " +
                "Haufen 2: " + haufen[1] + " Kugel(n)";
    }
}
