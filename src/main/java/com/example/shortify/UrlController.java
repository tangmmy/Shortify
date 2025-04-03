package com.example.shortify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shorten")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public String shortenUrl(@RequestBody String originalUrl) {
        return urlService.shortenUrl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public String redirectToOriginal(@PathVariable String shortUrl) {
        return urlService.getOriginalUrl(shortUrl);
    }
}
