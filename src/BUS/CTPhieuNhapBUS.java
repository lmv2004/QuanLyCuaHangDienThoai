/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTPhieuNhapDAO;
import DTO.ChiTietPhieuDTO;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class CTPhieuNhapBUS {
    DAO.CTPhieuNhapDAO CTPNDAO = new CTPhieuNhapDAO();
    
    public ArrayList<DTO.ChiTietPhieuDTO> getAllByID(int ID) {
        return CTPNDAO.selecAllByID(ID);
    }
    
    public boolean add(ChiTietPhieuDTO CT) {
        if(CTPNDAO.insert(CT)!=0) return true;
        return false;
    }
    
    public boolean edit(ChiTietPhieuDTO CT) {
        if(CTPNDAO.update(CT)>0) {
            return true;
        }
        return false;
    }
    
    public boolean delete(ChiTietPhieuDTO CT) {
        if(CTPNDAO.delete(CT)>0) {
            return true;
        }
        return false;
    }
}
