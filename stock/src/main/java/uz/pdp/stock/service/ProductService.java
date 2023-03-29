package uz.pdp.stock.service;

import uz.pdp.stock.entity.Product;
import uz.pdp.stock.payload.DTOProduct;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ResultMessage add(DTOProduct dtoProduct);
    List<Product> getAll();
   Optional<Product> getOne(Integer id);
    ResultMessage edit(Integer id,DTOProduct dtoProduct);
    ResultMessage delete(Integer Id);
}
