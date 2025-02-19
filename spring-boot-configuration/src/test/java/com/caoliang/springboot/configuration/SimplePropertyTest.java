package com.caoliang.springboot.configuration;

import com.caoliang.springboot.configuration.property.SimpleProperty;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimplePropertyTest {

    @Autowired
    private SimpleProperty simpleProperty;

    @Test
    public void getApp(){
        Assert.assertEquals("spring-boot-configuration", simpleProperty.getApp());
    }

    @Test
    public void getUser(){
        Assert.assertEquals("happyxiaofan", simpleProperty.getUser());
    }

    @Test
    public void getAge(){
        Assert.assertEquals(24, simpleProperty.getAge());
    }

    @Test
    public void getEmail(){
        Assert.assertEquals("rhwayfun@gmail.com", simpleProperty.getEmail());
    }

    @Test
    public void getBlog(){
        Assert.assertEquals("http://blog.csdn.net/u011116672", simpleProperty.getBlog());
    }

    @Test
    public void getGithub(){
        Assert.assertEquals("https://github.com/happyxiaofan/spring-boot-learning-examples", simpleProperty.getGithub());
    }
}
