/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.DeGiay;
import com.example.RunFlex.repository.DeGiayRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DeGiayService {

    @Autowired
    private DeGiayRepository deGiayRepository;

    public List<DeGiay> getAll() {
        return deGiayRepository.getAll();
    }

    public DeGiay add(DeGiay deGiay) {
        deGiay.setTrangThai(1);
        return deGiayRepository.save(deGiay);
    }

    public DeGiay update(long id, DeGiay deGiay) {
        DeGiay deGiayUpdate = deGiayRepository.findById(id).orElseThrow();

        deGiayUpdate.setTenDeGiay(deGiay.getTenDeGiay());
        return deGiayRepository.save(deGiayUpdate);
    }

    public void delete(long id) {
        DeGiay deGiayUpdate = deGiayRepository.findById(id).orElseThrow();
        deGiayUpdate.setTrangThai(0);
        deGiayRepository.save(deGiayUpdate);
    }
}
