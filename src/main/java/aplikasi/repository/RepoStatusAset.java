/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.StatusAset;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoStatusAset extends BaseRepository<StatusAset, Integer>{
    public StatusAset findByKode(String kode) throws SQLException;
    
    public Boolean existsByKode(String kode) throws SQLException;
    
    public List<StatusAset> findByNama(String nama) throws SQLException;
}
