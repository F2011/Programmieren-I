package exercises.java8.soccer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Soccer {
    public static void main(String[] args) {
        Path p = Paths.get("/Users/i589151/repos/Programmieren-I/src/exercises/java8/soccer/33_Java8_Aufgaben_TeamDE/33_Java8_Aufgaben_TeamDE.txt");
        List<Player> players;
        try {
            players = Files.readAllLines(p)
                    .stream()
                    .map(Soccer::parseLine)
                    .filter(Objects::nonNull)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Players sorted by number:");
        players.stream().sorted(Soccer::comparePlayerByNumber).forEach(System.out::println);

        System.out.println("\nPlayers with more than 50 games:");
        players.stream().filter(player -> player.games() > 50).sorted(Soccer::comparePlayerByName).forEach(System.out::println);

        System.out.println("\nAll clubs of the players:");
        players.stream().map(Player::club).distinct().forEach(System.out::println);

        System.out.print("\nNumber of players with less than 5 goals: ");
        System.out.println(players.stream().filter(player -> player.goals() < 5).count());

        System.out.print("\nNumber of goals scored by all of the players: ");
        System.out.println(players.stream().mapToInt(Player::goals).sum());
    }

    private static Player parseLine(String l) {
        String[] line = l.split(";");
        if (line.length == 7) {
            return new Player(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], Integer.parseInt(line[5]), Integer.parseInt(line[6]));
        } else {
            return null;
        }
    }

    private static int comparePlayerByNumber(Player p1, Player p2) {
        return Integer.compare(p1.number(), p2.number());
    }

    private static int comparePlayerByName(Player p1, Player p2) {
        return p1.name().compareTo(p2.name());
    }
}
