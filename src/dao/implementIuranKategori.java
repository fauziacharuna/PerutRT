/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import object.iuran_kategori;

/**
 *
 * @author Setyawati
 */
public interface implementIuranKategori {
     public void insert(iuran_kategori b);
    
    public iuran_kategori get(int iuran_Kategori_id);

    public void update(iuran_kategori b);

    public void delete(int iuran_Kategori_id);

    public List<iuran_kategori> getAll();

    public List<iuran_kategori> getCari(String iuran_Kategori_Nama);
    
    public int getCount();
}
