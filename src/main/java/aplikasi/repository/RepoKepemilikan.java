/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Kepemilikan;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoKepemilikan extends BaseRepository<Kepemilikan, Integer>{
    public List<Kepemilikan> findByNama(String nama) throws SQLException;
}
