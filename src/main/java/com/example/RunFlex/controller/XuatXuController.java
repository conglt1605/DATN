/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.XuatXu;
import com.example.RunFlex.service.XuatXuService;
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
@RequestMapping("/xuatxu")
public class XuatXuController {
      @Autowired
private XuatXuService xuatXuService;


@GetMapping()
public List<XuatXu> getAll(){
    return xuatXuService.getAll();
}
@PostMapping()
public XuatXu add(@RequestBody XuatXu xuatXu){
    return xuatXuService.add(xuatXu);
}
@PutMapping("/{id}")
public XuatXu update (@RequestBody XuatXu xuatXu, @PathVariable Long id){
    return xuatXuService.update(id, xuatXu);
}
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    xuatXuService.delete(id);
}
    
}
