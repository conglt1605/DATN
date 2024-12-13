/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Runflex.repository;

import com.example.Runflex.entity.Invoice;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cong
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "SELECT * FROM invoice WHERE status = 1", nativeQuery = true)
    List<Invoice> getInvoicesWithStatusActive();

    @Query(value = "select i.ID, i.InvoiceCode, i.TotalAmount, i.CreatedDate, i.`Status`,PaymentMethod, PhoneNumber,DeliveryAddress, ConsigneeName, i.Description "
            + "from invoice i "
            + "join invoiceuser iuser on i.ID = iuser.InvoiceID "
            + "where iuser.UserID = :userId",
            nativeQuery = true)
    List<Map<Object, String>> getInvoiceWithUserId(@Param("userId") Long userId);

    @Query(value = "select ProductDetailID,d.Quantity, CurrentPrice, TotalPrice, ProductDetailCode, pd.ImageURL, s.SizeNumber, c.ColorName, m.MaterialName, p.ProductName "
            + "from invoicedetail d "
            + "join productdetail pd on d.ProductDetailID=pd.ID "
            + "join size s on pd.SizeID=s.ID "
            + "join color c on pd.ColorID=c.ID "
            + "join material m on pd.MaterialID=m.ID "
            + "join product p on pd.ProductID=p.ID "
            + "where d.InvoiceID= :invoiceId",
            nativeQuery = true)
    List<Map<Object, String>> getInvoiceWithDetail(@Param("invoiceId") Long invoiceId);
}
