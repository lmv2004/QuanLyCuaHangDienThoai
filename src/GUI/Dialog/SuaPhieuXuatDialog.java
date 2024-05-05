///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package GUI.Dialog;
//
//import DTO.AccountDTO;
//import DTO.PhieuNhapDTO;
//import java.awt.Frame;
//import BUS.*;
//import DTO.ChiTietPhieuDTO;
//import DTO.SanPhamDTO;
//import DTO.SoLuongSPDTO;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author ACER
// */
//public class SuaPhieuXuatDialog extends ChiTietPhieuXuatDialog {
//
//    private PhieuNhapDTO PN;
//    CTPhieuNhapBUS CTPNBUS = new CTPhieuNhapBUS();
//    SanPhamBUS SPBUS = new SanPhamBUS();
//    PhienBanSanPhamBUS PBSPBUS = new PhienBanSanPhamBUS();
//    ArrayList<SoLuongSPDTO> listSPPNCu;
//
//    public SuaPhieuXuatDialog(Frame parent, boolean modal, AccountDTO myAcc, PhieuNhapDTO PN) {
//        super(parent, modal, myAcc);
//        this.PN = PN;
//        setForm();
//        setEvent2();
//    }
//
//    public void setForm() {
//        super.getTitleLbl().setText("Sửa phiếu nhập");
//        super.getAddBtn().setText("Sửa");
//        ArrayList<ChiTietPhieuDTO> CTPN = CTPNBUS.getAllByID(PN.getMaPhieu());
//        ArrayList<SanPhamDTO> listSP = SPBUS.getAllSanPhamAttribute();
//        for (ChiTietPhieuDTO x : CTPN) {//maphienbansp sl
//            for (SanPhamDTO y : listSP) {
//                if (PBSPBUS.getSanPham(x.getMPBSP()).getMasp() == y.getMasp() && x.getMPBSP() == y.getPBSPDTO().getMaphienbansp()) {
//                    super.listSPPN.add(new SoLuongSPDTO(y, x.getSoLuong()));
//                    break;
//                }
//            }
//        }
//        listSPPNCu = new ArrayList<>(listSPPN);
//        reloadSPPN();
//    }
//
//    public void setEvent2() {
//        removeAllListeners(super.getAddBtn());
//        super.getAddBtn().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                actionEditBtn();
//            }
//        });
//    }
//
//    private void actionEditBtn() {
//        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa?") == 0) {
//            //todo edit database
//            if (listSPPN.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Phiếu nhập rỗng");
//                return;
//            }
//            // xóa toàn bộ ct phiếu nhập cũ
//            for (SoLuongSPDTO x : listSPPNCu) {
//                if (CTPNBUS.delete(new ChiTietPhieuDTO(PN.getMaPhieu(), x.getSP().getPBSPDTO().getMaphienbansp(), 0, 0, 1)) == false) {
//                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!! xóa pn cũ");
//                    return;
//                }
//            }
//            //thêm ct phiếu nhập mới
//            for (SoLuongSPDTO x : listSPPN) {
//                if (CTPNBUS.add(new ChiTietPhieuDTO(PN.getMaPhieu(), x.getSP().getPBSPDTO().getMaphienbansp(), x.getSL(), x.getSP().getPBSPDTO().getGianhap(), 1)) == false
//                        || new PhienBanSanPhamBUS().nhapHang(x.getSP().getPBSPDTO().getMaphienbansp(), x.getSL()) == false) {
//                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!! thêm pn mới");
//                    return;
//                }
//            }
//            reloadSPPN();
//            PN.setTongTien(TongTien);
//            PNBUS.edit(PN);
//            JOptionPane.showMessageDialog(null, "Sửa thành công");
//            this.dispose();
//        }
//    }
//
//    public static void removeAllListeners(JButton button) {
//        // Lấy danh sách bộ lắng nghe sự kiện của button
//        ActionListener[] listeners = button.getActionListeners();
//
//        // Xóa tất cả các bộ lắng nghe sự kiện
//        for (ActionListener listener : listeners) {
//            button.removeActionListener(listener);
//        }
//    }
//
//}
