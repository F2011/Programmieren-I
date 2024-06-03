package exercises.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculator extends JFrame {
    public CurrencyCalculator() {
        this.setLayout(new BorderLayout());
        this.setTitle("Currency converter");
        JTextField currencyField = new JTextField("Please enter amount to convert!");
        JButton[] buttons = new JButton[3];
        buttons[0] = new JButton("EUR -> USD");
        buttons[1] = new JButton("USD -> EUR");
        buttons[2] = new JButton("Cancel");
        buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text;
                try {
                    double amount = Double.parseDouble(currencyField.getText());
                    text = "" + amount * 1.09;
                } catch (NumberFormatException exception) {
                    text = "Error! Please enter a valid number!";
                }
                currencyField.setText(text);
            }
        });
        buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text;
                try {
                    double amount = Double.parseDouble(currencyField.getText());
                    text = "" + amount / 1.09;
                } catch (NumberFormatException exception) {
                    text = "Error! Please enter a valid number!";
                }
                currencyField.setText(text);
            }
        });
        buttons[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

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
