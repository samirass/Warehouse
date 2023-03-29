package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Attachment;
import uz.pdp.stock.entity.Category;
import uz.pdp.stock.entity.Measurement;
import uz.pdp.stock.entity.Product;
import uz.pdp.stock.payload.DTOProduct;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.AttachmentRepository;
import uz.pdp.stock.repository.CategoryRepository;
import uz.pdp.stock.repository.MeasurementRepository;
import uz.pdp.stock.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;
    final MeasurementRepository measurementRepository;
    final AttachmentRepository attachmentRepository;

    @Override
    public ResultMessage add(DTOProduct dtoProduct) {
        if(productRepository.existsByNameAndCategoryId(dtoProduct.getName(),dtoProduct.getCategoryId()))
            return new ResultMessage("This product already exist in this category",false);
        Optional<Category> optionalCategory = categoryRepository.findById(dtoProduct.getCategoryId());
        if(optionalCategory.isEmpty())
            return new ResultMessage("Category not found",false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(dtoProduct.getMeasurementId());
        if(optionalMeasurement.isEmpty())
            return new ResultMessage("Measurement not found",false);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(dtoProduct.getPhotoId());
        if (optionalAttachment.isEmpty())
            return new ResultMessage("Photo not found",false);

        Product product=new Product();
        product.setName(dtoProduct.getName());
        product.setCode(UUID.randomUUID().toString());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new ResultMessage("Product successfully added",true);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAllByIs_activeIsTrue();
    }

    @Override
    public Optional<Product> getOne(Integer id) {
        return productRepository.findByIdAndIs_activeIsTrue(id);
    }
    @Override
    public ResultMessage edit(Integer id, DTOProduct dtoProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())
            return new ResultMessage("Product not found",false);

        if (productRepository.existsByNameAndCategoryId(dtoProduct.getName(), dtoProduct.getCategoryId()))
            return new ResultMessage("This product already exist in this category",false);

        Optional<Category> optionalCategory = categoryRepository.findById(dtoProduct.getCategoryId());
                if(optionalCategory.isEmpty())
                    return new ResultMessage("Category not found",false);

                Optional<Attachment> optionalAttachment = attachmentRepository.findById(dtoProduct.getPhotoId());
        if (optionalAttachment.isEmpty())
            return new ResultMessage("Photo not found",false);

            Optional<Measurement> optionalMeasurement = measurementRepository.findById(dtoProduct.getMeasurementId());
                    if(optionalMeasurement.isEmpty())
                        return new ResultMessage("Measurement not found",false);

                    Product editProduct = optionalProduct.get();
                    editProduct.setName(dtoProduct.getName());
                    editProduct.setCode(UUID.randomUUID().toString());
                    editProduct.setCategory(optionalCategory.get());
                    editProduct.setPhoto(optionalAttachment.get());
                    editProduct.setMeasurement(optionalMeasurement.get());
                    productRepository.save(editProduct);
                    return new ResultMessage("Product successfully edited",true);
    }

    @Override
    public ResultMessage delete(Integer Id)  {
        Optional<Product> optionalProduct = productRepository.findByIdAndIs_activeIsTrue(Id);
        if(optionalProduct.isEmpty())
            return new ResultMessage("Product not found",false);
        Product deletingProduct = optionalProduct.get();
        deletingProduct.setIs_active(false);
        productRepository.save(deletingProduct);
        return new ResultMessage("Product successfully deleted",true);
    }
}
