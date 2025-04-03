package com.example.shortify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    // Create a shortened URL
    public String shortenUrl(String originalUrl) {
        String shortUrl = UUID.randomUUID().toString().substring(0, 6);  // Generate a 6-character short URL
        Url url = new Url();
        url.setShortUrl(shortUrl);
        url.setOriginalUrl(originalUrl);
        urlRepository.save(url);
        return shortUrl;
    }

    // Retrieve the original URL from the short URL
    public String getOriginalUrl(String shortUrl) {
        Optional<Url> url = urlRepository.findById(shortUrl);
        return url.map(Url::getOriginalUrl).orElse(null);
    }
}
