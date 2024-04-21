
package BUS;

import DAO.DungLuongRamDAO;
import DTO.thuocTinhSanPham.DungLuongRamDTO;
import java.util.ArrayList;


public class DungLuongRamBUS {
    private final DungLuongRamDAO dlrDao=new DungLuongRamDAO();
    private ArrayList<DungLuongRamDTO> listDLR=new ArrayList<>();

    public DungLuongRamBUS() {
        listDLR = dlrDao.selecAll();
    }
    public ArrayList<DungLuongRamDTO> getAll(){
        return this.listDLR;
    }
    public DungLuongRamDTO getByIndex(int index){
        return this.listDLR.get(index);
    }
      public int getIndexById(int madlram) {
        int i = 0;
        int vitri = -1;
        while (i < this.listDLR.size() && vitri == -1) {
            if (listDLR.get(i).getMadlram()== madlram) {
                vitri = i;
            } else i++;
        }
        return vitri;
    }
     public boolean add(DungLuongRamDTO dlram){
         boolean check=dlrDao.insert(dlram) !=0;
         if(check){
             this.listDLR.add(dlram);
         }
         return check;
     }
     public boolean delete(DungLuongRamDTO dlram,int index){
         boolean check=dlrDao.delete(dlram) !=0;
         if(check){
             this.listDLR.remove(index);
         }
         return check;
     }
     public boolean update(DungLuongRamDTO dlram){
         boolean check =dlrDao.update(dlram)!=0;
         if(check){
             this.listDLR.set(getIndexById(dlram.getMadlram()), dlram);
         }
         return check;
     }
    public boolean checkDup(int dl){
        boolean check=true;
        int i=0;
        while(i < this.listDLR.size() && check==true){
            if(this.listDLR.get(i).getDungluongram()==dl){
                check=false;
            } else i++;
        }
        return check;
    }
    public int getKichThuocByID(int madlram){
        return this.listDLR.get(this.getIndexById(madlram)).getDungluongram();
    }
    public String[] getArrKichThuoc(){
        String[] ketqua=new String[listDLR.size()];
        for(int i=0 ;i< listDLR.size();i++){
            ketqua[i]=Integer.toString(listDLR.get(i).getDungluongram())+"GB";
        }
        return ketqua;
    }
   
}
