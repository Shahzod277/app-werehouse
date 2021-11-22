package uz.developer.appwerehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uz.developer.appwerehouse.entity.User;
import uz.developer.appwerehouse.entity.Werehouse;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.UserDto;
import uz.developer.appwerehouse.repository.UserRepository;
import uz.developer.appwerehouse.repository.WerehouseRespository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WerehouseRespository werehouseRespository;


    @Override
    public Result getAllUser() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return new Result("user not found", 403, null);
        }
        return new Result("all user", 202, userList);
    }

    @Override
    public Result getOneUser(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()) {
            return new Result("id user  not found ", 409, null);
        }
        return new Result("successfull", 202, byId);
    }


    @Override
    public Result deleteUser(Integer id) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);
            return new Result("user deleted", 220);
        }
        return new Result("id not found", 405);
    }

    @Override
    public Result editUser(Integer id, UserDto userDto) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setCode(userDto.getCode());
            user.setActive(user.isActive());
            user.setPassword(user.getPassword());
            boolean exists = userRepository.existsByPhoneNumberAndIdNot(user.getPhoneNumber(), id);
            if (exists) {
                return new Result("this phone number already added", 401, null);
            }

            List<Werehouse> optionalWerehouse = werehouseRespository.findAllByIdIn(userDto.getWerehouseId());

            user.setWerehouses(optionalWerehouse);
            user.setPassword(userDto.getPassword());
            user.setFirstName(userDto.getFirstName());
            user.setFirstName(userDto.getFirstName());
            userRepository.save(user);
            return new Result("edited user", 405, null);
        }
        return new Result("id not found", 202, null);
    }

    @Override
    public Result addUser(UserDto userDto) {
        boolean exists = userRepository.existsByFirstNameAndLastName(userDto.getFirstName(), userDto.getLastName());
        if (exists) {
            return new Result("this user already added", 405, null);
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCode(userDto.getCode());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setActive(false);
        List<Werehouse> byId = werehouseRespository.findAllByIdIn(userDto.getWerehouseId());
        user.setWerehouses(byId);
        userRepository.save(user);
        return new Result("user added", 203);

    }
}
