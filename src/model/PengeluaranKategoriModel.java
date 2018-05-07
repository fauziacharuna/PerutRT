/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.pengeluaran_kategori;
import dao.implementPengeluaranKategori;
import factory.DAOFactory;
import factory.MySqlDAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class PengeluaranKategoriModel implements implementPengeluaranKategori{

    RESTDAOFactory  restFactory;
    implementPengeluaranKategori daoPengeluaranKategori;
    List<pengeluaran_kategori> listPegeluaranKategori;

    public PengeluaranKategoriModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        daoPengeluaranKategori = restFactory.getPengeluaranKategori();
        listPegeluaranKategori = daoPengeluaranKategori.getAll();

    }
    @Override
    public void insert(pengeluaran_kategori b) {
        daoPengeluaranKategori.insert(b);
    }

    @Override
    public pengeluaran_kategori get(Integer pengeluaran_Kategori_id) {
        return daoPengeluaranKategori.get(pengeluaran_Kategori_id);
   }

    @Override
    public void update(pengeluaran_kategori b) {
        daoPengeluaranKategori.update(b);
    }

    @Override
    public void delete(Integer pengeluaran_Kategori_id) {
        daoPengeluaranKategori.delete(pengeluaran_Kategori_id);
    }

    @Override
    public List<pengeluaran_kategori> getAll() {
        return listPegeluaranKategori;
    }

    @Override
    public List<pengeluaran_kategori> getCari(String pengeluaran_Kategori_Nama) {
        return daoPengeluaranKategori.getCari(pengeluaran_Kategori_Nama);
    }

    @Override
    public Integer getCount() {
        return daoPengeluaranKategori.getCount();
    }
    
}

