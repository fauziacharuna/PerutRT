/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import object.pengeluaran_jenis;

/**
 *
 * @author Setyawati
 */
public interface implementPengeluaranJenis {
    public void insert(pengeluaran_jenis b);
    
    public pengeluaran_jenis get(Integer pengeluaran_Jenis_id);

    public void update(pengeluaran_jenis b);

    public void delete(Integer pengeluaran_Jenis_id);

    public List<pengeluaran_jenis> getAll();

    public List<pengeluaran_jenis> getCari(String pengeluaran_Jenis_Nama);
    
    public Integer getCount();
}
