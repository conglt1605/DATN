/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

/**
 *
 * @author Cong
 */
import com.example.Runflex.entity.InvoiceUser;
import com.example.Runflex.service.InvoiceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoiceuser")
public class InvoiceUserController {

    @Autowired
    private InvoiceUserService invoiceUserService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllInvoiceUsers() {
        return invoiceUserService.getAllInvoiceUsers();
    }

@GetMapping("/active")
public ResponseEntity<?> getInvoicesWithStatusActive() {
    return invoiceUserService.getInvoiceUsersWithStatusActive();
}


    @PostMapping("/add")
    public ResponseEntity<?> addInvoiceUser(@RequestBody InvoiceUser invoiceUser) {
        return invoiceUserService.saveInvoiceUser(invoiceUser);
    }

    @PostMapping("/add-list")
    public ResponseEntity<?> addInvoiceUsers(@RequestBody List<InvoiceUser> invoiceUsers) {
        return invoiceUserService.saveInvoiceUsers(invoiceUsers);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInvoiceUser(@PathVariable("id") Long id, @RequestBody InvoiceUser invoiceUser) {
        return invoiceUserService.updateInvoiceUser(id, invoiceUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInvoiceUser(@PathVariable("id") Long id) {
        return invoiceUserService.deleteInvoiceUser(id);
    }
}

