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
                mhs.setJK(rs.getString("jk"));
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

    @Override
    public boolean insert(Mahasiswa b) {
        boolean result = true;
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1 , b.getId());
            statement.setString(2 , b.getNim());
            statement.setString(3 , b.getNama());
            statement.setString(4 , b.getJk());
            statement.setString(5 , b.getAlamat());
            statement.execute();
        }catch(SQLException x)
        {
            System.out.println("gagal input");
            result = false;
        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("gagal inputt");
                result = false;
            }
        }
        return result;
    }
   
    @Override
    public void update(Mahasiswa b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1 , b.getNim());
            statement.setString(2 , b.getNama());
            statement.setString(3 , b.getJk());
            statement.setString(4 , b.getAlamat());
            statement.setInt(5 , b.getId());
            statement.executeUpdate();
        }catch(SQLException e)
        {
            System.out.println("gagal update");

        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException x) {
                System.out.println("gagal updatee");
            }
        }
    }
    
    @Override
    public void delete(int id) 
    {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1 , id);
            statement.executeUpdate();
        }catch(SQLException x)
        {
            System.out.println("gagal delete");

        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("gagal deletee");
            }
        }
    }
    
    @Override
    public List<Mahasiswa> getAllByName(String nama) {
        List<Mahasiswa> lstMhs = null;
        try
        {
            lstMhs = new ArrayList<Mahasiswa>();
            PreparedStatement st = con.prepareStatement(strSearch);
            st.setString(1 , "%"+nama+"%");
            ResultSet rs = st.executeQuery() ;
            while(rs.next())
            {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setId(rs.getInt("ID"));
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setJK(rs.getString("jk"));
                mhs.setAlamat(rs.getString("alamat"));
                lstMhs.add(mhs);
            }
        }
        catch(SQLException e)
        {
            System.err.println("Error");
        }
        return lstMhs;    }
    
    Connection con;
    //SQL Query
    String strRead = "select * from tblMahasiswa order by id asc;";
    String strInsert = "insert into tblMahasiswa(id, nim, nama, jk, alamat) values(?,?,?,?,?);";
    String strUpdate = "update tblMahasiswa set nim=?, nama=?, jk=?, alamat=? where id=?";
    String strDelete = "delete from tblMahasiswa where id=?"; 
    String strSearch = "select * from tblMahasiswa where nama like ?;";

}
