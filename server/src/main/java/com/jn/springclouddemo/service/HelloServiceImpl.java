package com.jn.springclouddemo.service;

import com.jn.langx.text.StringTemplates;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.cloud.zookeeper.serviceregistry.ServiceInstanceRegistration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperServiceRegistry;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService, InitializingBean {
    @Value("${server.port}")
    private int port;
    private ServiceRegistry registry;

    @Autowired
    public void setRegistry(ZookeeperServiceRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServiceInstanceRegistration registration = ServiceInstanceRegistration.builder()
                .defaultUriSpec()
                .address("localhost")
                .port(port)
                .name("a/b/hello")
                .build();

        this.registry.register(registration);
    }

    @Override
    public String sayHello(String message) {
        return StringTemplates.formatWithPlaceholder("hello, {}", message);
    }
}
