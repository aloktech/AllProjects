/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import static com.imos.sample.json.RaspberryPiConstant.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Pintu
 */
@Data
@JsonPropertyOrder({"temp", "humid"})
public class TempHumidData implements Serializable {

    @JsonProperty(TEMP)
    private double temperature;

    @JsonProperty(HUMID)
    private double humidity;
}
