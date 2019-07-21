package com.greeting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GreetingModel {

    private String country;
    private String translation;
    private String description;
    private Map<String, String> family;

}
