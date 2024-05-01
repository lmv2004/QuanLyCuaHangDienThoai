/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class NhanVienBUS {

    private NhanVienDAO NVDAO = new NhanVienDAO();

    public ArrayList<NhanVienDTO> getAllNhanVien() {
        return NVDAO.selecAll();
    }

    public NhanVienDTO getByID(int ID) {
        return NVDAO.selectByID(ID);
    }

    public ArrayList<NhanVienDTO> search(int typeSearch, String text) {//"Tất cả", "Họ tên", "Giới tính", "SĐT", "Email"
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> all = getAllNhanVien();
        switch (typeSearch) {
            case 0: {
                for (NhanVienDTO x : all) {
                    if (text.toLowerCase().contains(x.toString().toLowerCase())) {
                        result.add(x);
                    }
                } break;
            }
            case 1: {
                for (NhanVienDTO x : all) {
                    if (text.toLowerCase().contains(x.getHoTen().toLowerCase())) {
                        result.add(x);
                    }
                } 
            } break;
            case 2: {
                for (NhanVienDTO x : all) {
                    if (text.toLowerCase().contains(x.getGioiTinh() == 1 ? "Nam" : "Nữ".toLowerCase())) {
                        result.add(x);
                    }
                }
            } break;
            case 3: {
                for (NhanVienDTO x : all) {
                    if (text.contains(x.getSDT())) {
                        result.add(x);
                    }
                }
            } break;
            case 4: {
                for (NhanVienDTO x : all) {
                    if (text.toLowerCase().contains(x.getEmail().toLowerCase())) {
                        result.add(x);
                    }
                }
            } break;
        }
        return result;
    }
}
