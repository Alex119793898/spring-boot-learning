package com.caoliang.springboot.configuration;

import com.caoliang.springboot.configuration.property.SimpleProperty;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ProfilePropertyTest {

    @Autowired
    private SimpleProperty simpleProperty;

    @Test
    public void getApp(){
        Assert.assertEquals("spring-boot-configuration", simpleProperty.getApp());
    }

    @Test
    public void getUser(){
        Assert.assertEquals("springboot", simpleProperty.getUser());
    }

    @Test
    public void getAge(){
        Assert.assertEquals(1, simpleProperty.getAge());
    }

    @Test
    public void getEmail(){
        Assert.assertEquals("springboot@gmail.com", simpleProperty.getEmail());
    }

    @Test
    public void getBlog(){
        Assert.assertEquals("http://blog.csdn.net/springboot", simpleProperty.getBlog());
    }

    @Test
    public void getGithub(){
        Assert.assertEquals("https://github.com/springboot/spring-boot-samples", simpleProperty.getGithub());
    }
}
