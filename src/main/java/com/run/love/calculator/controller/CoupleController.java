package com.run.love.calculator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.run.love.calculator.model.Couple;
import com.run.love.calculator.service.CoupleService;

@RestController
public class CoupleController {

    @Autowired
    private CoupleService coupleService;

    @GetMapping("/couples")
    public List<Couple> findCouples() {
        return coupleService.findAll();
    }
    
    @GetMapping("/couples/top10")
    public List<Couple> findCouplesTop10() {
        return coupleService.findTop10();
    }

    @PostMapping("/couples")
    public Couple saveCouple(@Valid @RequestBody Couple couple) {
        return coupleService.save(couple);
    }
}
