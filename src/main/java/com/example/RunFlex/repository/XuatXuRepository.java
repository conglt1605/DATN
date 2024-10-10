/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.RunFlex.repository;

import com.example.RunFlex.model.XuatXu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface XuatXuRepository extends JpaRepository<XuatXu, Long> {

    @Query(value = "select * from xuatxu where trangthai=1", nativeQuery = true)
    List<XuatXu> getAll();
}
