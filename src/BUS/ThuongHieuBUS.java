
package BUS;

import DAO.ThuongHieuDAO;
import DTO.thuocTinhSanPham.ThuongHieuDTO;
import java.util.ArrayList;


public class ThuongHieuBUS {
       private final ThuongHieuDAO thdao=new ThuongHieuDAO();
       private ArrayList<ThuongHieuDTO> listThuongHieu=new ArrayList<>();

    public ThuongHieuBUS() {
    listThuongHieu=thdao.selecAll();
    }
    public ArrayList<ThuongHieuDTO> getAll(){
        return this.listThuongHieu;
    }
    public ThuongHieuDTO getIndex(int index){
        return this.listThuongHieu.get(index);
    }
    public int getIndexByID(int math){
        int i=0;
        int vitri=-1;
        while(i<this.listThuongHieu.size() && vitri==-1){
            if(this.listThuongHieu.get(i).getMathuonghieu()==math){
                vitri=i;
            }else i++;
        }
        return vitri;
    }
     public boolean add(ThuongHieuDTO thuonghieu){
        boolean check= thdao.insert(thuonghieu)!=0;
        if(check){
            this.listThuongHieu.add(thuonghieu);
        }
        return check;
    }
    public boolean delete(ThuongHieuDTO thuonghieu,int index){
        boolean check=thdao.delete(thuonghieu)!=0;
        if(check){
            this.listThuongHieu.remove(index);
        }
        return check;
    }
    public boolean update(ThuongHieuDTO thuonghieu){
        boolean check =thdao.update(thuonghieu)!=0;
        if(check){
            this.listThuongHieu.set(getIndexByID(thuonghieu.getMathuonghieu()), thuonghieu);
        }
        return check;
    }
      public boolean checkDup(String name){
        boolean check=true;
        int i=0;
        while(i < this.listThuongHieu.size() && check==true){
            if(this.listThuongHieu.get(i).getTenthuonghieu().toLowerCase().contains(name.toLowerCase())){
                check=false;
            } else i++;
        }
        return check;
    }
    public String getTenThuongHieu(int math){
        return this.listThuongHieu.get(this.getIndexByID(math)).getTenthuonghieu();
    }
    public String[] getArrThuongHieu(){
        String[] ketqua=new String[listThuongHieu.size()];
        for(int i=0 ;i< listThuongHieu.size();i++){
            ketqua[i]=listThuongHieu.get(i).getTenthuonghieu();
        }
        return ketqua;
    }
}
