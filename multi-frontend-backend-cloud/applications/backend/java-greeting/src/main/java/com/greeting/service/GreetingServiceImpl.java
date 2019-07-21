package com.greeting.service;

import com.greeting.client.DescriptionFeignClient;
import com.greeting.client.FamilyFeignClient;
import com.greeting.client.TranslationFeignClient;
import com.greeting.model.GreetingModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GreetingServiceImpl implements GreetingService {

    private final TranslationFeignClient translationClient;
    private final DescriptionFeignClient descriptionClient;
    private final FamilyFeignClient feignClient;

    @Override
    public List<GreetingModel> getGreetings() throws Exception {
        final CompletableFuture<Map<String, String>> futureTranslations = CompletableFuture.supplyAsync(this::getTranslations);
        final CompletableFuture<Map<String, String>> futureDescriptions = CompletableFuture.supplyAsync(this::getDescriptions);
        final CompletableFuture<Map<String, Map<String, String>>> futureFamilies = CompletableFuture.supplyAsync(this::getFamilies);
        final CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futureTranslations, futureDescriptions, futureFamilies);
        combinedFuture.get();

        final Map<String, String> translations = futureTranslations.get();
        final Map<String, String> descriptions = futureDescriptions.get();
        final Map<String, Map<String, String>> families = futureFamilies.get();

        return translations.entrySet().stream()
                .map(item -> new GreetingModel(item.getKey(), item.getValue(), descriptions.get(item.getKey()), families.get(item.getKey())))
                .collect(Collectors.toList());
    }

    private Map<String, String> getTranslations() {
        return translationClient.getTranslations();
    }

    private Map<String, String> getDescriptions() {
        return descriptionClient.getDescriptions();
    }

    private Map<String, Map<String, String>> getFamilies() {
        return feignClient.getFamilies();
    }
}
