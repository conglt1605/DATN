/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.DeGiay;
import com.example.RunFlex.service.DeGiayService;
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
 * @author Admin
 */
@RestController
@Controller
@RequestMapping("/degiay")
public class DeGiayController {
  @Autowired
private DeGiayService deGiayService;


@GetMapping()
public List<DeGiay> getAll(){
    return deGiayService.getAll();
}
@PostMapping()
public DeGiay add(@RequestBody DeGiay deGiay){
    return deGiayService.add(deGiay);
}
@PutMapping("/{id}")
public DeGiay update (@RequestBody DeGiay deGiay, @PathVariable Long id){
    return deGiayService.update(id, deGiay);
}
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    deGiayService.delete(id);
}
    
}
