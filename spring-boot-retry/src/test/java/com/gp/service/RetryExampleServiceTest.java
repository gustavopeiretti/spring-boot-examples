package com.gp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetryExampleServiceTest {

    @Autowired
    private RetryExampleService retryExampleService;

    @Test
    public void retryExampleWithRecoveryTest() throws Exception {
        String result = retryExampleService.retryExample("error");
        Assert.assertEquals("Retry Recovery OK!", result);
    }

}
