/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.XuatXu;
import com.example.RunFlex.repository.XuatXuRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class XuatXuService {

    @Autowired
    private XuatXuRepository xuatXuRepository;

    public List<XuatXu> getAll() {
        return xuatXuRepository.getAll();
    }

    public XuatXu add(XuatXu xuatXu) {
        xuatXu.setTrangThai(1);
        return xuatXuRepository.save(xuatXu);
    }

    public XuatXu update(long id, XuatXu xuatXu) {
        XuatXu xuatXuUpdate = xuatXuRepository.findById(id).orElseThrow();

        xuatXuUpdate.setTenXuatXu(xuatXu.getTenXuatXu());
        return xuatXuRepository.save(xuatXuUpdate);
    }

    public void delete(long id) {
        XuatXu xuatXuUpdate = xuatXuRepository.findById(id).orElseThrow();
        xuatXuUpdate.setTrangThai(0);
        xuatXuRepository.save(xuatXuUpdate);
    }
}
