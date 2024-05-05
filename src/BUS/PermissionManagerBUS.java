/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PermissionManagerDAO;
import DTO.PermissionManagerDTO;

import java.util.ArrayList;


/**
 *
 * @author Danny
 */
public class PermissionManagerBUS {
    private final PermissionManagerDAO perDAO = new PermissionManagerDAO();
    private ArrayList<PermissionManagerDTO> listPermission = new ArrayList<>();

    public PermissionManagerBUS getInstance() {
        return new PermissionManagerBUS();
    }

    public PermissionManagerBUS() {
        listPermission = perDAO.selecAll();
    }

    public ArrayList<PermissionManagerDTO> getAll() {
        return listPermission;
    }

    public PermissionManagerDTO getByIndex(int index) {
        return this.listPermission.get(index);
    }

    public boolean add(PermissionManagerDTO per) {
        boolean check = perDAO.insert(per) != 0;
        if (check) {
            this.listPermission.add(per);
        }
        return check;
    }

    public boolean update (PermissionManagerDTO per, int index) {
        boolean check = perDAO.update(per) != 0;
        if (check) {
            this.listPermission.set(index, per);
        }
        return check;
    }
}
