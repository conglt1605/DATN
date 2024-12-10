/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.dto.ColorDto;
import com.example.Runflex.dto.MaterialDto;
import com.example.Runflex.dto.ProductDetailDto;
import com.example.Runflex.dto.SizeDto;
import com.example.Runflex.entity.ProductDetail;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    //Gọi màu theo sản phẩm
    @Query(value = "SELECT pd.colorID, c.colorName "
            + "FROM productdetail pd "
            + "JOIN color c ON pd.colorID = c.id "
            + "WHERE pd.productID = :productID "
            + "GROUP BY pd.colorID, c.colorName",
            nativeQuery = true)
    List<Map<String, Object>> GetColorByProductID(@Param("productID") Long productID);

    //Gọi kích cỡ theo sản phẩm
    @Query(value = "SELECT pd.sizeID, s.sizeNumber "
            + "FROM productdetail pd "
            + "JOIN size s ON pd.sizeID = s.id "
            + "WHERE pd.productID = :productID "
            + "GROUP BY pd.SizeID,s.sizeNumber",
            nativeQuery = true)
    List<Map<String, Object>> GetSizeByProductID(@Param("productID") Long productID);

    //GỌi chất liệu theo sản phẩm
    @Query(value = "SELECT pd.materialID, m.materialName "
            + "FROM productdetail pd "
            + "JOIN material m ON pd.materialID = m.id "
            + "WHERE pd.productID = :productID "
            + "GROUP BY pd.materialID,m.materialName",
            nativeQuery = true)
    List<Map<String, Object>> GetMaterialByProductID(@Param("productID") Long productID);

    //tìm giá thấp nhất và cao nhất 
    @Query(value = "SELECT ProductID, MIN(Price) AS MinPrice, MAX(Price) AS MaxPrice "
            + "FROM productdetail "
            + "WHERE ProductID = :productID "
            + "GROUP BY ProductID", 
            nativeQuery = true)
    List<Map<String, Object>> findPriceMinMax(@Param("productID") Long productID);

}
