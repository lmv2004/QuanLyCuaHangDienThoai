
package BUS;

import DAO.DungLuongRomDAO;
import DTO.thuocTinhSanPham.DungLuongRomDTO;
import java.util.ArrayList;


public class DungLuongRomBUS {
   private final DungLuongRomDAO dlromDAO= new DungLuongRomDAO();
   private ArrayList<DungLuongRomDTO> listdlrom=new ArrayList<>();

    public DungLuongRomBUS() {
        listdlrom=dlromDAO.selecAll();
    }
    public ArrayList<DungLuongRomDTO> getAll(){
        return this.listdlrom;
    }
    public DungLuongRomDTO getByIndex(int index){
        return this.listdlrom.get(index);
    }
    public int getIndexById(int madlrom){
        int i=0;
        int vitri=-1;
        while(i < this.listdlrom.size() && vitri == -1){
            if(listdlrom.get(i).getMadungluongrom()==madlrom){
                vitri=i;
            }else i++;
        }
        return vitri;
    }
    public boolean add(DungLuongRomDTO dlrom){
        boolean check=dlromDAO.insert(dlrom) !=0;
        if(check){
            this.listdlrom.add(dlrom);
        }
        return check;
    }
    public boolean delete(DungLuongRomDTO dlrom,int index){
        boolean check=dlromDAO.delete(dlrom) !=0;
        if(check){
           this.listdlrom.remove(index);
        }
        return check;
    }
    public boolean update(DungLuongRomDTO dlrom){
        boolean check=dlromDAO.update(dlrom)!=0;
        if(check){
            this.listdlrom.set(getIndexById(dlrom.getMadungluongrom()), dlrom);
        }
        return check;
    }
      public boolean checkDup(int dl){
        boolean check=true;
        int i=0;
        while(i < this.listdlrom.size() && check==true){
            if(this.listdlrom.get(i).getDungluongrom()==dl){
                check=false;
            } else i++;
        }
        return check;
    }
    public int getKichThuocByID(int madlrom){
        return this.listdlrom.get(this.getIndexById(madlrom)).getDungluongrom();
    }
    public String[] getArrKichThuoc(){
        String[] ketqua=new String[listdlrom.size()];
        for(int i=0 ;i< listdlrom.size();i++){
            ketqua[i]=Integer.toString(listdlrom.get(i).getDungluongrom())+"GB";
        }
        return ketqua;
    }
   
}
