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
public class QuanLyBao extends TaiLieu{
    private String MaBao;
    private String TenBao;
    private String NgayPhatHanh;
    private String TenNXB;
    private int SoBan;

   

    public QuanLyBao(String MaBao, String TenBao, String NgayPhatHanh, String TenNXB, int SoBan) {
        this.MaBao = MaBao;
        this.TenBao = TenBao;
        this.NgayPhatHanh = NgayPhatHanh;
        this.TenNXB = TenNXB;
        this.SoBan = SoBan;

    }

    public QuanLyBao(String MaTaiLieu,String MaBao, String TenBao, String NgayPhatHanh, String TenNXB, int SoBan, String TenTaiLieu) {
        super(MaTaiLieu, TenTaiLieu);
        this.MaBao = MaBao;
        this.TenBao = TenBao;
        this.NgayPhatHanh = NgayPhatHanh;
        this.TenNXB = TenNXB;
        this.SoBan = SoBan;
  
    }


    public String getMaBao() {
        return MaBao;
    }

    public void setMaBao(String MaBao) {
        this.MaBao = MaBao;
    }

    public String getTenBao() {
        return TenBao;
    }

    public void setTenBao(String TenBao) {
        this.TenBao = TenBao;
    }

    public String getNgayPhatHanh() {
        return NgayPhatHanh;
    }

    public void setNgayPhatHanh(String NgayPhatHanh) {
        this.NgayPhatHanh = NgayPhatHanh;
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

