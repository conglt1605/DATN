/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.ChatLieu;
import com.example.RunFlex.model.ChiTietAnhGiay;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ChiTietAnhGiayRepository extends JpaRepository<ChiTietAnhGiay, Long>{
        @Query(value = "select * from ChiTietAnhGiay where trangthai=1", nativeQuery = true)
    List<ChiTietAnhGiay> getAll();
}