/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.pengeluaran_perubahan;
import dao.implementPengeluaran;
import dao.implementPengeluaranPerubahan;
import factory.DAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class PengeluaranPerubahanModel implements implementPengeluaranPerubahan{

    RESTDAOFactory restFactory;
    implementPengeluaranPerubahan dAOPengeluaranPerubahan;
    List<pengeluaran_perubahan> listPegeluaranPerubahan;

    public PengeluaranPerubahanModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOPengeluaranPerubahan = restFactory.getPengeluaranPerubahan();
        listPegeluaranPerubahan = dAOPengeluaranPerubahan.getAll();
    }
    @Override
    public void insert(pengeluaran_perubahan b) {
        dAOPengeluaranPerubahan.insert(b);
    }

    @Override
    public pengeluaran_perubahan get(Integer pengeluaran_Perubahan_id) {
        return dAOPengeluaranPerubahan.get(pengeluaran_Perubahan_id);
    }

    @Override
    public void update(pengeluaran_perubahan b) {
        dAOPengeluaranPerubahan.update(b);
    }

    @Override
    public void delete(Integer pengeluaran_Perubahan_id) {
        dAOPengeluaranPerubahan.delete(pengeluaran_Perubahan_id);
    }

    @Override
    public List<pengeluaran_perubahan> getAll() {
        return listPegeluaranPerubahan;
    }

    @Override
    public List<pengeluaran_perubahan> getCari(String pengeluaran_Perubahan_Nama) {
        return dAOPengeluaranPerubahan.getCari(pengeluaran_Perubahan_Nama);
    }

    @Override
    public Integer getCount() {
        return dAOPengeluaranPerubahan.getCount();
    }
    
}
