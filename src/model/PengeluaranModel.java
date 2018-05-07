/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.pengeluaran;
import dao.implementDeposit;
import dao.implementPengeluaran;
import factory.DAOFactory;
import factory.MySqlDAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
import object.pengeluaran_jenis;
import object.pengeluaran_kategori;
/**
 *
 * @author Setyawati
 */
public class PengeluaranModel implements implementPengeluaran {

    RESTDAOFactory restFactory;
    implementPengeluaran dAOPengeluaran;
    List<pengeluaran> listPegeluaran;

    public PengeluaranModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOPengeluaran = restFactory.getPengeluaran();
        listPegeluaran = dAOPengeluaran.getAll();

    }

    @Override
    public void insert(pengeluaran b) {
        dAOPengeluaran.insert(b);
    }

    @Override
    public pengeluaran get(Integer pengeluaran_id) {
        return dAOPengeluaran.get(pengeluaran_id);
    }

    @Override
    public void update(pengeluaran b) {
        dAOPengeluaran.update(b);
    }

    @Override
    public void delete(Integer pengeluaran_id) {
        dAOPengeluaran.delete(pengeluaran_id);
    }

    @Override
    public List<pengeluaran> getAll() {
        return dAOPengeluaran.getAll();
    }

    @Override
    public List<pengeluaran> getCari(String pengeluaran_Nama) {
        return dAOPengeluaran.getCari(pengeluaran_Nama);
    }

    @Override
    public Integer getCount() {
        return dAOPengeluaran.getCount();
    }

    @Override
    public pengeluaran_jenis getPengeluaranJenis(pengeluaran b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pengeluaran_kategori getPengeluaranKategori(pengeluaran b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

