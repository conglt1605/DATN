/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.dto.LoginDto;
import com.example.Runflex.dto.LogoutDto;
import com.example.Runflex.dto.RegisterDto;
import com.example.Runflex.entity.User;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Cong
 */
public interface IUserService {

    ResponseEntity<?> authenticate(LoginDto loginDto);

    ResponseEntity<?> register(RegisterDto registerDto);
    ResponseEntity<?> logout(LogoutDto logoutDto);
    ResponseEntity<?> userById(long userId);
    ResponseEntity<?> updateUser(Long id,User user);
}
