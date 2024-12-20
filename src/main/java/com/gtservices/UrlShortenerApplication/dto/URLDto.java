package com.gtservices.UrlShortenerApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class URLDto {

	private String longUrl;
	private String shortUrl;
}
