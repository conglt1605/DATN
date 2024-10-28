/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.KichCo;
import com.example.RunFlex.service.KichCoService;
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
@RequestMapping("/kichco")
public class KichCoController {

    @Autowired
    private KichCoService kichCoService;

    @GetMapping()
    public List<KichCo> getAll() {
        return kichCoService.getAll();
    }

    @PostMapping()
    public KichCo add(@RequestBody KichCo kichCo) {
        return kichCoService.add(kichCo);
    }

    @PutMapping("/{id}")
    public KichCo update(@RequestBody KichCo kichCo, @PathVariable Long id) {
        return kichCoService.update(id, kichCo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        kichCoService.delete(id);
    }
}
