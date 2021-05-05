package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.shared.UserRequestModel;
import com.example.demo.shared.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@Validated
public class UserController {
    private UserService userService;
    @Autowired

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    //Display Data user
    @GetMapping(path = "/user/details")
    public List<UserDto> displayUser(){
        ModelMapper modelMapper = new ModelMapper();
        return userService.displayUser().stream().map(post->modelMapper.map(post,UserDto.class)).collect(Collectors.toList());

    }

    //create Data user
    @PostMapping("/user")
    public ResponseEntity<UserResponseModel> createAccount(@Valid @RequestBody UserRequestModel accRequestModel) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(accRequestModel, UserDto.class);
        userDto.setUserId(UUID.randomUUID().toString());
        UserDto response = userService.createUser(userDto);
        UserResponseModel model = mapper.map(response, UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);

    }

    //Find User by userID
    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<UserResponseModel> findByAccountId(@PathVariable("userId") String userId){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto response=userService.findByUserId(userId);
        UserResponseModel model=mapper.map(response,UserResponseModel.class);
        return ResponseEntity.ok(model);
    }
    //DElETE User By UserID

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Integer> deleteAccount(@PathVariable("userId") String userId) {

        Integer result=userService.deleteByUserId(userId);
        if(result<1)
        {
            throw new UserNotFoundException("no user found.");
        }
        return ResponseEntity.ok(result);

    }
    //Update User by Id
    @PutMapping("/user/{userid}")
    public ResponseEntity<UserDto> updateAccount(@PathVariable("userid")@Min(1) String userId,
                                                    @RequestBody UserRequestModel requestModel)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto dto= mapper.map(requestModel, UserDto.class);
        UserDto d= userService.updateUser(userId,dto);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }


}
