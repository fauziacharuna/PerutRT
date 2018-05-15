/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.iuran_perubahan;
import dao.implementIuranPerubahan;
import dao.implementIuran;
import dao.implementIuranPerubahan;
import factory.DAOFactory;
import factory.RESTDAOFactory;
import java.util.List;

/**
 *
 * @author Setyawati
 */
public class IuranPerubahanModel implements implementIuranPerubahan{

    RESTDAOFactory restFactory;
    implementIuranPerubahan dAOIuranPerubahan;
    List<iuran_perubahan> listIuranPengeluaran;
    private final List<iuran_perubahan> listIuranPerubahan;

    public IuranPerubahanModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOIuranPerubahan = restFactory.getIuranPerubahan();
        listIuranPerubahan = dAOIuranPerubahan.getAll();
    }
    @Override
    public void insert(iuran_perubahan b) {
        dAOIuranPerubahan.insert(b);
    }

    @Override
    public iuran_perubahan get(Integer iuran_Perubahan_id) {
        return dAOIuranPerubahan.get(iuran_Perubahan_id);
    }

    @Override
    public void update(iuran_perubahan b) {
        dAOIuranPerubahan.update(b);
    }

    @Override
    public void delete(Integer iuran_Perubahan_id) {
        dAOIuranPerubahan.delete(iuran_Perubahan_id);
    }

    @Override
    public List<iuran_perubahan> getAll() {
        return listIuranPerubahan;
    }

    @Override
    public List<iuran_perubahan> getCari(String iuran_Perubahan_Nama) {
        return dAOIuranPerubahan.getCari(iuran_Perubahan_Nama);
    }

    @Override
    public Integer getCount() {
        return dAOIuranPerubahan.getCount();
    }
    
}
