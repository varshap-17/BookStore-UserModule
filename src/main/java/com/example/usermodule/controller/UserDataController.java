package com.example.usermodule.controller;

import com.example.usermodule.Dto.ResponseDto;
import com.example.usermodule.Dto.UserDataDto;
import com.example.usermodule.consumer.MessageConfigure;
import com.example.usermodule.model.UserData;
import com.example.usermodule.service.UserDataService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserData")
public class UserDataController {
    @Autowired
    UserDataService userDataService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("/addUser")
    public ResponseEntity<ResponseDto> addUser(@RequestBody UserDataDto userDataDto){
        UserData userData=null;
        userData=userDataService.createUser(userDataDto);
        rabbitTemplate.convertAndSend(MessageConfigure.EXCHANGE,MessageConfigure.ROUTING_KEY,userData);
        ResponseDto responseDto=new ResponseDto("data saved successfully",userData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PutMapping("/updateUser/{userid}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable long userid,@RequestBody UserDataDto userDataDto){
        UserData userData=userDataService.updateUser(userid,userDataDto);
        ResponseDto responseDto=new ResponseDto("data updated successfully with userid "+userid,userData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getUsers")
    public List<UserData> retrieveUser(){
        return userDataService.retrieveUser();
    }
    @DeleteMapping("/deleteUser/{userid}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable long userid){
        UserData userData=userDataService.deleteUser(userid);
        ResponseDto responseDto=new ResponseDto("deleted userid "+userid+" successfully",userData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getById/{userid}")
    public UserData getUserById(@PathVariable long userid){
        UserData userData=userDataService.findById(userid);
        return userData;
//        ResponseDto responseDto=new ResponseDto("data got for id "+userid,userData);
//        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
