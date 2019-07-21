package com.greeting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "${service.description.name}", url = "${service.description.url}")
public interface DescriptionFeignClient {

    @GetMapping(value = "/descriptions", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, String> getDescriptions();

}
