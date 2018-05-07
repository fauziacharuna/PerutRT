/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.mysql.DAOMySqlDeposit;
import dao.mysql.DAOMySqlIuran;
import dao.mysql.DAOMySqlIuranUser;
import dao.mysql.DAOMySqlIuranJenis;
import dao.mysql.DAOMySqlIuranKategori;
import dao.mysql.DAOMySqlPengeluaran;
import dao.mysql.DAOMySqlPengeluaranJenis;
import dao.mysql.DAOMySqlPengeluaranKategori;
import dao.mysql.DAOMySqlTransaksi;
import dao.mysql.DAOMySqlUser;
import dao.implementDeposit;
import dao.implementIuran;
import dao.implementIuranUser;
import dao.implementIuranJenis;
import dao.implementIuranKategori;
import dao.implementPengeluaran;
import dao.implementPengeluaranJenis;
import dao.implementPengeluaranKategori;
import dao.implementTransaksi;
import dao.implementUser;

/**
 *
 * @author Komputer 03
 */
public class MySqlDAOFactory extends DAOFactory{
    
    public implementUser getUserMySql() {
        return new DAOMySqlUser();
    }

    public implementIuran getIuranMySql() {
       return new DAOMySqlIuran();
    }

    public implementDeposit getDepositMySql() {
        return new DAOMySqlDeposit();
    }

    public implementIuranUser getIuranUserMySql() {
        return new DAOMySqlIuranUser();
    }
    
    public implementTransaksi getTransaksiMySql() {
        return new DAOMySqlTransaksi();
    }
    
    public implementPengeluaran getPengeluaranMySQL(){
        return new DAOMySqlPengeluaran();
    }
    
    public implementPengeluaranKategori getPengeluaranKategoriMySql(){
        return new DAOMySqlPengeluaranKategori();
    }
    
    public implementPengeluaranJenis getPengeluaranJenisMySql(){
        return new DAOMySqlPengeluaranJenis();
    }
    
    public implementIuranKategori getKategoriIuran(){
        return new DAOMySqlIuranKategori();
    }
    
    public implementIuranJenis getJenisIuran(){
        return new DAOMySqlIuranJenis();
    }
    

}