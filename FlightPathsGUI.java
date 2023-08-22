/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author aripa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FlightPathsGUI extends JFrame {
    private JTextField sourceTextField;
    private JTextField destinationTextField;
    private JTextArea pathsTextArea;

    public FlightPathsGUI() {
        // Set the frame properties
        setTitle("Flight Paths");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create a panel with a vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create labels and text fields for source and destination airports
        JLabel sourceLabel = new JLabel("Source Airport:");
        sourceTextField = new JTextField();
        JLabel destinationLabel = new JLabel("Destination Airport:");
        destinationTextField = new JTextField();

        // Create a button to find paths
        JButton findPathsButton = new JButton("Find Paths");
        findPathsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findPaths();
            }
        });

        // Create a text area to display the paths
        pathsTextArea = new JTextArea();
        pathsTextArea.setEditable(false);

        // Add the components to the panel
        panel.add(sourceLabel);
        panel.add(sourceTextField);
        panel.add(destinationLabel);
        panel.add(destinationTextField);
        panel.add(findPathsButton);
        panel.add(pathsTextArea);

        // Add the panel to the frame
        add(panel);

        // Display the frame
        setVisible(true);
    }

    private void findPaths() {
        String sourceAirport = sourceTextField.getText();
        String destinationAirport = destinationTextField.getText();

        // Replace this with your actual path-finding algorithm
        List<String> paths = calculatePaths(sourceAirport, destinationAirport);

        // Display the paths in the text area
        if (!paths.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String path : paths) {
                sb.append(path).append("\n");
            }
            pathsTextArea.setText(sb.toString());
        } else {
            pathsTextArea.setText("No paths found.");
        }
    }

    // Replace this method with your actual path-finding algorithm implementation
    private List<String> calculatePaths(String sourceAirport, String destinationAirport) {
        // Simulated example paths
        List<String> paths = new ArrayList<>();
        paths.add("Path 1: " + sourceAirport + " -> Airport A -> " + destinationAirport);
        paths.add("Path 2: " + sourceAirport + " -> Airport B -> " + destinationAirport);
        paths.add("Path 3: " + sourceAirport + " -> Airport C -> " + destinationAirport);
        return paths;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FlightPathsGUI::new);
    }
}
