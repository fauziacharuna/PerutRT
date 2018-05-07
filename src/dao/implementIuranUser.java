/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import object.iuran;
import object.iuran_user;
import object.transaksi;
import object.user;

/**
 *
 * @author Setyawati
 */
public interface implementIuranUser {
    public void insert(iuran_user b);
    
    public iuran_user get(Integer iuran_User_id);
    
    public iuran_user getByUserAndIuran(user u, iuran i);

    public void update(iuran_user b);
 
    public void delete(Integer iuran_User_id);

    public List<iuran_user> getAll();

    public List<iuran_user> getCari(Integer user_id);
    
    public user getUser(iuran_user b);
    
    public iuran getIuran(iuran_user b);
        
    public List<iuran_user> getBelumLunas(user b);
        
    public Integer getCount();
}
