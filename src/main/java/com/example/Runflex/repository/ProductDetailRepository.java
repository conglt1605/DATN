/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.dto.ProductDetailDto;
import com.example.Runflex.entity.ProductDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    @Query(value = "SELECT * FROM productdetail WHERE status = 1", nativeQuery = true)
    List<ProductDetail> getProductDetailWithStatusActive();

    @Query("SELECT new com.example.Runflex.dto.ProductDetailDto( "
            + "pd.id, p.productCode, pd.productDetailCode, p.productName, b.brandName, ca.categoryName, "
            + "ub.usageObjectName, m.materialName, s.sizeNumber, c.colorName, pd.imageURL, pd.quantity, pd.price, pd.status) "
            + "FROM ProductDetail pd "
            + "JOIN pd.product p "
            + "JOIN pd.material m "
            + "JOIN pd.size s "
            + "JOIN pd.color c "
            + "JOIN p.brand b "
            + "JOIN p.usageObject ub "
            + "JOIN p.category ca "
            + "WHERE s.id = :sizeId AND p.id = :productId AND c.id = :colorId AND m.id = :materialId")
    ProductDetailDto getProductDetail(Long sizeId, Long productId, Long colorId, Long materialId);

//    @Query("SELECT new com.example.Runflex.dto.ProductDetailDto( "
//            + "c.colorName) "
//            + "FROM productdetail pd "
//            + "JOIN color c ON pd.colorID = c.id "
//            + "WHERE pd.productID = :productID;")
//    List<ProductDetailDto> getProductDetailByID(Long productID);

}
