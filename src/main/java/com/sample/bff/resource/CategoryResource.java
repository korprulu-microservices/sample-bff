package com.sample.bff.resource;

import com.sample.bff.dto.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryResource {
    @RequestMapping("/categories/{id}")
    @ResponseBody
    public Category getCategory(@PathVariable("id") String id) {
        return new Category();
    }
}
