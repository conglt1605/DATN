/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Invoice;
import com.example.Runflex.entity.InvoiceUser;
import org.springframework.http.ResponseEntity;

/**
 * Interface for Invoice Service
 */
public interface IInvoiceService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getInvoicesWithStatusActive();
    ResponseEntity<?> saveInvoice(Invoice invoice);
    ResponseEntity<?> updateInvoice(Long id, Invoice invoice);
    ResponseEntity<?> deleteInvoice(Long id);
    ResponseEntity<?> saveInvoiceWithDetails(Invoice invoice);
    ResponseEntity<?> getInvoiceWithUserId(Long userId);
    ResponseEntity<?> getInvoiceWithDetail(Long invoiceId);
    ResponseEntity<?> cancelOrder(Long id);
}

