/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.MauSac;
import com.example.RunFlex.repository.MauSacRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    public MauSac add(MauSac mauSac) {
        mauSac.setTrangThai(1);
        return mauSacRepository.save(mauSac);
    }

    public MauSac update(long id, MauSac mauSac) {
        MauSac mausacUpdate = mauSacRepository.findById(id).orElseThrow();

        mausacUpdate.setTenMauSac(mauSac.getTenMauSac());
        return mauSacRepository.save(mausacUpdate);
    }

    public void delete(long id) {
        MauSac mausacUpdate = mauSacRepository.findById(id).orElseThrow();
        mausacUpdate.setTrangThai(0);
        mauSacRepository.save(mausacUpdate);
    }
}
