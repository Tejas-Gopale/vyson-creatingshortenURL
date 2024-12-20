package com.gtservices.UrlShortenerApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gtservices.UrlShortenerApplication.entity.URLEntity;
import com.gtservices.UrlShortenerApplication.repository.URLRepo;

@Service
public class URLServiceImpl {

	@Autowired URLRepo  urlRepo;
	
	 private static final String BASE_URL = "http://192.168.1.91:8080/URLConverter/";
	
	public ResponseEntity<?> shortenURL(URLEntity url){
		if (url.getLongUrl() == null || url.getLongUrl().isEmpty()) {
            return ResponseEntity.badRequest().body("Missing longUrl parameter");
        }

        // Check if the URL is already shortened
        Optional<URLEntity> existingUrl = urlRepo.findByLongUrl(url.getLongUrl());
        if (existingUrl.isPresent()) {
            return ResponseEntity.ok(BASE_URL + existingUrl.get().getShortCode());
        }

        // Save the URL first to generate an ID
        URLEntity savedUrl = urlRepo.save(url);

        // Generate a short code based on the saved ID
        String shortCode = generateShortCode(savedUrl.getId());
        savedUrl.setShortCode(shortCode);
        urlRepo.save(savedUrl); // Update the saved URL with the short code

        return ResponseEntity.status(201).body(BASE_URL + shortCode );
    
	}
	
	public ResponseEntity<?> redirectToUrl(String code){
		Optional<URLEntity> url = urlRepo.findByShortCode(code); 
		if (url.isPresent()) {
	            return ResponseEntity
	            		.status(302)
	            		.header("Location", url.get().getLongUrl())
	            		.build();
	        } else {
	            return ResponseEntity
	            		.status(404)
	            		.body("Short code not found");
	        }
	    }

	    private String generateShortCode(Long id) {
	        // Convert the ID to a base-62 encoded string
	        return encodeToBase62(id);
	    }

	    private String encodeToBase62(Long id) {
	        final String base62Chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        StringBuilder shortCode = new StringBuilder();
	        while (id > 0) {
	            shortCode.append(base62Chars.charAt((int) (id % 62)));
	            id /= 62;
	        }
	        return shortCode.reverse().toString(); // Reverse to get the correct order
	    }
	

}
