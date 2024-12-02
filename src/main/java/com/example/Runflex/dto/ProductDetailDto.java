/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Runflex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Cong
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDto {

    private Long id;
    private String productCode;
    private String productDetailCode;
    private String productName;
    private String brandName;
    private String categoryName;
    private String usageObjectName;
    private String materialName;
    private int sizeNumber;
    private String colorName;
    private String imageURL;
    private int quantity;
    private double price;
    private int status;
}
