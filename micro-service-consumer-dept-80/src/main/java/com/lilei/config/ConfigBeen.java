package com.lilei.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBeen {

    @Bean  //将 RestTemplate 注入到容器中
    @LoadBalanced  //在客户端使用 RestTemplate 请求服务端时，开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    //自定义负载均衡策略

}
