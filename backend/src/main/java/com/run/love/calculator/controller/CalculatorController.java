package com.run.love.calculator.controller;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.run.love.calculator.model.Couple;
import com.run.love.calculator.service.CalculatorService;
import com.run.love.calculator.service.CoupleService;

@RestController
public class CalculatorController {

    @Autowired
    private CoupleService coupleService;

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public Couple calculate(@Valid @RequestBody Couple couple) throws ExecutionException {

        couple = coupleService.getOrCreate(couple);
        if (couple.isNew()) {
            calculatorService.calculateLove(couple);
        }

        return couple;
    }
}
