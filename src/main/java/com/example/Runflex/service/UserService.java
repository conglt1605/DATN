/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.config.JwtUtilities;
import com.example.Runflex.dto.LoginDto;
import com.example.Runflex.dto.LogoutDto;
import com.example.Runflex.dto.RegisterDto;
import com.example.Runflex.entity.Role;
import com.example.Runflex.entity.User;
import com.example.Runflex.repository.RoleRepository;
import com.example.Runflex.repository.UserRepository;
import com.example.Runflex.service.impl.IUserService;
import com.example.Runflex.util.Status;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class UserService implements IUserService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtilities jwtUtilities;

    @Override
    public ResponseEntity<?> authenticate(LoginDto loginDto) {
        try {
            // Xác thực người dùng
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUserName(),
                            loginDto.getPassword()
                    )
            );

            // Thiết lập ngữ cảnh bảo mật
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Tìm người dùng trong cơ sở dữ liệu
            User user = userRepository.findByUsername(authentication.getName());
            if (user == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Tài Khoản Chưa Được Đăng Ký"));
            }
            // Tạo token
            String token = jwtUtilities.generateToken(user.getId(), user.getUsername(),
                    user.getRole().getRoleName());

            // Trả về token và ID nếu xác thực thành công
            return ResponseEntity.ok(Map.of(
                    "success", token,
                    "userId", user.getId()
            ));

        } catch (AuthenticationException e) {
            // Nếu xác thực thất bại do thông tin không hợp lệ
            return ResponseEntity.badRequest().body(Map.of("error", "Đăng Nhập Thất Bại"));
        }
    }

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        // Validate username
        if (registerDto.getUserName() == null || registerDto.getUserName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Tài Khoản Không Được Để Trống"));
        } else if (userRepository.existsByUsername(registerDto.getUserName())) {
            return ResponseEntity.badRequest().body(Map.of("error", "Tài Khoản Đã Tồn Tại"));
        }
        if (registerDto.getPassword() == null || registerDto.getPassword().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Mật Khẩu Không Được Để Trống"));
        } else if (registerDto.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body(Map.of("error", "Mật khẩu phải có ít nhất 6 ký tự!"));
        } else if (registerDto.getPassword().contains(" ")) {
            return ResponseEntity.badRequest().body(Map.of("error", "Mật khẩu không được chứa dấu cách!"));
        }
        if (registerDto.getFullName() == null || registerDto.getFullName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Họ tên không được để trống!"));
        }
        if (registerDto.getEmail() == null || registerDto.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email không được để trống!"));
        } else if (userRepository.existsByEmail(registerDto.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email đã được sử dụng!"));
        }

        // Save new user if all validations pass
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setFullName(registerDto.getFullName());
        user.setUsername(registerDto.getUserName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setStatus(Status.active);
        Role role = roleRepository.findById(2L).orElseThrow(); // 2L user role
        user.setRole(role);
        userRepository.save(user);
        return ResponseEntity.ok(Map.of("succes", "Tạo Tài Khoản Thành Công"));
    }

    @Override
    public ResponseEntity<?> logout(LogoutDto logoutDto) {
        if (logoutDto.getUserId() == null || logoutDto.getToken() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Yêu cầu đăng xuất không hợp lệ."));
        }

        // Giả sử sử dụng JWT, kiểm tra tính hợp lệ của token
        boolean isTokenValid = jwtUtilities.validateToken(logoutDto.getToken());
        if (!isTokenValid) {
            return ResponseEntity.badRequest().body(Map.of("error", "Token không hợp lệ hoặc đã hết hạn."));
        }

        //    // Logic thêm token vào blacklist (nếu cần)
        //    jwtUtilities.invalidateToken(logoutDto.getToken()); // Hàm cần được xây dựng trong `JwtUtilities`
        return ResponseEntity.ok(Map.of("success", "Đăng xuất thành công."));
    }

}
