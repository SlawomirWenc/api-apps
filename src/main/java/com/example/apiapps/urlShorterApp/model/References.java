package com.example.apiapps.urlShorterApp.model;

import java.util.HashMap;
import java.util.Map;

public class References {

    private String group;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}