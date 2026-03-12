package com.example.demo.slice;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.wellsfargo.counselor.Controller.AdvisorController;
import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.service.AdvisorService;

@WebMvcTest(AdvisorController.class)
class AdvisorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdvisorService advisorService;

    @Test
    void endPointShouldReturnAuthOfClient() throws Exception {
        // Arrange
        Advisor advisor = new Advisor(
            "String", "Ivory", "1435 boggs Road Duluth, GA",
            "478-352-9024", "devonivory27@gmail.com"
        );

        // Mock service method
        when(advisorService.getAdvisor()).thenReturn(advisor);

        // Act & Assert
        mockMvc.perform(get("/get"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.firstName").value("Ivory"));
               //how jsonpath works is converts the object like advisor into json format 
               //from there you can access the differnt attributes of 
               //object by calling atribut name 
    }
}