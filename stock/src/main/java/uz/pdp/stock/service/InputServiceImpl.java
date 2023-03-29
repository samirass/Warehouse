package uz.pdp.stock.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Currency;
import uz.pdp.stock.entity.Input;
import uz.pdp.stock.entity.Supplier;
import uz.pdp.stock.entity.WareHouse;
import uz.pdp.stock.payload.DTOInput;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.CurrencyRepository;
import uz.pdp.stock.repository.InputRepository;
import uz.pdp.stock.repository.SupplierRepository;
import uz.pdp.stock.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class InputServiceImpl implements InputService{
    final InputRepository inputRepository;
    final WarehouseRepository warehouseRepository;
    final CurrencyRepository currencyRepository;
    final SupplierRepository supplierRepository;
    @Override
    public ResultMessage add(DTOInput dtoInput) {
        if(inputRepository.existsByCode(dtoInput.getCode()))
            return new ResultMessage("This input already exist", false);
        Optional<WareHouse> optionalWareHouse = warehouseRepository.findByIdAndActiveIsTrue(dtoInput.getWarehouse_id());
        if (optionalWareHouse.isEmpty())
            return new ResultMessage("Warehouse not found",false);
        Optional<Currency> optionalCurrency = currencyRepository.findByIs_activeIsTrue(dtoInput.getCurrency_id());
        if (optionalCurrency.isEmpty())
            return new ResultMessage("Currency not found",false);
       Optional<Supplier> optionalSupplier = supplierRepository.findByIs_activeIsTrue(dtoInput.getSupplier_id());
       if (optionalSupplier.isEmpty())
           return new ResultMessage("Supplier not found",false);

       Input input = new Input();
       input.setData(dtoInput.getData());
       input.setCode(dtoInput.getCode());
       input.setSupplier(optionalSupplier.get());
       input.setWareHouse(optionalWareHouse.get());
       input.setCurrency(optionalCurrency.get());
       input.setFacture_Number(dtoInput.getFactureNumber());
       inputRepository.save(input);
       return new ResultMessage("Input successfully added",true);
    }

    @Override
    public List<Input> getAll() {
        return inputRepository.findAll();
    }

    @Override
    public Optional<Input> getOne(Integer id) {
        return inputRepository.findById(id);
    }

    @Override
    public ResultMessage edit(Integer id, DTOInput dtoInput) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if(optionalInput.isEmpty())
            return new ResultMessage("Input not found",false);
        Optional<WareHouse> optionalWareHouse = warehouseRepository.findByIdAndActiveIsTrue(dtoInput.getWarehouse_id());
        if(optionalWareHouse.isEmpty())
            return new ResultMessage("Warehouse not foundd",false);
        Optional<Currency> optionalCurrency =currencyRepository.findByIs_activeIsTrue(dtoInput.getCurrency_id());
        if(optionalCurrency.isEmpty())
            return new ResultMessage("Currency not found",false);
        Optional<Supplier> optionalSupplier =supplierRepository.findByIs_activeIsTrue(dtoInput.getSupplier_id());
        if(optionalSupplier.isEmpty())
            return new ResultMessage("Supplier not found",false);

        Input edit = optionalInput.get();
        edit.setData(dtoInput.getData());
        edit.setCode(dtoInput.getCode());
        edit.setFacture_Number(dtoInput.getFactureNumber());
        edit.setWareHouse(optionalWareHouse.get());
        edit.setCurrency(optionalCurrency.get());
        edit.setSupplier(optionalSupplier.get());
        inputRepository.save(edit);
        return new ResultMessage("Input successfully edited",true);
    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<Input> optionalInput = inputRepository.findById(Id);
        if(optionalInput.isEmpty())
            return new ResultMessage("Input not found",false);
        inputRepository.deleteById(Id);
        return new ResultMessage("Input successfully deleted",false);
    }
}
