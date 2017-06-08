package com.sample.bff.service;

import com.sample.bff.client.CategoryServiceClient;
import com.sample.bff.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryServiceClient categoryClient;

    public Category getCategory(String id) {
        return categoryClient.get(id);
    }
}
