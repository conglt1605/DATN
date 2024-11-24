/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Invoice;
import com.example.Runflex.repository.InvoiceRepository;
import com.example.Runflex.service.impl.IInvoiceService;
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
public class InvoiceService implements IInvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        if (invoices.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh Sach Trong"));
        }
        return ResponseEntity.ok(Map.of("Succes", invoices));
    }

    @Override
    public ResponseEntity<?> getInvoiceWithStatusActive() {
        List<Invoice> invoices = invoiceRepository.getInvoiceWithStatusActive();
        if (invoices.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("Succes", invoices));
    }

    @Override
    public ResponseEntity<?> saveInvoice(Invoice invoice) {
        if (invoice.getInvoiceCode().equals("") || invoice.getInvoiceCode()== null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Ten Hang K Duoc De Trong"));
        }
        invoice.setStatus(Status.active);
        invoiceRepository.save(invoice);
        return ResponseEntity.ok(Map.of("Succes", "Them Thanh Cong"));
    }

    @Override
    public ResponseEntity<?> deleteInvoice(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow();
        if (invoice == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        invoice.setStatus(Status.delete);
        invoiceRepository.save(invoice);
        return ResponseEntity.ok(Map.of("Succes", "Xoa Thanh Cong"));
    }

    @Override
    public ResponseEntity<?> updateInvoice(Long id, Invoice invoice) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElseThrow();
        if (invoice == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Khong Tim Thay"));
        }
        existingInvoice.setInvoiceCode(invoice.getInvoiceCode());
        invoiceRepository.save(existingInvoice);
        return ResponseEntity.ok(Map.of("Succes","Sua Thanh Cong"));
    }
}
