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
    
    public pengeluaran_kategori get(int pengeluaran_Kategori_id);

    public void update(pengeluaran_kategori b);

    public void delete(int pengeluaran_Kategori_id);

    public List<pengeluaran_kategori> getAll();

    public List<pengeluaran_kategori> getCari(String pengeluaran_Kategori_Nama);
    
    public int getCount();
}
