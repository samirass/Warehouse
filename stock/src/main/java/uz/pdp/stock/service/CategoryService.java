package uz.pdp.stock.service;

import uz.pdp.stock.entity.Category;
import uz.pdp.stock.entity.Input;
import uz.pdp.stock.payload.DTOCategory;
import uz.pdp.stock.payload.DTOInput;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    ResultMessage add(DTOCategory dtoCategory);
    List<Category> getAll();
    Optional<Category> getOne(Integer id);
    ResultMessage edit(Integer id, DTOCategory dtoCategory);
    ResultMessage delete(Integer Id);
}
