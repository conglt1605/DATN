/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.AnhGiay;
import com.example.RunFlex.repository.AnhGiayRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class AnhGiayService {
    @Autowired
    private AnhGiayRepository anhGiayRepository;

    public List<AnhGiay> getAll() {
        return anhGiayRepository.getAll();
    }

    public AnhGiay add(AnhGiay anhGiay) {
        anhGiay.setTrangThai(1);
        return anhGiayRepository.save(anhGiay);
    }

    public AnhGiay update(long id, AnhGiay anhGiay) {
        AnhGiay anhGiayUpdate = anhGiayRepository.findById(id).orElseThrow();
        anhGiayUpdate.setTenURL(anhGiay.getTenURL());
        return anhGiayRepository.save(anhGiayUpdate);
    }

    public void delete(long id) {
        AnhGiay anhGiayUpdate = anhGiayRepository.findById(id).orElseThrow();
        anhGiayUpdate.setTrangThai(0);
        anhGiayRepository.save(anhGiayUpdate);
    } 
}
