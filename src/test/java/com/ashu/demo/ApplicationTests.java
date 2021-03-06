package com.ashu.demo;

import com.ashu.demo.web.PetController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private PetController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
