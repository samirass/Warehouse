package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Currency;
import uz.pdp.stock.entity.Measurement;
import uz.pdp.stock.entity.Output;
import uz.pdp.stock.entity.WareHouse;
import uz.pdp.stock.payload.DTOOutput;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.CurrencyRepository;
import uz.pdp.stock.repository.OutputRepository;
import uz.pdp.stock.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputServiceImpl implements OutputService{
    private final OutputRepository outputRepository;
    private final WarehouseRepository warehouseRepository;
    private final CurrencyRepository currencyRepository;

    @Override
    public ResultMessage add(DTOOutput output) {
        if (outputRepository.existsByCode(output.getCode()))
            return new ResultMessage("This output already exist",false);
        Optional<WareHouse> optionalWareHouse=warehouseRepository.findByIdAndActiveIsTrue(output.getWarehouse_id());
        if (optionalWareHouse.isEmpty())
            return new ResultMessage("Warehouse not found",false);
        Optional<Currency> optionalCurrency = currencyRepository.findByIs_activeIsTrue(output.getCurrency_id());
        if (optionalCurrency.isEmpty())
            return new ResultMessage("Currency not found",false);


        Output output1 = new Output();
        output1.setData(output.getData());
        output1.setFacture_Number(output.getFacture_Number());
        output1.setCode(output.getCode());
        output1.setCurrency(optionalCurrency.get());
        output1.setWareHouse(optionalWareHouse.get());
        outputRepository.save(output1);
        return new ResultMessage("Output successfully added",false);
    }

    @Override
    public List<Output> getAll() {
        return outputRepository.findAll();
    }

    @Override
    public Optional<Output> getOne(Integer id) {
        return Optional.ofNullable(outputRepository.findById(id).orElse(null));
    }

    @Override
    public ResultMessage edit(Integer id, DTOOutput Dtooutput) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if(optionalOutput.isEmpty())
            return new ResultMessage("Output not found",false);

        Optional<WareHouse> optionalWareHouse=warehouseRepository.findByIdAndActiveIsTrue(Dtooutput.getWarehouse_id());
        if (optionalWareHouse.isEmpty())
            return new ResultMessage("Warehouse not found",false);
           Optional<Currency> optionalCurrency = currencyRepository.findByIs_activeIsTrue(Dtooutput.getCurrency_id());
        if (optionalCurrency.isEmpty())
            return new ResultMessage("Currency not found",false);

        Output editOutput = optionalOutput.get();
        editOutput.setData(Dtooutput.getData());
        editOutput.setCode(Dtooutput.getCode());
        editOutput.setFacture_Number(Dtooutput.getFacture_Number());
        editOutput.setWareHouse(optionalWareHouse.get());
        editOutput.setCurrency(optionalCurrency.get());
        outputRepository.save(editOutput);

        return new ResultMessage("Output successfully edited",true);
    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<Output> optionalOutput = outputRepository.findById(Id);
        if (optionalOutput.isEmpty())
            return new ResultMessage("Output not found",false);
        Output deletingOutput= optionalOutput.get();
        deletingOutput.setId(null);
        outputRepository.save(deletingOutput);
        return new ResultMessage("Output successfully deleted",true);
    }
}
