package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.Category;
import uz.pdp.stock.payload.DTOCategory;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.CategoryServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    final CategoryServiceImpl categoryService;

    @PostMapping
    public ResultMessage add(@RequestBody DTOCategory categoryDto) {
        return categoryService.add(categoryDto);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getOne(@PathVariable Integer id) {
        return categoryService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody DTOCategory categoryDto) {
        return categoryService.edit(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return categoryService.delete(id);
    }
}
