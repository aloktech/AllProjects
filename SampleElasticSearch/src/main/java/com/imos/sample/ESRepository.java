/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import static com.imos.sample.ESConstant.AGGREGATIONS;
import static com.imos.sample.ESConstant.BUCKETS;
import static com.imos.sample.ESConstant.DOC_COUNT;
import static com.imos.sample.ESConstant.KEY;
import static com.imos.sample.ESConstant.VALUE;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alok
 */
public class ESRepository {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ESRepository.class);

    public JSONObject getAggregatesValue(String jsonData, String termsName) {
        JSONObject json = new JSONObject(jsonData);
        try {
            if (json.has(AGGREGATIONS)) {
                JSONObject aggs = json.getJSONObject(AGGREGATIONS);
                json = aggs.getJSONObject(termsName);
            } else {
                throw new InvalidJSONDataException(AGGREGATIONS + " json data is missing.");
            }
        } catch (JSONException e) {
            json = new JSONObject();
            LOGGER.error("Invalid JSON data");
        } catch (InvalidJSONDataException ex) {
            json = new JSONObject();
            LOGGER.error(ex.getMessage());
        }
        return json;
    }

    public JSONArray getAggregatesBuckets(String jsonData, String termsName) {
        JSONObject name = getAggregatesValue(jsonData, termsName);
        JSONArray buckets = name.getJSONArray(BUCKETS);
        return buckets;
    }

    public Map<String, Integer> getAggregateTerms(String jsonData, String termsName) {
        Map<String, Integer> keyCountMap = new HashMap<>();
        JSONArray buckets = getAggregatesBuckets(jsonData, termsName);
        for (int index = 0, size = buckets.length(); index < size; index++) {
            JSONObject json = buckets.getJSONObject(index);
            keyCountMap.put(json.getString(KEY), json.getInt(DOC_COUNT));
        }
        return keyCountMap;
    }

    public int getAggregateCount(String jsonData, String termsName) {
        JSONObject json = getAggregatesValue(jsonData, termsName);
        return json.getInt(VALUE);
    }
}
