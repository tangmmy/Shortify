package com.example.shortify.services;

import com.example.shortify.models.Url;
import com.example.shortify.repos.UrlRepository;
import com.example.shortify.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author tangmingyi
 */
@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private RedisUtil redisUtil;

    private static final String prefix = "http://shortify/api/shorten/";

    // Create a shortened URL
    public String shortenUrl(String originalUrl) {

        // Generate a 6-character short URL
        String shortUrl = UUID.randomUUID().toString().substring(0, 6);
        Url url = new Url();
        url.setShortUrl(shortUrl);
        url.setOriginalUrl(originalUrl);

        urlRepository.save(url);
        return prefix + shortUrl;
    }

    // Retrieve the original URL from the short URL
    public String getOriginalUrl(String shortUrl) {
        if (shortUrl == null || shortUrl.isEmpty()) {
            throw new RuntimeException("cannot be empty");
        }
        //find with cache
        String url = (String) redisUtil.get(shortUrl);
        if (url == null || url.isEmpty()) {
            //lock this
            synchronized (this) {
                url = (String) redisUtil.get(shortUrl);
                if(url == null){

                    // find with db
                    url = urlRepository.findById(shortUrl).get().getOriginalUrl();

                    //then update the cache
                    redisUtil.save(shortUrl, url, 60 * 60 * 24);
                }
            }
        }
        redisUtil.save(shortUrl, url, 60 * 60 * 24);
        return url;
    }
}
