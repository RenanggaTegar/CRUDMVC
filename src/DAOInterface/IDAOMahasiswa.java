/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Mahasiswa;
import java.util.List;

/**
 *
 * @author kumil
 */
public interface IDAOMahasiswa {
    //read
    public List<Mahasiswa> getAll();
    //insert
    public boolean insert(Mahasiswa b);
    //update
    public void update(Mahasiswa b);
    //delete
    public void delete(int id); 
    //search
    public List<Mahasiswa> getAllByName(String nama);
}
