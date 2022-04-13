package com.lilei.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RandomConfig {

    //ribbon已被弃用，Rule也被弃用
    /*@Bean
    public IRule myRule(){
        // RandomRule 为随机策略
        return new RandomRule();
    }*/

    //LoadBalancer负载均衡随机策略
    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment
            , LoadBalancerClientFactory loadBalancerClientFactory){
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RandomLoadBalancer(loadBalancerClientFactory
                .getLazyProvider(name, ServiceInstanceListSupplier.class),name);
    }
}
