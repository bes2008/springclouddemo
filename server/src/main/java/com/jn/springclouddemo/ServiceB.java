package com.jn.springclouddemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceB {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/showinfo")
    public String showInfo() {
        return "service B";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceB.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
