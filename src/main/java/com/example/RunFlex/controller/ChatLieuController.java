/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.controller;

import com.example.RunFlex.model.ChatLieu;
import com.example.RunFlex.model.MauSac;
import com.example.RunFlex.service.ChatLieuService;
import com.example.RunFlex.service.MauSacService;
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
@RequestMapping("/chatlieu")
public class ChatLieuController {

    @Autowired
    private ChatLieuService chatLieuService;

    @GetMapping()
    public List<ChatLieu> getAll() {
        return chatLieuService.getAll();
    }

    @PostMapping()
    public ChatLieu add(@RequestBody ChatLieu chatLieu) {
        return chatLieuService.add(chatLieu);
    }

    @PutMapping("/{id}")
    public ChatLieu update(@RequestBody ChatLieu chatLieu, @PathVariable Long id) {
        return chatLieuService.update(id, chatLieu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chatLieuService.delete(id);
    }
}
