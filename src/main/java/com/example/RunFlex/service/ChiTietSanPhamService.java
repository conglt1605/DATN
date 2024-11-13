/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RunFlex.service;

import com.example.RunFlex.model.ChiTietSanPham;
import com.example.RunFlex.model.KichCo;
import com.example.RunFlex.model.MauSac;
import com.example.RunFlex.model.SanPham;
import com.example.RunFlex.repository.ChiTietSanPhamRepository;
import com.example.RunFlex.repository.KichCoRepository;
import com.example.RunFlex.repository.MauSacRepository;
import com.example.RunFlex.repository.SanPhamRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cong
 */
@Service
public class ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichCoRepository kichCoRepository;

    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.getAll();
    }

    public List<ChiTietSanPham> add(List<ChiTietSanPham> chiTietSanPhams) {
        List<ChiTietSanPham> savedChiTietSanPhams = new ArrayList<>();

        for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
            SanPham sanPham = sanPhamRepository.findById(chiTietSanPham.getSanPham().getId())
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));
            MauSac mauSac = mauSacRepository.findById(chiTietSanPham.getMauSac().getId())
                    .orElseThrow(() -> new RuntimeException("Màu sắc không tồn tại"));
            KichCo kichCo = kichCoRepository.findById(chiTietSanPham.getKichCo().getId())
                    .orElseThrow(() -> new RuntimeException("Kích cỡ không tồn tại"));

            chiTietSanPham.setTrangThai(1);
            chiTietSanPham.setNgayTao(LocalDateTime.now());

            // Tạo tên chi tiết sản phẩm theo định dạng yêu cầu
            chiTietSanPham.setTenChiTietSanPham(sanPham.getTenSanPham() + ", Màu " + mauSac.getTenMauSac() + ", Size " + kichCo.getSoKichCo());

            // Lưu chi tiết sản phẩm
            savedChiTietSanPhams.add(chiTietSanPhamRepository.save(chiTietSanPham));
        }

        return savedChiTietSanPhams;
    }

    public List<ChiTietSanPham> update(List<ChiTietSanPham> chiTietSanPhams) {
        for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
            ChiTietSanPham chiTietSanPhamUpdate = chiTietSanPhamRepository.findById(chiTietSanPham.getId()).orElseThrow();
            
            chiTietSanPhamUpdate.setChatLieu(chiTietSanPham.getChatLieu());
            chiTietSanPhamUpdate.setDeGiay(chiTietSanPham.getDeGiay());
            chiTietSanPhamUpdate.setGiaBan(chiTietSanPham.getGiaBan());
            chiTietSanPhamUpdate.setKichCo(chiTietSanPham.getKichCo());
            chiTietSanPhamUpdate.setMauSac(chiTietSanPham.getMauSac());
            chiTietSanPhamUpdate.setMoTa(chiTietSanPham.getMoTa());
            chiTietSanPhamUpdate.setSoLuong(chiTietSanPham.getSoLuong());
            chiTietSanPhamUpdate.setTrangThai(chiTietSanPham.getTrangThai());
            chiTietSanPhamRepository.save(chiTietSanPhamUpdate);
        }
        return chiTietSanPhams;
    }

    public void delete(long id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElseThrow();
        chiTietSanPham.setTrangThai(0);
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    public List<Object[]> getTongSLSP() {
        return chiTietSanPhamRepository.getTongSLSP();
    }

    public List<ChiTietSanPham> getCTSPByID(long id) {
        return chiTietSanPhamRepository.getCTSPByID(id);
    }

    //Lấy (giá thấp nhất) - (Giá cao nhất) trong ctsp theo id sản phẩm
    public Map<String, String> getPriceRangeBySanPhamId(Long sanPhamId) {
        List<Object[]> result = chiTietSanPhamRepository.findMinMaxPriceBySanPhamId(sanPhamId);

        Map<String, String> priceRange = new HashMap<>();
        if (result != null && !result.isEmpty()) {
            Object[] range = result.get(0);
            BigDecimal minPrice = (BigDecimal) range[0];
            BigDecimal maxPrice = (BigDecimal) range[1];

            // Nếu minPrice và maxPrice bằng nhau, chỉ trả về 1 giá duy nhất
            if (minPrice.compareTo(maxPrice) == 0) {
                priceRange.put("price", formatPrice(minPrice));  // Trả về 1 giá duy nhất
            } else {
                priceRange.put("minPrice", formatPrice(minPrice));
                priceRange.put("maxPrice", formatPrice(maxPrice));
            }
        } else {
            // Trường hợp không tìm thấy giá, trả về null cho minPrice và maxPrice
            priceRange.put("minPrice", "0");
            priceRange.put("maxPrice", "0");
        }
        return priceRange;
    }

    //Hàm loại bỏ phần thập phân nếu không có
    private String formatPrice(BigDecimal price) {
        if (price != null) {
            return price.stripTrailingZeros().toPlainString();
        }
        return "null";
    }
}
