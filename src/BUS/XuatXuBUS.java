
package BUS;

import DAO.XuatXuDAO;
import DTO.thuocTinhSanPham.XuatXuDTO;
import java.util.ArrayList;


public class XuatXuBUS {
    public final XuatXuDAO xxDAO=new XuatXuDAO();
    private ArrayList<XuatXuDTO> listXuatXu=new ArrayList<>();

    public XuatXuBUS() {
    listXuatXu=xxDAO.selecAll();
    }
     public ArrayList<XuatXuDTO> getAll(){
        return this.listXuatXu;
    }
    public XuatXuDTO getIndex(int index){
        return this.listXuatXu.get(index);
    }
    public int getIndexByID(int maxuatxu){
        int i=0;
        int vitri=-1;
        while(i<this.listXuatXu.size() && vitri==-1){
            if(this.listXuatXu.get(i).getMaxuatxu()==maxuatxu){
                vitri=i;
            }else i++;
        }
        return vitri;
    }
     public boolean add(XuatXuDTO xuatxu){
        boolean check= xxDAO.insert(xuatxu)!=0;
        if(check){
            this.listXuatXu.add(xuatxu);
        }
        return check;
    }
    public boolean delete(XuatXuDTO xuatxu,int index){
        boolean check=xxDAO.delete(xuatxu)!=0;
        if(check){
            this.listXuatXu.remove(index);
        }
        return check;
    }
    public boolean update(XuatXuDTO xuatxu){
        boolean check =xxDAO.update(xuatxu)!=0;
        if(check){
            this.listXuatXu.set(getIndexByID(xuatxu.getMaxuatxu()), xuatxu);
        }
        return check;
    }
      public boolean checkDup(String name){
        boolean check=true;
        int i=0;
        while(i < this.listXuatXu.size() && check==true){
            if(this.listXuatXu.get(i).getTenxuatxu().toLowerCase().contains(name.toLowerCase())){
                check=false;
            } else i++;
        }
        return check;
    }
    public String getTenXuatXu(int maxuatxu){
        return this.listXuatXu.get(this.getIndexByID(maxuatxu)).getTenxuatxu();
    }
    public String[] getArrTenXuatXu(){
        String[] ketqua=new String[listXuatXu.size()];
        for(int i=0 ;i< listXuatXu.size();i++){
            ketqua[i]=listXuatXu.get(i).getTenxuatxu();
        }
        return ketqua;
    }
    
}
