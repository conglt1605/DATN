/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.entity.InvoiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface InvoiceUserRepository extends JpaRepository<InvoiceUser, Long>{
    
}