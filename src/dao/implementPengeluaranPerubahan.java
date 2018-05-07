/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import object.pengeluaran_perubahan;
/**
 *
 * @author Setyawati
 */
public interface implementPengeluaranPerubahan {
    public void insert(pengeluaran_perubahan b);
    
    public pengeluaran_perubahan get(Integer pengeluaran_Perubahan_id);

    public void update(pengeluaran_perubahan b);

    public void delete(Integer pengeluaran_Perubahan_id);

    public List<pengeluaran_perubahan> getAll();

    public List<pengeluaran_perubahan> getCari(String pengeluaran_Perubahan_Nama);
    
    public Integer getCount();
}
