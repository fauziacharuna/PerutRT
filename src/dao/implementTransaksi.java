/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import object.iuran;
import object.pengeluaran;
import object.transaksi;
import object.user;

/**
 *
 * @author Setyawati
 */
public interface implementTransaksi {
    public void insert(transaksi b);
    
    public transaksi get(Integer transaksi_id);

    public void update(transaksi b);

    public void delete(Integer transaksi_id);

    public List<transaksi> getAll();

    public List<transaksi> getCari(String user_id);
    
    public user getUser(transaksi b);
    
    public iuran getIuran(transaksi b);
    
    public pengeluaran getPengeluaran(transaksi b);
    
    public Integer getJumlahKas();
    
    public Integer getJumlahIuran();
    
    public Integer getJumlahPengeluaran();
    
    public Integer getJumlahTransaksi();
    
    public Integer getUtang(Integer user_id, Integer iuran_id);
    
    public Integer getTotalBayar(Integer user_id, Integer iuran_id);
    
    public Integer getTotalDibayar(Integer user_id, Integer iuran_id);
    
    public transaksi getTransaksiPertama(Integer user_id, Integer iuran_id);
    
    public Integer getCount();
}
