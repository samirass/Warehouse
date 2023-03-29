package uz.pdp.stock.service;

import uz.pdp.stock.entity.OutputProduct;
import uz.pdp.stock.payload.DTOOutputProduct;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;

public interface OutputProductService {
    ResultMessage add(DTOOutputProduct dtoOutputProduct);
    List<OutputProduct> getAll();
    OutputProduct getOne(Integer id);
    ResultMessage edit(Integer id,DTOOutputProduct dtoOutputProduct);
    ResultMessage delete(Integer Id);

}
