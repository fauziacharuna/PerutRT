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
    
    public transaksi get(int transaksi_id);

    public void update(transaksi b);

    public void delete(int transaksi_id);

    public List<transaksi> getAll();

    public List<transaksi> getCari(String user_id);
    
    public user getUser(transaksi b);
    
    public iuran getIuran(transaksi b);
    
    public pengeluaran getPengeluaran(transaksi b);
    
    public int getJumlahKas();
    
    public int getJumlahIuran();
    
    public int getJumlahPengeluaran();
    
    public int getJumlahTransaksi();
    
    public int getUtang(int user_id, int iuran_id);
    
    public int getTotalBayar(int user_id, int iuran_id);
    
    public int getTotalDibayar(int user_id, int iuran_id);
    
    public transaksi getTransaksiPertama(String user_id, String iuran_id);
    
    public int getCount();
}
