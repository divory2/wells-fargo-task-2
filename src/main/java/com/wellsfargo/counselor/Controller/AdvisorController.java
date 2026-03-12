package com.wellsfargo.counselor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/advisor")
public class AdvisorController {

    @GetMapping(path = "/get")
    public Object getAdvisor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdvisor'");
    }


}
