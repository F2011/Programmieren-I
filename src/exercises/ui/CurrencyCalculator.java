package exercises.ui;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator extends JFrame {
    public CurrencyCalculator() {
        this.setLayout(new BorderLayout());
        this.setTitle("Currency converter");
        JTextField currencyField = new JTextField("Please enter amount to convert!");
        JButton[] buttons = new JButton[3];
        buttons[0] = new JButton("EUR -> USD");
        buttons[1] = new JButton("USD -> EUR");
        buttons[2] = new JButton("Cancel");

        this.add(currencyField, BorderLayout.NORTH);
        JPanel lowerContainer = new JPanel();
        lowerContainer.setLayout(new FlowLayout());
        this.add(lowerContainer, BorderLayout.SOUTH);
        for (JButton button : buttons) {
            lowerContainer.add(button);
        }

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
