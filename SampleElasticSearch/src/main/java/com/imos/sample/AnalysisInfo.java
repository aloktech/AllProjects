/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.imos.sample;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * AnalysisInfo.
 * 
 * @author alok
 */
@Data
public class AnalysisInfo implements Serializable {
    
    /**
     * serialVersionUID.
     */
    public static final long serialVersionUID = 0L;
    
    /**
     * dateOfMonth.
     */
    @JsonProperty(value = "DateOfMonth")
    private String dateOfMonth;
    
    /**
     * analysisId.
     */
    @JsonProperty(value = "AnalysisId")
    private int analysisId;
    
    /**
     * projectId.
     */
    @JsonProperty(value = "ProjectId")
    private int projectId;
    
    /**
     * accountId.
     */
    @JsonProperty(value = "AccountId")
    private int accountId;
    
    /**
     * numOfElements.
     */
    @JsonProperty(value = "NumOfElements")
    private int numOfElements;
    
    /**
     * numOfRules.
     */
    @JsonProperty(value = "NumOfRules")
    private int numOfRules;
    
    /**
     * failedRules.
     */
    @JsonProperty(value = "FailedRules")
    private int failedRules;
    
    /**
     * failedElements.
     */
    @JsonProperty(value = "FailedElements")
    private int failedElements;
    
    /**
     * bimTimeStamp.
     */
    @JsonProperty(value = "BIMTimeStamp")
    private long bimTimeStamp;
}
