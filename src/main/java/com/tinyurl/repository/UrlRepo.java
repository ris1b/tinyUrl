package com.tinyurl.repository;

import com.tinyurl.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<Url, String> {

}
