package com.example.shortify.models;

import jakarta.persistence.*;

@Entity
public class Url {

    @Id
    private String shortUrl;
    private String originalUrl;

    // Getters and Setters
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}