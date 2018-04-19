/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import object.pengeluaran;
import java.util.List;

/**
 *
 * @author Setyawati
 */
public interface implementPengeluaran {
    public void insert(pengeluaran b);
    
    public pengeluaran get(int pengeluaran_id);

    public void update(pengeluaran b);

    public void delete(int pengeluaran_id);

    public List<pengeluaran> getAll();

    public List<pengeluaran> getCari(String pengeluaran_Nama);
    
    public int getCount();
}
