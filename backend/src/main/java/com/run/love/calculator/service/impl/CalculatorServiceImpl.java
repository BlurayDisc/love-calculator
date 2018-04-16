package com.run.love.calculator.service.impl;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.run.love.calculator.model.Couple;
import com.run.love.calculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServiceImpl.class);

    private static final int MAX = 100;

    private Random random;

    @PostConstruct
    public void init() {
        random = new Random();
    }

    @Override
    public void calculateLove(Couple couple) {

        log.info("[CALCULATE] Calculating love value for couple: {}", couple);

        giveAnyRandom(couple);
        cheat(couple);

        log.info("[RESULT] Love is: {}", couple.getLove());
    }

    private void giveAnyRandom(Couple couple) {
        int love = random.nextInt(MAX);
        couple.setLove(love);
    }

    private void cheat(Couple couple) {

        String personName = couple.getPersonA().toLowerCase();
        String loverName = couple.getPersonB().toLowerCase();
        
        if (personName.contains("run") && loverName.contains("ying") || 
            personName.contains("闰") && loverName.contains("荧") ) {
            log.info("Enabling cheat");
            couple.setLove(100);
        }

    }

}
