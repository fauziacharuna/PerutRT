/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import rest.dao.DAORestDeposit;
import rest.dao.DAORestIuran;
import rest.dao.DAORestIuranUser;
import rest.dao.DAORestIuranJenis;
import rest.dao.DAORestIuranKategori;
import rest.dao.DAORestPengeluaran;
import rest.dao.DAORestPengeluaranJenis;
import rest.dao.DAORestPengeluaranKategori;
import rest.dao.DAORestPengeluaranPerubahan;
import rest.dao.DAORestTransaksi;
import rest.dao.DAORestUser;
import dao.implementDeposit;
import dao.implementIuran;
import dao.implementIuranUser;
import dao.implementIuranJenis;
import dao.implementIuranKategori;
import dao.implementIuranPerubahan;
import dao.implementPengeluaran;
import dao.implementPengeluaranJenis;
import dao.implementPengeluaranKategori;
import dao.implementPengeluaranPerubahan;
import dao.implementTransaksi;
import dao.implementUser;

/**
 *
 * @author Setyawati
 */
public class RESTDAOFactory extends DAOFactory{
    public implementUser getUser() {
        return new DAORestUser();
    }
    
    public implementIuran getIuran() {
        return new DAORestIuran();
    }
    
    public implementDeposit getDeposit() {
        return new DAORestDeposit();
    }
    
    public implementIuranUser getIuranUser() {
        return new DAORestIuranUser();
    }
    
    public implementIuranJenis getIuranJenis(){
        return new DAORestIuranJenis();
    }
    
    public implementIuranKategori getIuranKategori(){
        return new DAORestIuranKategori();
    }
    
    public implementPengeluaran getPengeluaran(){
        return new DAORestPengeluaran();
    }
    
    public implementPengeluaranJenis getPengeluaranJenis(){
        return new DAORestPengeluaranJenis();
    }
    
    public implementPengeluaranKategori getPengeluaranKategori(){
        return new DAORestPengeluaranKategori();
    }
    
    public implementPengeluaranPerubahan getPengeluaranPerubahan(){
        return new DAORestPengeluaranPerubahan();
    }
    
    public implementTransaksi getTransaksi(){
        return new DAORestTransaksi();
    }

    public implementIuranPerubahan getIuranPerubahan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
