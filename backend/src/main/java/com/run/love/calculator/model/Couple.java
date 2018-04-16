package com.run.love.calculator.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.core.style.ToStringCreator;

public class Couple implements Comparable<Couple> {

    private static final String KEY_GEN = "%s-%s";

    private final UUID id;

    @Length(min = 3, message = "Your name must have more than 3 characters.")
    @NotBlank(message = "You must fill in your name.")
    private String personA;

    @Length(min = 3, message = "Your lover's name must have more than 3 characters.")
    @NotBlank(message = "You must fill in your lover's name.")
    private String personB;

    private Integer love;

    public Couple() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getPersonA() {
        return personA;
    }

    public void setPersonA(String personA) {
        this.personA = personA;
    }

    public String getPersonB() {
        return personB;
    }

    public void setPersonB(String personB) {
        this.personB = personB;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public boolean isNew() {
        return love == null;
    }

    public String genKey() {
        return String.format(KEY_GEN, personA, personB);
    }

    @Override
    public int compareTo(Couple that) {
        return this.love.compareTo(that.love);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("player", personA)
                .append("lover", personB)
                .toString();
    }

}
