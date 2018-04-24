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
public class iuran_perubahan {
    private int iuran_Perubahan_id, iuran_id;
    private Double iuran_Perubahan_Nominal;
    private String iuran_Peruahan_Nama;
    private String iuran_Perubahan_Tanggal;

    public int getIuran_Perubahan_id() {
        return iuran_Perubahan_id;
    }

    public void setIuran_Perubahan_id(int iuran_Perubahan_id) {
        this.iuran_Perubahan_id = iuran_Perubahan_id;
    }

    public int getIuran_id() {
        return iuran_id;
    }

    public void setIuran_id(int iuran_id) {
        this.iuran_id = iuran_id;
    }

    public Double getIuran_Perubahan_Nominal() {
        return iuran_Perubahan_Nominal;
    }

    public void setIuran_Perubahan_Nominal(Double iuran_Perubahan_Nominal) {
        this.iuran_Perubahan_Nominal = iuran_Perubahan_Nominal;
    }

    public String getIuran_Peruahan_Nama() {
        return iuran_Peruahan_Nama;
    }

    public void setIuran_Peruahan_Nama(String iuran_Peruahan_Nama) {
        this.iuran_Peruahan_Nama = iuran_Peruahan_Nama;
    }

    public String getIuran_Perubahan_Tanggal() {
        return iuran_Perubahan_Tanggal;
    }

    public void setIuran_Perubahan_Tanggal(String iuran_Perubahan_Tanggal) {
        this.iuran_Perubahan_Tanggal = iuran_Perubahan_Tanggal;
    }
}
