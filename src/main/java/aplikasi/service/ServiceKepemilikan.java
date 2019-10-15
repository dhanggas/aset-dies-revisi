/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Kepemilikan;
import aplikasi.repository.RepoKepemilikan;
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
public class ServiceKepemilikan implements RepoKepemilikan {

    private DataSource ds;

    public ServiceKepemilikan(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Kepemilikan save(Kepemilikan value) throws SQLException {
        String sql = "INSERT INTO tb_kepemilikan (id_kepemilikan, nama, tlp, alamat, ket)\n"
                + "VALUES (?,?,?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, value.getId_kepemilikan());
        ps.setString(2, value.getNama());
        ps.setString(3, value.getTlp());
        ps.setString(4, value.getAlamat());
        ps.setString(5, value.getKet());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public Kepemilikan update(Kepemilikan value) throws SQLException {
        String sql = "UPDATE tb_kepemilikan SET nama = ?, tlp = ?, alamat = ?, ket = ? "
                + "WHERE id_kepemilikan = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getNama());
        ps.setString(2, value.getTlp());
        ps.setString(3, value.getAlamat());
        ps.setString(4, value.getKet());
        ps.setInt(5, value.getId_kepemilikan());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<Kepemilikan> findAll() throws SQLException {
        String sql = "SELECT * FROM tb_kepemilikan";
        List<Kepemilikan> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama"));
            p.setTlp(rs.getString("tlp"));
            p.setAlamat(rs.getString("alamat"));
            p.setKet(rs.getString("ket"));
            list.add(p);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Kepemilikan findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM tb_kepemilikan WHERE id_kepemilikan = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<Kepemilikan> findMaxValue() throws SQLException {
        String sql = "SELECT * FROM tb_kepemilikan order BY id_kepemilikan DESC LIMIT 1";
        List<Kepemilikan> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Kepemilikan p = new Kepemilikan();
        while (rs.next()) {
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama"));
            p.setTlp(rs.getString("tlp"));
            p.setAlamat(rs.getString("alamat"));
            p.setKet(rs.getString("ket"));
            list.add(p);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<Kepemilikan> findByNama(String nama) throws SQLException {
        String sql = "SELECT * FROM tb_kepemilikan where nama like CONCAT('%', ?, '%')";
        List<Kepemilikan> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama"));
            p.setTlp(rs.getString("tlp"));
            p.setAlamat(rs.getString("alamat"));
            p.setKet(rs.getString("ket"));
            list.add(p);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
