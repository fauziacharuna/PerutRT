/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import object.iuran;
import object.iuran_user;
import object.user;
import dao.implementIuranUser;
import factory.DAOFactory;
import factory.MySqlDAOFactory;
import factory.RESTDAOFactory;
import java.util.List;

/**
 *
 * @author Setyawati
 */
public class IuranUserModel implements implementIuranUser{

    RESTDAOFactory restFactory;
    implementIuranUser dAOIuranUser;
    List<iuran_user> listIuranUser;
    
    public IuranUserModel() {
        restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAOIuranUser = restFactory.getIuranUser();
        listIuranUser = dAOIuranUser.getAll();
    }
    @Override
    public void insert(iuran_user b) {
        dAOIuranUser.insert(b);
    }

    @Override
    public iuran_user get(Integer iuran_User_id) {
        return dAOIuranUser.get(iuran_User_id);
    }

    @Override
    public void update(iuran_user b) {
        dAOIuranUser.update(b);
    }

    @Override
    public void delete(Integer iuran_User_id) {
        dAOIuranUser.delete(iuran_User_id);
    }

    @Override
    public List<iuran_user> getAll() {
        return listIuranUser;
    }

    @Override
    public List<iuran_user> getCari(Integer user_id) {
        return dAOIuranUser.getCari(user_id);
    }

    @Override
    public user getUser(iuran_user b) {
        return dAOIuranUser.getUser(b);
    }

    @Override
    public iuran getIuran(iuran_user b) {
       return dAOIuranUser.getIuran(b);
    }

    @Override
    public Integer getCount() {
        return dAOIuranUser.getCount();
    }

    @Override
    public iuran_user getByUserAndIuran(user u, iuran i) {
        return dAOIuranUser.getByUserAndIuran(u, i);
    }

    @Override
    public List<iuran_user> getBelumLunas(user b) {
        return dAOIuranUser.getBelumLunas(b);
    }
    
}
