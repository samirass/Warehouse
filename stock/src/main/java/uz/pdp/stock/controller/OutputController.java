package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.Output;
import uz.pdp.stock.payload.DTOOutput;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.OutputServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {
    final OutputServiceImpl outputService;
    @PostMapping
    public ResultMessage add(@RequestBody DTOOutput outputDto) {
        return outputService.add(outputDto);
    }

    @GetMapping
    public List<Output> getAll() {
        return outputService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Output> getOne(@PathVariable Integer id) {
        return outputService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody DTOOutput outputDto) {
        return outputService.edit(id, outputDto);
    }

    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return outputService.delete(id);
    }
}
