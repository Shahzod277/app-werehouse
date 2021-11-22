package uz.developer.appwerehouse.service;

import uz.developer.appwerehouse.payload.CategoryDto;
import uz.developer.appwerehouse.payload.Result;

public interface CategoryService {
    Result getOneCategory(Integer id);

    Result getAllCategory();

    Result editCategory(Integer id, CategoryDto categoryDto);

    Result deleteCategory(Integer id);

    Result addCategory(CategoryDto categoryDto);
}
