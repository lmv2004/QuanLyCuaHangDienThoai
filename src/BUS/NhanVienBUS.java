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
}
