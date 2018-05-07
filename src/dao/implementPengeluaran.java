/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import object.pengeluaran;
import java.util.List;
import object.pengeluaran_jenis;
import object.pengeluaran_kategori;

/**
 *
 * @author Setyawati
 */
public interface implementPengeluaran {
    public void insert(pengeluaran b);
    
    public pengeluaran get(Integer pengeluaran_id);
    
    public pengeluaran_jenis getPengeluaranJenis(pengeluaran b);
    
    public pengeluaran_kategori getPengeluaranKategori(pengeluaran b);

    public void update(pengeluaran b);

    public void delete(Integer pengeluaran_id);

    public List<pengeluaran> getAll();

    public List<pengeluaran> getCari(String pengeluaran_Nama);
    
    public Integer getCount();
}
