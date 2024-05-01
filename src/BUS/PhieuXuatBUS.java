/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuatDTO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PhieuXuatBUS {
    static PhieuXuatDAO PXDAO=new PhieuXuatDAO();

    public PhieuXuatBUS() {
    }
    public ArrayList<PhieuXuatDTO> getAll(){
        return PXDAO.selecAll();
    }
    public boolean add(PhieuXuatDTO px){
        if(PXDAO.insert(px)!=0){
            return true;
        }
        return false;
    }
    
}
