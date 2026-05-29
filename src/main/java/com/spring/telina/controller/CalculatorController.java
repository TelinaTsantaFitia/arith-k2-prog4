package com.spring.telina.controller;

import com.spring.telina.model.CalculationRequest;
import com.spring.telina.model.CalculationResult;
import com.spring.telina.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResult> calculate(@Valid @RequestBody CalculationRequest request) {
        CalculationResult result = calculatorService.calculate(request);
        if (!result.isSuccess()) return ResponseEntity.badRequest().body(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/add")
    public ResponseEntity<CalculationResult> add(@RequestParam Double a, @RequestParam Double b) {
        return ResponseEntity.ok(calculatorService.add(a, b));
    }

    @GetMapping("/subtract")
    public ResponseEntity<CalculationResult> subtract(@RequestParam Double a, @RequestParam Double b) {
        return ResponseEntity.ok(calculatorService.subtract(a, b));
    }

    @GetMapping("/multiply")
    public ResponseEntity<CalculationResult> multiply(@RequestParam Double a, @RequestParam Double b) {
        return ResponseEntity.ok(calculatorService.multiply(a, b));
    }

    @GetMapping("/divide")
    public ResponseEntity<CalculationResult> divide(@RequestParam Double a, @RequestParam Double b) {
        CalculationResult result = calculatorService.divide(a, b);
        if (!result.isSuccess()) return ResponseEntity.badRequest().body(result);
        return ResponseEntity.ok(result);
    }
}