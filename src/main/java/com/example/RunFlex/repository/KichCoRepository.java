/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.KichCo;
import com.example.RunFlex.model.MauSac;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface KichCoRepository extends JpaRepository<KichCo, Long>{
    @Query(value = "select * from KichCo where trangthai=1",nativeQuery = true)
    List<KichCo> getAll();
}