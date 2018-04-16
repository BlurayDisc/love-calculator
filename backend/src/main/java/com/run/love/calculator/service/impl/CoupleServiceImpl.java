package com.run.love.calculator.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.Cache;
import com.run.love.calculator.model.Couple;
import com.run.love.calculator.service.CoupleService;

@Service
public class CoupleServiceImpl implements CoupleService {

    private static final Logger log = LoggerFactory.getLogger(CoupleServiceImpl.class);

    @Autowired
    private Cache<String, Couple> coupleRepository;

    @Override
    public List<Couple> findAll() {

        log.info("Looking up all couples...");

        Map<String, Couple> map = coupleRepository.asMap();

        log.info("Found {} entry(s)", map.size());

        return new ArrayList<>(map.values());
    }

    @Override
    public List<Couple> findTop10() {

        log.info("Looking up top 10 couples...");

        Map<String, Couple> map = coupleRepository.asMap();
        List<Couple> couples = new ArrayList<>(map.values());

        Collections.sort(couples);

        int k = couples.size();
        if (k > 10) {
            return couples.subList(0, 10);
        }
        return couples;
    }

    @Override
    public Couple save(Couple couple) {

        log.info("Persisting couple {}", couple);

        coupleRepository.put(couple.genKey(), couple);

        return couple;
    }

    @Override
    public Couple getOrCreate(Couple couple) throws ExecutionException {

        log.info("[GET] Looking up couple: {}", couple);

        return coupleRepository.get(couple.genKey(), () -> {
            log.info("[CREATE] Persisting new couple {}", couple);
            return couple;
        });
    }
}