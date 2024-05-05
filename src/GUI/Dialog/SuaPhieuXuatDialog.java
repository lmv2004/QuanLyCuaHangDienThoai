/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Dialog;

import DTO.AccountDTO;
import DTO.PhieuNhapDTO;
import java.awt.Frame;
import BUS.*;
import DTO.ChiTietPhieuDTO;
import DTO.PhieuXuatDTO;
import DTO.SanPhamDTO;
import DTO.SoLuongSPDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class SuaPhieuXuatDialog extends ChiTietPhieuXuatDialog {

    CTPhieuNhapBUS CTPNBUS = new CTPhieuNhapBUS();
    SanPhamBUS SPBUS = new SanPhamBUS();
    PhienBanSanPhamBUS PBSPBUS = new PhienBanSanPhamBUS();
    ArrayList<SoLuongSPDTO> listSPPXCu;
    BUS.PhieuXuatBUS PXBUS = new BUS.PhieuXuatBUS();

    public SuaPhieuXuatDialog(Frame parent, boolean modal, AccountDTO myAcc, PhieuXuatDTO PX) {
        super(parent, modal, PX);
        setForm();
        setEvent2();
    }

    public void setForm() {
        super.getTitleLbl().setText("Sửa phiếu xuất");
        AddBtn.setVisible(true);
        ArrayList<ChiTietPhieuDTO> CTPX = CTPXBUS.getAllByID(PX.getMaPhieu());
        ArrayList<SanPhamDTO> listSP = SPBUS.getAllSanPhamAttribute();
        for (ChiTietPhieuDTO x : CTPX) {//maphienbansp sl
            for (SanPhamDTO y : listSP) {
                if (PBSPBUS.getSanPham(x.getMPBSP()).getMasp() == y.getMasp() && x.getMPBSP() == y.getPBSPDTO().getMaphienbansp()) {
                    super.listSPPX.add(new SoLuongSPDTO(y, x.getSoLuong()));
                    break;
                }
            }
        }
        listSPPXCu = new ArrayList<>(listSPPX);
        reloadSPPX();
    }

    public void setEvent2() {
        removeAllListeners(AddBtn);
        AddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionEditBtn();
            }
        });
    }

    private void actionEditBtn() {
        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa?") == 0) {
            //todo edit database
            if (listSPPX.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phiếu xuất rỗng");
                return;
            }
            // xóa toàn bộ ct phiếu nhập cũ
            for (SoLuongSPDTO x : listSPPXCu) {
                if (CTPXBUS.delete(new ChiTietPhieuDTO(PX.getMaPhieu(), x.getSP().getPBSPDTO().getMaphienbansp(), 0, 0, 1)) == false) {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!! xóa px cũ");
                    return;
                }
            }
            //thêm ct phiếu xuất mới
            for (SoLuongSPDTO x : listSPPX) {
                if (CTPNBUS.add(new ChiTietPhieuDTO(PX.getMaPhieu(), x.getSP().getPBSPDTO().getMaphienbansp(), x.getSL(), x.getSP().getPBSPDTO().getGiaxuat(), 1)) == false) {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!! thêm px mới");
                    return;
                }
            }
            reloadSPPX();
            PX.setTongTien(TongTien);
            PXBUS.edit(PX);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            this.dispose();
        }
    }

    public static void removeAllListeners(JButton button) {
        // Lấy danh sách bộ lắng nghe sự kiện của button
        ActionListener[] listeners = button.getActionListeners();

        // Xóa tất cả các bộ lắng nghe sự kiện
        for (ActionListener listener : listeners) {
            button.removeActionListener(listener);
        }
    }

}
