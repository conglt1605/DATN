/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.InvoiceDetail;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ADMIN
 */
public interface IInvoiceDetailService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getInvoiceDetailWithStatusActive();
    ResponseEntity<?> saveInvoiceDetail(InvoiceDetail invoiceDetail);
    ResponseEntity<?> updateInvoiceDetail(Long id,InvoiceDetail invoiceDetail);
    ResponseEntity<?> deleteInvoiceDetail(Long id);
}
