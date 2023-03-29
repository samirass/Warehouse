package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.WareHouse;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class WarehouseImpl implements WarehouseService{
    private final WarehouseRepository warehouseRepository;
    @Override
    public ResultMessage add(WareHouse warehouse) {
        if(warehouseRepository.existsByName((warehouse.getName())))

        return new ResultMessage("This warehouse already exists",false);
        warehouseRepository.save(warehouse);
        return new ResultMessage("Warehouse successfully added",true);
    }

    @Override
    public List<WareHouse> getAll() {
        return warehouseRepository.findAllByIs_activeIsTrue();
    }

    @Override
    public WareHouse getOne(Integer id) {
        return warehouseRepository.findByIdAndActiveIsTrue(id).orElse(null);
    }

    @Override
    public ResultMessage edit(Integer id, WareHouse wareHouse) {
        Optional<WareHouse> optionalWareHouse = warehouseRepository.findByIdAndActiveIsTrue(id);
        if(optionalWareHouse.isEmpty())
            return new ResultMessage("Warehouse not found",false);
          WareHouse editingWareHouse = optionalWareHouse.get();
          editingWareHouse.setName(wareHouse.getName());
          warehouseRepository.save(editingWareHouse);
          return new ResultMessage("Warehouse successfully edited",true);

    }

    @Override
    public ResultMessage delete(Integer Id) {
//        Optional<WareHouse> optionalWareHouse = warehouseRepository.findByIdAndAndIs_activeIsTrueTrue(id);
//        if(optionalWareHouse.isEmpty())
//            return new ResultMessage("Warehouse not found",false);
//        WareHouse deletingWarehouse = optionalWareHouse.get();
//        deletingWarehouse.setIs_active(false);
//        warehouseRepository.save(deletingWarehouse);
//        return new ResultMessage("Warehouse successfully deleted",true);


        Optional<WareHouse> optionalWarehouse = warehouseRepository.findByIdAndActiveIsTrue(id);
        if(optionalWarehouse.isEmpty())
            return new ResultMessage("Warehouse not found", false);
        WareHouse deletingWarehouse = optionalWarehouse.get();
        deletingWarehouse.setIs_active(false);
        warehouseRepository.save(deletingWarehouse);

        return new ResultMessage("Warehouse successfully deleted", true);
    }

}
