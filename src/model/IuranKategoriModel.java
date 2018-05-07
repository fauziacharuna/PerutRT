/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.iuran_kategori;
import dao.implementIuran;
import dao.implementIuranKategori;
import factory.DAOFactory;
import factory.MySqlDAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class IuranKategoriModel implements implementIuranKategori{

    RESTDAOFactory restFactory;
    implementIuranKategori dAOIuranKategori;
    List<iuran_kategori> listIuranKategori;
    
    public IuranKategoriModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOIuranKategori = restFactory.getIuranKategori();
        listIuranKategori = dAOIuranKategori.getAll();
    }
    
    @Override
    public void insert(iuran_kategori b) {
        dAOIuranKategori.insert(b);
    }

    @Override
    public iuran_kategori get(Integer iuran_Kategori_id) {
        return dAOIuranKategori.get(iuran_Kategori_id);
    }

    @Override
    public void update(iuran_kategori b) {
        dAOIuranKategori.update(b);
    }

    @Override
    public void delete(Integer iuran_Kategori_id) {
        dAOIuranKategori.delete(iuran_Kategori_id);
    }

    @Override
    public List<iuran_kategori> getAll() {
        return listIuranKategori;
    }

    @Override
    public List<iuran_kategori> getCari(String iuran_Kategori_Nama) {
        return dAOIuranKategori.getCari(iuran_Kategori_Nama);
    }

    @Override
    public Integer getCount() {
        return dAOIuranKategori.getCount();
    }
    
}

