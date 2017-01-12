package com.run.love.calculator.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.run.love.calculator.model.Couple;

public interface CoupleService {

    List<Couple> findTop10();

    List<Couple> findAll();

    Couple save(Couple couple);

    Couple getOrCreate(Couple couple) throws ExecutionException;

}
