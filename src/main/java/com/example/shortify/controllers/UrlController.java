package com.example.shortify.controllers;

import com.example.shortify.models.SaveUrlRequest;
import com.example.shortify.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tangmingyi
 */
@RestController
@RequestMapping("/api/shorten")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public String shortenUrl(@RequestBody SaveUrlRequest saveUrlRequest) {
        return urlService.shortenUrl(saveUrlRequest.getOriginalUrl());
    }

    @GetMapping("/{shortUrl}")
    public String redirectToOriginal(@PathVariable String shortUrl) {
        return urlService.getOriginalUrl(shortUrl);
    }
}
