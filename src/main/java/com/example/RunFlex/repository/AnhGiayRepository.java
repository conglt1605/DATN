/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.AnhGiay;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface AnhGiayRepository extends JpaRepository<AnhGiay, Long>{
        @Query(value = "select ag.* from AnhGiay ag join ChiTietSanPham ctsp on ag.ID_ChiTietSanPham=ctsp.id where ag.trangthai=1", nativeQuery = true)
    List<AnhGiay> getAll();
}
