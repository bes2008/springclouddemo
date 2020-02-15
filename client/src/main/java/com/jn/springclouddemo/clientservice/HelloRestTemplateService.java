package com.jn.springclouddemo.clientservice;


import org.springframework.web.client.RestTemplate;

public class HelloRestTemplateService {
    private RestTemplate restTemplate;


    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
