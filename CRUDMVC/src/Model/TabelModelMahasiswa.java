package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kumil
 */
public class TabelModelMahasiswa extends AbstractTableModel{
    
    public TabelModelMahasiswa(List<Mahasiswa> lstMhs)
    {
        this.lstMhs = lstMhs;
    }
    @Override
    public int getRowCount() {
        return this.lstMhs.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "NIM";
            case 2:
                return "Nama";
            case 3:
                return "Jenis Kelamin";
            case 4:
                return "Alamat";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lstMhs.get(rowIndex).getId();
            case 1:
                return lstMhs.get(rowIndex).getNim();
            case 2:
                return lstMhs.get(rowIndex).getNama();
            case 3:
                return lstMhs.get(rowIndex).getJk();
            case 4:
                return lstMhs.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }
   List<Mahasiswa> lstMhs;
}
