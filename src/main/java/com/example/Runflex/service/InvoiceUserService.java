/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.InvoiceUser;
import com.example.Runflex.repository.InvoiceUserRepository;
import com.example.Runflex.service.impl.IInvoiceUserService;
import com.example.Runflex.util.Status;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class InvoiceUserService implements IInvoiceUserService{
    @Autowired
    private InvoiceUserRepository invoiceUserRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<InvoiceUser> invoiceUsers = invoiceUserRepository.findAll();
        if (invoiceUsers.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sach Trong"));
        }
        return ResponseEntity.ok(Map.of("Succes", invoiceUsers));
    }

    @Override
    public ResponseEntity<?> getInvoiceUserWithStatusActive() {
        List<InvoiceUser> invoiceUsers = invoiceUserRepository.getInvoiceUserWithStatusActive();
        if (invoiceUsers.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Succes", invoiceUsers));
    }

    @Override
    public ResponseEntity<?> saveInvoiceUser(InvoiceUser invoiceUser) {
        if (invoiceUser.getInvoice().equals("") || invoiceUser.getInvoice()== null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Ten Hang K Duoc De Trong"));
        }
        invoiceUser.setStatus(Status.active);
        invoiceUserRepository.save(invoiceUser);
        return ResponseEntity.ok(Map.of("Succes", "Them Thanh Cong"));
    }

    @Override
    public ResponseEntity<?> deleteInvoiceUser(Long id) {
        InvoiceUser invoiceUser = invoiceUserRepository.findById(id).orElseThrow();
        if (invoiceUser == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        invoiceUser.setStatus(Status.delete);
        invoiceUserRepository.save(invoiceUser);
        return ResponseEntity.ok(Map.of("Succes", "Xoa Thanh Cong"));
    }

    @Override
    public ResponseEntity<?> updateInvoiceUser(Long id, InvoiceUser invoiceUser) {
        InvoiceUser existingInvoiceUser = invoiceUserRepository.findById(id).orElseThrow();
        if (invoiceUser == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        existingInvoiceUser.setId(invoiceUser.getId());
        invoiceUserRepository.save(existingInvoiceUser);
        return ResponseEntity.ok(Map.of("Succes","Sua Thanh Cong"));
}
    
}
