package uz.pdp.stock.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.Product;
import uz.pdp.stock.payload.DTOProduct;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.ProductServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
final ProductServiceImpl productService;
@PostMapping
    public  ResultMessage add(@RequestBody DTOProduct product){
    return productService.add(product);
}
@GetMapping
    public List<Product> getAll(){
    return productService.getAll();
}
@GetMapping("/{id}")
public Optional<Product> getOne(@PathVariable Integer id){
    return productService.getOne(id);
}
@PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id,@RequestBody DTOProduct product){
    return productService.edit(id,product);
}
    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id){
        return productService.delete(id);
    }

}