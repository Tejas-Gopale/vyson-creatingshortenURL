package com.gtservices.UrlShortenerApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtservices.UrlShortenerApplication.entity.URLEntity;

import com.gtservices.UrlShortenerApplication.service.URLServiceImpl;


@RestController
@RequestMapping("/URLConverter")
public class URLController {

		 
	 @Autowired URLServiceImpl urlServiceImpl;
	 

	 //Handel the controller for which will take the URL 
	    @PostMapping("/shorten")
	    public ResponseEntity<?> shortenUrl(@RequestBody URLEntity url) {
	        return urlServiceImpl.shortenURL(url);
	    }

	
	    @GetMapping("/{code}")
	    public ResponseEntity<?> redirectToUrl(@PathVariable String code) {
	    	return urlServiceImpl.redirectToUrl(code);
	    }


}
