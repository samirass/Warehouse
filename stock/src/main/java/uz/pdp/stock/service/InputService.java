package uz.pdp.stock.service;

import uz.pdp.stock.entity.Input;
import uz.pdp.stock.payload.DTOInput;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.entity.Input;
import uz.pdp.stock.payload.DTOInput;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;
import java.util.Optional;

public interface InputService {
    ResultMessage add(DTOInput dtoInput);
    List<Input> getAll();
    Optional<Input> getOne(Integer id);
    ResultMessage edit(Integer id, DTOInput dtoInput);
    ResultMessage delete(Integer Id);
}
