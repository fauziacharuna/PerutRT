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

public class iuran_perubahan {
    private Integer iuran_Perubahan_id, iuran_id;
    private Double iuran_Perubahan_Nominal;
    private String iuran_Perubahan_Nama;
    private String iuran_Perubahan_Tanggal;

    public iuran_perubahan() {
    }
    
    public iuran_perubahan(int iuran_Perubahan_id, int iuran_id, double iuran_Perubahan_Nominal, String iuran_Perubahan_Nama, String iuran_Perubahan_Tanggal) {
        this.iuran_Perubahan_id = iuran_Perubahan_id;
        this.iuran_id = iuran_id;
        this.iuran_Perubahan_Nominal = iuran_Perubahan_Nominal;
        this.iuran_Perubahan_Nama = iuran_Perubahan_Nama;
        this.iuran_Perubahan_Tanggal = iuran_Perubahan_Tanggal;
    }

    public iuran_perubahan(double iuran_Perubahan_Nominal, String iuran_Perubahan_Tanggal, int iuran_id) {
        this.iuran_Perubahan_Nominal = iuran_Perubahan_Nominal;
        this.iuran_Perubahan_Tanggal = iuran_Perubahan_Tanggal;
        this.iuran_id = iuran_id;
    }
    
    public Integer getIuran_Perubahan_id() {
        return iuran_Perubahan_id;
    }

    public void setIuran_Perubahan_id(Integer iuran_Perubahan_id) {
        this.iuran_Perubahan_id = iuran_Perubahan_id;
    }

    public Integer getIuran_id() {
        return iuran_id;
    }

    public void setIuran_id(Integer iuran_id) {
        this.iuran_id = iuran_id;
    }

    public Double getIuran_Perubahan_Nominal() {
        return iuran_Perubahan_Nominal;
    }

    public void setIuran_Perubahan_Nominal(Double iuran_Perubahan_Nominal) {
        this.iuran_Perubahan_Nominal = iuran_Perubahan_Nominal;
    }

    public String getIuran_Perubahan_Nama() {
        return iuran_Perubahan_Nama;
    }

    public void setIuran_Perubahan_Nama(String iuran_Perubahan_Nama) {
        this.iuran_Perubahan_Nama = iuran_Perubahan_Nama;
    }

    public String getIuran_Perubahan_Tanggal() {
        return iuran_Perubahan_Tanggal;
    }

    public void setIuran_Perubahan_Tanggal(String iuran_Perubahan_Tanggal) {
        this.iuran_Perubahan_Tanggal = iuran_Perubahan_Tanggal;
    }

    }
