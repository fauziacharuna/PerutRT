/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import object.pengeluaran_kategori;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public interface implementPengeluaranKategori {
    public void insert(pengeluaran_kategori b);
    
    public pengeluaran_kategori get(Integer pengeluaran_Kategori_id);

    public void update(pengeluaran_kategori b);

    public void delete(Integer pengeluaran_Kategori_id);

    public List<pengeluaran_kategori> getAll();

    public List<pengeluaran_kategori> getCari(String pengeluaran_Kategori_Nama);
    
    public Integer getCount();
}
