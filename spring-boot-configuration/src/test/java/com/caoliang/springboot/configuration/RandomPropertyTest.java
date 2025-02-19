package com.caoliang.springboot.configuration;


import com.caoliang.springboot.configuration.random.RandomProperty;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomPropertyTest {

    @Autowired
    private RandomProperty randomProperty;

    @Test
    public void getRadomSecret(){
        Assert.assertNotNull(randomProperty.getSecret());
    }

    @Test
    public void getRadomNumber(){
        Assert.assertTrue(randomProperty.getNumber() > Integer.MIN_VALUE);
    }

    @Test
    public void getRadomUUid(){
        Assert.assertNotNull(randomProperty.getUuid());
    }

    @Test
    public void getRandomIntRange(){
        Assert.assertTrue(randomProperty.getRandomIntRange() < 10);
    }

    @Test
    public void getRandomIntMaxMinRange(){
        Assert.assertTrue(randomProperty.getRandomIntMaxMinRange() > 10);
        Assert.assertTrue(randomProperty.getRandomIntMaxMinRange() < 100);
    }



}
