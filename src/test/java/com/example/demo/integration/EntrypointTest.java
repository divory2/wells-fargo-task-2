package com.example.demo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wellsfargo.counselor.Entrypoint;
import com.wellsfargo.counselor.Controller.AdvisorController;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(classes= Entrypoint.class)// means spring boot will look for configuration
//class with springboot application test 
 class EntrypointTest {
    @Autowired
    private AdvisorController controller;
    @Test
    void contextLoads(){
        assertThat(controller).isNotNull();
    }

}
