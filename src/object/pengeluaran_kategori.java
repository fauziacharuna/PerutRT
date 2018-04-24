/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author PC-14
 */
public class pengeluaran_kategori {

    public int getPengeluaran_Kategori_id() {
        return pengeluaran_Kategori_id;
    }

    public void setPengeluaran_Kategori_id(int pengeluaran_Kategori_id) {
        this.pengeluaran_Kategori_id = pengeluaran_Kategori_id;
    }

    public int getPengeluaran_id() {
        return pengeluaran_id;
    }

    public void setPengeluaran_id(int pengeluaran_id) {
        this.pengeluaran_id = pengeluaran_id;
    }

    public String getPengeluaran_Kategori_Nama() {
        return pengeluaran_Kategori_Nama;
    }

    public void setPengeluaran_Kategori_Nama(String pengeluaran_Kategori_Nama) {
        this.pengeluaran_Kategori_Nama = pengeluaran_Kategori_Nama;
    }
    private int pengeluaran_Kategori_id, pengeluaran_id;
    private String pengeluaran_Kategori_Nama;
    
}
