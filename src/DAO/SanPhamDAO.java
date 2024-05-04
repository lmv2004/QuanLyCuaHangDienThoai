package DAO;

import DTO.PhienBanSanPhamDTO;
import DTO.SanPhamDTO;
import DTO.thuocTinhSanPham.DungLuongRamDTO;
import DTO.thuocTinhSanPham.DungLuongRomDTO;
import DTO.thuocTinhSanPham.HeDieuHanhDTO;
import DTO.thuocTinhSanPham.MauSacDTO;
import DTO.thuocTinhSanPham.ThuongHieuDTO;
import DTO.thuocTinhSanPham.XuatXuDTO;
import java.sql.*;
import java.util.ArrayList;

public class SanPhamDAO implements DAO_Interface<SanPhamDTO> {

    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }

    @Override
    public int insert(SanPhamDTO t) {
        int ketqua = 0;
        try {

            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "INSERT TO sanpham(tensp,hinhanh,xuatxu,chipxuly,dungluongpin,kichthuocman,hedieuhanh"
                    + ",phienbanhdh,camerasau,cameratruoc,thoigianbaohanh,thuonghieu,khuvuckho,soluongton,trangthai)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t.getTensp());
            psm.setString(2, t.getHinhanh());
            psm.setInt(3, t.getXuatxu());
            psm.setString(4, t.getChipxuly());
            psm.setInt(5, t.getDungluongpin());
            psm.setDouble(6, t.getKichthuocman());
            psm.setInt(7, t.getHedieuhanh());
            psm.setInt(8, t.getPhienbanhdh());
            psm.setString(9, t.getCamerasau());
            psm.setString(10, t.getCameratruoc());
            psm.setInt(11, t.getThoigianbaohanh());
            psm.setInt(12, t.getThuonghieu());
            psm.setInt(13, t.getKhuvuckho());
            psm.setInt(14, t.getSoluongton());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public int update(SanPhamDTO t) {
        int ketqua = 0;
        try {

            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE sanpham"
                    + " SET tensp=? ,hinhanh=? ,xuatxu=? ,chipxuly=? ,dungluongpin=? ,kichthuocman=? ,hedieuhanh=? ,phienbanhdh=? ,camerasau=? ,cameratruoc=? ,thoigianbaohanh=? ,thuonghieu=? ,khuvuckho=? ,trangthai=1"
                    + " WHERE masp=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, t.getTensp());
            psm.setString(2, t.getHinhanh());
            psm.setInt(3, t.getXuatxu());
            psm.setString(4, t.getChipxuly());
            psm.setInt(5, t.getDungluongpin());
            psm.setDouble(6, t.getKichthuocman());
            psm.setInt(7, t.getHedieuhanh());
            psm.setInt(8, t.getPhienbanhdh());
            psm.setString(9, t.getCamerasau());
            psm.setString(10, t.getCameratruoc());
            psm.setInt(11, t.getThoigianbaohanh());
            psm.setInt(12, t.getThuonghieu());
            psm.setInt(13, t.getKhuvuckho());

            psm.setInt(14, t.getMasp());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public int delete(SanPhamDTO t) {
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE sanpham"
                    + " SET trangthai=0"
                    + " WHERE masp=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t.getMasp());
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<SanPhamDTO> selecAll() {
        ArrayList<SanPhamDTO> ketqua = new ArrayList<SanPhamDTO>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM sanpham WHERE trangthai=1";
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int masp = rs.getInt("masp");
                String tensp = rs.getString("tensp");
                String hinhanh = rs.getString("hinhanh");
                int xuatxu = rs.getInt("xuatxu");
                String chipxuly = rs.getString("chipxuly");
                int dungluongpin = rs.getInt("dungluongpin");
                double kichthuocman = rs.getDouble("kichthuocman");
                int hedieuhanh = rs.getInt("hedieuhanh");
                int phienbanhdh = rs.getInt("phienbanhdh");
                String camerasau = rs.getString("camerasau");
                String cameratruoc = rs.getString("cameratruoc");
                int thoigianbaohanh = rs.getInt("thoigianbaohanh");
                int thuonghieu = rs.getInt("thuonghieu");
                int khuvuckho = rs.getInt("khuvuckho");
                int soluongton = rs.getInt("soluongton");
                ketqua.add(new SanPhamDTO(masp, tensp, hinhanh, xuatxu, chipxuly, dungluongpin, kichthuocman, hedieuhanh, phienbanhdh, camerasau, cameratruoc, thoigianbaohanh, thuonghieu, khuvuckho, soluongton));

            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public ArrayList<SanPhamDTO> getAllSanPhamFullThongTin() {
        ArrayList<SanPhamDTO> ketqua = new ArrayList<>();
        PhienBanSanPhamDTO PBSP;
        DungLuongRamDTO DLRam;
        DungLuongRomDTO DLRom;
        HeDieuHanhDTO HDH;
        MauSacDTO mausac;
        ThuongHieuDTO ThuongHieu;
        XuatXuDTO xuatxu;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
<<<<<<< HEAD
=======
            String sql = "SELECT Distinct sp.masp,sp.tensp ,sp.hinhanh ,sp.chipxuly,dlram.kichthuocram ,dlrom.kichthuocrom ,sp.dungluongpin,sp.kichthuocman,sp.camerasau,sp.cameratruoc,hdh.tenhedieuhanh ,sp.phienbanhdh,th.tenthuonghieu,xx.tenxuatxu,ms.tenmau,pbsp.giaxuat,sp.soluongton,pbsp.gianhap,pbsp.maphienbansp"
                    + " FROM sanpham sp,phienbansanpham pbsp,dungluongram dlram,dungluongrom dlrom,hedieuhanh hdh,thuonghieu th,xuatxu xx,mausac ms"
                    + " WHERE sp.hedieuhanh=hdh.mahedieuhanh && sp.thuonghieu=th.mathuonghieu && sp.masp=pbsp.masp && sp.xuatxu=xx.maxuatxu "
                    + " && pbsp.rom=dlrom.madlrom && pbsp.ram=dlram.madlram && pbsp.mausac=ms.mamau";

>>>>>>> 6d3b275bef97ae0a8c786caef9bfc73beefc69b3
            String SQL = "SELECT DISTINCT * "
                    + "FROM sanpham sp "
                    + "Right JOIN phienbansanpham pbsp ON sp.masp = pbsp.masp "
                    + "JOIN dungluongram dlram ON pbsp.ram = dlram.madlram "
                    + "JOIN dungluongrom dlrom ON pbsp.rom = dlrom.madlrom "
                    + "JOIN hedieuhanh hdh ON sp.hedieuhanh = hdh.mahedieuhanh "
                    + "JOIN thuonghieu th ON sp.thuonghieu = th.mathuonghieu "
                    + "JOIN xuatxu xx ON sp.xuatxu = xx.maxuatxu "
                    + "JOIN mausac ms ON pbsp.mausac = ms.mamau"
                    + " Where pbsp.trangthai=1";
            PreparedStatement psm = conn.prepareStatement(SQL);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                PBSP = new PhienBanSanPhamDTO(rs.getInt("maphienbansp"), rs.getInt("masp"), rs.getInt("ram"), rs.getInt("rom"), rs.getInt("mausac"), rs.getInt("gianhap"), rs.getInt("giaxuat"), rs.getInt("pbsp.soluongton"));
                DLRam = new DungLuongRamDTO(rs.getInt("madlram"), rs.getInt("kichthuocram"));
                DLRom = new DungLuongRomDTO(rs.getInt("madlrom"), rs.getInt("kichthuocrom"));
                HDH = new HeDieuHanhDTO(rs.getInt("mahedieuhanh"), rs.getString("tenhedieuhanh"));
                mausac = new MauSacDTO(rs.getInt("mamau"), rs.getString("tenmau"));
                ThuongHieu = new ThuongHieuDTO(rs.getInt("mathuonghieu"), rs.getString("tenthuonghieu"));
                xuatxu = new XuatXuDTO(rs.getInt("maxuatxu"), rs.getString("tenxuatxu"));
                SanPhamDTO sanpham = new SanPhamDTO(rs.getInt("masp"), rs.getString("tensp"),
                        rs.getString("hinhanh"), rs.getInt("xuatxu"), rs.getString("chipxuly"),
                        rs.getInt("dungluongpin"), rs.getDouble("kichthuocman"), rs.getInt("hedieuhanh"),
                        rs.getInt("phienbanhdh"), rs.getString("camerasau"), rs.getString("cameratruoc"),
                        rs.getInt("thoigianbaohanh"), rs.getInt("thuonghieu"), rs.getInt("khuvuckho"), rs.getInt("soluongton"));
                sanpham.setPBSPDTO(PBSP);
                sanpham.setDLRamDTO(DLRam);
                sanpham.setDLRomDTO(DLRom);
                sanpham.setHDHDTO(HDH);
                sanpham.setMSDTO(mausac);
                sanpham.setTHDTO(ThuongHieu);
                sanpham.setXXDTO(xuatxu);
                ketqua.add(sanpham);
            }

            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public SanPhamDTO selectById(int t) {
        SanPhamDTO ketqua = null;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM sampham WHERE masp=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, t);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int masp = rs.getInt("masp");
                String tensp = rs.getString("tensp");
                String hinhanh = rs.getString("hinhanh");
                int xuatxu = rs.getInt("xuatxu");
                String chipxuly = rs.getString("chipxuly");
                int dungluongpin = rs.getInt("dungluongpin");
                double kichthuocman = rs.getDouble("kichthuocman");
                int hedieuhanh = rs.getInt("hedieuhanh");
                int phienbanhdh = rs.getInt("phienbanhdh");
                String camerasau = rs.getString("camerasau");
                String cameratruoc = rs.getString("cameratruoc");
                int thoigianbaohanh = rs.getInt("thoigianbaohanh");
                int thuonghieu = rs.getInt("thuonghieu");
                int khuvuckho = rs.getInt("khuvuckho");
                int soluongton = rs.getInt("soluongton");
                ketqua = new SanPhamDTO(masp, tensp, hinhanh, xuatxu, chipxuly, dungluongpin, kichthuocman, hedieuhanh, phienbanhdh, camerasau, cameratruoc, thoigianbaohanh, thuonghieu, khuvuckho, soluongton);
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<SanPhamDTO> selectByCondition(String condition) {
        ArrayList<SanPhamDTO> ketqua = new ArrayList<SanPhamDTO>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "SELECT * FROM sampham WHERE " + condition;
            PreparedStatement psm = conn.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                int masp = rs.getInt("masp");
                String tensp = rs.getString("tensp");
                String hinhanh = rs.getString("hinhanh");
                int xuatxu = rs.getInt("xuatxu");
                String chipxuly = rs.getString("chipxuly");
                int dungluongpin = rs.getInt("dungluongpin");
                double kichthuocman = rs.getDouble("kichthuocman");
                int hedieuhanh = rs.getInt("hedieuhanh");
                int phienbanhdh = rs.getInt("phienbanhdh");
                String camerasau = rs.getString("camerasau");
                String cameratruoc = rs.getString("cameratruoc");
                int thoigianbaohanh = rs.getInt("thoigianbaohanh");
                int thuonghieu = rs.getInt("thuonghieu");
                int khuvuckho = rs.getInt("khuvuckho");
                int soluongton = rs.getInt("soluongton");
                ketqua.add(new SanPhamDTO(masp, tensp, hinhanh, xuatxu, chipxuly, dungluongpin, kichthuocman, hedieuhanh, phienbanhdh, camerasau, cameratruoc, thoigianbaohanh, thuonghieu, khuvuckho, soluongton));
            }
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public int updateSoLuongTon(int masp, int soluong) {
        int soLuongThayDoi = this.selectById(masp).getSoluongton();
        int ketqua = 0;
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "UPDATE sanpham SET soluongton=? WHERE masp=?";
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setInt(1, soLuongThayDoi);
            psm.setInt(2, masp);
            ketqua = psm.executeUpdate();
            JDBCConnection.closeConection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public SanPhamDTO selectById(SanPhamDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
