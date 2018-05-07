/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import java.util.List;
import object.iuran_jenis;
/**
 *
 * @author Setyawati
 */

public interface implementIuranJenis {
    public void insert(iuran_jenis b);
    
    public iuran_jenis get(Integer iuran_Jenis_id);

    public void update(iuran_jenis b);

    public void delete(Integer iuran_Jenis_id);

    public List<iuran_jenis> getAll();

    public List<iuran_jenis> getCari(String iuran_Jenis_Nama);
    
    public Integer getCount();
}
