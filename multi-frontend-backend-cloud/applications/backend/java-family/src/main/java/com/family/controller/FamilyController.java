package com.family.controller;

import com.family.data.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/families")
public class FamilyController {

    @GetMapping()
    public Map<String, Map<String, String>> getFamilies() {
        return Data.families;
    }

    @GetMapping("/{language}")
    public ResponseEntity<?> getFamily(@PathVariable("language") String language) {
        final String languageCapitalized = language.substring(0, 1).toUpperCase() + language.substring(1);
        final Optional<Map<String, String>> family = Optional.ofNullable(Data.families.get(languageCapitalized));
        return family.isPresent() ? ResponseEntity.ok(family.get()) : ResponseEntity.badRequest().body("Not found");
    }
}
