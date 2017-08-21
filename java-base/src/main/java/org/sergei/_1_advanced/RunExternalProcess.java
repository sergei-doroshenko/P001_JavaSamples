package org.sergei._1_advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RunExternalProcess {

    public static void main(String[] args) {
        String[] command = {"CMD", "/C", "dir"};
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(new File("c:\\tomcat1"));
        Process p = null;

        try {
            p = pb.start();
            handleProcessData(command, p);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            p.destroy();
        }

    }

    private static void handleProcessData(String[] command, Process p) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(new File("directory.log")))
        ) {
            System.out.printf("Output of running %s is:\n", Arrays.toString(command));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line + System.getProperty("line.separator"));
            }

            int exitValue = p.waitFor();
            System.out.println("\n\nExit Value is " + exitValue);
            bw.write("\n\nExit Value is " + exitValue);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
