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
public class ProductFilterDto {

    private long id;
    private String productCode;
    private String productName;
    private String categoryName;
    private String usageObjectName;
    private String brandName;
    private String imageURL;
    private String imageURL2;
    private int status;
}
