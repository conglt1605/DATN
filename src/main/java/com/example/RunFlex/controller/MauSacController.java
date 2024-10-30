/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;
import com.example.RunFlex.model.MauSac;
import com.example.RunFlex.service.MauSacService;
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
@RequestMapping("/mausac")
public class MauSacController {
  @Autowired
private MauSacService mauSacService;
@GetMapping()
public List<MauSac> getAll(){
    return mauSacService.getAll();
}
@PostMapping()
public MauSac add(@RequestBody MauSac mauSac){
    return mauSacService.add(mauSac);
}
@PutMapping("/{id}")
public MauSac update (@RequestBody MauSac mauSac, @PathVariable Long id){
    return mauSacService.update(id, mauSac);
}
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    mauSacService.delete(id);
}
}
