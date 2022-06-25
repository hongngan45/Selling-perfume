package com.example.SweetLNP;

public class ttdonhang {
    private String tenkh;
    private String diachi;
    private String sdt;
    private long tongtien;
    private String ngaydh;



    public ttdonhang(String tenkh, String diachi, String sdt, long tongtien, String ngaydh) {
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.tongtien = tongtien;
        this.ngaydh = ngaydh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaydh() {
        return ngaydh;
    }

    public void setNgaydh(String ngaydh) {
        this.ngaydh = ngaydh;
    }
}
