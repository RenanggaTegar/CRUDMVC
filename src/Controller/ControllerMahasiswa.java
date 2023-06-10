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
import javax.swing.JOptionPane;


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
    
    public void Insert()
    {
         Mahasiswa b = new Mahasiswa();
         b.setId(Integer.parseInt(frmMahasiswa.gettxtID().getText()));
         b.setNim(frmMahasiswa.gettxtNim().getText());
         b.setNama(frmMahasiswa.gettxtNama().getText());
         b.setJK(frmMahasiswa.getJkel().getSelectedItem().toString());
         b.setAlamat(frmMahasiswa.gettxtAlamat().getText());
         boolean res = iMahasiswa.insert(b);
         if(res)
             JOptionPane.showMessageDialog(null, "Input berhasil");
         else
             JOptionPane.showMessageDialog(null, "Gagal/Data Duplikat");

    }
    
    public void reset()
    {
        if(!frmMahasiswa.gettxtID().isEnabled())
            frmMahasiswa.gettxtID().setEnabled(true);
        frmMahasiswa.gettxtID().setText("");
        frmMahasiswa.gettxtNim().setText("");
        frmMahasiswa.gettxtNama().setText("");
        frmMahasiswa.getJkel().setSelectedItem("");
        frmMahasiswa.gettxtAlamat().setText("");
    }
    
    public void isiField(int row)
    {
        frmMahasiswa.gettxtID().setEnabled(false);
        frmMahasiswa.gettxtID().setText(lstMhs.get(row).getId().toString());
        frmMahasiswa.gettxtNim().setText(lstMhs.get(row).getNim());
        frmMahasiswa.gettxtNama().setText(lstMhs.get(row).getNama());
        frmMahasiswa.getJkel().setSelectedItem(lstMhs.get(row).getJk());
        frmMahasiswa.gettxtAlamat().setText(lstMhs.get(row).getAlamat());
    }
    
    public void update()
    {
         Mahasiswa b = new Mahasiswa();
         b.setNim(frmMahasiswa.gettxtNim().getText());
         b.setNama(frmMahasiswa.gettxtNama().getText());
         b.setJK((frmMahasiswa.getJkel().getSelectedItem().toString()));
         b.setAlamat((frmMahasiswa.gettxtAlamat().getText()));
         b.setId(Integer.parseInt(frmMahasiswa.gettxtID().getText()));
         iMahasiswa.update(b);
         JOptionPane.showMessageDialog(null, "Update berhasil");
    }
    
    public void delete()
    {
         iMahasiswa.delete(Integer.parseInt(frmMahasiswa.gettxtID().getText()));
         JOptionPane.showMessageDialog(null, "Delete berhasil");
    }
    
    public void cari()
    {
        lstMhs = iMahasiswa.getAllByName(frmMahasiswa.gettxtCariNama().getText());
        TabelModelMahasiswa tabelMhs = new TabelModelMahasiswa(lstMhs);
        frmMahasiswa.getTabelData().setModel(tabelMhs);
    }
     
    FormMahasiswa frmMahasiswa;
    IDAOMahasiswa iMahasiswa;
    List<Mahasiswa> lstMhs;
}
