package uz.pdp.stock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.stock.entity.User;
import uz.pdp.stock.payload.ResultMessage;
import uz.pdp.stock.repository.UserRepository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResultMessage add(User user) {
       if(userRepository.existsByPhone_number(user.getPhone_number()))
           return new ResultMessage("This user already exists",false);
       userRepository.save(user);
       return new ResultMessage("User successfully added", true);
    }

    @Override
    public List<User> getAll() {
       return userRepository.findAllByIs_activeIsTrue();
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.findByIdIs_activeIsTrue(id).orElse(null);
    }

    @Override
    public ResultMessage edit(Integer id, User user) {
      Optional<User> optionalUser = userRepository.findByIdIs_activeIsTrue(id);
      if(optionalUser.isEmpty())
          return new ResultMessage("User not found",false);
      User editingUser = optionalUser.get();
      editingUser.setFirst_name(user.getFirst_name());
        editingUser.setLast_name(user.getLast_name());
        editingUser.setCode(user.getCode());
        editingUser.setPassword(user.getPassword());
        editingUser.setPhone_number(user.getPhone_number());
        editingUser.setWareHouseSet(user.getWareHouseSet()); ;
        userRepository.save(editingUser);
        return new ResultMessage("User successfully edited",true);
    }

    @Override
     public ResultMessage delete(Integer Id) {
        Optional<User> optionalUser = userRepository.findByIdIs_activeIsTrue(Id);
        if(optionalUser.isEmpty())
            return new ResultMessage("User not found",false);
          User deletingUser= optionalUser.get();
          deletingUser.setIs_active(false);
          userRepository.save(deletingUser);
          return  new ResultMessage("User successfully deleted",true);
    }

}