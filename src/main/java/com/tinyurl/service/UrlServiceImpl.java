package com.tinyurl.service;

import com.tinyurl.Dto.UrlDto;
import com.tinyurl.entity.Url;
import com.tinyurl.exception.NoUrlFound;
import com.tinyurl.repository.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService{
    @Autowired
    private UrlRepo urlRepo;

    @Override
    public UrlDto save(UrlDto urlDto) {
        Url theUrl = new Url(urlDto.getShortUrl(), urlDto.getLongUrl());
        urlRepo.save(theUrl);
        return urlDto;
    }

    @Override
    public String findByShortUrl(String shortUrl) {
        Optional<Url> longUrl = urlRepo.findById(shortUrl);
        if(longUrl.isEmpty()) throw new NoUrlFound("No such url exist");

        return longUrl.get().getLongUrl();
    }

}
