package com.tinyurl.controller;

import com.tinyurl.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody Map<String, String> request) {

        String longUrl = request.get("longUrl");
        String shortUrl = urlShortenerService.generateShortUrl(longUrl);

        Map<String, String> response = new HashMap<>();
        response.put("shortUrl", shortUrl);

//        return ResponseEntity.ok(response);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/shortUrl")
    public ResponseEntity<Map<String, String>> getLongUrl(@RequestBody Map<String, String> request) {
        String longUrl = urlShortenerService.getLongUrl(request.get("shortUrl"));

//        if (longUrl != null) {
//            Map<String, String> response = new HashMap<>();
//            response.put("longUrl", longUrl);
//            return ResponseEntity.ok(response);
//        }

        Map<String, String> response = new HashMap<>();
        response.put("longUrl", longUrl);

        return ResponseEntity.ok(response);
//        return ResponseEntity.notFound().build();
    }
}
