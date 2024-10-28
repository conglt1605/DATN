/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ThuongHieu;
import com.example.RunFlex.service.ThuongHieuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/thuonghieu")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping()
    public List<ThuongHieu> getAll() {
        return thuongHieuService.getAll();
    }

    @PostMapping()
    public ThuongHieu add(@RequestBody ThuongHieu thuongHieu) {
        return thuongHieuService.add(thuongHieu);
    }

    @PutMapping("/{id}")
    public ThuongHieu update(@RequestBody ThuongHieu thuongHieu, @PathVariable Long id) {
        return thuongHieuService.update(id, thuongHieu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        thuongHieuService.delete(id);
    }
}
