package com.repository;

import java.util.List;

import com.dto.Category;

public interface CategoryRepository {

	public Category getParentCategoryByName(String categoryName);
	
	public List<Category> getChildCategoriesByName(String categoryName);
}
