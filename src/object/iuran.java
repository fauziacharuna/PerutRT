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

public class iuran {


    public iuran(int iuran_id, int iuran_Kategori_id, int iuran_Jenis_id, Double iuran_Nominal, String iuran_Tanggal, String iuran_Nama) {
        this.iuran_id = iuran_id;
        this.iuran_Nama = iuran_Nama;
       
        this.iuran_Jenis_id = iuran_Jenis_id;
        this.iuran_Kategori_id = iuran_Kategori_id;
        this.iuran_Tanggal = iuran_Tanggal;
        this.iuran_Nominal = iuran_Nominal;
     
       
    }

    public iuran(int iuran_id, int iuran_Kategori_id, int iuran_Jenis_id, Double iuran_Nominal, Double iuran_Total, String iuran_Tanggal, String iuran_Nama) {
        this.iuran_id = iuran_id;
        this.iuran_Kategori_id = iuran_Kategori_id;
        this.iuran_Jenis_id = iuran_Jenis_id;
        this.iuran_Nominal = iuran_Nominal;
        this.iuran_Total = iuran_Total;
        this.iuran_Tanggal = iuran_Tanggal;
        this.iuran_Nama = iuran_Nama;
    }
    private int iuran_id, iuran_Kategori_id, iuran_Jenis_id;
    private Double iuran_Nominal, iuran_Total;
    private String iuran_Tanggal;
    private String iuran_Nama;
    
    public iuran() {
        
    }

//    public iuran(Integer iuran_id, Integer iuran_Kategori_id, Integer iuran_Jenis_id, Double iuran_Nominal, String iuran_Tanggal, String iuran_Nama) {
//        this.iuran_id = iuran_id;
//        this.iuran_Kategori_id = iuran_Kategori_id;
//        this.iuran_Jenis_id = iuran_Jenis_id;
//        this.iuran_Nominal = iuran_Nominal;
//        this.iuran_Tanggal = iuran_Tanggal;
//        this.iuran_Nama = iuran_Nama;
//    }
    public iuran(String iuran_Nama,int iuran_id, int iuran_Jenis_id, String iuran_Tanggal ){
        this.iuran_id=iuran_id;
        this.iuran_Jenis_id=iuran_Jenis_id;
        this.iuran_Nama=iuran_Nama;
        this.iuran_Tanggal=iuran_Tanggal;
         this.iuran_Nama=iuran_Nama;
        this.iuran_Nominal=iuran_Nominal;
        
    }

   

//    public iuran(int iuran_id, int iuran_Jenis_id, int iuran_Kategori_id, String iuran_Nama, String iuran_Tanggal, double iuran_Nominal, double iuran_Total) {
//        this.iuran_id = iuran_id;
//        this.iuran_Jenis_id = iuran_Jenis_id;
//        this.iuran_Kategori_id = iuran_Kategori_id;
//        this.iuran_Nama = iuran_Nama;
//        this.iuran_Tanggal = iuran_Tanggal;
//        this.iuran_Nominal = iuran_Nominal;
//        this.iuran_Total = iuran_Total;
//    }

//    public iuran(int iuran_Jenis_id, int iuran_Kategori_id, String iuran_Nama, String iuran_Tanggal, double iuran_Nominal, double iuran_Total) {
//        this.iuran_Jenis_id = iuran_Jenis_id;
//        this.iuran_Kategori_id = iuran_Kategori_id;
//        this.iuran_Nama = iuran_Nama;
//        this.iuran_Tanggal = iuran_Tanggal;
//        this.iuran_Nominal = iuran_Nominal;
//        this.iuran_Total = iuran_Total;
//    }

    


 

   
    
    public Integer getIuran_id() {
        return iuran_id;
    }

    public void setIuran_id(Integer iuran_id) {
        this.iuran_id = iuran_id;
    }

    public Integer getIuran_Kategori_id() {
        return iuran_Kategori_id;
    }

    public void setIuran_Kategori_id(Integer iuran_Kategori_id) {
        this.iuran_Kategori_id = iuran_Kategori_id;
    }

    public Integer getIuran_Jenis_id() {
        return iuran_Jenis_id;
    }

    public void setIuran_Jenis_id(Integer iuran_Jenis_id) {
        this.iuran_Jenis_id = iuran_Jenis_id;
    }

    public Double getIuran_Nominal() {
        return iuran_Nominal;
    }

    public void setIuran_Nominal(Double iuran_Nominal) {
        this.iuran_Nominal = iuran_Nominal;
    }

    public Double getIuran_Total() {
        return iuran_Total;
    }

    public void setIuran_Total(Double iuran_Total) {
        this.iuran_Total = iuran_Total;
    }

    public String getIuran_Tanggal() {
        return iuran_Tanggal;
    }

    public void setIuran_Tanggal(String iuran_Tanggal) {
        this.iuran_Tanggal = iuran_Tanggal;
    }

    public String getIuran_Nama() {
        return iuran_Nama;
    }

    public void setIuran_Nama(String iuran_Nama) {
        this.iuran_Nama = iuran_Nama;
    }
}