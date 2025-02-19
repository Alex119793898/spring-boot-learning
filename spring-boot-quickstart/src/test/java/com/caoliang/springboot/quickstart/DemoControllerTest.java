package com.caoliang.springboot.quickstart;


import com.caoliang.springboot.quickstart.web.DemoController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest
{

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void now() throws Exception {
        ResultActions hello = this.mockMvc.perform(new RequestBuilder() {
            @Override
            public MockHttpServletRequest buildRequest(ServletContext servletContext) {
                return new MockHttpServletRequest(RequestMethod.GET.name(), "/now");
            }
        }).andExpect(status().isOk()).andExpect(content().string("hello"));

        String contentAsString = hello.andReturn().getResponse().getContentAsString();
        Assert.assertEquals(contentAsString, "hello");
        System.out.println(contentAsString);


    }

}
