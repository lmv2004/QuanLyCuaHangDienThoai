
package BUS;

import DAO.MauSacDAO;
import DTO.thuocTinhSanPham.MauSacDTO;
import java.util.ArrayList;


public class MauSacBUS {
    private final MauSacDAO msdao= new MauSacDAO();
    private ArrayList<MauSacDTO> listMauSac=new ArrayList<>();

    public MauSacBUS() {
    listMauSac=msdao.selecAll();
    }
    public ArrayList<MauSacDTO> getAll(){
        return this.listMauSac;
    }
    public MauSacDTO getIndex(int index){
        return this.listMauSac.get(index);
    }
    public int getIndexByID(int mamau){
        int i=0;
        int vitri=-1;
        while(i<this.listMauSac.size() && vitri==-1){
            if(listMauSac.get(i).getMamau()==mamau){
                vitri=i;
            }else i++;
        }
        return vitri;
    }
    public boolean add(MauSacDTO mausac){
        boolean check=msdao.insert(mausac)!=0;
        if(check){
            listMauSac.add(mausac);
        }
        return check;
    }
    public boolean delete(MauSacDTO mausac,int index){
        boolean check=msdao.delete(mausac)!=0;
        if(check){
            listMauSac.remove(index);
        }
        return check;
    }
    public boolean update(MauSacDTO mausac){
        boolean check=msdao.update(mausac)!=0;
        if(check){
            listMauSac.set(getIndexByID(mausac.getMamau()), mausac);
        }
        return check;
    }
      public boolean checkDup(String name){
        boolean check=true;
        int i=0;
        while(i < this.listMauSac.size() && check==true){
            if(this.listMauSac.get(i).getTenmau().toLowerCase().contains(name.toLowerCase())){
                check=false;
            } else i++;
        }
        return check;
    }
       public String getTenMau(int mamau){
        return this.listMauSac.get(this.getIndexByID(mamau)).getTenmau();
    }
    public String[] getArrTenHDH(){
        String[] ketqua=new String[listMauSac.size()];
        for(int i=0 ;i< listMauSac.size();i++){
            ketqua[i]=listMauSac.get(i).getTenmau();
        }
        return ketqua;
    }
}
