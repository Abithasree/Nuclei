package com.securin.nuclei;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NucleiServer {

    public static void startNucleiApiServer() throws IOException {
        // Full path to the go executable
        ProcessBuilder processBuilder = new ProcessBuilder(
            "C:\\Program Files\\Go\\bin\\go.exe", 
            "run", "main.go", "start", "-a", "localhost:8555"
        );

        // Set the working directory where main.go is located
        processBuilder.directory(new File("C:\\Users\\abith\\nuclei-api"));

        // Redirect error and output streams for debugging
        processBuilder.redirectErrorStream(true);

        // Start the process
        Process process = processBuilder.start();

        // Read the output and print it to the console
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        try {
            startNucleiApiServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
