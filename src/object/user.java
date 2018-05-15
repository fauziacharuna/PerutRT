package object;

/**
 *
 * @author PC-14
 */

public class user {

    public user(String user_Username, String user_Password, String user_Nama_Lengkap, String user_KTP, String user_Alamat, String user_Tanggal_lahir, String user_Tipe_User) {
        this.user_Username = user_Username;
        this.user_Password = user_Password;
        this.user_Nama_Lengkap = user_Nama_Lengkap;
        this.user_KTP = user_KTP;
        this.user_Alamat = user_Alamat;
        this.user_Tanggal_lahir = user_Tanggal_lahir;
        this.user_Tipe_User = user_Tipe_User;
    }
    private Integer user_id, deposit_id;
    private String user_Username;
    private String user_Password;
    private String user_Nama_Lengkap;
    private String user_KTP;
    private String user_Alamat;
    private String user_Tanggal_lahir;
    private String user_Tipe_User;
    private String user_Gender;
    private String user_email;
    private String user_NoHP;
    
    public user() {
        
    }
    

    public user(int user_id, int deposit_id, String user_Username, String user_Nama_Lengkap, String user_Gender, String user_email, String user_NoHP, String user_Password, String user_Tipe_User, String user_KTP, String user_Alamat, String user_Tanggal_lahir) {
        this.user_id = user_id;
        this.deposit_id = deposit_id;
        this.user_Gender = user_Gender;
        this.user_Username = user_Username;
        this.user_Nama_Lengkap = user_Nama_Lengkap;
        this.user_Password = user_Password;
        this.user_Tipe_User = user_Tipe_User;
        this.user_KTP = user_KTP;
        this.user_Alamat = user_Alamat;
        this.user_email = user_email;
        this.user_NoHP = user_NoHP;
        this.user_Tanggal_lahir = user_Tanggal_lahir;
    }

    public user(String user_Username, String user_Nama_Lengkap, String user_Gender, String user_email, String user_NoHP, String user_Password, String user_Tipe_User, String user_KTP, String user_Alamat, String user_Tanggal_lahir) {
        this.user_Gender = user_Gender;
        this.user_Username = user_Username;
        this.user_Nama_Lengkap = user_Nama_Lengkap;
        this.user_Password = user_Password;
        this.user_Tipe_User = user_Tipe_User;
        this.user_KTP = user_KTP;
        this.user_Alamat = user_Alamat;
        this.user_email = user_email;
        this.user_NoHP = user_NoHP;
        this.user_Tanggal_lahir = user_Tanggal_lahir;
    }

   
    

   

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getDeposit_id() {
        return deposit_id;
    }

    public void setDeposit_id(Integer deposit_id) {
        this.deposit_id = deposit_id;
    }

    public String getUser_KTP() {
        return user_KTP;
    }

    public void setUser_KTP(String user_KTP) {
        this.user_KTP = user_KTP;
    }
    
    public String getUser_Username() {
        return user_Username;
    }
    
    public void setUser_Username(String user_Username) {
        this.user_Username = user_Username;
    }
    
    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public String getUser_Nama_Lengkap() {
        return user_Nama_Lengkap;
    }

    public void setUser_Nama_Lengkap(String user_Nama_Lengkap) {
        this.user_Nama_Lengkap = user_Nama_Lengkap;
    }

    public String getUser_Alamat() {
        return user_Alamat;
    }

    public void setUser_Alamat(String user_Alamat) {
        this.user_Alamat = user_Alamat;
    }

    public String getUser_Tanggal_lahir() {
        return user_Tanggal_lahir;
    }

    public void setUser_Tanggal_lahir(String user_Tanggal_lahir) {
        this.user_Tanggal_lahir = user_Tanggal_lahir;
    }

    public String getUser_Tipe_User() {
        return user_Tipe_User;
    }

    public void setUser_Tipe_User(String user_Tipe_User) {
        this.user_Tipe_User = user_Tipe_User;
    }

    public String getUser_Gender() {
        return user_Gender;
    }

    public void setUser_Gender(String user_Gender) {
        this.user_Gender = user_Gender;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_NoHP() {
        return user_NoHP;
    }

    public void setUser_NoHP(String user_NoHP) {
        this.user_NoHP = user_NoHP;
    }
    
}   
