/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.LokasiAset;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoLokasiAset extends BaseRepository<LokasiAset, Integer>{
    
    public List<String> findNamaLokasi() throws SQLException;
    
    public List<LokasiAset> findByNama(String nama) throws SQLException;
}
