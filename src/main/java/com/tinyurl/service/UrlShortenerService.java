package com.tinyurl.service;

import com.tinyurl.Dto.UrlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlShortenerService {
    @Autowired
    private IdGeneratorService idGeneratorService;

    @Autowired
    private UrlService urlService;

    private Map<String, String> urlMap = new HashMap<>();

    public String generateShortUrl(String longUrl) {
        String shortUrl = idGeneratorService.generate();

        shortUrl = base62encode(shortUrl);
        // instead persist in db ?
//       urlMap.put(shortUrl, longUrl);

        urlService.save(new UrlDto(shortUrl, longUrl));

        return "tiny.url/" + shortUrl;
    }

    private static final String BASE62_CHARS = "0123456789"  +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";

    private String base62encode(String id) {
        long number = Long.parseLong(id);

        StringBuilder sb = new StringBuilder();
        int rem = 0;

        while(number > 0){
            rem = (int)(number% 62 + 62) % 62;
            number /= 62;
            sb.append(BASE62_CHARS.charAt(rem));
        }
        return sb.reverse().toString();
    }

    public String getLongUrl(String shortUrl) {

        String longUrl = urlService.findByShortUrl(shortUrl);

        return longUrl;
    }
}
