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
    private int deposit_id, user_id;
    private Double deposit_jumlah;

    public int getDeposit_id() {
        return deposit_id;
    }

    public void setDeposit_id(int deposit_id) {
        this.deposit_id = deposit_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Double getDeposit_jumlah() {
        return deposit_jumlah;
    }

    public void setDeposit_jumlah(Double deposit_jumlah) {
        this.deposit_jumlah = deposit_jumlah;
    }
}
