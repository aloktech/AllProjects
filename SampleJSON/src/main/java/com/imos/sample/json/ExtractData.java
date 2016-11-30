/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.imos.sample.json.RaspberryPiConstant.DATA;
import static com.imos.sample.json.RaspberryPiConstant.HUMID;
import static com.imos.sample.json.RaspberryPiConstant.TEMP;
import static com.imos.sample.json.RaspberryPiConstant.TIME;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Pintu
 */
public class ExtractData {

    static Calendar calendar = GregorianCalendar.getInstance();
    static ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        JSONArray allData = new JSONArray();
        searchAndParse(Paths.get("F:\\Tools\\Netbeans8.1Workspace\\RaspberryPiServer\\Backup"), allData);
        System.out.println(allData.length());
        try {
            TimeTempHumidData[] arr = MAPPER.readValue(allData.toString(), TimeTempHumidData[].class);
            Map<Long, List<TimeTempHumidData>> map = new HashMap<>();

            Calendar cal = GregorianCalendar.getInstance();
            for (int index = 0, n = arr.length; index < n; index++) {
                TimeTempHumidData tthd = arr[index];
                cal.setTimeInMillis(tthd.getTime());
                long val = (long) cal.get(Calendar.HOUR_OF_DAY);
                List<TimeTempHumidData> list = map.get(val);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(val, list);
                }
                list.add(tthd);
            }

            for (int index = 0, n = arr.length; index < n; index++) {
                TimeTempHumidData tthd = arr[index];
                cal.setTimeInMillis(tthd.getTime());
                long val = (long) cal.get(Calendar.HOUR_OF_DAY);
                List<TimeTempHumidData> list = map.get(val);
                if (list != null && list.size() > 60) {
                    System.out.println(index + " : " + list.size() + " : " + val + " : " + new Date(tthd.getTime()));
                }
            }
//            System.out.println(Arrays.asList(MAPPER.readValue(allData.toString(), TimeTempHumidData[].class))
//                    .stream()
//                    .sorted((d1, d2) -> Long.compare(d1.getTime(), d2.getTime()))
//                    .distinct()
//                    .collect(Collectors.toList()).size());
//
//            Files.write(Paths.get("allDatas.json"),
//                    Arrays.asList(MAPPER.readValue(allData.toString(), TimeTempHumidData[].class))
//                    .stream()
//                    .sorted((d1, d2) -> Long.compare(d1.getTime(), d2.getTime()))
//                    .distinct()
//                    .map(d -> {
//                        try {
//                            return MAPPER.writeValueAsString(d);
//                        } catch (JsonProcessingException ex) {
//                            return "";
//                        }
//                    })
//                    .collect(Collectors.toList()).toString().getBytes(),
//                    StandardOpenOption.CREATE,
//                    StandardOpenOption.TRUNCATE_EXISTING
//            );
        } catch (IOException ex) {
            Logger.getLogger(ExtractData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void searchAndParse(Path folderPath, JSONArray allData) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(folderPath)) {
            for (Path path : directoryStream) {
                File file = path.toFile();
                if (file.isFile() && file.getName().endsWith(".json") && file.getName().startsWith("2016-11-06")) {
//                if (file.isFile() && file.getName().endsWith(".json") && file.getName().startsWith("allData")) {
                    String data;
                    try {
                        data = new String(Files.readAllBytes(path));
                        JSONArray array = new JSONArray(data);
                        System.out.println(path.toFile().getAbsolutePath() + " : " + array.length());
                        for (int index = 0, size = array.length(); index < size; index++) {
                            JSONObject json = array.getJSONObject(index);
//                            System.out.println(json.toString() + " : " + index);
                            if (!json.has(DATA) && !json.has(TIME)) {
                                continue;
                            }
                            try {
                                String time = json.getString(TIME);
                                String[] value = time.split("_");
                                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(value[0]));
                                calendar.set(Calendar.MONTH, Integer.parseInt(value[1]) - 1);
                                calendar.set(Calendar.YEAR, Integer.parseInt(value[2]));
                                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(value[3]));
                                calendar.set(Calendar.MINUTE, Integer.parseInt(value[4]));
                                calendar.set(Calendar.SECOND, Integer.parseInt(value[5]));
                                json.put(TIME, calendar.getTimeInMillis());
                                if (json.getJSONObject(DATA).has(DATA)) {
                                    allData.put(json.getJSONObject(DATA));
                                    System.out.println(json.toString());
                                } else if (json.getJSONObject(DATA).has(HUMID)
                                        && json.getJSONObject(DATA).has(TEMP)) {
                                    allData.put(json);
                                } else {
                                    System.out.println(json.toString());
                                }
                            } catch (JSONException | NumberFormatException e) {
                                try {
                                    if (json.getJSONObject(DATA).has(DATA)) {
                                        JSONObject temp = json.getJSONObject(DATA).getJSONObject(DATA);
                                        if (temp.has("temperature") && temp.has("humidity")) {
                                            temp.put(TEMP, temp.getDouble("temperature"));
                                            temp.put(HUMID, temp.getDouble("humidity"));
                                            temp.remove("temperature");
                                            temp.remove("humidity");
                                            allData.put(json.getJSONObject(DATA));
                                        } else if (temp.has(TEMP) && temp.has(HUMID)) {
                                            allData.put(json.getJSONObject(DATA));
                                        }
                                    } else if (json.getJSONObject(DATA).has(HUMID)
                                            && json.getJSONObject(DATA).has(TEMP)) {
                                        allData.put(json);
                                    } else {
                                        System.out.println(json.toString());
                                    }
//                                    System.out.println(new Date(json.getLong(TIME)));
                                } catch (Exception e1) {
                                    System.out.println(e1.getMessage());
                                    System.out.println(new Date(json.getLong(TIME)));
                                    System.out.println(json.toString() + " : " + e.getMessage());
                                }
                            }
                        }
                    } catch (IOException | JSONException e) {
                        System.out.println(e.getMessage());
                        System.out.println(path);
                        try {
                            String[] list = MAPPER.readValue(path.toFile(), String[].class);
                            System.out.println(list.length);
                            Arrays.asList(list).stream().forEach(d -> {
                                allData.put(new JSONObject(d));
                            });
                        } catch (Exception e1) {
                            System.out.println(e1.getMessage());
                        }
                    }
                } else if (path.toFile().isDirectory()) {
//                    searchAndParse(path, allData);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
