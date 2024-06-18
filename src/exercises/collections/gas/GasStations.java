package exercises.collections.gas;

import javax.swing.*;
import java.awt.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class GasStations extends JFrame {
    private SortedMap<String, GasPrices> prices;
    public static void main(String[] args) {
        new GasStations();
    }

    public GasStations() {
        prices = new TreeMap<>();

        this.setTitle("Gas Stations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1));
        this.setSize(500, 500);

        JPanel panelStationName = new JPanel();
        panelStationName.setLayout(new GridLayout(1, 2));
        JLabel labelStationName = new JLabel("Station Name");
        panelStationName.add(labelStationName);
        JTextField textFieldStationName = new JTextField();
        panelStationName.add(textFieldStationName);

        JPanel panelDiesel = new JPanel();
        panelDiesel.setLayout(new GridLayout(1, 2));
        JLabel labelDiesel = new JLabel("Diesel");
        panelDiesel.add(labelDiesel);
        JTextField textFieldDiesel = new JTextField();
        panelDiesel.add(textFieldDiesel);

        JPanel panelSuperE5 = new JPanel();
        panelSuperE5.setLayout(new GridLayout(1, 2));
        JLabel labelSuperE5 = new JLabel("SuperE5");
        panelSuperE5.add(labelSuperE5);
        JTextField textFieldSuperE5 = new JTextField();
        panelSuperE5.add(textFieldSuperE5);

        JPanel panelSuperE10 = new JPanel();
        panelSuperE10.setLayout(new GridLayout(1, 2));
        JLabel labelSuperE10 = new JLabel("SuperE10");
        panelSuperE10.add(labelSuperE10);
        JTextField textFieldSuperE10 = new JTextField();
        panelSuperE10.add(textFieldSuperE10);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, 2));
        JButton buttonSave = new JButton("Save");
        buttonSave.addActionListener(e -> {
            if (textFieldStationName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide a station name");
                return;
            }
            GasPrices gasPrices = new GasPrices();
            double diesel;
            double superE5;
            double superE10;
            try {
                diesel = Double.parseDouble(textFieldDiesel.getText());
            } catch (NumberFormatException ex) {
                diesel = -1;
            }
            try {
                superE5 = Double.parseDouble(textFieldSuperE5.getText());
            } catch (NumberFormatException ex) {
                superE5 = -1;
            }
            try {
                superE10 = Double.parseDouble(textFieldSuperE10.getText());
            } catch (NumberFormatException ex) {
                superE10 = -1;
            }
            gasPrices.setPrices(diesel, superE5, superE10);
            prices.put(textFieldStationName.getText(), gasPrices);

            JOptionPane.showMessageDialog(this,
                    "Saved: " + textFieldStationName.getText() + " (" + gasPrices + ")");
            textFieldStationName.setText("");
            textFieldDiesel.setText("");
            textFieldSuperE5.setText("");
            textFieldSuperE10.setText("");
        });
        buttonSave.setActionCommand("Save");
        panelButtons.add(buttonSave);
        JButton buttonShowAll = new JButton("Show all");
        buttonShowAll.addActionListener(e -> {
            StringBuilder builder = new StringBuilder();
            for (String key : prices.keySet()) {
                builder.append(key).append(": ").append(prices.get(key)).append("\n");
            }
            JOptionPane.showMessageDialog(this, builder.toString());
        });
        panelButtons.add(buttonShowAll);

        this.add(panelStationName);
        this.add(panelDiesel);
        this.add(panelSuperE5);
        this.add(panelSuperE10);
        this.add(panelButtons);
        this.setVisible(true);

    }
}
