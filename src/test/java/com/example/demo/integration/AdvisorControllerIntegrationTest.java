package com.example.demo.integration;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.wellsfargo.counselor.Entrypoint;
import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.service.AdvisorService;
@SpringBootTest(classes = Entrypoint.class)
@AutoConfigureWebTestClient
public class AdvisorControllerIntegrationTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private AdvisorService advisorService;
    
    @Test
    void endPointShouldReturnAuthOfClient()throws Exception{

        Advisor advisor = new Advisor("String", "Ivory", "1435 boggs Road Duluth, GA","478-352-9024","devonivory27@gmail.com");

        when(advisorService.getAdvisor()).thenReturn(advisor);

        webTestClient.get().uri("/get")
        .exchange()
        .expectBody(Advisor.class).
        isEqualTo(advisor);

    }


}
