package com.control.money.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private double result;

    public Result() {

    }

    public double getResult() {
        return result;
    }
}
