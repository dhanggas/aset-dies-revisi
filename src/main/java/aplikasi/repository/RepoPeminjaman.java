/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.repository;

import aplikasi.entity.Peminjaman;
import aplikasi.entity.PeminjamanDetail;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author soraya
 */
public interface RepoPeminjaman extends BaseRepository<Peminjaman, String>{
    public Peminjaman save(Peminjaman p, List<PeminjamanDetail> listPeminjaman) throws SQLException;
    
    public List<PeminjamanDetail> findPeminjamanByTglBetween(Date awal, Date akhir) throws SQLException;
    
    public List<PeminjamanDetail> findPeminjamanByTglBetweenByKategoriByKepemilikan(Date awal, Date akhir, String kategori, String kepemilikan) throws SQLException;

    public List<PeminjamanDetail> findPeminjamanDetailByPeminjamanKode(String kode) throws SQLException;
    
    public List<PeminjamanDetail> findPeminjamanDetailByIdAset(String kode) throws SQLException;

    public List<PeminjamanDetail> findPeminjamanDetailByTanggalLowerThen(Date tgl) throws SQLException;
   
    public List<Peminjaman> findPeminjamanByTanggal(Date tgl) throws SQLException;

    public Peminjaman findByPelangganOrderByTanggalAscLastTransaction(String kode) throws SQLException;
    
    public List<PeminjamanDetail> findPeminjamanDetailByPelangganKode(String kode) throws SQLException;
    
    public List<PeminjamanDetail> findPeminjamanDetailFilter(String kode) throws SQLException;
    
    public void deletePeminjamanDetail(List<PeminjamanDetail> listPeminjaman) throws SQLException;
    
    public void updatePeminjamanDetail(List<PeminjamanDetail> listPeminjaman) throws SQLException;
    
    public List<Peminjaman> findPeminjamanByStatus() throws SQLException;
    
    public Peminjaman updateApproval(Peminjaman p) throws SQLException;

}
