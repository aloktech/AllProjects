/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import static com.imos.sample.json.ExtractData.MAPPER;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author Pintu
 */
public class SampleJackson {

    public static void main(String[] args) throws IOException {
        ObjectMapper MAPPER = new ObjectMapper();
        MAPPER.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        ObjectWriter output = MAPPER.writer().withDefaultPrettyPrinter();
////        System.out.println(output.writeValueAsString(MAPPER.readTree(Files.toString(new File("src/main/resources/21_8_2016_0_0_0.json"), StandardCharsets.UTF_8))));
////        System.out.println(output.writeValueAsString(MAPPER.readTree(Files.toString(new File("src/main/resources/13_8_2016_0_0_4.json"), StandardCharsets.UTF_8))));
////        JsonNode array = MAPPER.readTree(Files.toString(new File("src/main/resources/13_8_2016_0_0_4.json"), StandardCharsets.UTF_8));
//        JsonNode array = MAPPER.readTree(Files.toString(new File("src/main/resources/sample.json"), StandardCharsets.UTF_8));
////        JsonNode array = MAPPER.readTree(Files.toString(new File("src/main/resources/21_8_2016_0_0_0.json"), StandardCharsets.UTF_8));
//        if (array.isArray()) {
//            Iterator<JsonNode> itr = array.iterator();
//            while (itr.hasNext()) {
//                String str = output.writeValueAsString(itr.next());
//                System.out.println(str);
//                System.out.println("# " + new JSONObject(str));
//            }
//        }
        TimeTempHumidData[] list;
//        TimeTempHumidData[] list = MAPPER.readValue(new File("src/main/resources/sample.json"), TimeTempHumidData[].class);
//        TimeTempHumidData[] list = MAPPER.readValue(new File("src/main/resources/allData_1.json"), TimeTempHumidData[].class);
        list = MAPPER.readValue(new File("src/main/resources/1_9_2016_0_0_0.json"), TimeTempHumidData[].class);
//        list = MAPPER.readValue(new File("src/main/resources/1_9_2016.json"), TimeTempHumidData[].class);
//        TimeTempHumidData[] list = MAPPER.readValue(new File("src/main/resources/allDatas1.json"), TimeTempHumidData[].class);
        System.out.println(list.length);
        AtomicInteger value = new AtomicInteger(0);
        Arrays.asList(list)
                .stream()
                .sorted((d1, d2) -> Long.compare(d1.getTime(), d2.getTime()))
                .distinct()
                .forEach(d -> {
                    System.out.println(value.incrementAndGet() + " : " + new Date(d.getTime()) + " : " + d);
                });

//        Calendar tempCal = GregorianCalendar.getInstance();
//        Calendar cal = GregorianCalendar.getInstance();
//        cal.set(Calendar.DAY_OF_MONTH, 26);
//        cal.set(Calendar.MONTH, 7);
//        cal.set(Calendar.YEAR, 2016);
//        String srcFilepath = "F:\\Tools\\Netbeans8.1Workspace\\RaspberryPiServer\\Backup\\August/30_8_2016.json";
//        String destFilepath = "F:\\Tools\\Netbeans8.1Workspace\\RaspberryPiServer\\Backup\\August/30_8_2016_0_0_0.json";
//        List<TimeTempHumidData> data = new ArrayList<>();
//        data.addAll(Arrays.asList(MAPPER.readValue(new File(srcFilepath), TimeTempHumidData[].class)));
//        data.addAll(Arrays.asList(MAPPER.readValue(new File(destFilepath), TimeTempHumidData[].class)));
//        Files.write(Paths.get(destFilepath),
//                data
//                .stream()
//                .sorted((d1, d2) -> Long.compare(d1.getTime(), d2.getTime()))
//                .distinct()
//                .filter(d -> {
//                    tempCal.setTimeInMillis(d.getTime());
//                    return tempCal.get(Calendar.MONTH) == 7 && tempCal.get(Calendar.DAY_OF_MONTH) == 30;
//                })
//                .map(d -> {
//                    try {
//                        return MAPPER.writeValueAsString(d);
//                    } catch (JsonProcessingException ex) {
//                        return "";
//                    }
//                })
//                .collect(Collectors.toList()).toString().getBytes(),
//                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING
//        );
    }
}
