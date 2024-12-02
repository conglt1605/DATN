/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.service.impl;

import com.example.Runflex.entity.Voucher;
import org.springframework.http.ResponseEntity;

public interface IVoucherService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getActiveVouchers();
    ResponseEntity<?> saveVoucher(Voucher voucher);
    ResponseEntity<?> updateVoucher(Long id, Voucher voucher);
    ResponseEntity<?> deleteVoucher(Long id);
}

