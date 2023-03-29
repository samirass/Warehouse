package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Input;
import uz.pdp.stock.entity.InputProduct;
import uz.pdp.stock.entity.Product;
import uz.pdp.stock.payload.DTOInputProduct;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.InputProductRepository;
import uz.pdp.stock.repository.InputRepository;
import uz.pdp.stock.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class InputProductImpl implements InputProductService {
    final InputProductRepository inputProductRepository;
    final InputRepository inputRepository;
    final ProductRepository productRepository;


    @Override
    public ResultMessage add(DTOInputProduct inputProduct) {
        Optional<Product> optionalProduct = productRepository.findByIdAndIs_activeIsTrue(inputProduct.getProduct_id());
        if (optionalProduct.isEmpty())
            return new ResultMessage("Product not found",false);

        Optional<Input> optionalInput = inputRepository.findById(inputProduct.getInputId());
        if (optionalInput.isEmpty())
            return new ResultMessage("Input not found",false);
        InputProduct add= new InputProduct();
        add.setProduct(optionalProduct.get());
        add.setCount(inputProduct.getCount());
        add.setPrice(inputProduct.getPrice());
        add.setData(inputProduct.getExpireData());
        add.setInput(optionalInput.get());
        inputProductRepository.save(add);
        return new ResultMessage("Product successfully added",true);
    }

    @Override
    public List<InputProduct> getAll() {
        return inputProductRepository.findAll();
    }

    @Override
    public InputProduct getOne(Integer id) {
        return inputProductRepository.findById(id).orElse(null);
    }

    @Override
    public ResultMessage edit(Integer id, DTOInputProduct inputProduct) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isEmpty())
            return new ResultMessage("Product not found",false);

        Optional<Product> optionalProduct = productRepository.findByIdAndIs_activeIsTrue(inputProduct.getInputId());
        if (optionalProduct.isEmpty())
            return new ResultMessage("Product bot found",false);

        Optional<Input> optionalInput = inputRepository.findById(inputProduct.getInputId());
        if (optionalInput.isEmpty())
            return new ResultMessage("Input not found",false);
       InputProduct edit = optionalInputProduct.get();
       edit.setProduct(optionalProduct.get());
       edit.setCount(inputProduct.getCount());
       edit.setPrice(inputProduct.getPrice());
       edit.setInput(optionalInput.get());
       edit.setData(inputProduct.getExpireData());
       inputProductRepository.save(edit);
        return new ResultMessage("Product successfully edited",true);
    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<uz.pdp.stock.entity.InputProduct> optionalInputProduct = inputProductRepository.findById(Id);
        if (optionalInputProduct.isEmpty())
            return new ResultMessage("Product not found",false);
        inputProductRepository.deleteById(Id);
        return new ResultMessage("Product successfully deleted",true);
    }
}
