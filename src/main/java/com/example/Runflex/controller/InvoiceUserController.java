/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.Invoice;
import com.example.Runflex.entity.InvoiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Runflex.service.impl.IInvoiceUserService;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/invoiceuser")
public class InvoiceUserController {
    @Autowired
    private IInvoiceUserService invoiceUserService;
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return invoiceUserService.getAll();
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody InvoiceUser invoiceUser){
        return invoiceUserService.saveInvoiceUser(invoiceUser);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody InvoiceUser invoiceUser){
        return invoiceUserService.updateInvoiceUser(id, invoiceUser);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return invoiceUserService.deleteInvoiceUser(id);
    }
}
