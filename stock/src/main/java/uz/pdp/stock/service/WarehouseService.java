package uz.pdp.stock.service;

import uz.pdp.stock.entity.WareHouse;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;

public interface WarehouseService {
    ResultMessage add(WareHouse warehouse);
    List<WareHouse> getAll();
    WareHouse getOne(Integer id);
    ResultMessage edit(Integer id,WareHouse wareHouse);
    ResultMessage delete(Integer Id);

}
