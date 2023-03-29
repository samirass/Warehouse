package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.InputProduct;
import uz.pdp.stock.payload.DTOInputProduct;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.InputProductImpl;

import java.util.List;

@RestController
@RequestMapping("/input-product")
@RequiredArgsConstructor
public class InputProductController {
    final InputProductImpl inputProduct;
    @PostMapping
    public ResultMessage add(@RequestBody DTOInputProduct inputProductDto) {
        return inputProduct.add(inputProductDto);
    }

    @GetMapping
    public List<InputProduct> getAll() {
        return inputProduct.getAll();
    }

    @GetMapping("/{id}")
    public InputProduct getOne(@PathVariable Integer id) {
        return inputProduct.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody DTOInputProduct inputProductDto) {
        return inputProduct.edit(id, inputProductDto);
    }

    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return inputProduct.delete(id);
    }
}
