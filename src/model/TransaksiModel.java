/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.pengeluaran;
import object.iuran;
import object.transaksi;
import object.user;
import dao.implementTransaksi;
import factory.DAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class TransaksiModel implements implementTransaksi{
    RESTDAOFactory restFactory;
    implementTransaksi dAOTransaksi;
    List<transaksi> listTransaksi;
        
    public TransaksiModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOTransaksi = restFactory.getTransaksi();
        listTransaksi = dAOTransaksi.getAll();
    }

    @Override
    public void insert(transaksi b) {
        dAOTransaksi.insert(b);
    }

    @Override
    public transaksi get(Integer transaksi_id) {
        return dAOTransaksi.get(transaksi_id);
    }

    @Override
    public void update(transaksi b) {
        dAOTransaksi.update(b);
    }

    @Override
    public void delete(Integer transaksi_id) {
        dAOTransaksi.delete(transaksi_id);
    }

    @Override
    public List<transaksi> getAll() {
        return listTransaksi;
    }

    @Override
    public List<transaksi> getCari(String iuran_Nama) {
        return dAOTransaksi.getCari(iuran_Nama);
    }

    @Override
    public user getUser(transaksi b) {
        return dAOTransaksi.getUser(b);
    }

    @Override
    public iuran getIuran(transaksi b) {
        return dAOTransaksi.getIuran(b);
    }

    @Override
    public pengeluaran getPengeluaran(transaksi b) {
        return dAOTransaksi.getPengeluaran(b);
    }

    @Override
    public Integer getCount() {
        return dAOTransaksi.getCount();
    }

    @Override
    public Integer getJumlahKas() {
        return dAOTransaksi.getJumlahKas();
    }

    @Override
    public Integer getJumlahIuran() {
        return dAOTransaksi.getJumlahIuran();
    }

    @Override
    public Integer getJumlahPengeluaran() {
        return dAOTransaksi.getJumlahPengeluaran();
    }

    @Override
    public Integer getJumlahTransaksi() {
        return dAOTransaksi.getJumlahTransaksi();
    }

    @Override
    public transaksi getTransaksiPertama(Integer user_id, Integer iuran_id) {
        return dAOTransaksi.getTransaksiPertama(user_id, iuran_id);
    }

    @Override
    public Integer getUtang(Integer user_id, Integer iuran_id) {
        return dAOTransaksi.getUtang(user_id, iuran_id);
    }

    @Override
    public Integer getTotalBayar(Integer user_id, Integer iuran_id) {
        return dAOTransaksi.getTotalBayar(user_id, iuran_id);
    }

    @Override
    public Integer getTotalDibayar(Integer user_id, Integer iuran_id) {
        return dAOTransaksi.getTotalDibayar(user_id, iuran_id);
    }
    
}
