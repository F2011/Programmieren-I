package exercises.threads;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DancingText extends JComponent implements Runnable {
    private String text;
    private long delay;

    private int x = 20;
    private int y = 20;

    private int i = 0;
    private int direction = 1;

    private static final Random RANDOM = new Random();

    private int colR, colG, colB;

    public DancingText(String text, long delay) {
        this.text = text;
        this.delay = delay;
        this.colR = colG = colB = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        for (int i = 0; i < text.length(); i++) {
            char c = this.text.charAt(i);

            this.colR = (this.colR + 4 + DancingText.RANDOM.nextInt(200)) % 256;
            this.colG = (this.colG + 4 + DancingText.RANDOM.nextInt(200)) % 256;
            this.colB = (this.colB + 4 + DancingText.RANDOM.nextInt(200)) % 256;
            g.setColor(new Color(this.colR, this.colG, this.colB));
            this.y = (this.y + this.direction * DancingText.RANDOM.nextInt(20));
            if (this.y > 200) {
                this.y = 200;
                this.direction *= -1;
            } else if (this.y < 20) {
                this.y = 20;
                this.direction *= -1;
            }
            g.drawString(String.valueOf(c), this.x + i * 10, this.y);
        }
    }

    public void run() {
        while (true) {
            this.repaint();
            System.out.println(i++);
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dancing Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DancingText dt = new DancingText("Hello World", 300);

        frame.add(dt);
        new Thread(dt).start();

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
