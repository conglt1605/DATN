/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.entity.Brand;
import java.util.List;

import com.example.Runflex.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
    
    @Query(value = "SELECT * FROM BRAND WHERE STATUS = 1",nativeQuery = true)
    List<Brand> getBrandWithStatusActive();
}
    