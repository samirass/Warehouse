package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.OutputProduct;
import uz.pdp.stock.payload.DTOInputProduct;
import uz.pdp.stock.payload.DTOOutputProduct;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.OutputProductImpl;

import java.util.List;

@RestController
@RequestMapping("/output-product")
@RequiredArgsConstructor
public class OutputProductController {
    final OutputProductImpl outputProduct;
    @PostMapping
    public ResultMessage add(@RequestBody DTOOutputProduct outputProduct1) {
        return outputProduct.add(outputProduct1);
    }

    @GetMapping
    public List<OutputProduct> getAll() {
        return outputProduct.getAll();
    }

    @GetMapping("/{id}")
    public OutputProduct getOne(@PathVariable Integer id) {
        return outputProduct.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody DTOOutputProduct dtoOutputProduct) {
        return outputProduct.edit(id, dtoOutputProduct);
    }

    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return outputProduct.delete(id);
    }
}
