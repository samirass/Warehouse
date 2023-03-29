package uz.pdp.stock.service;

import uz.pdp.stock.entity.InputProduct;
import uz.pdp.stock.payload.DTOInputProduct;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;

public interface InputProductService {

    ResultMessage add(DTOInputProduct inputProduct);
    List<uz.pdp.stock.entity.InputProduct> getAll();
    InputProduct getOne(Integer id);
    ResultMessage edit(Integer id,DTOInputProduct inputProduct);
    ResultMessage delete(Integer Id);

}
