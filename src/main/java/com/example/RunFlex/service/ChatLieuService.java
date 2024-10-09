
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChatLieu;
import com.example.RunFlex.model.DanhMuc;
import com.example.RunFlex.repository.ChatLieuRepository;
import com.example.RunFlex.repository.DanhMucRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    public List<ChatLieu> getAll() {
        return chatLieuRepository.getAll();
    }

    public ChatLieu add(ChatLieu chatLieu) {
        chatLieu.setTrangThai(1);
        return chatLieuRepository.save(chatLieu);
    }

    public ChatLieu update(long id, ChatLieu chatLieu) {
        ChatLieu chatLieuUpdate = chatLieuRepository.findById(id).orElseThrow();

        chatLieuUpdate.setTenChatLieu(chatLieu.getTenChatLieu());
        return chatLieuRepository.save(chatLieuUpdate);
    }

    public void delete(long id) {
        ChatLieu chatLieuUpdate = chatLieuRepository.findById(id).orElseThrow();
        chatLieuUpdate.setTrangThai(0);
        chatLieuRepository.save(chatLieuUpdate);
    }
}
