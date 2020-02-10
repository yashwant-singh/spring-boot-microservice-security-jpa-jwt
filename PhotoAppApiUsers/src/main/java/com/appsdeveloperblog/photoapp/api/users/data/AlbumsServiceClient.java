package com.appsdeveloperblog.photoapp.api.users.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appsdeveloperblog.photoapp.api.users.ui.model.AlbumResponseModel;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name = "albums-ws", fallbackFactory = AlbumsFalbackFactory.class)
public interface AlbumsServiceClient {

	@GetMapping("/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);
}

@Component
class AlbumsFalbackFactory implements FallbackFactory<AlbumsServiceClient> {

	public AlbumsServiceClient create(Throwable cause) {
		return new AlbumsServiceClientFallback(cause);
	}

}

class AlbumsServiceClientFallback implements AlbumsServiceClient {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	Throwable cause;

	AlbumsServiceClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<AlbumResponseModel> getAlbums(String id) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 400) {
			logger.error("404 error took place when getAlbums was called with userId: " + id + ". Error Message :"
					+ cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place :" + cause.getLocalizedMessage());
		}
		return new ArrayList<>();
	}

}