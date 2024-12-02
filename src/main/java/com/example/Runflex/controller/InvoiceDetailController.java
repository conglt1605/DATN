/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.controller;

import com.example.Runflex.entity.InvoiceDetail;
import com.example.Runflex.service.InvoiceDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoicedetail")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return invoiceDetailService.getAll();
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveInvoiceDetails() {
        return invoiceDetailService.getActiveInvoiceDetails();
    }

@PostMapping("/add")
public ResponseEntity<?> addList(@RequestBody List<InvoiceDetail> invoiceDetails) {
    return invoiceDetailService.saveInvoiceDetails(invoiceDetails);
}


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.updateInvoiceDetail(id, invoiceDetail);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return invoiceDetailService.deleteInvoiceDetail(id);
    }
}

