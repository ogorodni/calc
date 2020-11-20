package com.calc.client.service;

public class ServiceFactory {

    public CalculatorService getService(String address) {
        if (address.startsWith("http")) {
            return new HttpCalculatorService(address);
        } else {
            throw new IllegalArgumentException("Incorrect address: " + address);
        }
    }
}
