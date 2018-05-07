/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package object;

/**
 *
 * @author Setyawati
 */
public class iuran_user {
    private Integer iuran_User_id, iuran_id, user_id, iuran_User_Status;

    public iuran_user() {
    }

    public iuran_user(int user_id, int iuran_id, int iuran_User_Status) {
        this.user_id = user_id;
        this.iuran_id = iuran_id;
        this.iuran_User_Status = iuran_User_Status;
    }

    public iuran_user(int iuran_User_id, int user_id, int IuranId, int iuran_User_Status) {
        this.iuran_User_id = iuran_User_id;
        this.user_id = user_id;
        this.iuran_id = iuran_id;
        this.iuran_User_Status = iuran_User_Status;
    }
    
    
    public Integer getIuran_User_id() {
        return iuran_User_id;
    }

    public void setIuran_User_id(Integer iuran_User_id) {
        this.iuran_User_id = iuran_User_id;
    }

    public Integer getIuran_id() {
        return iuran_id;
    }

    public void setIuran_id(Integer iuran_id) {
        this.iuran_id = iuran_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getIuran_User_Status() {
        return iuran_User_Status;
    }

    public void setIuran_User_Status(Integer iuran_User_Status) {
        this.iuran_User_Status = iuran_User_Status;
    }
            
}
