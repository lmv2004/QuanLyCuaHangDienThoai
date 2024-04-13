/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuVucKhoDAO;
import DTO.KhuVucKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class KhuVucKhoBUS {
    private final KhuVucKhoDAO khuVucKhoDAO = new KhuVucKhoDAO();
    private ArrayList<KhuVucKhoDTO> listKhuVucKho = new ArrayList<>();

    public KhuVucKhoBUS getInstance() {
        return new KhuVucKhoBUS();
    }
    
    public KhuVucKhoBUS() {
        listKhuVucKho = khuVucKhoDAO.selecAll();
    }
    
    
    public ArrayList<KhuVucKhoDTO> getAll(){
        return listKhuVucKho;
    }
    
    public KhuVucKhoDTO getByIndex(int index) {
        return this.listKhuVucKho.get(index);
    }
    
    public int getByMaKV(int makhuvuc){
        int vitri = -1;
        int i = 0;
        while(i < this.listKhuVucKho.size() && vitri == -1){
            if (listKhuVucKho.get(i).getMaKhuVuc() == makhuvuc){
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }
    
    public boolean add( KhuVucKhoDTO khuvuckho){
        boolean check = khuVucKhoDAO.insert(khuvuckho) != 0 ;
        if (check){
            this.listKhuVucKho.add(khuvuckho);
        }
        return check;
    }
    
    public boolean delete(KhuVucKhoDTO khuvuckho , int index){
        boolean check = khuVucKhoDAO.delete(khuvuckho) != 0;
        if (check) {
            this.listKhuVucKho.remove(index);
        }
        
        return check;
    }
    
    public boolean update(KhuVucKhoDTO khuvuckho){
        boolean check = khuVucKhoDAO.update(khuvuckho) != 0;
        if(check){
            this.listKhuVucKho.set(getIndexByMaKhuVuc(khuvuckho.getMaKhuVuc()), khuvuckho);
        }
        
        return check;
    }
    
    
    
    public int getIndexByMaKhuVuc(int makvk){
        int vitri = -1;
        int i = 0;
        while (i < this.listKhuVucKho.size() && vitri == -1) {
            if (listKhuVucKho.get(i).getMaKhuVuc() == makvk) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }
    
    
    public ArrayList<KhuVucKhoDTO> search(String type, String txt){
        ArrayList<KhuVucKhoDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả":
                for(KhuVucKhoDTO i: listKhuVucKho){
                    if(Integer.toString(i.getMaKhuVuc()).contains(txt) || i.getTenKhuVuc().toLowerCase().contains(txt)){
                        result.add(i);
                    }
                }
                break;
                
            case "Mã khu vực kho":
                for(KhuVucKhoDTO i: listKhuVucKho){
                    if(Integer.toString(i.getMaKhuVuc()).contains(txt)){
                        result.add(i);
                    }
                }
                break;
            case "Tên khu vực kho":
                for(KhuVucKhoDTO i: listKhuVucKho){
                    if(i.getTenKhuVuc().toLowerCase().contains(txt)){
                        result.add(i);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        
        
        return result;
    }
    
    public String getTenKhuVuc(int makhuvuc) {
        return this.listKhuVucKho.get(this.getIndexByMaKhuVuc(makhuvuc)).getTenKhuVuc();
    }
}
