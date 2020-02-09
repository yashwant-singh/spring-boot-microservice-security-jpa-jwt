package com.appsdeveloperblog.photoapp.api.users.shared;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

	private Environment environment;

	public FeignErrorDecoder(Environment environment) {
		this.environment = environment;
	}

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 400:

			break;

		case 404:

			if (methodKey.contains("getAlbums")) {
				return new ResponseStatusException(HttpStatus.valueOf(response.status()),
						environment.getProperty("api.albums.not.found"));
			}

			break;

		default:
			return new Exception(response.reason());
		}
		return null;
	}

}
