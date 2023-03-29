package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.WareHouse;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.WarehouseService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping
    public ResultMessage add(@RequestBody WareHouse wareHouse){
        return warehouseService.add(wareHouse);
    }

    @GetMapping
    public List<WareHouse> getAll() {
        return warehouseService.getAll();
    }
    @GetMapping("/{id}")
    public WareHouse getOne(@PathVariable Integer id) {
        return warehouseService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody WareHouse warehouse) {
        return warehouseService.edit(id,warehouse);
    }
    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return warehouseService.delete(id);
    }
}
