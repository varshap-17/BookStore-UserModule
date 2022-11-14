package com.example.usermodule.service;

import com.example.usermodule.Dto.UserDataDto;
import com.example.usermodule.model.UserData;

import java.util.List;

public interface IUserData {
    public UserData createUser(UserDataDto userDataDto);
    public UserData updateUser(Long userid,UserDataDto userDataDto);
    public List<UserData> retrieveUser();
    public UserData deleteUser(Long userid);
    public UserData findById(Long userid);
}
