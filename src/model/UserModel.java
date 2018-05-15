/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.user;
import dao.implementUser;
import factory.DAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class UserModel implements implementUser{

    RESTDAOFactory restFactory;
    implementUser dAOUser;
    List<user> listUser;

    public UserModel() {
         restFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
         dAOUser = restFactory.getUser();
         listUser = dAOUser.getAll(); 
    }
    
    @Override
    public Integer insert(user b) {
        return dAOUser.insert(b);
    }

    @Override
    public user getUser(Integer user_id) {
        return dAOUser.getUser(user_id);
    }

    @Override
    public void update(user b) {
        dAOUser.update(b);
    }

    @Override
    public void delete(Integer user_id) {
        dAOUser.delete(user_id);
    }

    @Override
    public List<user> getAll() {
        return listUser;
    }

    @Override
    public List<user> getCari(String user_Username) {
        return dAOUser.getCari(user_Username);
    }

    @Override
    public Integer getCount() {
        return dAOUser.getCount();
    }

    @Override
    public Integer  getValidLogin(String username, String password) {
        return dAOUser.getValidLogin(username, password);
    }   

  

 
}