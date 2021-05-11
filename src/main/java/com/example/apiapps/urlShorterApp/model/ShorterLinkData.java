package com.example.apiapps.urlShorterApp.model;

import com.example.apiapps.urlShorterApp.model.References;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShorterLinkData {

    private String createdAt;
    private String id;
    private String link;
    private List<Object> customBitlinks = null;
    private String longUrl;
    private Boolean archived;
    private List<Object> tags = null;
    private List<Object> deeplinks = null;
    private References references;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ShorterLinkData() {
    }

    public ShorterLinkData(String createdAt, String id, String link, List<Object> customBitlinks, String longUrl, Boolean archived, List<Object> tags, List<Object> deeplinks, References references, Map<String, Object> additionalProperties) {
        this.createdAt = createdAt;
        this.id = id;
        this.link = link;
        this.customBitlinks = customBitlinks;
        this.longUrl = longUrl;
        this.archived = archived;
        this.tags = tags;
        this.deeplinks = deeplinks;
        this.references = references;
        this.additionalProperties = additionalProperties;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Object> getCustomBitlinks() {
        return customBitlinks;
    }

    public void setCustomBitlinks(List<Object> customBitlinks) {
        this.customBitlinks = customBitlinks;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public List<Object> getDeeplinks() {
        return deeplinks;
    }

    public void setDeeplinks(List<Object> deeplinks) {
        this.deeplinks = deeplinks;
    }

    public References getReferences() {
        return references;
    }

    public void setReferences(References references) {
        this.references = references;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}