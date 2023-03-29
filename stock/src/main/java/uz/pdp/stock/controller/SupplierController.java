package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.Supplier;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.SupplierService;
import uz.pdp.stock.service.SupplierServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierServiceImpl supplierServiceImpl;

    @PostMapping
    public ResultMessage add(@RequestBody Supplier supplier){
        return supplierServiceImpl.add(supplier);
    }

    @GetMapping
    public List<Supplier> getAll(){
        return supplierServiceImpl.getAll();
    }
    @GetMapping("/{id}")
    public Supplier getOne(@PathVariable Integer id){
        return supplierServiceImpl.getOne(id);
    }

    @PutMapping("'/{id}")
    public ResultMessage edit(@PathVariable Integer id,@RequestBody Supplier supplier){
        return supplierServiceImpl.edit(id,supplier);
    }
    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id){
        return supplierServiceImpl.delete(id);
    }


}
