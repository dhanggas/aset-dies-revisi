/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Users;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author soraya
 */
public interface RepoUsers extends BaseRepository<Users, Integer> {

    public Users findByUsernameAndPasswordAndIsStatusEnabled(String username, String Password) throws SQLException;

    public void updatePasswordByUsername(String username, String password) throws SQLException;
    
    public List<Users> findByNama(String nama) throws SQLException;
}
