/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.imos.sample;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * AnalysisData.
 *
 * @author alok
 */
@Data
public final class AnalysisData implements Serializable {

    /**
     * serialVersionUID.
     */
    public static final long serialVersionUID = 0L;
    
    /**
     * dayOfMonth.
     */
    @JsonProperty(value = "DayOfMonth")
    private String dayOfMonth;

    /**
     * daysData.
     */
    @JsonProperty(value = "DaysData")
    private List<AnalysisInfo> daysData;
    
}
