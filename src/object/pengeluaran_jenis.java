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
public class pengeluaran_jenis {
    private Integer pengeluaran_Jenis_id, pengeluaran_id;
    private String pengeluaran_Jenis_Nama;
    private String pengeluaran_Nama;

    public pengeluaran_jenis() {
    }

    public pengeluaran_jenis(int pengeluaran_Jenis_id, int pengeluaran_id, String pengeluaran_Nama) {
        this.pengeluaran_Jenis_id = pengeluaran_Jenis_id;
        this.pengeluaran_Nama = pengeluaran_Nama;
        this.pengeluaran_id = pengeluaran_id;
    }

    public pengeluaran_jenis(String pengeluaran_nama) {
        this.pengeluaran_Nama = pengeluaran_Nama;
    }
    
    public Integer getPengeluaran_Jenis_id() {
        return pengeluaran_Jenis_id;
    }

    public void setPengeluaran_Jenis_id(Integer pengeluaran_Jenis_id) {
        this.pengeluaran_Jenis_id = pengeluaran_Jenis_id;
    }

    public Integer getPengeluaran_id() {
        return pengeluaran_id;
    }

    public void setPengeluaran_id(Integer pengeluaran_id) {
        this.pengeluaran_id = pengeluaran_id;
    }

    public String getPengeluaran_Jenis_Nama() {
        return pengeluaran_Jenis_Nama;
    }

    public void setPengeluaran_Jenis_Nama(String pengeluaran_Jenis_Nama) {
        this.pengeluaran_Jenis_Nama = pengeluaran_Jenis_Nama;
    }

    }
