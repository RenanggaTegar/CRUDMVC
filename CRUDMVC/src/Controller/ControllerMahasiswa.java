/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOMahasiswa;
import DAOInterface.IDAOMahasiswa;
import Model.Mahasiswa;
import Model.TabelModelMahasiswa;
import View.FormMahasiswa;
import java.util.List;


/**
 *
 * @author kumil
 */
public class ControllerMahasiswa {
    public ControllerMahasiswa(FormMahasiswa frmMahasiswa)
    {
        this.frmMahasiswa = frmMahasiswa;
        iMahasiswa = new DAOMahasiswa();
    }
    
    public void isiTable()
    {
        lstMhs = iMahasiswa.getAll();
        TabelModelMahasiswa tabelMhs = new TabelModelMahasiswa(lstMhs);
        frmMahasiswa.getTabelData().setModel(tabelMhs);
    }
    
    FormMahasiswa frmMahasiswa;
    IDAOMahasiswa iMahasiswa;
    List<Mahasiswa> lstMhs;
}
