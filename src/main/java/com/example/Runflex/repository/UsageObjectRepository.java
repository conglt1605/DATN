/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.entity.UsageObject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface UsageObjectRepository extends JpaRepository<UsageObject, Long>{
    @Query(value = "SELECT * FROM usageobject WHERE status = 1", nativeQuery = true)
    List<UsageObject> getUsageObjectsWithStatusActive(); 
}
