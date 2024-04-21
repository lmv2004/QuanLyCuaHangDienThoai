
package BUS;

import DAO.HeDieuHanhDAO;
import DTO.thuocTinhSanPham.HeDieuHanhDTO;
import java.util.ArrayList;


public class HeDieuHanhBUS {
    private final HeDieuHanhDAO hdhDAO= HeDieuHanhDAO.getInstance();
    private ArrayList<HeDieuHanhDTO> listhdh= new ArrayList<>();

    public HeDieuHanhBUS() {
        listhdh=hdhDAO.selecAll();
    }
    public ArrayList<HeDieuHanhDTO> getAll(){
        return this.listhdh;
    }
    public HeDieuHanhDTO getIndex(int index){
        return this.listhdh.get(index);
    }
    public int getIndexByID(int mahdh){
        int i=0;
        int vitri=-1;
        while(i<this.listhdh.size() && vitri==-1){
            if(listhdh.get(i).getMahdh()==mahdh){
                vitri=i;
            }else i++;
        }
        return vitri;
    }
    public boolean add(HeDieuHanhDTO hdh){
        boolean check= hdhDAO.insert(hdh)!=0;
        if(check){
            this.listhdh.add(hdh);
        }
        return check;
    }
    public boolean delete(HeDieuHanhDTO hdh,int index){
        boolean check=hdhDAO.delete(hdh)!=0;
        if(check){
            this.listhdh.remove(index);
        }
        return check;
    }
    public boolean update(HeDieuHanhDTO hdh){
        boolean check =hdhDAO.update(hdh)!=0;
        if(check){
            this.listhdh.set(getIndexByID(hdh.getMahdh()), hdh);
        }
        return check;
    }
      public boolean checkDup(String name){
        boolean check=true;
        int i=0;
        while(i < this.listhdh.size() && check==true){
            if(this.listhdh.get(i).getTenhdh().toLowerCase().contains(name.toLowerCase())){
                check=false;
            } else i++;
        }
        return check;
    }
    public String getTenHDH(int mahdh){
        return this.listhdh.get(this.getIndexByID(mahdh)).getTenhdh();
    }
    public String[] getArrTenHDH(){
        String[] ketqua=new String[listhdh.size()];
        for(int i=0 ;i< listhdh.size();i++){
            ketqua[i]=listhdh.get(i).getTenhdh();
        }
        return ketqua;
    }
   
    
}
