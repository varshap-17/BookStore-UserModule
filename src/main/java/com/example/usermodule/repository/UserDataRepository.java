package com.example.usermodule.repository;

import com.example.usermodule.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData,Long> {
}
