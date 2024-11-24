/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.InvoiceDetail;
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
import com.example.Runflex.service.impl.IInvoiceDetailService;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/invoicedetail")
public class InvoiceDetailController {
    @Autowired
    private IInvoiceDetailService invoiceDetailService;
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return invoiceDetailService.getAll();
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody InvoiceDetail invoiceDetail){
        return invoiceDetailService.saveInvoiceDetail(invoiceDetail);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody InvoiceDetail invoiceDetail){
        return invoiceDetailService.updateInvoiceDetail(id, invoiceDetail);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return invoiceDetailService.deleteInvoiceDetail(id);
    }
}
