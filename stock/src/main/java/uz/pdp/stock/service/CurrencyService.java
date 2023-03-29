package uz.pdp.stock.service;

import uz.pdp.stock.entity.Currency;
import uz.pdp.stock.payload.ResultMessage;
import java.util.List;
import java.util.Optional;


public interface CurrencyService {

    ResultMessage add(Currency currency);
    List<Currency> getAll();
    Optional<Currency> getOne(Integer id);
    ResultMessage edit(Integer id,Currency currency);
    ResultMessage delete(Integer Id);



}
