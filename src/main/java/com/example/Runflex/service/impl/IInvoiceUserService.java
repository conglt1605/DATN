/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.InvoiceUser;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ADMIN
 */
public interface IInvoiceUserService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getInvoiceUserWithStatusActive();
    ResponseEntity<?> saveInvoiceUser(InvoiceUser invoiceUser);
    ResponseEntity<?> updateInvoiceUser(Long id,InvoiceUser invoiceUser);
    ResponseEntity<?> deleteInvoiceUser(Long id);
}
