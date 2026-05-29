package com.spring.telina.service;

import com.spring.telina.model.CalculationRequest;
import com.spring.telina.model.CalculationResult;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationResult calculate(CalculationRequest request) {
        Double a = request.getA();
        Double b = request.getB();
        String op = request.getOperation().trim();

        return switch (op) {
            case "+" -> CalculationResult.success(a, b, op, a + b);
            case "-" -> CalculationResult.success(a, b, op, a - b);
            case "*" -> CalculationResult.success(a, b, op, a * b);
            case "/" -> {
                if (b == 0) yield CalculationResult.error(a, b, op, "Division par zéro impossible");
                yield CalculationResult.success(a, b, op, a / b);
            }
            default -> CalculationResult.error(a, b, op,
                    "Opération inconnue : '" + op + "'. Utilisez +, -, *, /");
        };
    }

    public CalculationResult add(Double a, Double b) {
        return CalculationResult.success(a, b, "+", a + b);
    }

    public CalculationResult subtract(Double a, Double b) {
        return CalculationResult.success(a, b, "-", a - b);
    }

    public CalculationResult multiply(Double a, Double b) {
        return CalculationResult.success(a, b, "*", a * b);
    }

    public CalculationResult divide(Double a, Double b) {
        if (b == 0) return CalculationResult.error(a, b, "/", "Division par zéro impossible");
        return CalculationResult.success(a, b, "/", a / b);
    }
}