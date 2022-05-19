package com.spring.tobi.learningtest.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ContextConfiguration
public class JUnitTest {

    @Autowired
    ApplicationContext applicationContext;

    static Set<JUnitTest> jUnitTest = new HashSet<>();
    static ApplicationContext context = null;

    @Test
    void test1() {
        assertThat(this).isNotEqualTo(jUnitTest);
        jUnitTest.add(this);
        System.out.println(jUnitTest.size());
        assertThat(context == null || context == this.applicationContext).isTrue();
        context = this.applicationContext;
    }

    @Test
    void test2() {
        assertThat(this).isNotEqualTo(jUnitTest);
        jUnitTest.add(this);
        System.out.println(jUnitTest.size());
        assertThat(context == null || context == this.applicationContext).isTrue();
        context = this.applicationContext;
    }

    @Test
    void test3() {
        assertThat(this).isNotEqualTo(jUnitTest);
        jUnitTest.add(this);
        System.out.println(jUnitTest.size());
        assertThat(context == null || context == this.applicationContext).isTrue();
        context = this.applicationContext;
    }
}
