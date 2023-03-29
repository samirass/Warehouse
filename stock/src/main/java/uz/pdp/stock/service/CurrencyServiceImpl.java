package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.Currency;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService{
    private final CurrencyRepository currencyRepository;
    @Override
    public ResultMessage add(Currency currency) {
       if(currencyRepository.existsByName(currency.getName()))
           return new ResultMessage("This currency allready exists",false);
       currencyRepository.save(currency);
       return new ResultMessage("Currency successfully added",true);
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAllByIs_activeIsTrue();
    }

    @Override
    public Optional<Currency> getOne(Integer id) {
        return currencyRepository.findByIs_activeIsTrue(id);
    }

    @Override
    public ResultMessage edit(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findByIs_activeIsTrue(id);
        if(optionalCurrency.isEmpty())
            return new ResultMessage("Currency not found", false);
        Currency editingCurrency = optionalCurrency.get();
        editingCurrency.setName(currency.getName());
        currencyRepository.save(editingCurrency);

        return new ResultMessage("Currency successfully edited", true);
    }

    @Override
    public ResultMessage delete(Integer Id) {
        Optional<Currency> optionalCurrency = currencyRepository.findByIs_activeIsTrue(Id);
        if(optionalCurrency.isEmpty())
            return new ResultMessage("Currency not found", false);
        Currency deletingCurrency = optionalCurrency.get();
        deletingCurrency.setIs_active(false);
        currencyRepository.save(deletingCurrency);

        return new ResultMessage("Currency successfully deleted", true);
    }
}
