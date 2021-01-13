package com.cybertek.service;

import com.cybertek.model.Category;
import com.cybertek.model.SubCategory;
import com.cybertek.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryService subCategoryService;

    public CategoryService(CategoryRepository categoryRepository, SubCategoryService subCategoryService) {
        this.categoryRepository = categoryRepository;
        this.subCategoryService = subCategoryService;
    }

    public Category create(Category category) throws Exception {
        Optional<Category> foundedCategory = categoryRepository.findByName(category.getName());

        if(foundedCategory.isPresent())
            throw new Exception("Category Already exist");
        return categoryRepository.save(category);
    }

    public void update(Category category) throws Exception {

        Optional<Category> foundCategory = categoryRepository.findByName(category.getName());

        if (foundCategory.isEmpty()) {
            throw new Exception("There is no category");
        }
        category.setId(foundCategory.get().getId());

        categoryRepository.save(category);
    }

    public List<Category> readAll(){
        return  categoryRepository.findAll(Sort.by("name"));

    }

    public Category readById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) throws Exception {


        Category foundedCategory = categoryRepository.findById(id).orElseThrow(() -> new Exception("category doesn't exist"));
        List<SubCategory> subCategories = subCategoryService.readAllByCategory(foundedCategory);

       if( subCategories.size()>0 ) {
           throw new Exception("This category can not be deleted");
       }

        foundedCategory.setName(foundedCategory.getName()+"-"+foundedCategory.getId());
        foundedCategory.setIsDeleted(true);
        categoryRepository.save(foundedCategory);
    }
}
