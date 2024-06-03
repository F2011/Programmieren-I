package exercises.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryNumber extends JFrame {
    private int value = 0;
    private final JLabel labelBinN;

    public static void main(String[] args) {
        new BinaryNumber();
    }

    public BinaryNumber() {
        this.setTitle("Binary Number");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        this.setSize(400, 100);

        JToggleButton[] toggleButtons = new JToggleButton[8];
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 8));
        this.add(buttonPanel);

        for (int i = 0; i < toggleButtons.length; i++) {
            toggleButtons[i] = new JToggleButton(String.valueOf(i));
            toggleButtons[i].setIcon(new ImageIcon("/Users/i589151/repos/Programmieren-I/src/exercises/ui/event/off.png"));
            toggleButtons[i].setSelectedIcon(new ImageIcon("/Users/i589151/repos/Programmieren-I/src/exercises/ui/event/on.png"));
            toggleButtons[i].addActionListener(new Action(i));
            buttonPanel.add(toggleButtons[i]);
        }
        for (int i = 0; i < toggleButtons.length; i++) {
            buttonPanel.add(new JLabel("2^" + i));
        }

        labelBinN = new JLabel(formatText(String.valueOf(value), 20));
        labelBinN.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelBinN);

        this.setVisible(true);

    }

    private class Action extends AbstractAction implements ActionListener {
        private final int exponent;
        private Action(int exponent) {
            this.exponent = exponent;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JToggleButton) e.getSource()).isSelected()) {
                value += (int) Math.pow(2, exponent);
                labelBinN.setText(formatText(String.valueOf(value), 20));
                if (value == 187) {
                    BinaryNumber.this.setSize(400, 200);
                    labelBinN.setText(formatText(String.valueOf(value), 40));
                } else {
                    BinaryNumber.this.setSize(400, 100);
                }
            } else {
                value -= (int) Math.pow(2, exponent);
                labelBinN.setText(formatText(String.valueOf(value), 20));
                if (value == 187) {
                    BinaryNumber.this.setSize(400, 200);
                    labelBinN.setText(formatText(String.valueOf(value), 40));
                } else {
                    BinaryNumber.this.setSize(400, 100);
                }
            }
        }
    }

    private String formatText(String text, int size) {
        return "<html><p style=font-weight:bold;font-size:" + size + "pt>" + text + "</p></html>";
    }
}
