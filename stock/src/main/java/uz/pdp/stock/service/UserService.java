package uz.pdp.stock.service;

import uz.pdp.stock.entity.User;
import uz.pdp.stock.entity.WareHouse;
import uz.pdp.stock.payload.ResultMessage;

import java.util.List;

public interface UserService {
    ResultMessage add(User user);
    List<User> getAll();
    User getOne(Integer id);
    ResultMessage edit(Integer id,User user);
    ResultMessage delete(Integer Id);

}
