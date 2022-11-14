package com.example.usermodule.model;

import com.example.usermodule.Dto.UserDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String password;

    public UserData(UserDataDto userDataDto){
        this.firstname=userDataDto.firstname;
        this.lastname=userDataDto.lastname;
        this.address=userDataDto.address;
        this.email=userDataDto.email;
        this.password=userDataDto.password;
    }
}
