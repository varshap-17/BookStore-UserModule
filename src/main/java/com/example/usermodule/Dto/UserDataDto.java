package com.example.usermodule.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {
    public String firstname;
    public String lastname;
    public String address;
    public String email;
    public String password;
}
