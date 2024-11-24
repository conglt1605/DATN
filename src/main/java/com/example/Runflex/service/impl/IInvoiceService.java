/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Invoice;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ADMIN
 */
public interface IInvoiceService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getInvoiceWithStatusActive();
    ResponseEntity<?> saveInvoice(Invoice invoice);
    ResponseEntity<?> updateInvoice(Long id,Invoice invoice);
    ResponseEntity<?> deleteInvoice(Long id);
    
}
