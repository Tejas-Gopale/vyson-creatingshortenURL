package com.gtservices.UrlShortenerApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtservices.UrlShortenerApplication.entity.URLEntity;

public interface URLRepo extends JpaRepository<URLEntity, Long>{

	Optional<URLEntity> findByShortCode(String shortCode);
    Optional<URLEntity> findByLongUrl(String longUrl);
}
