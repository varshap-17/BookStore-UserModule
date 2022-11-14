package com.example.usermodule.service;

import com.example.usermodule.Dto.UserDataDto;
import com.example.usermodule.model.UserData;
import com.example.usermodule.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService implements IUserData{
    @Autowired
    UserDataRepository userDataRepository;

    public UserData createUser(UserDataDto userDataDto){
        UserData userData=new UserData(userDataDto);
        return userDataRepository.save(userData);
    }
    public UserData updateUser(Long userid,UserDataDto userDataDto){
        UserData userData=userDataRepository.findById(userid).orElse(null);
        if (userData!=null){
            userData.setFirstname(userDataDto.firstname);
            userData.setLastname(userDataDto.lastname);
            userData.setAddress(userDataDto.address);
            userData.setEmail(userDataDto.email);
            userData.setPassword(userDataDto.password);
            return userDataRepository.save(userData);
        }else
            return null;
    }
    public List<UserData> retrieveUser(){
        return userDataRepository.findAll();
    }
    public UserData deleteUser(Long userid){
        userDataRepository.deleteById(userid);
        return null;
    }
    public UserData findById(Long userid){
        return userDataRepository.findById(userid).orElse(null);
    }
}
