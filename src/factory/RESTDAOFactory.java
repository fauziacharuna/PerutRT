/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.Rest.DAORestDeposit;
import dao.Rest.DAORestIuran;
import dao.Rest.DAORestIuranUser;
import dao.Rest.DAORestIuranJenis;
import dao.Rest.DAORestIuranKategori;
import dao.Rest.DAORestPengeluaran;
import dao.Rest.DAORestPengeluaranJenis;
import dao.Rest.DAORestPengeluaranKategori;
import dao.Rest.DAORestPengeluaranPerubahan;
import dao.Rest.DAORestTransaksi;
import dao.Rest.DAORestUser;
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
