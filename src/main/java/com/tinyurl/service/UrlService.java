package com.tinyurl.service;

import com.tinyurl.Dto.UrlDto;

public interface UrlService {
    UrlDto save(UrlDto url);

    // returns a long url eg "google.com"
    String findByShortUrl(String shortUrl);
}
