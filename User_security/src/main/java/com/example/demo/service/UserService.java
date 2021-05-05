package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserModel;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<UserModel> displayUser();
    public UserDto findByUserId(String userId);
    public UserDto updateUser(String userId,UserDto userDto);
    public Integer deleteByUserId(String userId);
}
