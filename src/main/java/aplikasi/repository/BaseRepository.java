/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface BaseRepository <T, E>{
    public T save(T value) throws SQLException;

    public T update(T value) throws SQLException;

    public List<T> findAll() throws SQLException;
    
    public T findOne(E id) throws SQLException;

    public Boolean exists(E id) throws SQLException;
    
    public void delete(E id)throws SQLException;
    
    public List<T> findMaxValue() throws SQLException;
    
}
