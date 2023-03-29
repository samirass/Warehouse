package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.Input;
import uz.pdp.stock.payload.DTOInput;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.InputServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/input")
public class InputController {
    final InputServiceImpl inputService;

    @PostMapping
    public ResultMessage add(@RequestBody DTOInput inputDto) {
        return inputService.add(inputDto);
    }

    @GetMapping
    public List<Input> getAll() {
        return inputService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Input> getOne(@PathVariable Integer id) {
        return inputService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody DTOInput inputDto) {
        return inputService.edit(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return inputService.delete(id);
    }
}
