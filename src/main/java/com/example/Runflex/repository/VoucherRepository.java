/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.entity.Category;
import com.example.Runflex.entity.Voucher;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    @Query(value = "SELECT * FROM voucher WHERE status = 1", nativeQuery = true)
    List<Voucher> findActiveVouchers();

    @Query(value = "SELECT * FROM voucher WHERE voucher_code = ?1", nativeQuery = true)
    Voucher findByVoucherCode(String voucherCode);
}

