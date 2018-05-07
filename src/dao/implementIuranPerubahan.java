/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import java.util.List;
import object.iuran_perubahan;
/**
 *
 * @author Setyawati
 */
public interface implementIuranPerubahan {
    public void insert(iuran_perubahan b);
    
    public iuran_perubahan get(Integer iuran_Perubahan_id);

    public void update(iuran_perubahan b);

    public void delete(Integer iuran_Perubahan_id);

    public List<iuran_perubahan> getAll();

    public List<iuran_perubahan> getCari(String iuran_Perubahan_Nama);
    
    public Integer getCount();
}
