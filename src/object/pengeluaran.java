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

public class pengeluaran {
    private Integer pengeluaran_id, pengeluaran_Kategori_id, pengeluaran_Jenis_id;
    private Double pengeluaran_Nominal;
    private String pengeluaran_Nama;
    private String pengeluaran_Tanggal;

    public pengeluaran() {
    }

    public pengeluaran(int pengeluaran_Jenis_id, int pengeluaran_Kategori_id, String pengeluaran_Nama, String pengeluaran_Tanggal, double pengeluaran_Nominal) {
        this.pengeluaran_Jenis_id = pengeluaran_Jenis_id;
        this.pengeluaran_Kategori_id = pengeluaran_Kategori_id;
        this.pengeluaran_Nama = pengeluaran_Nama;
        this.pengeluaran_Tanggal = pengeluaran_Tanggal;
        this.pengeluaran_Nominal = pengeluaran_Nominal;
    }

    public pengeluaran(int pengeluaran_id, int pengeluaran_jenis_id, int pengeluaran_kategori_id, String pengeluaran_nama, String pengeluaran_keterangan, double pengeluaran_Nominal) {
        this.pengeluaran_id = pengeluaran_id;
        this.pengeluaran_Jenis_id = pengeluaran_Jenis_id;
        this.pengeluaran_Kategori_id = pengeluaran_Kategori_id;
        this.pengeluaran_Nama = pengeluaran_Nama;
        this.pengeluaran_Tanggal = pengeluaran_Tanggal;
        this.pengeluaran_Nominal = pengeluaran_Nominal;
    }
    
    public Integer getPengeluaran_id() {
        return pengeluaran_id;
    }

    public void setPengeluaran_id(Integer pengeluaran_id) {
        this.pengeluaran_id = pengeluaran_id;
    }

    public Integer getPengeluaran_Kategori_id() {
        return pengeluaran_Kategori_id;
    }

    public void setPengeluaran_Kategori_id(Integer pengeluaran_Kategori_id) {
        this.pengeluaran_Kategori_id = pengeluaran_Kategori_id;
    }

    public Integer getPengeluaran_Jenis_id() {
        return pengeluaran_Jenis_id;
    }

    public void setPengeluaran_Jenis_id(Integer pengeluaran_Jenis_id) {
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
