/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.InvoiceDetail;
import com.example.Runflex.repository.InvoiceDetailRepository;
import com.example.Runflex.service.impl.IInvoiceDetailService;
import com.example.Runflex.util.Status;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<InvoiceDetail> details = invoiceDetailRepository.findAll();
        if (details.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
        }
        return ResponseEntity.ok(Map.of("success", details));
    }

    @Override
    public ResponseEntity<?> getActiveInvoiceDetails() {
        List<InvoiceDetail> details = invoiceDetailRepository.getActiveInvoiceDetails();
        if (details.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không có dữ liệu hoạt động"));
        }
        return ResponseEntity.ok(Map.of("success", details));
    }

    @Override
    public ResponseEntity<?> saveInvoiceDetails(List<InvoiceDetail> invoiceDetails){
        for (InvoiceDetail detail : invoiceDetails) {
            if (detail.getQuantity() <= 0 || detail.getCurrentPrice() <= 0) {
                return ResponseEntity.badRequest().body(Map.of("error", "Số lượng hoặc giá không hợp lệ trong danh sách"));
            }
            detail.setTotalPrice(detail.getQuantity() * detail.getCurrentPrice());
            detail.setStatus(Status.active);
        }
        invoiceDetailRepository.saveAll(invoiceDetails); // Lưu tất cả các đối tượng vào database
        return ResponseEntity.ok(Map.of("success", "Thêm danh sách thành công"));
    }

    @Override
    public ResponseEntity<?> updateInvoiceDetail(Long id, InvoiceDetail invoiceDetail) {
        InvoiceDetail existingDetail = invoiceDetailRepository.findById(id).orElseThrow();
        existingDetail.setQuantity(invoiceDetail.getQuantity());
        existingDetail.setCurrentPrice(invoiceDetail.getCurrentPrice());
        existingDetail.setTotalPrice(invoiceDetail.getQuantity() * invoiceDetail.getCurrentPrice());
        invoiceDetailRepository.save(existingDetail);
        return ResponseEntity.ok(Map.of("success", "Cập nhật thành công"));
    }

    @Override
    public ResponseEntity<?> deleteInvoiceDetail(Long id) {
        InvoiceDetail detail = invoiceDetailRepository.findById(id).orElseThrow();
        detail.setStatus(Status.delete);
        invoiceDetailRepository.save(detail);
        return ResponseEntity.ok(Map.of("success", "Xóa thành công"));
    }
}
