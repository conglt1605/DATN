/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ThuocTinh;
import com.example.RunFlex.model.ThuongHieu;
import com.example.RunFlex.service.ThuocTinhService;
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
@RequestMapping("/thuoctinh")
public class ThuoctinhController {

    @Autowired
    private ThuocTinhService thuocTinhService;

    @GetMapping()
    public List<ThuocTinh> getAll() {
        return thuocTinhService.getAll();
    }

    @PostMapping()
    public ThuocTinh add(@RequestBody ThuocTinh thuocTinh) {
        return thuocTinhService.add(thuocTinh);
    }

    @PutMapping("/{id}")
    public ThuocTinh update(@RequestBody ThuocTinh thuocTinh, @PathVariable Long id) {
        return thuocTinhService.update(id, thuocTinh);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        thuocTinhService.delete(id);
    }
}
