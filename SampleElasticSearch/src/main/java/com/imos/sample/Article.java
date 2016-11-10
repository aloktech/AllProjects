/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author alok
 */
@Data
public class Article {
    
    @JsonProperty
    private String author;
    
    @JsonProperty
    private String content;
}
