/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author User
 */

import DTO.KhachHangDTO;
import DAO.KhachHangDAO;
import java.util.ArrayList;

public class KhachHangBUS {
    
    private ArrayList<KhachHangDTO> DanhSachKH = new ArrayList<>();
    private final KhachHangDAO KHDao = new KhachHangDAO();
    
    public static KhachHangBUS getInstance() {
        return new KhachHangBUS();
    }
    
    public KhachHangBUS() {
        DanhSachKH = KHDao.selecAll();
    }
    
    public ArrayList<KhachHangDTO> getAllKhachHang() {
        return DanhSachKH;
    }
    
    public KhachHangDTO getByIndex(int index) {
        return this.DanhSachKH.get(index);
    }
    
    public String getNameByID(int ID) {
        for(KhachHangDTO x : DanhSachKH) {
            if(x.getMaKhachHang()==ID) {
                return x.getTenKhachHang();
            }
        }
        return null;
    }
    public KhachHangDTO getBySDT(String sdt){
        return KHDao.SelectBySDT(sdt);
    }
    public int getByID(int maKH) {
        int vitri = -1;
        for (int i = 0; i < DanhSachKH.size(); i++) {
            if (DanhSachKH.get(i).getMaKhachHang() == maKH) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public boolean add(KhachHangDTO khachhang) {
        if (KHDao.insert(khachhang) != 0) {
            DanhSachKH.add(khachhang);
            return true;
        }
        return false;
    }
    
    public boolean delete(KhachHangDTO khachhang) {
        if (KHDao.delete(khachhang) != 0) {
            DanhSachKH.remove(khachhang);
            return true;
        }
        return false;
    }
    
    public boolean edit(KhachHangDTO khachhang) {
        if (KHDao.update(khachhang) != 0) {
            for (int i = 0; i < DanhSachKH.size(); i++) {
                if (DanhSachKH.get(i).getMaKhachHang() == khachhang.getMaKhachHang()) {
                    DanhSachKH.set(i, khachhang);
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<KhachHangDTO> search(String type, String txt) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả":
                for (KhachHangDTO i : DanhSachKH) {
                    if (Integer.toString(i.getMaKhachHang()).contains(txt) || i.getTenKhachHang().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;

            case "Mã khách hàng":
                for (KhachHangDTO i : DanhSachKH) {
                    if (Integer.toString(i.getMaKhachHang()).contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            case "Tên khách hàng":
                for (KhachHangDTO i : DanhSachKH) {
                    if (i.getTenKhachHang().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
}
