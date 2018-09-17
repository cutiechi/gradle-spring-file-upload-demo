package com.cutiechi.demo;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Spring 测试类
 *
 * @author Cutie Chi
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ApplicationTests {

}
