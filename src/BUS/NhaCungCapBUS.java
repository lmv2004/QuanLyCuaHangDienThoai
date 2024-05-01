/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.NhaCungCapDTO;
import DAO.NhaCungCapDAO;
import java.awt.AWTEventMulticaster;
import java.util.ArrayList;
/**
 *
 * @author ACER
 */
public class NhaCungCapBUS {
    NhaCungCapDAO NCCDAO = new NhaCungCapDAO();
    public ArrayList<NhaCungCapDTO> getAllNhaCungCap() {
        return NCCDAO.selecAll();
    }
    public NhaCungCapDTO getByID(int ID) {
        return NCCDAO.selectById(ID);
    }
    
    
    public ArrayList<NhaCungCapDTO> filterByName(String name) {
        ArrayList<NhaCungCapDTO> l = new ArrayList<>();
        for(NhaCungCapDTO x : getAllNhaCungCap()) {
            if(x.getTenNCC().equals(name)) {
                l.add(x);
            }
        }
        return l;
    }
}
