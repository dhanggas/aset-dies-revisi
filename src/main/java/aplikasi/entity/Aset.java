/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.entity;

import java.sql.Date;

/**
 *
 * @author dhiskar
 */
public class Aset {
    private String kode;
    private Date tanggal;
    private String nama;
    private KategoriAset kategoriAset;
    private StatusAset statusAset;
    private LokasiAset lokasiAset;
    private Kepemilikan kepemilikan;
    private Integer qty;
    private String satuan;
    private Users users;

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Kepemilikan getKepemilikan() {
        return kepemilikan;
    }

    public void setKepemilikan(Kepemilikan kepemilikan) {
        this.kepemilikan = kepemilikan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public KategoriAset getKategoriAset() {
        return kategoriAset;
    }

    public void setKategoriAset(KategoriAset kategoriAset) {
        this.kategoriAset = kategoriAset;
    }

    public StatusAset getStatusAset() {
        return statusAset;
    }

    public void setStatusAset(StatusAset statusAset) {
        this.statusAset = statusAset;
    }

    public LokasiAset getLokasiAset() {
        return lokasiAset;
    }

    public void setLokasiAset(LokasiAset lokasiAset) {
        this.lokasiAset = lokasiAset;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    
}
