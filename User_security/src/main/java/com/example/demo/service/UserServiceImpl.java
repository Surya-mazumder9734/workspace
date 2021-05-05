package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserModel;
import com.example.demo.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public List<UserModel> displayUser(){
        return userRepository.findAll();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserModel model=modelMapper.map(userDto,UserModel.class);
        userRepository.save(model);
        UserDto Dto=modelMapper.map(model,UserDto.class);
        return  Dto;
    }

    @Override
    public UserDto findByUserId(String userId) {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserModel model=userRepository.findByUserId(userId);
        if(model==null){
            return  null;
        }else{
            UserDto dto=modelMapper.map(model,UserDto.class);
            return dto;
        }

    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        UserModel userModel=userRepository.findByUserId(userId);
        if(userModel==null)
        {
            throw new UserNotFoundException("no such account found");
        }
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserModel model=mapper.map(userDto, UserModel.class);
        userModel.setFirstName(model.getFirstName());
        userModel.setLastName(model.getLastName());
        userModel.setEmail(model.getEmail());
        userRepository.save(userModel);
        UserDto accDto=mapper.map(userModel, UserDto.class);
        return accDto;
    }

    @Override
    @Transactional
    public Integer deleteByUserId(String userId) {
        return userRepository.deleteByUserId(userId);
    }


}
