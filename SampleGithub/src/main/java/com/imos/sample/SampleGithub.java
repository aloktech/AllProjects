/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alok
 */
public class SampleGithub {

    public static void main(String[] args) {
        try {
            String cmd = "";
//            cmd = "git status";
//            cmd = "ls";
            cmd = "pwd";
//            cmd = "cd..";
//            executeCommand(cmd);
//            cmd = "cd /home/alok/Tools/netbean_dev_workspace/shiro/samples/quickstart/";
//            executeCommand(cmd);
//            cmd = "ls";
            executeCommand(cmd);
//            cmd = "cd..";
            String cmds;
            executeCommand(new String[]{"cd", "/home/alok/Tools/netbean_dev_workspace/shiro/samples/quickstart/"});
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(SampleGithub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void executeCommand(String cmd) throws InterruptedException, IOException {
        if (cmd == null || cmd.trim().isEmpty()) {
            return;
        }
        Process process = Runtime.getRuntime().exec(cmd);
        InputStream output = process.getInputStream();
        InputStream error = process.getErrorStream();

        if (output.available() > 0) {
            readOutput("Output", output);

        }
        if (error.available() > 0) {
            readOutput("Error", error);
        }

        int value = process.waitFor();
        process.destroy();
    }

    private static void executeCommand(String[] cmd) throws InterruptedException, IOException {
        Process process = Runtime.getRuntime().exec(cmd);
        InputStream output = process.getInputStream();
        InputStream error = process.getErrorStream();

        if (output.available() > 0) {
            readOutput("Output", output);

        }
        if (error.available() > 0) {
            readOutput("Error", error);
        }

        int value = process.waitFor();
        process.destroy();
    }

    private static void readOutput(String header, InputStream output) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(output))) {
            String line;
            System.out.println(String.format("%s : ", header));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(SampleGithub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
