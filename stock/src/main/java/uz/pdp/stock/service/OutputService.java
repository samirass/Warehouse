package uz.pdp.stock.service;

import uz.pdp.stock.entity.Currency;
import uz.pdp.stock.entity.Output;
import uz.pdp.stock.payload.DTOOutput;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;
import java.util.Optional;

public interface OutputService {
    ResultMessage add(DTOOutput output);
    List<Output> getAll();
    Optional<Output> getOne(Integer id);
    ResultMessage edit(Integer id, DTOOutput DtoOutput);
    ResultMessage delete(Integer Id);
}
