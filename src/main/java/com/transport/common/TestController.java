package com.transport.common;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping
    public  String test(){
        return " JWT Authentication Working";
    }
}
