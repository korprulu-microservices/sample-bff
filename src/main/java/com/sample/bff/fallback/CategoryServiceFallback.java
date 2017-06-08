package com.sample.bff.fallback;

import com.sample.bff.client.CategoryServiceClient;
import com.sample.bff.dto.Category;

public class CategoryServiceFallback implements CategoryServiceClient {
    @Override
    public Category get(String id) {
        final Category category = new Category();
        category.setName("fallback category");
        return category;
    }
}
