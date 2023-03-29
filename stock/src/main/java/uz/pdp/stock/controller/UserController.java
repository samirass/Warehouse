package uz.pdp.stock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.stock.entity.User;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResultMessage add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Integer id) {
        return userService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResultMessage edit(@PathVariable Integer id, @RequestBody User user) {
        return userService.edit(id, user);
    }

    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
