/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Cong
 */
@Entity
@Table(name = "productdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productDetailCode;
    private String productDetailName;
    private String imageURL;
    private double price;
    private int quantity;
    private String description;
    private int status;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "SizeID")
    private Size size;
    @ManyToOne
    @JoinColumn(name = "ColorID")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "MaterialID")
    private Material material;
}
