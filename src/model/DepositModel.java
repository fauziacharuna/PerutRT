/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import object.deposit;
import object.user;
import dao.implementDeposit;
import factory.DAOFactory;
import factory.MySqlDAOFactory;
import factory.RESTDAOFactory;
import java.util.List;
/**
 *
 * @author Setyawati
 */
public class DepositModel implements implementDeposit{

    RESTDAOFactory mysqlFactory;
    implementDeposit dAODeposit;
    List<deposit> listDeposit;

    public DepositModel() {
        mysqlFactory = (RESTDAOFactory) DAOFactory.getFactory(DAOFactory.REST);
        dAODeposit = mysqlFactory.getDeposit();
        listDeposit = dAODeposit.getAll();

    }
    
    @Override
    public void insert(deposit b) {
        dAODeposit.insert(b);
    }

    @Override
    public deposit get(Integer deposit_id) {
        return dAODeposit.get(deposit_id);
    }

    @Override
    public deposit getByUser(user b) {
        return dAODeposit.getByUser(b);
    }

    @Override
    public void update(deposit b) {
        dAODeposit.update(b);
    }

    @Override
    public void delete(Integer deposit_id) {
        dAODeposit.delete(deposit_id);
    }

    @Override
    public List<deposit> getAll() {
        return listDeposit;
    }

    @Override
    public List<deposit> getCari(Integer user_id) {
       return dAODeposit.getCari(user_id);
    }

    @Override
    public user getUser(deposit b) {
        return dAODeposit.getUser(b);
    }

    @Override
    public Integer getCount() {
        return dAODeposit.getCount();
    }
    
}