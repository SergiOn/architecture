package com.greeting.service;

import com.greeting.model.GreetingModel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface GreetingService {

    public List<GreetingModel> getGreetings() throws Exception;

}
