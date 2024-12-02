/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.InvoiceDetail;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IInvoiceDetailService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getActiveInvoiceDetails();
    ResponseEntity<?> saveInvoiceDetails(List<InvoiceDetail> invoiceDetail);
    ResponseEntity<?> updateInvoiceDetail(Long id, InvoiceDetail invoiceDetail);
    ResponseEntity<?> deleteInvoiceDetail(Long id);
}

