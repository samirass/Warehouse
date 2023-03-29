package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.Currency;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.CurrencyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")

public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping
    public ResultMessage add(@RequestBody Currency currency) {
        return currencyService.add(currency);
    }

    @GetMapping
    public List<Currency> getAll() {
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Currency> getOne(@PathVariable Integer id) {
        return currencyService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody Currency currency) {
        return currencyService.edit(id, currency);
    }

    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return currencyService.delete(id);
    }
}
