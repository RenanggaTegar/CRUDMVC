/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author kumil
 */
public class KoneksiDB {
    static Connection con;
    
    public static Connection getConnection()
    {
        if(con == null)
        {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_crud");
            data.setUser("root");
            data.setPassword("");
            try
            {
                con = data.getConnection();
                System.out.println("Koneksi Berhasil");
            }catch(SQLException e)
            {
                System.out.println("Koneksi Gagal");
                
            }
        }
            
        return con;
    }
}
