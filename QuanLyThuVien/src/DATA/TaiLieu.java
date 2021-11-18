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
public class TaiLieu {
    protected String MaTaiLieu;
    protected String TenTaiLieu;
    public TaiLieu(){}

    public TaiLieu(String MaTaiLieu, String TenTaiLieu) {
        this.MaTaiLieu = MaTaiLieu;
        this.TenTaiLieu = TenTaiLieu;
    }
    
    public String getTenTaiLieu() {
        return TenTaiLieu;
    }

    public void setTenTaiLieu(String TenTaiLieu) {
        this.TenTaiLieu = TenTaiLieu;
    }

    public String getMaTaiLieu() {
        return MaTaiLieu;
    }

    public void setMaTaiLieu(String MaTaiLieu) {
        this.MaTaiLieu = MaTaiLieu;
    }


}
