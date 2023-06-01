package com.tinyurl.service;

import com.tinyurl.Dto.UrlDto;

public interface UrlService {
    UrlDto save(UrlDto url);

    String findByShortUrl(String shortUrl);
}
