package org.gs.utils;

import org.gs.model.MarsRoverPhotos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class typeConvertion {
        
    public static MarsRoverPhotos parseJson(String json) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, MarsRoverPhotos.class);
        } catch (JsonProcessingException e) {
            // Handle the exception accordingly
            e.printStackTrace();
            return null;
        }
    }
}
