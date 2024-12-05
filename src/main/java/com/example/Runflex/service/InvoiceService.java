/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.service;

import com.example.Runflex.entity.Invoice;
import com.example.Runflex.entity.InvoiceDetail;
import com.example.Runflex.repository.InvoiceRepository;
import com.example.Runflex.repository.ProductDetailRepository;
import com.example.Runflex.service.impl.IInvoiceService;
import com.example.Runflex.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Cong
 */
@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ResponseEntity<?> getAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
    if (invoices == null || invoices.isEmpty()) {
        return ResponseEntity.badRequest().body(Map.of("error", "Danh sách trống"));
    }
        return ResponseEntity.ok(Map.of("Success", invoices));
    }

    @Override
    public ResponseEntity<?> getInvoicesWithStatusActive() {
        List<Invoice> invoices = invoiceRepository.getInvoicesWithStatusActive();
        if (invoices.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không có hóa đơn nào hoạt động"));
        }
        return ResponseEntity.ok(Map.of("Success", invoices));
    }

    @Override
    public ResponseEntity<?> saveInvoice(Invoice invoice) {
        if (invoice.getInvoiceCode() == null || invoice.getInvoiceCode().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Mã hóa đơn không được để trống"));
        }
        invoice.setStatus(Status.active);
        invoiceRepository.save(invoice);
        return ResponseEntity.ok(Map.of("Success", "Thêm hóa đơn thành công"));
    }

    @Override
    public ResponseEntity<?> deleteInvoice(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if (invoice == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy hóa đơn"));
        }
        invoice.setStatus(0); // Mark as deleted
        invoiceRepository.save(invoice);
        return ResponseEntity.ok(Map.of("Success", "Xóa hóa đơn thành công"));
    }

    @Override
    public ResponseEntity<?> updateInvoice(Long id, Invoice invoice) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElse(null);
        if (existingInvoice == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Không tìm thấy hóa đơn"));
        }
        existingInvoice.setInvoiceCode(invoice.getInvoiceCode());
        existingInvoice.setPaymentMethod(invoice.getPaymentMethod());
        existingInvoice.setDeliveryAddress(invoice.getDeliveryAddress());
        existingInvoice.setTotalAmount(invoice.getTotalAmount());
        existingInvoice.setDescription(invoice.getDescription());
        existingInvoice.setStatus(invoice.getStatus());
        existingInvoice.setVoucher(invoice.getVoucher());
        invoiceRepository.save(existingInvoice);
        return ResponseEntity.ok(Map.of("Success", "Cập nhật hóa đơn thành công"));
    }

    @Override
    public ResponseEntity<?> saveInvoiceWithDetails(Invoice invoice) {
                if (invoice.getInvoiceDetails() == null || invoice.getInvoiceDetails().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Danh sách chi tiết hóa đơn không được để trống"));
        }

        // Gắn hóa đơn cho từng chi tiết hóa đơn
        for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
            detail.setInvoice(invoice);
            detail.setStatus(Status.active);
            // Kiểm tra sản phẩm tồn tại
            if (productDetailRepository.findById(detail.getProductDetail().getId()).isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Sản phẩm không tồn tại"));
            }
        }

        // Lưu hóa đơn và các chi tiết hóa đơn
        invoice.setStatus(Status.active);
        invoiceRepository.save(invoice);
        return ResponseEntity.ok(Map.of("success", "Hóa đơn và chi tiết đã được lưu thành công"));
    }

}

