
package DAO;

import DTO.ChiTietSanPhamDTO;
import DTO.PhienBanSanPhamDTO;
import DTO.SanPhamDTO;
import java.sql.*;
import java.util.ArrayList;
public class PhienBanSanPhamDAO implements DAO_Interface<PhienBanSanPhamDTO>{

    @Override
    public int insert(PhienBanSanPhamDTO t) {
        int ketqua=0;
        try {
            Connection conn=JDBCConnection.getJDBCConnection();
            String sql="INSERT INTO phienbansanpham(maphienbansp,masp,rom,ram,mausac,gianhap,giaxuat,soluongton)"
                    +" VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement psm=conn.prepareStatement(sql);
            psm.setInt(1, t.getMaphienbansp());
            psm.setInt(2, t.getMasp());
            psm.setInt(3, t.getRom());
            psm.setInt(4, t.getRam());
            psm.setInt(5, t.getMausac());
            psm.setInt(6, t.getGianhap());
            psm.setInt(7, t.getGiaxuat());
            psm.setInt(8, t.getSoluongton());
            ketqua=psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public int insert(ArrayList<PhienBanSanPhamDTO> t){
        int ketqua=0;
        for(int i=0;i<t.size();i++){
            try {
                   Connection conn=JDBCConnection.getJDBCConnection();
            String sql="INSERT INTO phienbansanpham(maphienbansp,masp,rom,ram,mausac,gianhap,giaxuat,soluongton)"
                    +" VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement psm=conn.prepareStatement(sql);
            psm.setInt(1, t.get(i).getMaphienbansp());
            psm.setInt(2, t.get(i).getMasp());
            psm.setInt(3, t.get(i).getRom());
            psm.setInt(4, t.get(i).getRam());
            psm.setInt(5, t.get(i).getMausac());
            psm.setInt(6, t.get(i).getGianhap());
            psm.setInt(7, t.get(i).getGiaxuat());
            psm.setInt(8, t.get(i).getSoluongton());
            ketqua=psm.executeUpdate();
            JDBCConnection.closeConection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ketqua;
    }
    @Override
    public int update(PhienBanSanPhamDTO t) {
           int ketqua=0;
        try {
            Connection conn=JDBCConnection.getJDBCConnection();
            String sql="UPDATE phienbansanpham"
                    +" SET rom=? ,ram=? ,gianhap=? ,giaxuat=?"
                    +" WHERE maphienbansp=?";
            PreparedStatement psm=conn.prepareStatement(sql);
           
            psm.setInt(1, t.getRom());
            psm.setInt(2, t.getRam());
            psm.setInt(3, t.getMausac());
            psm.setInt(4, t.getGianhap());
            psm.setInt(5, t.getGiaxuat());
            psm.setInt(6, t.getMaphienbansp());
            ketqua=psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    public int updateSoLuongTon(int maphienban,int soluong){
        PhienBanSanPhamDTO pbsp=this.selectById(maphienban);
        int soLuongThayDoi=pbsp.getSoluongton()+soluong;
          int ketqua=0;
        try {
            Connection conn=JDBCConnection.getJDBCConnection();
            String sql="UPDATE phienbansanpham"
                    +" SET soluongton=?"
                    +" WHERE maphienbansp=? ";
            PreparedStatement psm=conn.prepareStatement(sql);
           
            psm.setInt(1, soLuongThayDoi);
            psm.setInt(2, pbsp.getMaphienbansp());
            ketqua=psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SanPhamDAO.getInstance().updateSoLuongTon(pbsp.getMasp(), soluong);
        return ketqua;
    }
    public int updateSLTonAfterThanhToan(ArrayList<SanPhamDTO> Sp){
        int ketqua=0;
        for(int i=0;i<Sp.size();i++){
             try {
            Connection conn=JDBCConnection.getJDBCConnection();
            String sql="UPDATE phienbansanpham"
                    +" SET soluongton=?"
                    +" WHERE maphienbansp=? and masp=?";
            PreparedStatement psm=conn.prepareStatement(sql);
           
            psm.setInt(1, Sp.get(i).getPBSPDTO().getSoluongton());
            psm.setInt(2, Sp.get(i).getPBSPDTO().getMaphienbansp());
            psm.setInt(3, Sp.get(i).getPBSPDTO().getMasp());
            ketqua=psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
            SanPhamDAO.getInstance().updateSoLuongTon(Sp.get(i).getMasp(), Sp.get(i).getPBSPDTO().getSoluongton());
        }
        
        return ketqua;
    }
    @Override
    public int delete(PhienBanSanPhamDTO t) {
            int ketqua=0;
        try {
            Connection conn=JDBCConnection.getJDBCConnection();
            String sql="UPDATE phienbansanpham"
                    +" SET trangthai=0"
                    +" WHERE maphienbansp=?";
            PreparedStatement psm=conn.prepareStatement(sql);
            psm.setInt(1, t.getMaphienbansp());
            ketqua=psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<PhienBanSanPhamDTO> selecAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<PhienBanSanPhamDTO> selectAll(int t){
        ArrayList<PhienBanSanPhamDTO> ketqua=new ArrayList<>();
        try {
             Connection conn=JDBCConnection.getJDBCConnection();
            String sql="SELECT * FROM phienbansanpham WHERE masp=? and trangthai=1";
            PreparedStatement psm=conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                 int maphienbansp = rs.getInt("maphienbansp");
                int masp = rs.getInt("masp");
                int ram = rs.getInt("ram");
                int mausac = rs.getInt("mausac");
                int rom = rs.getInt("rom");
                int gianhap = rs.getInt("gianhap");
                int giaxuat = rs.getInt("giaxuat");
                int soluongton = rs.getInt("soluongton");
                ketqua.add(new PhienBanSanPhamDTO(maphienbansp,masp,ram,rom,mausac,gianhap,giaxuat,soluongton));
            }
              JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public PhienBanSanPhamDTO selectById(PhienBanSanPhamDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public PhienBanSanPhamDTO selectById(int t){
        PhienBanSanPhamDTO ketqua=null;
         try {
              Connection conn=JDBCConnection.getJDBCConnection();
            String sql="SELECT * FROM phienbansanpham WHERE maphienbansp=?";
            PreparedStatement psm=conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                 int maphienbansp = rs.getInt("maphienbansp");
                int masp = rs.getInt("masp");
                int ram = rs.getInt("ram");
                int mausac = rs.getInt("mausac");
                int rom = rs.getInt("rom");
                int gianhap = rs.getInt("gianhap");
                int giaxuat = rs.getInt("giaxuat");
                int soluongton = rs.getInt("soluongton");
                ketqua=new PhienBanSanPhamDTO(maphienbansp,masp,ram,rom,mausac,gianhap,giaxuat,soluongton);
            }
              JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return ketqua;
    }
    public boolean checkImeiExist(ArrayList<ChiTietSanPhamDTO> arr){
        for(ChiTietSanPhamDTO chiTietSanPhamDTO:arr){
            try {
            Connection conn=JDBCConnection.getJDBCConnection();
            String sql="SELECT * FROM ctsanpham WHERE maimei=?";
            PreparedStatement psm=conn.prepareStatement(sql);
            psm.setString(1, chiTietSanPhamDTO.getImei());
            ResultSet rs=psm.executeQuery();
            while(rs.next()){
                return false;
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    @Override
    public ArrayList<PhienBanSanPhamDTO> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
