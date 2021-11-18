/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author loqco
 */
public class QuanLyTapChi extends TaiLieu {
    String MaTapChi;
    String TenTapChi;
    int SoPhatHanh;
    String ThangPhatHanh;
    String TenNXB;
    int SoBan;

    public QuanLyTapChi(String MaTapChi, String TenTapChi, int SoPhatHanh, String ThangPhatHanh, String TenNXB, int SoBan) {
        this.MaTapChi = MaTapChi;
        this.TenTapChi = TenTapChi;
        this.SoPhatHanh = SoPhatHanh;
        this.ThangPhatHanh = ThangPhatHanh;
        this.TenNXB = TenNXB;
        this.SoBan = SoBan;
    }

    public QuanLyTapChi(String MaTaiLieu, String MaTapChi, String TenTapChi, int SoPhatHanh, String ThangPhatHanh, String TenNXB, int SoBan, String TenTaiLieu) {
        super(MaTaiLieu, TenTaiLieu);
        this.MaTapChi = MaTapChi;
        this.TenTapChi = TenTapChi;
        this.SoPhatHanh = SoPhatHanh;
        this.ThangPhatHanh = ThangPhatHanh;
        this.TenNXB = TenNXB;
        this.SoBan = SoBan;
    }

    public String getMaTapChi() {
        return MaTapChi;
    }

    public void setMaTapChi(String MaTapChi) {
        this.MaTapChi = MaTapChi;
    }

    public String getTenTapChi() {
        return TenTapChi;
    }

    public void setTenTapChi(String TenTapChi) {
        this.TenTapChi = TenTapChi;
    }

    public int getSoPhatHanh() {
        return SoPhatHanh;
    }

    public void setSoPhatHanh(int SoPhatHanh) {
        this.SoPhatHanh = SoPhatHanh;
    }

    public String getThangPhatHanh() {
        return ThangPhatHanh;
    }

    public void setThangPhatHanh(String ThangPhatHanh) {
        this.ThangPhatHanh = ThangPhatHanh;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
    }

    public int getSoBan() {
        return SoBan;
    }

    public void setSoBan(int SoBan) {
        this.SoBan = SoBan;
    }

    public String getMaTaiLieu() {
        return MaTaiLieu;
    }

    public void setMaTaiLieu(String MaTaiLieu) {
        this.MaTaiLieu = MaTaiLieu;
    }

    public String getTenTaiLieu() {
        return TenTaiLieu;
    }

    public void setTenTaiLieu(String TenTaiLieu) {
        this.TenTaiLieu = TenTaiLieu;
    }
    
    
    
}
