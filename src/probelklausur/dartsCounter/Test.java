package probelklausur.dartsCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Game game = new Game(null, null);
        game.test();
//        Path p = Paths.get("src/probelklausur/dartsCounter/checkouts.txt");
//        String[] lines = new String[170];
//        lines = Files.readAllLines(p.toAbsolutePath()).toArray(lines);
//        for (String line : lines) {
//            System.out.println(line);
//        }
    }
}

