package com.jn.springclouddemo.service;

import com.jn.langx.text.StringTemplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;

/**
 * 指定了这个注解后，就可以在这个类中直接使用 discoveryClient
 */
@EnableDiscoveryClient
@Service
public class WorldService {
    @Autowired
    private DiscoveryClient discoveryClient;

    public String sayWorld(String message) {
        return StringTemplates.formatWithPlaceholder("hello world, {}", message);
    }
}
