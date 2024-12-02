/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Voucher;
import com.example.Runflex.repository.VoucherRepository;
import com.example.Runflex.service.impl.IVoucherService;
import com.example.Runflex.util.Status;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class VoucherService implements IVoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Voucher> vouchers = voucherRepository.findAll();
        if (vouchers.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách voucher trống"));
        }
        return ResponseEntity.ok(Map.of("Success", vouchers));
    }

    @Override
    public ResponseEntity<?> getActiveVouchers() {
        List<Voucher> vouchers = voucherRepository.findActiveVouchers();
        if (vouchers.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không có voucher nào đang hoạt động"));
        }
        return ResponseEntity.ok(Map.of("Success", vouchers));
    }

    @Override
    public ResponseEntity<?> saveVoucher(Voucher voucher) {
        if (voucher.getVoucherCode() == null || voucher.getVoucherCode().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Mã voucher không được để trống"));
        }
        if (voucher.getEndDate().isBefore(voucher.getStartDate())) {
            return ResponseEntity.badRequest().body(Map.of("error", "Ngày kết thúc không được trước ngày bắt đầu"));
        }
        voucher.setStatus(Status.active);
        voucherRepository.save(voucher);
        return ResponseEntity.ok(Map.of("Success", "Thêm voucher thành công"));
    }

    @Override
    public ResponseEntity<?> deleteVoucher(Long id) {
        Voucher voucher = voucherRepository.findById(id).orElse(null);
        if (voucher == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy voucher"));
        }
        voucher.setStatus(Status.delete);
        voucherRepository.save(voucher);
        return ResponseEntity.ok(Map.of("Success", "Xóa voucher thành công"));
    }

    @Override
    public ResponseEntity<?> updateVoucher(Long id, Voucher voucher) {
        Voucher existingVoucher = voucherRepository.findById(id).orElse(null);
        if (existingVoucher == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy voucher"));
        }
        existingVoucher.setVoucherName(voucher.getVoucherName());
        existingVoucher.setMaxAmount(voucher.getMaxAmount());
        existingVoucher.setUsageLimit(voucher.getUsageLimit());
        existingVoucher.setStartDate(voucher.getStartDate());
        existingVoucher.setEndDate(voucher.getEndDate());
        existingVoucher.setDiscountPercentage(voucher.getDiscountPercentage());
        existingVoucher.setStatus(voucher.getStatus());
        voucherRepository.save(existingVoucher);
        return ResponseEntity.ok(Map.of("Success", "Cập nhật voucher thành công"));
    }
}

