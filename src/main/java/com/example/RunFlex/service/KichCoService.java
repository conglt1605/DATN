/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.KichCo;
import com.example.RunFlex.repository.KichCoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class KichCoService {

    @Autowired
    private KichCoRepository kichCoRepository;

    public List<KichCo> getAll() {
        return kichCoRepository.getAll();
    }

    public KichCo add(KichCo kichCo) {
        kichCo.setTrangThai(1);
        return kichCoRepository.save(kichCo);
    }

    public KichCo update(long id, KichCo kichCo) {
        KichCo kichCoUpdate = kichCoRepository.findById(id).orElseThrow();

        kichCoUpdate.setSoKichCo(kichCo.getSoKichCo());
        return kichCoRepository.save(kichCoUpdate);
    }

    public void delete(long id) {
        KichCo kichCoUpdate = kichCoRepository.findById(id).orElseThrow();
        kichCoUpdate.setTrangThai(0);
        kichCoRepository.save(kichCoUpdate);
    }
}
