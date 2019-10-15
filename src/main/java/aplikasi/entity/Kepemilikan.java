/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.entity;

/**
 *
 * @author dhiskar
 */
public class Kepemilikan {

    private Integer id_kepemilikan;
    private String nama;
    private String tlp;
    private String alamat;
    private String ket;

    public Integer getId_kepemilikan() {
        return id_kepemilikan;
    }

    public void setId_kepemilikan(Integer id_kepemilikan) {
        this.id_kepemilikan = id_kepemilikan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    

}
