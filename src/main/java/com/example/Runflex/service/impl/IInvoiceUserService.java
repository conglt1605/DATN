/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

/**
 *
 * @author Cong
 */
import com.example.Runflex.entity.InvoiceUser;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IInvoiceUserService {
    ResponseEntity<?> getAllInvoiceUsers();
    ResponseEntity<?> getInvoiceUsersWithStatusActive();
    ResponseEntity<?> saveInvoiceUser(InvoiceUser invoiceUser);
    ResponseEntity<?> saveInvoiceUsers(List<InvoiceUser> invoiceUsers);
    ResponseEntity<?> updateInvoiceUser(Long id, InvoiceUser invoiceUser);
    ResponseEntity<?> deleteInvoiceUser(Long id);
}
