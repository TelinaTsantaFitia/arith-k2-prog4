package com.spring.telina.model;

import jakarta.validation.constraints.NotNull;

public class CalculationRequest {

    @NotNull(message = "Le nombre a est obligatoire")
    private Double a;

    @NotNull(message = "Le nombre b est obligatoire")
    private Double b;

    @NotNull(message = "L'opération est obligatoire")
    private String operation;

    public CalculationRequest() {}

    public CalculationRequest(Double a, Double b, String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public Double getA() { return a; }
    public void setA(Double a) { this.a = a; }

    public Double getB() { return b; }
    public void setB(Double b) { this.b = b; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
}