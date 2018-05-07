package object;

/**
 *
 * @author PC-14
 */

public class transaksi {
    private Integer transaksi_id, pengeluaran_id, iuran_id, user_id;
    private Double transaksi_Saldo, transaksi_Nominal;
    private String transaksi_Tanggal;
    private String transaksi_tipe;
    private String transaksi_Nama, user_Username;

    public transaksi(){
    }

    public transaksi(double transaksi_Nominal, double transaksi_Saldo, int user_id, int iuran_id, int pengeluaran_id, String user_Username, String transaksi_Tanggal, String transaksi_Nama, String transaksi_tipe) {
        this.transaksi_Nominal = transaksi_Nominal;
        this.user_id = user_id;
        this.iuran_id = iuran_id;
        this.pengeluaran_id = pengeluaran_id;
        this.transaksi_Tanggal = transaksi_Tanggal;
        this.transaksi_Nama = transaksi_Nama;
        this.transaksi_Saldo = transaksi_Saldo;
        this.transaksi_tipe = transaksi_tipe;
        this.user_Username = user_Username;
    }

    public transaksi(int transaksi_id, double transaksi_Nominal, double transaksi_Saldo, int user_id, int iuran_id, int pengeluaran_id,  String transaksi_Tanggal, String transaksi_Nama, String transaksi_tipe, String user_Username) {
        this.transaksi_id = transaksi_id;
        this.transaksi_Nominal = transaksi_Nominal;
        this.transaksi_Saldo = transaksi_Saldo;
        this.user_id = user_id;
        this.iuran_id = iuran_id;
        this.pengeluaran_id = pengeluaran_id;
        this.transaksi_Tanggal = transaksi_Tanggal;
        this.transaksi_Nama = transaksi_Nama;
        this.transaksi_tipe = transaksi_tipe;
        this.user_Username = user_Username;    
    }
    
    public Integer getTransaksi_id() {
        return transaksi_id;
    }

    public void setTransaksi_id(Integer transaksi_id) {
        this.transaksi_id = transaksi_id;
    }

    public Integer getPengeluaran_id() {
        return pengeluaran_id;
    }

    public void setPengeluaran_id(Integer pengeluaran_id) {
        this.pengeluaran_id = pengeluaran_id;
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

    public Double getTransaksi_Saldo() {
        return transaksi_Saldo;
    }

    public void setTransaksi_Saldo(Double transaksi_Saldo) {
        this.transaksi_Saldo = transaksi_Saldo;
    }

    public Double getTransaksi_Nominal() {
        return transaksi_Nominal;
    }

    public void setTransaksi_Nominal(Double transaksi_Nominal) {
        this.transaksi_Nominal = transaksi_Nominal;
    }

    public String getTransaksi_Tanggal() {
        return transaksi_Tanggal;
    }

    public void setTransaksi_Tanggal(String transaksi_Tanggal) {
        this.transaksi_Tanggal = transaksi_Tanggal;
    }

    public String getTransaksi_tipe() {
        return transaksi_tipe;
    }

    public void setTransaksi_tipe(String transaksi_tipe) {
        this.transaksi_tipe = transaksi_tipe;
    }

    public String getTransaksi_Nama() {
        return transaksi_Nama;
    }

    public void setTransaksi_Nama(String transaksi_Nama) {
        this.transaksi_Nama = transaksi_Nama;
    }

    public String getUser_Username() {
        return user_Username;
    }

    public void setUser_Username(String user_Username) {
        this.user_Username = user_Username;
    }

    
    }
