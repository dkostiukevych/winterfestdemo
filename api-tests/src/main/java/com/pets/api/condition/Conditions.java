package com.pets.api.condition;

import org.hamcrest.Matcher;

public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static ResponseBodyCondition jsonObject(String jsonPath, Matcher matcher) {
        return new ResponseBodyCondition(matcher, jsonPath);
    }
}
