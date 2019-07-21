package com.greeting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "${service.family.name}", url = "${service.family.url}")
public interface FamilyFeignClient {

    @GetMapping(value = "/families", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Map<String, String>> getFamilies();

}
