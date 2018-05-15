/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.pengeluaran_jenis;
import dao.implementPengeluaranJenis;
import factory.DAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class PengeluaranJenisModel implements implementPengeluaranJenis{
    RESTDAOFactory restFactory;
    implementPengeluaranJenis daoPengeluaranJenis;
    List<pengeluaran_jenis> listPegeluaranJenis;

    public PengeluaranJenisModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        daoPengeluaranJenis = restFactory.getPengeluaranJenis();
        listPegeluaranJenis = daoPengeluaranJenis.getAll();

    }
    
    
    @Override
    public void insert(pengeluaran_jenis b) {
        daoPengeluaranJenis.insert(b);
    }

    @Override
    public pengeluaran_jenis get(Integer pengeluaran_Jenis_id) {
        return daoPengeluaranJenis.get(pengeluaran_Jenis_id);
    }

    @Override
    public void update(pengeluaran_jenis b) {
        daoPengeluaranJenis.update(b);
    }

    @Override
    public void delete(Integer pengeluaran_Jenis_id) {
        daoPengeluaranJenis.delete(pengeluaran_Jenis_id);
    }

    @Override
    public List<pengeluaran_jenis> getAll() {
        return listPegeluaranJenis;
    }

    @Override
    public List<pengeluaran_jenis> getCari(String pengeluaran_Nama) {
        return getCari(pengeluaran_Nama);
    }

    @Override
    public Integer getCount() {
        return daoPengeluaranJenis.getCount();
    }
    
}
