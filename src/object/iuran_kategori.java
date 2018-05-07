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
public class iuran_kategori {
    private Integer iuran_Kategori_id , iuran_id;
    private String iuran_Kategori_Nama;

    public iuran_kategori() {
    }

    public iuran_kategori(Integer valueOf, String valueOf0, Integer valueOf1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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

   public String getIuran_Kategori_Nama() {
        return iuran_Kategori_Nama;
    }

    public void setIuran_Kategori_Nama(String iuran_Kategori_Nama) {
        this.iuran_Kategori_Nama = iuran_Kategori_Nama;
    }

    
}
