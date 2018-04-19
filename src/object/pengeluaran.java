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
import java.util.Date;
public class pengeluaran {
    private int pengeluaran_id, pengeluaran_Kategori, pengeluaran_Jenis_id;
    private Double pengeluaran_Nominal;
    private String pengeluaran_Nama;
    private String pengeluaran_Tanggal;

    public int getPengeluaran_id() {
        return pengeluaran_id;
    }

    public void setPengeluaran_id(int pengeluaran_id) {
        this.pengeluaran_id = pengeluaran_id;
    }

    public int getPengeluaran_Kategori() {
        return pengeluaran_Kategori;
    }

    public void setPengeluaran_Kategori(int pengeluaran_Kategori) {
        this.pengeluaran_Kategori = pengeluaran_Kategori;
    }

    public int getPengeluaran_Jenis_id() {
        return pengeluaran_Jenis_id;
    }

    public void setPengeluaran_Jenis_id(int pengeluaran_Jenis_id) {
        this.pengeluaran_Jenis_id = pengeluaran_Jenis_id;
    }

    public Double getPengeluaran_Nominal() {
        return pengeluaran_Nominal;
    }

    public void setPengeluaran_Nominal(Double pengeluaran_Nominal) {
        this.pengeluaran_Nominal = pengeluaran_Nominal;
    }

    public String getPengeluaran_Nama() {
        return pengeluaran_Nama;
    }

    public void setPengeluaran_Nama(String pengeluaran_Nama) {
        this.pengeluaran_Nama = pengeluaran_Nama;
    }

    public String getPengeluaran_Tanggal() {
        return pengeluaran_Tanggal;
    }

    public void setPengeluaran_Tanggal(String pengeluaran_Tanggal) {
        this.pengeluaran_Tanggal = pengeluaran_Tanggal;
    }
}
