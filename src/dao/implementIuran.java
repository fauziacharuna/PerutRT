/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import object.iuran;
import object.iuran_jenis;
import object.iuran_kategori;

/**
 *
 * @author Setyawati
 */
public interface implementIuran {
    public Integer insert(iuran b);
    
    public iuran get(Integer iuran_id);

    public void update(iuran b);

    public void delete(Integer iuran_id);

    public List<iuran> getAll();

    public List<iuran> getCari(String iuran_Nama);
    
    public iuran_jenis getIuranJenis(iuran b);
    
    public iuran_kategori getIuranKategori(iuran b);
    
    public Integer getCount();
    
}

