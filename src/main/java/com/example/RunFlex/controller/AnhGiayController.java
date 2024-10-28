/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.AnhGiay;
import com.example.RunFlex.service.AnhGiayService;
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
@RequestMapping("/anhgiay")
public class AnhGiayController {
        @Autowired
    private AnhGiayService anhGiayService;

    @GetMapping()
    public List<AnhGiay> getAll() {
        return anhGiayService.getAll();
    }

    @PostMapping()
    public AnhGiay add(@RequestBody AnhGiay anhGiay) {
        return anhGiayService.add(anhGiay);
    }

    @PutMapping("/{id}")
    public AnhGiay update(@RequestBody AnhGiay anhGiay, @PathVariable Long id) {
        return anhGiayService.update(id, anhGiay);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        anhGiayService.delete(id);
    }
}
