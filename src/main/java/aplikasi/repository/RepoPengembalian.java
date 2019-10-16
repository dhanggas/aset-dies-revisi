/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Pengembalian;
import aplikasi.entity.PengembalianDetail;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoPengembalian extends BaseRepository<Pengembalian, Integer>{
    public Pengembalian save(Pengembalian b, List<PengembalianDetail> listPengembalian) throws SQLException;

    public List<PengembalianDetail> findPengembalianDetailByPengembalianId(Integer idPengembalian) throws SQLException;

    public List<PengembalianDetail> findPengembalianDetailBetweenTanggal(Date awal, Date akhir) throws SQLException;
    
    public List<PengembalianDetail> findPengembalianDetailBetweenTanggalByKategoriByKepemilikan(Date awal, Date akhir, String kategori, String kepemilikan) throws SQLException;

    public List<PengembalianDetail> findPengembalianDetailByTanggalLowerThen(Date tanggal) throws SQLException;
    
    public List<PengembalianDetail> findPengembalianDetailFilter(String kode) throws SQLException;
    
    public List<PengembalianDetail> findPengembalianDetailByIdAset(String kode) throws SQLException;

    public void deletePengembalianDetail(List<PengembalianDetail> listPengembalian) throws SQLException;
    
    public void updateStatusPeminjaman(Pengembalian pengembalian) throws SQLException;
    
}
