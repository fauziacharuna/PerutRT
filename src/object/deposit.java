/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author PC-14
 */
public class deposit {
    private Integer deposit_id, user_id;
    private Double deposit_Nominal;

    public deposit() {
    }
    
    public deposit(int deposit_d, int user_id, double deposit_Nominal) {
        this.deposit_id = deposit_id;
        this.user_id = user_id;
        this.deposit_Nominal = deposit_Nominal;
    }

    public deposit(int user_id, double deposit_Nominal) {
        this.user_id = user_id;
        this.deposit_Nominal = deposit_Nominal;
    }
    
    public Integer getDeposit_id() {
        return deposit_id;
    }

    public void setDeposit_id(Integer deposit_id) {
        this.deposit_id = deposit_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Double getDeposit_Nominal() {
        return deposit_Nominal;
    }

    public void setDeposit_Nominal(Double deposit_Nominal) {
        this.deposit_Nominal = deposit_Nominal;
    }
}

    