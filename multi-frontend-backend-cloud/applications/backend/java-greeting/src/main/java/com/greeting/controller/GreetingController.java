package com.greeting.controller;

import com.greeting.model.GreetingModel;
import com.greeting.service.GreetingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
@AllArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping()
    public List<GreetingModel> getGreetings() throws Exception {
        return greetingService.getGreetings();
    }

//    @GetMapping("/{language}")
//    public ResponseEntity<?> getFamily(@PathVariable("language") String language) {
//        final String languageCapitalized = language.substring(0, 1).toUpperCase() + language.substring(1);
//        final Optional<Map<String, String>> family = Optional.ofNullable(Data.families.get(languageCapitalized));
//        return family.isPresent() ? ResponseEntity.ok(family.get()) : ResponseEntity.badRequest().body("Not found");
//    }
}
