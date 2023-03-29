package uz.pdp.stock.service;

import uz.pdp.stock.entity.Supplier;
import uz.pdp.stock.entity.User;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;

public interface SupplierService {
    ResultMessage add(Supplier supplier);
    List<Supplier> getAll();
    Supplier getOne(Integer id);
    ResultMessage edit(Integer id,Supplier supplier);
    ResultMessage delete(Integer Id);
}
