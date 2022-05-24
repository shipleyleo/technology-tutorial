package com.leo.example.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

@SpringBootTest
class ApiApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("开始");
        Integer res = fun3(2,0,3);
        Assert.assertEquals(7,res.intValue());
        System.out.println("结束");
    }

    public Integer fun3(Integer a, Integer b, Integer x) {

        if (a > 1 && b == 0) {
            x = x + a;
        }
        if (a == 2 || x > 1) {
            x += 1;
        }
        return x;
    }

}

