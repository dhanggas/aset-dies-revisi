/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.StatusAset;
import aplikasi.repository.RepoStatusAset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author dhiskar
 */
public class ServiceStatusAset implements RepoStatusAset {

    private DataSource ds;

    public ServiceStatusAset(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public StatusAset findByKode(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean existsByKode(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatusAset save(StatusAset value) throws SQLException {
        String sql = "INSERT INTO tb_status (id_status, status)\n"
                + "VALUES (?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, value.getId());
        ps.setString(2, value.getStatus());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;

    }

    @Override
    public StatusAset update(StatusAset value) throws SQLException {
        String sql = "UPDATE tb_status SET status = ? WHERE id_status = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getStatus());
        ps.setInt(2, value.getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<StatusAset> findAll() throws SQLException {
        String sql = "SELECT * FROM tb_status";
        List<StatusAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            StatusAset kb = new StatusAset();
            kb.setId(rs.getInt("id_status"));
            kb.setStatus(rs.getString("status"));
            list.add(kb);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public StatusAset findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM tb_status WHERE id_status = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<StatusAset> findMaxValue() throws SQLException {
        String sql = "SELECT * FROM tb_status order BY id_status DESC LIMIT 1";
        List<StatusAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            StatusAset kb = new StatusAset();
            kb.setId(rs.getInt("id_status"));
            kb.setStatus(rs.getString("status"));
            list.add(kb);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<StatusAset> findByNama(String nama) throws SQLException {
        String sql = "SELECT * FROM tb_status where status like CONCAT('%', ?, '%')";
        List<StatusAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            StatusAset kb = new StatusAset();
            kb.setId(rs.getInt("id_status"));
            kb.setStatus(rs.getString("status"));
            list.add(kb);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
