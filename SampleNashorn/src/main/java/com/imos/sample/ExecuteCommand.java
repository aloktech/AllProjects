/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alok
 */
public class ExecuteCommand {

    public static void main(String[] args) {
        partOne();
    }

    private static void partOne() {
        try {
            final String cmd = "curl https://mixpanel.com/api/2.0/jql -u %s: --data-urlencode script@%s";
            final String apiSecret = "edda4d902425195e92106ac868cfee99";
            final String filePath = "src/main/resources/query.js";
            System.out.println("Part One");
            Process process = Runtime.getRuntime().exec(String.format(cmd, apiSecret, filePath));
            showOutput(process);
            showError(process);
        } catch (IOException ex) {
            Logger.getLogger(ExecuteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void partTwo() {
        try {
            // curl https://mixpanel.com/api/2.0/jql  -u %s: --data-urlencode script@%s | python -m json.tool
//            String cmd = "curl https://mixpanel.com/api/2.0/jql  -u %s: --data-urlencode script@%s | python -m json.tool";
            String cmd = "curl https://mixpanel.com/api/2.0/jql -u %s: --data-urlencode script@%s";
            String apiSecret = "edda4d902425195e92106ac868cfee99";
//            String filePath = System.getProperty("user.dir")+"/src/main/resources/query.js";
            String filePath = "src/main/resources/query.js";
//            String filePath = System.getProperty("user.dir")+"/query.js";
//            String filePath = "query.js";
            cmd = String.format(cmd, apiSecret, filePath);

            System.out.println("Part Two");
            List<String> command = new ArrayList<>();

            command.add("curl");
            command.add("https://mixpanel.com/api/2.0/jql");

            command.add("-u");
            command.add(String.format("%s:", apiSecret));

            command.add("--data-urlcode");
            command.add(String.format("script@%s", filePath));
//            command.add("|");
//            command.add("python");
//            command.add("-m");
//            command.add("json.tool");

            System.out.println(command);

            ProcessBuilder builder = new ProcessBuilder(command);
            Process process = builder.start();
            showOutput(process);
            showError(process);

            System.out.println("done");
        } catch (IOException ex) {
            Logger.getLogger(ExecuteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void showError(Process process) throws IOException {
        System.out.println("Error : ");
        String line;
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((line = error.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void showOutput(Process process) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        System.out.println("Output : ");
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
    }
}
