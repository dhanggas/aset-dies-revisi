/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Aset;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoAset extends BaseRepository<Aset, String> {

    public List<Aset> findByKategoriKode(String kode) throws SQLException;
    
    public List<Aset> findByNama(String nama) throws SQLException;

    public List<Aset> findByQtyZeroByName(String nama) throws SQLException;

    public List<Aset> findByQtyOneByName(String nama) throws SQLException;

    public List<Aset> findFilterAlll(String text, String toString, String toString0, String text0, String toString1, String toString2, String toString3, String toString4) throws SQLException;


}
