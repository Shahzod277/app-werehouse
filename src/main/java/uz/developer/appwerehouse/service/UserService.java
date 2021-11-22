package uz.developer.appwerehouse.service;


import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.UserDto;

import java.util.List;

public interface UserService {
    Result getAllUser();

    Result getOneUser(Integer id);

    Result deleteUser(Integer id);

    Result editUser(Integer id, UserDto userDto);

    Result addUser(UserDto userDto);
}
