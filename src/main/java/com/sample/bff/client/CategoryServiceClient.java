package com.sample.bff.client;

import com.sample.bff.dto.Category;
import com.sample.bff.fallback.CategoryServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sample-product", fallback = CategoryServiceFallback.class)
public interface CategoryServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/categories/{id}")
    Category get(@PathVariable("id") String id);
}
