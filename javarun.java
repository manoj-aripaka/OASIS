/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class javarun {

    public static void main(String [] args) throws IOException {
        
        
        ProcessBuilder builder = new ProcessBuilder("python", "C:\\Users\\aripa\\Desktop\\dbms pro\\map.py", "23.3924", "113.2988","33.6367", "-84.4281");
        Process process = builder.start();
        
    }
}