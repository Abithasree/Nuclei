package com.securin.nuclei;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import com.example.nuclei.NucleiApiGrpc;
import com.example.nuclei.ScanRequest;
import com.example.nuclei.ScanResult;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class NucleiClient {

    public static void main(String[] args) {
        // Define your thread pool
        ExecutorService executor = Executors.newFixedThreadPool(10);  // Adjust the pool size as needed

        // Input and output file paths
        String inputFilePath = "C:\\Users\\abith\\Downloads\\input_urls_small.txt";
        String outputFilePath = "C:\\Users\\abith\\Downloads\\scan_results.txt";

        // Build the gRPC channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8555)
                .usePlaintext()
                .enableFullStreamDecompression()  // Ensure this method is available
                .build();

        // Create the blocking stub for the Nuclei API
        NucleiApiGrpc.NucleiApiBlockingStub blockingStub = NucleiApiGrpc.newBlockingStub(channel);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            List<String> urls = new ArrayList<>();
            String url;
            while ((url = reader.readLine()) != null) {
                urls.add(url);
            }

            // Process URLs in parallel
            urls.forEach(u -> executor.submit(() -> {
                try {
                    ScanRequest request = ScanRequest.newBuilder()
                            .addTargets(u)
                            .setAutomaticScan(true)
                            .build();

                    Iterator<ScanResult> response = blockingStub.scan(request);

                    synchronized (writer) {
                        while (response.hasNext()) {
                            ScanResult result = response.next();
                            writer.write("URL: " + u + ", Template ID: " + result.getTemplateId() + "\n");
                        }
                    }
                } catch (StatusRuntimeException e) {
                    System.err.println("RPC failed: " + e.getStatus());
                } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }));

            // Shutdown the executor service
            executor.shutdown();
            while (!executor.isTerminated()) {
                // Wait for all tasks to finish
            }
            System.out.println("Scan completed. Results saved to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        } finally {
            // Shut down the channel
            channel.shutdown();
        }
    }
}
