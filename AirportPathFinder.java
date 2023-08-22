/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author aripa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class AirportPathFinder {
    private static Map<String, List<String>> graph; // Graph representation: airport -> neighboring airports

    public static List<String> findPath(String source, String destination) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>(); // Map to store parent or predecessor information

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            String currentAirport = queue.poll();

            if (currentAirport.equals(destination)) {
                // Destination airport found, backtrack to construct the path
                return constructPath(parent, source, destination);
            }

            List<String> neighbors = graph.get(currentAirport);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        parent.put(neighbor, currentAirport);
                    }
                }
            }
        }

        // No path found
        return null;
    }

    private static List<String> constructPath(Map<String, String> parent, String source, String destination) {
        List<String> path = new ArrayList<>();
        String current = destination;

        while (current != null) {
            path.add(current);
            if (current.equals(source)) {
                break;
            }
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Build the graph (airport connections)
        graph = new HashMap<>();
        
        graph.put("1", Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "15", "18", "19", "20", "21", "22", "24"));
        graph.put("2", Arrays.asList("1","3","4","5","6","7","8","11","15","17","19","20","21","22"));
        graph.put("3", Arrays.asList("1","2","4","5","6","7","8","9","10","11","13","14","19","20","21","22"));
        graph.put("4", Arrays.asList("2","3","4","6","7","8","10","11","12","13","16","17","18","19","20","21","22"));
        graph.put("5", Arrays.asList("1","2","3","4","6","7","8","10","11","12","14","15","17","19","20","21","22","23"));
        graph.put("6", Arrays.asList("1","2","3","4","5","7","8","9","11","14","15","16","17","18","19","20","21","22"));
        graph.put("7", Arrays.asList("1","2","3","4","5","8","9","10","12","13","14","16","17","18","19","20","21","22","23","24"));
        graph.put("8", Arrays.asList("2","3","4","5","6","8","10","13","15","17","18","19","20","21","22","23"));
        graph.put("9", Arrays.asList("1","2","3","4","5","6","7","11","12","13","16","17","19","20","21","22"));
        graph.put("10", Arrays.asList("1","3","6","8","11","12","13","14","15","16","17","18","19","20","21","22","23","24"));
        graph.put("11", Arrays.asList("2","3","6","8","10","12","13","14","15","16","17","18","19","20","21","22","23","24"));
        graph.put("12", Arrays.asList("1","4","5","7","9","10","11","13","14","15","16","17","18","19","20","21","22","23","24"));
        graph.put("13", Arrays.asList("4","5","7","9","10","11","14","15","16","18","19","20","21","22","23","24"));
        graph.put("14", Arrays.asList("3","4","5","6","7","9","10","11","17","18","19","20","21","22","23","24"));
        graph.put("15", Arrays.asList("1","2","3","6","9","10","11","12","13","16","17","18","19","20","21","22","23","24"));
        graph.put("16", Arrays.asList("T"));
        graph.put("17", Arrays.asList("T"));
        graph.put("18", Arrays.asList("U"));
        graph.put("19", Arrays.asList("U"));
        graph.put("20", Arrays.asList("V"));
        graph.put("21", Arrays.asList("V"));
        graph.put("22", Arrays.asList("U"));
        graph.put("22", Arrays.asList("V"));
        graph.put("23", Arrays.asList("V"));
        graph.put("24", Arrays.asList("V"));

        

        // Find path from source to destination
        String sourceAirport = "A";
        String destinationAirport = "U";
        List<String> path = findPath(sourceAirport, destinationAirport);

        if (path != null) {
            System.out.println("Path from " + sourceAirport + " to " + destinationAirport + ":");
            System.out.println(path);
        } else {
            System.out.println("No path found from " + sourceAirport + " to " + destinationAirport + ".");
        }
    }
}

