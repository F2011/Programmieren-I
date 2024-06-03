package exercises.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {
    public static void main(String[] args) {
        new BMICalculator();
    }

    public BMICalculator() {
        this.setTitle("BMICalculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6, 1));
        this.setSize(300, 250);

        JPanel panelWeight = new JPanel();
        panelWeight.setLayout(new GridLayout(1, 2));
        JLabel labelWeight = new JLabel("Weight [kg]");
        JTextField textFieldWeight = new JTextField();
        panelWeight.add(labelWeight);
        panelWeight.add(textFieldWeight);

        JPanel panelHeight = new JPanel();
        panelHeight.setLayout(new GridLayout(1, 2));
        JLabel labelHeight = new JLabel("Body height [m]");
        JTextField textFieldHeight = new JTextField();
        panelHeight.add(labelHeight);
        panelHeight.add(textFieldHeight);

        JPanel panelGenderButtons = new JPanel();
        panelGenderButtons.setLayout(new GridLayout(1, 2));
        ButtonGroup buttonGroupGender = new ButtonGroup();
        JRadioButton radioButtonMale = new JRadioButton("male");
        buttonGroupGender.add(radioButtonMale);
        panelGenderButtons.add(radioButtonMale);
        radioButtonMale.setSelected(true);
        JRadioButton radioButtonFemale = new JRadioButton("female");
        buttonGroupGender.add(radioButtonFemale);
        panelGenderButtons.add(radioButtonFemale);

        JButton buttonCalculate = new JButton("Calculate");

        JPanel panelBMI = new JPanel();
        panelBMI.setLayout(new GridLayout(1, 2));
        JLabel labelBMI = new JLabel("BMI");
        JLabel textFieldBMI = new JLabel();
        panelBMI.add(labelBMI);
        panelBMI.add(textFieldBMI);

        JLabel labelClassification = new JLabel();


        buttonCalculate.addActionListener(e -> {
            double weight;
            double height;
            try {
                weight = Double.parseDouble(textFieldWeight.getText());
                height = Double.parseDouble(textFieldHeight.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter a valid weight (e.g. 65.4) and height (e.g. 1.78)!");
                return;
            }
            double bmi = weight / (height * height);
            textFieldBMI.setText(String.valueOf(bmi));
            if (radioButtonMale.isSelected()) {
                String text;
                if (bmi > 40.0) {
                    text = "Massive Adiposity";
                } else if (bmi > 30.0) {
                    text = "Adiposity";
                } else if (bmi > 25.0) {
                    text = "Overweight";
                } else if (bmi > 20.0) {
                    text = "Normal Weight";
                } else {
                    text = "Short weight";
                }
                labelClassification.setText(text);
            } else {
                String text;
                if (bmi > 40.0) {
                    text = "Massive Adiposity";
                } else if (bmi > 30.0) {
                    text = "Adiposity";
                } else if (bmi > 24.0) {
                    text = "Overweight";
                } else if (bmi > 19.0) {
                    text = "Normal Weight";
                } else {
                    text = "Short weight";
                }
                labelClassification.setText(text);
            }
        });

        this.add(panelWeight);
        this.add(panelHeight);
        this.add(panelGenderButtons);
        this.add(buttonCalculate);
        this.add(panelBMI);
        this.add(labelClassification);

        this.setVisible(true);
    }
}
