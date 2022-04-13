package com.lilei.config;

import com.lilei.loadbalancerrule.CustomLoadBalancer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBalancerConfig {
    @Bean
    public ReactorServiceInstanceLoadBalancer customBalancer(
            ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSuppliers){
        return new CustomLoadBalancer(serviceInstanceListSuppliers);
    }
}
