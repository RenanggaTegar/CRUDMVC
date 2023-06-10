/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOMahasiswa;
import Helper.KoneksiDB;
import Model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author kumil
 */
public class DAOMahasiswa implements IDAOMahasiswa{
    
    public DAOMahasiswa()
    {
        con = KoneksiDB.getConnection();
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> lstMhs = null;
        try
        {
            lstMhs = new ArrayList<Mahasiswa>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setId(rs.getInt("id"));
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setJk(rs.getString("jk"));
                mhs.setAlamat(rs.getString("alamat"));
                lstMhs.add(mhs);
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error");
        }
        return lstMhs;
    }
    
    Connection con;
    //SQL Query
    String strRead = "select * from tblMahasiswa;";
    
    
}
