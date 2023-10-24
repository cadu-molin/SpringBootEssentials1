package com.devdojospringboot.error;

public class CustomErrorType {
    private String errorMassage;

    public CustomErrorType(String errorMassage) {
        this.errorMassage = errorMassage;
    }

    public String getErrorMassage() {
        return errorMassage;
    }
}
