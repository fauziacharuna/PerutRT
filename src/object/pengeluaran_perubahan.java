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
public class pengeluaran_perubahan {
    private int pengeluaran_Perubahan_id, pengeluaran_id;
    private String pengeluaran_Perubahan_Nama;
    private Double pengeluaran_Perubahan_Nominal;
    private String pengeluaran_Perubahan_Tanggal;

    public int getPengeluaran_Perubahan_id() {
        return pengeluaran_Perubahan_id;
    }

    public void setPengeluaran_Perubahan_id(int pengeluaran_Perubahan_id) {
        this.pengeluaran_Perubahan_id = pengeluaran_Perubahan_id;
    }

    public int getPengeluaran_id() {
        return pengeluaran_id;
    }

    public void setPengeluaran_id(int pengeluaran_id) {
        this.pengeluaran_id = pengeluaran_id;
    }

    public String getPengeluaran_Perubahan_Nama() {
        return pengeluaran_Perubahan_Nama;
    }

    public void setPengeluaran_Perubahan_Nama(String pengeluaran_Perubahan_Nama) {
        this.pengeluaran_Perubahan_Nama = pengeluaran_Perubahan_Nama;
    }

    public Double getPengeluaran_Perubahan_Nominal() {
        return pengeluaran_Perubahan_Nominal;
    }

    public void setPengeluaran_Perubahan_Nominal(Double pengeluaran_Perubahan_Nominal) {
        this.pengeluaran_Perubahan_Nominal = pengeluaran_Perubahan_Nominal;
    }

    public String getPengeluaran_Perubahan_Tanggal() {
        return pengeluaran_Perubahan_Tanggal;
    }

    public void setPengeluaran_Perubahan_Tanggal(String pengeluaran_Perubahan_Tanggal) {
        this.pengeluaran_Perubahan_Tanggal = pengeluaran_Perubahan_Tanggal;
    }
}
