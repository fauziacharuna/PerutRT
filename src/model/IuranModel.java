/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.iuran;
import object.iuran_jenis;
import object.iuran_kategori;
import dao.implementIuran;
import factory.DAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class IuranModel implements implementIuran{

    RESTDAOFactory restlFactory;
    implementIuran dAOIuran;
    List<iuran> listIuran;
    
    public IuranModel() {
        restlFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOIuran = restlFactory.getIuran();
        listIuran = dAOIuran.getAll();
    }

    @Override
    public Integer insert(iuran b) {
        return dAOIuran.insert(b);
    }

    @Override
    public iuran get(Integer iuran_id) {
        return dAOIuran.get(iuran_id);
    }

    @Override
    public void update(iuran b) {
        dAOIuran.update(b);
    }

    @Override
    public void delete(Integer iuran_id) {
        dAOIuran.delete(iuran_id);
    }

    @Override
    public List<iuran> getAll() {
        return dAOIuran.getAll();
    }

    @Override
    public List<iuran> getCari(String iuran_Nama) {
        return dAOIuran.getCari(iuran_Nama);
    }

    @Override
    public iuran_jenis getIuranJenis(iuran b) {
        return dAOIuran.getIuranJenis(b);
    }

    @Override
    public iuran_kategori getIuranKategori(iuran b) {
        return dAOIuran.getIuranKategori(b);
    }

    @Override
    public Integer getCount() {
        return dAOIuran.getCount();
    }
    
}

