package com.spring.telina.config;

import com.spring.telina.service.CalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfig {

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorService();
    }
}