package com.alerouge.demo.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class ExtendableBean {
    private Map<String, String> properties;

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void add(String attr, String value) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(attr, value);
    }
}
