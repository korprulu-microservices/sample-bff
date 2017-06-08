package com.sample.bff.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sample.bff.RibbonConfiguration;
import com.sample.bff.dto.Category;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RibbonClient(name = "sample-product", configuration = RibbonConfiguration.class)
public class CategoryService {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public Category getCategory(String id) {
        return restTemplate().getForObject("http://sample-product/categories/" + id, Category.class);
    }

    public Category reliable() {
        final Category category = new Category();
        category.setName("fallback category");
        return category;
    }
}
