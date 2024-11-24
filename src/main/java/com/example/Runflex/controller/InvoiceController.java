/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;
import com.example.Runflex.entity.Invoice;
import com.example.Runflex.service.impl.IInvoiceService;
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

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return invoiceService.getAll();
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Invoice invoice){
        return invoiceService.saveInvoice(invoice);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody Invoice invoice){
        return invoiceService.updateInvoice(id, invoice);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return invoiceService.deleteInvoice(id);
    }
}
