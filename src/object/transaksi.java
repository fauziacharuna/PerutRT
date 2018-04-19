package object;

/**
 *
 * @author PC-14
 */
import java.util.Date;
public class transaksi {
    private int transaksi_id, pengeluaran_id, iuran_id, user_id;
    private Double transaksi_Saldo, transaksi_Nominal;
    private Date transaksi_Tanggal;
    private Enum transaksi_tipe;
    private String transaksi_Nama, user_Username;

    public int getTransaksi_id() {
        return transaksi_id;
    }

    public void setTransaksi_id(int transaksi_id) {
        this.transaksi_id = transaksi_id;
    }

    public int getPengeluaran_id() {
        return pengeluaran_id;
    }

    public void setPengeluaran_id(int pengeluaran_id) {
        this.pengeluaran_id = pengeluaran_id;
    }

    public int getIuran_id() {
        return iuran_id;
    }

    public void setIuran_id(int iuran_id) {
        this.iuran_id = iuran_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
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

    public Date getTransaksi_Tanggal() {
        return transaksi_Tanggal;
    }

    public void setTransaksi_Tanggal(Date transaksi_Tanggal) {
        this.transaksi_Tanggal = transaksi_Tanggal;
    }

    public Enum getTransaksi_tipe() {
        return transaksi_tipe;
    }

    public void setTransaksi_tipe(Enum transaksi_tipe) {
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
