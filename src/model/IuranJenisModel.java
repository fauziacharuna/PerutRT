/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.iuran_jenis;
import dao.implementIuranJenis;
import dao.implementIuranKategori;
import factory.DAOFactory;
import factory.MySqlDAOFactory;
import factory.RESTDAOFactory;
import java.util.List;

/**
 *
 * @author Setyawati
 */
public class IuranJenisModel implements implementIuranJenis{
    RESTDAOFactory restFactory;
    implementIuranJenis dAOIuranJenis;
    List<iuran_jenis> listIuranJenis;
    
    public IuranJenisModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOIuranJenis = restFactory.getIuranJenis();
        listIuranJenis = dAOIuranJenis.getAll();
    }
    @Override
    public void insert(iuran_jenis b) {
        dAOIuranJenis.insert(b);
    }

    @Override
    public iuran_jenis get(Integer iuran_Jenis_id) {
        return dAOIuranJenis.get(iuran_Jenis_id);
    }

    @Override
    public void update(iuran_jenis b) {
        dAOIuranJenis.update(b);
    }

    @Override
    public void delete(Integer iuran_Jenis_id) {
        dAOIuranJenis.delete(iuran_Jenis_id);
    }

    @Override
    public List<iuran_jenis> getAll() {
        return listIuranJenis;
    }

    @Override
    public List<iuran_jenis> getCari(String iuran_Jenis_Nama) {
        return dAOIuranJenis.getCari(iuran_Jenis_Nama);
    }

    @Override
    public Integer getCount() {
        return dAOIuranJenis.getCount();
    }
    
}

