/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.Voucher;
import com.example.RunFlex.repository.VoucherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class VoucherService {
        @Autowired
    private VoucherRepository voucherRepository;

    public List<Voucher> getAll() {
        return voucherRepository.getAll();
    }

    public Voucher add(Voucher voucher) {
        voucher.setTrangThai(1);
        return voucherRepository.save(voucher);
    }

    public Voucher update(long id, Voucher voucher) {
        Voucher voucherUpdate = voucherRepository.findById(id).orElseThrow();

        voucherUpdate.setTenVoucher(voucher.getTenVoucher());
        voucherUpdate.setGiaTri(voucher.getGiaTri());
        return voucherRepository.save(voucherUpdate);
    }

    public void delete(long id) {
        Voucher voucherUpdate = voucherRepository.findById(id).orElseThrow();
        
        voucherUpdate.setTrangThai(0);
        voucherRepository.save(voucherUpdate);
    }
}
