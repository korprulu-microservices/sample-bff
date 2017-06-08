package com.sample.bff.resource;

import com.sample.bff.dto.Category;
import com.sample.bff.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories/{id}")
    @ResponseBody
    public Category getCategory(@PathVariable("id") String id) {
        return categoryService.getCategory(id);
    }
}
