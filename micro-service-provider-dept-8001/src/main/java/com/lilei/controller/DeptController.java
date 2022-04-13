package com.lilei.controller;

import com.lilei.entity.Dept;
import com.lilei.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") int id){
        return deptService.get(id);
    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list(){
        return deptService.selectAll();
    }
}
