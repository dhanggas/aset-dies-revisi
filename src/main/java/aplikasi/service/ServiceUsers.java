/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Users;
import aplikasi.repository.RepoUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author soraya
 */
public class ServiceUsers implements RepoUsers {

    private DataSource ds;

    public ServiceUsers(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Users save(Users value) throws SQLException {
        String sql = "INSERT INTO users (id_user, nama, username, password, jabatan, status) VALUES (?, ?, ?,?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, value.getId_user());
        ps.setString(2, value.getNama());
        ps.setString(3, value.getUsername());
        ps.setString(4, value.getPassword());
        ps.setString(5, value.getJabatan().toString());
        ps.setBoolean(6, value.getStatus());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public Users update(Users value) throws SQLException {
        String sql = "UPDATE users SET nama = ?, username = ?, password = ?,jabatan = ?, status = ? WHERE id_user = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getNama());
        ps.setString(2, value.getUsername());
        ps.setString(3, value.getPassword());
        ps.setString(4, value.getJabatan().toString());
        ps.setBoolean(5, value.getStatus());
        ps.setInt(6, value.getId_user());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<Users> findAll() throws SQLException {
        String sql = "SELECT \n"
                + "    p.id_user as kode_user,\n"
                + "    p.nama as nama_user,\n"
                + "    p.username as username,\n"
                + "    p.password as password,\n"
                + "    p.jabatan as jabatan, \n"
                + "    p.status as status \n"
                + "FROM users p";
        List<Users> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Users u = new Users();
            u.setId_user(rs.getInt("kode_user"));
            u.setNama(rs.getString("nama_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setJabatan(Users.Role.valueOf(rs.getString("jabatan")));
            u.setStatus(rs.getBoolean("status"));
            list.add(u);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Users findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM users WHERE id_user = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public Users findByUsernameAndPasswordAndIsStatusEnabled(String username, String Password) throws SQLException {
        String sql = "SELECT u.id_user, u.nama, u.username, u.password, u.jabatan, u.status\n"
                + "FROM users u\n"
                + "WHERE u.username = ? AND u.password = ? AND u.status = ?";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, Password);
        ps.setBoolean(3, true);
        ResultSet rs = ps.executeQuery();
        Users u = null;
        while (rs.next()) {
            u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setJabatan(Users.Role.valueOf(rs.getString("jabatan")));
            u.setStatus(rs.getBoolean("status"));
        }

        ps.close();
        rs.close();
        connect.close();
        return u;
    }

    @Override
    public void updatePasswordByUsername(String username, String password) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> findMaxValue() throws SQLException {
        String sql = "SELECT * FROM users order BY id_user DESC LIMIT 1";
        List<Users> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Users u = new Users();
        while (rs.next()) {
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setJabatan(Users.Role.valueOf(rs.getString("jabatan")));
            u.setStatus(rs.getBoolean("status"));
            list.add(u);
        }
        ps.close();
        connect.close();
        return list;
    }

    @Override
    public List<Users> findByNama(String nama) throws SQLException {
        String sql = "SELECT \n"
                + "    p.id_user as kode_user,\n"
                + "    p.nama as nama_user,\n"
                + "    p.username as username,\n"
                + "    p.password as password,\n"
                + "    p.jabatan as jabatan, \n"
                + "    p.status as status \n"
                + "FROM users p where nama like CONCAT('%', ?, '%')";
        List<Users> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Users u = new Users();
            u.setId_user(rs.getInt("kode_user"));
            u.setNama(rs.getString("nama_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setJabatan(Users.Role.valueOf(rs.getString("jabatan")));
            u.setStatus(rs.getBoolean("status"));
            list.add(u);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
