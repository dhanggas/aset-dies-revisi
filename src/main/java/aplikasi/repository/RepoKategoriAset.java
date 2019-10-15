/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.repository;

import aplikasi.entity.KategoriAset;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author soraya
 */
public interface RepoKategoriAset extends BaseRepository<KategoriAset, Integer>{
    public Integer findLastByKode() throws SQLException;
    
    public List<KategoriAset> findByNama(String nama) throws SQLException;
    
}
