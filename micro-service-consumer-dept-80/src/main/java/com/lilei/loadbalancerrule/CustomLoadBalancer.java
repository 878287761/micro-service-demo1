package com.lilei.loadbalancerrule;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

/**
 * 自定义负载均衡策略
 */
@Configuration
public class CustomLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    //服务列表
    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSuppliers;

    public CustomLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSuppliers){
        this.serviceInstanceListSuppliers = serviceInstanceListSuppliers;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSuppliers.getIfAvailable();
        return supplier.get().next().map(this::getInstanceResponse);
    }

    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances){
            //System.out.println("进来了");
            if (instances.isEmpty()) {
                return new EmptyResponse();
            }

            //System.out.println("进行随机选取服务");
            // 随机算法
            int size = instances.size();
            Random random = new Random();
            ServiceInstance instance = instances.get(random.nextInt(size));

            return new DefaultResponse(instance);
    }
}
