package uz.developer.appwerehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appwerehouse.entity.Category;
import uz.developer.appwerehouse.payload.CategoryDto;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Result getOneCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return new Result(".", 404, optionalCategory.get());
        }
        return new Result("this id category not found ", 203, null);
    }


    @Override
    public Result getAllCategory() {
        List<Category> allCategory = categoryRepository.findAll();
        if (allCategory.isEmpty()) {
            return new Result("Category not found", 207, null);
        }
        return new Result("All Category", 402, allCategory);
    }

    @Override
    public Result editCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category editCategory = optionalCategory.get();
            editCategory.setActive(categoryDto.isActive());
            editCategory.setName(editCategory.getName());
            Optional<Category> optionalParentCategoryId = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (optionalParentCategoryId.isPresent()) {
                editCategory.setParentCategory(optionalParentCategoryId.get());
                categoryRepository.save(editCategory);
                return new Result("successfull edited", 400, editCategory);

            }
            categoryRepository.save(editCategory);
            return new Result("category id but category parent id not found", 403, editCategory);
        }
        return new Result("category id not found ", 202, null);
    }

    @Override
    public Result deleteCategory(Integer id) {
        boolean deleteCategory = categoryRepository.existsById(id);
        if (deleteCategory) {
            categoryRepository.deleteById(id);
            return new Result("category deleted", 406, null);
        }
        return new Result("category id not found", 201, null);
    }

    @Override
    public Result addCategory(CategoryDto categoryDto) {
        boolean addcategoryName = categoryRepository.existsByName(categoryDto.getName());
        if (addcategoryName) {
            return new Result("category already added", 207, null);
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());

        Optional<Category> parentCategoryId = categoryRepository.findById(categoryDto.getParentCategoryId());
        if (parentCategoryId.isPresent()) {
            category.setParentCategory(parentCategoryId.get());
            categoryRepository.save(category);
            return new Result("category added", 404);
        }
        categoryRepository.save(category);
        return new Result("parent category not found but category added", 405);

    }
}
