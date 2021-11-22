package uz.developer.appwerehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developer.appwerehouse.payload.CategoryDto;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public Result getOneCategory(@PathVariable Integer id) {
        return categoryService.getOneCategory(id);
    }

    @GetMapping
    public Result getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public Result editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        return categoryService.editCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public Result deletecategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }
}
