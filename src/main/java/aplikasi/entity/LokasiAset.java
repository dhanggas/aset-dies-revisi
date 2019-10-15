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
public class LokasiAset {
    private Integer id_lokasi;
    private String nama_rak;
    private String lokasi;

    public Integer getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(Integer id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public String getNama_rak() {
        return nama_rak;
    }

    public void setNama_rak(String nama_rak) {
        this.nama_rak = nama_rak;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
}
