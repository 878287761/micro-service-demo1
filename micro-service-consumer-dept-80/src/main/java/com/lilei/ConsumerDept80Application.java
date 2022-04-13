package com.lilei;

import com.lilei.config.CustomBalancerConfig;
import com.lilei.config.RandomConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//加载负载均衡策略 不加注解则默认为轮询策略 不加请注释掉有关配置类
@LoadBalancerClient(name = "MICROSERVICEPROVIDERDEPT",configuration = CustomBalancerConfig.class)
public class ConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80Application.class, args);
    }

}
