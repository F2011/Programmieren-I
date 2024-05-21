package exercises.ui;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame extends JFrame {

    public ComponentFrame() {
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel("JLabel");
        this.add(label);
        JTextField textField = new JTextField();
        this.add(textField);
        JPasswordField passwordField = new JPasswordField();
        this.add(passwordField);
        JButton jButton = new JButton("JButton");
        this.add(jButton);
        JToggleButton jToggleButton = new JToggleButton("JToggleButton");
        this.add(jToggleButton);
        JCheckBox jCheckBox = new JCheckBox("JCheckBox");
        this.add(jCheckBox);
        JComboBox<String> jComboBox = new JComboBox<String>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"});
        this.add(jComboBox);
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            JRadioButton radioButton = new JRadioButton("Radio-Button-" + i);
            buttonGroup.add(radioButton);
            this.add(radioButton);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentFrame();
    }
}
