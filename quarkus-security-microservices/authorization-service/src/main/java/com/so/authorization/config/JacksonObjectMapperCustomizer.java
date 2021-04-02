package com.so.authorization.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;

@Singleton
public class JacksonObjectMapperCustomizer implements ObjectMapperCustomizer {
    @Override
    public void customize(final ObjectMapper mapper) {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
