/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

/**
 *
 * @author loqco
 */
public class QuanLySach extends TaiLieu{
    String MaSach;
    String TenSach;
    int SoTrang;
    String TenTacGia;
    String TenNXB;
    int SoBan;

    public QuanLySach(String MaSach, String TenSach, int SoTrang, String TenTacGia, String TenNXB, int SoBan) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.SoTrang = SoTrang;
        this.TenTacGia = TenTacGia;
        this.TenNXB = TenNXB;
        this.SoBan = SoBan;
    }

    public QuanLySach(String MaTaiLieu ,String MaSach, String TenSach, String TenTacGia,int SoTrang, String TenNXB, String TenTaiLieu, int SoBan) {
        super(MaTaiLieu, TenTaiLieu);
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTacGia = TenTacGia;
        this.SoTrang = SoTrang;
        this.SoBan = SoBan;
        this.TenNXB = TenNXB;
       
        
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int SoTrang) {
        this.SoTrang = SoTrang;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
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
   