package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Output;
import uz.pdp.stock.entity.OutputProduct;
import uz.pdp.stock.entity.Product;
import uz.pdp.stock.payload.DTOOutputProduct;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.OutputProductRepository;
import uz.pdp.stock.repository.OutputRepository;
import uz.pdp.stock.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputProductImpl implements OutputProductService{
    final OutputProductRepository outputProductRepository;
    final OutputRepository outputRepository;
    final ProductRepository productRepository;

    @Override
    public ResultMessage add(DTOOutputProduct dtoOutputProduct) {
        Optional<Product> optionalProduct = productRepository.findByIdAndIs_activeIsTrue(dtoOutputProduct.getProduct_id());
        if (optionalProduct.isEmpty())
            return new ResultMessage("Product not found",false);

        Optional<Output> optionalOutput = outputRepository.findById(dtoOutputProduct.getOutputId());
        if (optionalOutput.isEmpty())
            return new ResultMessage("Output not found",false);

        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setOutput(optionalOutput.get());
        outputProduct.setCount(dtoOutputProduct.getCount());
        outputProduct.setPrice(dtoOutputProduct.getPrice());
        outputProductRepository.save(outputProduct);
        return new ResultMessage("Product successfully added",true);
    }

    @Override
    public List<OutputProduct> getAll() {
        return outputProductRepository.findAll();
    }

    @Override
    public OutputProduct getOne(Integer id) {
        return outputProductRepository.findById(id).orElse(null);
    }

    @Override
    public ResultMessage edit(Integer id, DTOOutputProduct dtoOutputProduct) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isEmpty())
            return new ResultMessage("Product not found",false);

        Optional<Product> optionalProduct =  productRepository.findByIdAndIs_activeIsTrue(dtoOutputProduct.getProduct_id());
        if (optionalProduct.isEmpty())
            return new ResultMessage("Product not found",false);

        Optional<Output> optionalOutput = outputRepository.findById(dtoOutputProduct.getOutputId());
        if (optionalOutput.isEmpty())
            return new ResultMessage("Output not found",false);

        OutputProduct eit = optionalOutputProduct.get();
        eit.setProduct(optionalProduct.get());
        eit.setOutput(optionalOutput.get());
        eit.setPrice(dtoOutputProduct.getPrice());
        eit.setCount(dtoOutputProduct.getCount());
        outputProductRepository.save(eit);
        return new ResultMessage("Product successfully edited",true);
    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<OutputProduct> outputProduct = outputProductRepository.findById(Id);
        if (outputProduct.isEmpty())
            return new ResultMessage("Product not found",false);
        outputProductRepository.deleteById(Id);
        return new ResultMessage("Product successfully deleted",true);
    }
}
