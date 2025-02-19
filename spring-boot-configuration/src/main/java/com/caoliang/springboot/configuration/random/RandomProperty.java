package com.caoliang.springboot.configuration.random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomProperty {

    @Value("${my.secret}")
    private String secret;

    @Value("${my.number}")
    private int number;

    @Value("${my.bignumber}")
    private long bignumber;

    @Value("${my.uuid}")
    private String uuid;

    @Value("${my.number.less.than.ten}")
    private int randomIntRange;

    @Value("${my.number.in.range}")
    private int randomIntMaxMinRange;


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getBignumber() {
        return bignumber;
    }

    public void setBignumber(long bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getRandomIntRange() {
        return randomIntRange;
    }

    public void setRandomIntRange(int randomIntRange) {
        this.randomIntRange = randomIntRange;
    }

    public int getRandomIntMaxMinRange() {
        return randomIntMaxMinRange;
    }

    public void setRandomIntMaxMinRange(int randomIntMaxMinRange) {
        this.randomIntMaxMinRange = randomIntMaxMinRange;
    }
}
