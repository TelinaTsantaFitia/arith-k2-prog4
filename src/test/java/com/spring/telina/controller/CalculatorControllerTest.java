package com.spring.telina.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.telina.model.CalculationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @Test @DisplayName("POST + : 10 + 5 = 15")
    void testAdd() throws Exception {
        mockMvc.perform(post("/api/calculator/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CalculationRequest(10.0, 5.0, "+"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(15.0)));
    }

    @Test @DisplayName("POST - : 10 - 5 = 5")
    void testSubtract() throws Exception {
        mockMvc.perform(post("/api/calculator/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CalculationRequest(10.0, 5.0, "-"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(5.0)));
    }

    @Test @DisplayName("POST * : 10 * 5 = 50")
    void testMultiply() throws Exception {
        mockMvc.perform(post("/api/calculator/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CalculationRequest(10.0, 5.0, "*"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(50.0)));
    }

    @Test @DisplayName("POST / : 10 / 5 = 2")
    void testDivide() throws Exception {
        mockMvc.perform(post("/api/calculator/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CalculationRequest(10.0, 5.0, "/"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(2.0)));
    }

    @Test @DisplayName("POST / par zéro : 400")
    void testDivideByZero() throws Exception {
        mockMvc.perform(post("/api/calculator/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CalculationRequest(10.0, 0.0, "/"))))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success", is(false)));
    }

    @Test @DisplayName("GET /add?a=10&b=5 = 15")
    void testGetAdd() throws Exception {
        mockMvc.perform(get("/api/calculator/add").param("a","10").param("b","5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(15.0)));
    }

    @Test @DisplayName("GET /divide?a=10&b=0 : 400")
    void testGetDivideByZero() throws Exception {
        mockMvc.perform(get("/api/calculator/divide").param("a","10").param("b","0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success", is(false)));
    }
}