package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.Measurement;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.MeasurementServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/measurement")
public class MeasurementController {
    private final MeasurementServiceImpl measurementService;
    @PostMapping
    public ResultMessage add(@RequestBody Measurement measurement){
        return measurementService.add(measurement);
    }

    @GetMapping
    public List<Measurement> getAll(){
       return measurementService.getAll();
    }

    @GetMapping("/{id}")
    public Measurement getOne(@PathVariable Integer id){
        return measurementService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id,@RequestBody Measurement measurement){
        return measurementService.edit(id,measurement);
    }
    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id){
        return measurementService.delete(id);
    }

}
