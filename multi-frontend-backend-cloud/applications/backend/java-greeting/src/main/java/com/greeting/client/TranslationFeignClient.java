package com.greeting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "${service.translation.name}", url = "${service.translation.url}")
public interface TranslationFeignClient {

    @GetMapping(value = "/translations", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, String> getTranslations();

}
