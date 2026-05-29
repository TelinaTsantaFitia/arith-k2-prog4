package com.spring.telina.model;

public class CalculationResult {

    private Double a;
    private Double b;
    private String operation;
    private Double result;
    private String expression;
    private boolean success;
    private String errorMessage;

    public CalculationResult() {}

    public static CalculationResult success(Double a, Double b, String operation, Double result) {
        CalculationResult r = new CalculationResult();
        r.a = a;
        r.b = b;
        r.operation = operation;
        r.result = result;
        r.expression = a + " " + operation + " " + b + " = " + result;
        r.success = true;
        return r;
    }

    public static CalculationResult error(Double a, Double b, String operation, String message) {
        CalculationResult r = new CalculationResult();
        r.a = a;
        r.b = b;
        r.operation = operation;
        r.success = false;
        r.errorMessage = message;
        return r;
    }

    public Double getA() { return a; }
    public Double getB() { return b; }
    public String getOperation() { return operation; }
    public Double getResult() { return result; }
    public String getExpression() { return expression; }
    public boolean isSuccess() { return success; }
    public String getErrorMessage() { return errorMessage; }
}