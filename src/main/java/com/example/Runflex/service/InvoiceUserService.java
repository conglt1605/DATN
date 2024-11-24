/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

/**
 *
 * @author Cong
 */
import com.example.Runflex.entity.InvoiceUser;
import com.example.Runflex.repository.InvoiceUserRepository;
import com.example.Runflex.service.impl.IInvoiceUserService;
import com.example.Runflex.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InvoiceUserService implements IInvoiceUserService {

    @Autowired
    private InvoiceUserRepository invoiceUserRepository;

    @Override
    public ResponseEntity<?> getAllInvoiceUsers() {
        List<InvoiceUser> invoiceUsers = invoiceUserRepository.findAll();
        if (invoiceUsers.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("success", invoiceUsers));
    }

@Override
public ResponseEntity<?> getInvoiceUsersWithStatusActive() {
    List<InvoiceUser> activeInvoiceUsers = invoiceUserRepository.findByStatus(Status.active);
    if (activeInvoiceUsers.isEmpty()) {
        return ResponseEntity.ok(Map.of("message", "Không có InvoiceUser nào với trạng thái active."));
    }
    return ResponseEntity.ok(Map.of("success", activeInvoiceUsers));
}


    @Override
    public ResponseEntity<?> saveInvoiceUser(InvoiceUser invoiceUser) {
        if (invoiceUser.getInvoice() == null || invoiceUser.getUser() == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invoice hoặc User không được để trống"));
        }
        invoiceUser.setStatus(Status.active);
        invoiceUserRepository.save(invoiceUser);
        return ResponseEntity.ok(Map.of("success", "Thêm thành công"));
    }

    @Override
    public ResponseEntity<?> saveInvoiceUsers(List<InvoiceUser> invoiceUsers) {
        for (InvoiceUser invoiceUser : invoiceUsers) {
            if (invoiceUser.getInvoice() == null || invoiceUser.getUser() == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Invoice hoặc User không được để trống"));
            }
            invoiceUser.setStatus(Status.active);
        }
        invoiceUserRepository.saveAll(invoiceUsers);
        return ResponseEntity.ok(Map.of("success", "Thêm danh sách thành công"));
    }

    @Override
    public ResponseEntity<?> updateInvoiceUser(Long id, InvoiceUser invoiceUser) {
        InvoiceUser existingInvoiceUser = invoiceUserRepository.findById(id).orElse(null);
        if (existingInvoiceUser == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy InvoiceUser với ID: " + id));
        }
        existingInvoiceUser.setInvoice(invoiceUser.getInvoice());
        existingInvoiceUser.setUser(invoiceUser.getUser());
        existingInvoiceUser.setStatus(invoiceUser.getStatus());
        invoiceUserRepository.save(existingInvoiceUser);
        return ResponseEntity.ok(Map.of("success", "Cập nhật thành công"));
    }

    @Override
    public ResponseEntity<?> deleteInvoiceUser(Long id) {
        InvoiceUser existingInvoiceUser = invoiceUserRepository.findById(id).orElse(null);
        if (existingInvoiceUser == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy InvoiceUser với ID: " + id));
        }
        existingInvoiceUser.setStatus(Status.delete);
        invoiceUserRepository.save(existingInvoiceUser);
        return ResponseEntity.ok(Map.of("success", "Xóa thành công"));
    }
}

