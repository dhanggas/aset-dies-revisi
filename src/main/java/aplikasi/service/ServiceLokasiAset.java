/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.LokasiAset;
import aplikasi.repository.RepoLokasiAset;
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
public class ServiceLokasiAset implements RepoLokasiAset {

    private DataSource ds;

    public ServiceLokasiAset(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public LokasiAset save(LokasiAset value) throws SQLException {
        String sql = "INSERT INTO tb_lokasi (id_lokasi, nama_rak, lokasi)\n"
                + "VALUES (?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, value.getId_lokasi());
        ps.setString(2, value.getNama_rak());
        ps.setString(3, value.getLokasi());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public LokasiAset update(LokasiAset value) throws SQLException {
        String sql = "UPDATE tb_lokasi SET nama_rak = ?, lokasi = ? WHERE id_lokasi = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getNama_rak());
        ps.setString(2, value.getLokasi());
        ps.setInt(3, value.getId_lokasi());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<LokasiAset> findAll() throws SQLException {
        String sql = "SELECT * FROM tb_lokasi";
        List<LokasiAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            LokasiAset kb = new LokasiAset();
            kb.setId_lokasi(rs.getInt("id_lokasi"));
            kb.setNama_rak(rs.getString("nama_rak"));
            kb.setLokasi(rs.getString("lokasi"));
            list.add(kb);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public LokasiAset findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM tb_lokasi WHERE id_lokasi = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<LokasiAset> findMaxValue() throws SQLException {
        String sql = "SELECT * FROM tb_lokasi order BY id_lokasi DESC LIMIT 1";
        List<LokasiAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            LokasiAset kb = new LokasiAset();
            kb.setId_lokasi(rs.getInt("id_lokasi"));
            kb.setNama_rak(rs.getString("nama_rak"));
            kb.setLokasi(rs.getString("lokasi"));
            list.add(kb);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<String> findNamaLokasi() throws SQLException {
        String sql = "SELECT DISTINCT lokasi FROM tb_lokasi ORDER BY lokasi";
        List<String> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String a = rs.getString("lokasi");
            list.add(a);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<LokasiAset> findByNama(String nama) throws SQLException {
        String sql = "SELECT * FROM tb_lokasi where nama_rak like CONCAT('%', ?, '%')";
        List<LokasiAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            LokasiAset kb = new LokasiAset();
            kb.setId_lokasi(rs.getInt("id_lokasi"));
            kb.setNama_rak(rs.getString("nama_rak"));
            kb.setLokasi(rs.getString("lokasi"));
            list.add(kb);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
