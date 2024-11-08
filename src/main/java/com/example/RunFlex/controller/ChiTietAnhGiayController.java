/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;


import com.example.RunFlex.model.ChiTietAnhGiay;
import com.example.RunFlex.service.ChatLieuService;
import com.example.RunFlex.service.ChiTietAnhGiayService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cong
 */
@RestController
@RequestMapping("/chitietanhgiay")
public class ChiTietAnhGiayController {

    @Autowired
    private ChiTietAnhGiayService chiTietAnhGiayService;

    @GetMapping()
    public List<ChiTietAnhGiay> getAll() {
        return chiTietAnhGiayService.getAll();
    }

    @PostMapping()
    public ChiTietAnhGiay add(@RequestBody ChiTietAnhGiay chiTietAnhGiay) {
        return chiTietAnhGiayService.add(chiTietAnhGiay);
    }

    @PutMapping("/{id}")
    public ChiTietAnhGiay update(@RequestBody ChiTietAnhGiay chiTietAnhGiay, @PathVariable Long id) {
        return chiTietAnhGiayService.update(id, chiTietAnhGiay);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chiTietAnhGiayService.delete(id);
    }
}
