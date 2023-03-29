package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Category;
import uz.pdp.stock.payload.DTOCategory;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    final CategoryRepository categoryRepository;

    @Override
    public ResultMessage add(DTOCategory dtoCategory) {
        if (categoryRepository.existsByNameAndCategory_id(dtoCategory.getName(), dtoCategory.getCategory_id()))
            return new ResultMessage("This category already exist",false);

        Category category = new Category();
        category.setName(dtoCategory.getName());
        if(dtoCategory.getCategory_id() != null){
            Optional<Category> optionalCategory = categoryRepository.findById(dtoCategory.getCategory_id());
            if(optionalCategory.isEmpty())
                return new ResultMessage("Category not found",false);
            category.setCategory_id(optionalCategory.get().getCategory_id());
        }
        categoryRepository.save(category);
        return new ResultMessage("Category successfully added",true);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getOne(Integer id) {
        return Optional.ofNullable(categoryRepository.findByIdAndAndIs_activeTrue(id).orElse(null));
    }

    @Override
    public ResultMessage edit(Integer id, DTOCategory dtoCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty())
            return new ResultMessage("Category not found", false);
        if (categoryRepository.existsByNameAndCategory_id(dtoCategory.getName(), dtoCategory.getCategory_id()))
            return new ResultMessage("This category already exist", false);
        Category edit = optionalCategory.get();
        edit.setName(dtoCategory.getName());
        if (dtoCategory.getCategory_id() != null){
            categoryRepository.findById(dtoCategory.getCategory_id());
        if (optionalCategory.isEmpty())
            return new ResultMessage("Category not found", false);
        edit.setCategory_id(optionalCategory.get().getCategory_id());
    }

    categoryRepository.save(edit);
        return new ResultMessage("Category successfully edited",true);

    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<Category> optionalCategory = categoryRepository.findById(Id);
        if(optionalCategory.isEmpty())
            return new ResultMessage("Category not found",false);
        Category delete = optionalCategory.get();
        delete.setIs_active(false);
        categoryRepository.save(delete);
        return new ResultMessage("Category successfully deleted ",true);
    }
}
