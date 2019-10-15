/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.KategoriAset;
import aplikasi.repository.RepoKategoriAset;
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
public class ServiceKategoriAset implements RepoKategoriAset {

    private DataSource ds;

    public ServiceKategoriAset(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public KategoriAset save(KategoriAset value) throws SQLException {
        String sql = "INSERT INTO tb_kategori(id_kategori, kode, nama_kategori)\n"
                + "VALUE (?, ?, ?) ";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, value.getId_kategori());
        ps.setString(2, value.getKode());
        ps.setString(3, value.getNama_kategori());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public KategoriAset update(KategoriAset value) throws SQLException {
        String sql = "UPDATE tb_kategori SET kode = ?, nama_kategori = ? WHERE id_kategori = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getKode());
        ps.setString(2, value.getNama_kategori());
        ps.setInt(3, value.getId_kategori());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<KategoriAset> findAll() throws SQLException {
        String sql = "SELECT * FROM tb_kategori";
        List<KategoriAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            KategoriAset ka = new KategoriAset();
            ka.setId_kategori(rs.getInt("id_kategori"));
            ka.setKode(rs.getString("kode"));
            ka.setNama_kategori(rs.getString("nama_kategori"));
            list.add(ka);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public KategoriAset findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM tb_kategori WHERE id_kategori = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public Integer findLastByKode() throws SQLException {
        String sql = "SELECT id_kategori FROM tb_kategori ORDER BY id_kategori DESC LIMIT 1";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int a = rs.getInt("id_kategori");
        ps.close();
        rs.close();
        connect.close();
        return a;
    }

    @Override
    public List<KategoriAset> findMaxValue() throws SQLException {
        String sql = "SELECT * FROM tb_kategori order BY id_kategori DESC LIMIT 1";
        List<KategoriAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            KategoriAset ka = new KategoriAset();
            ka.setId_kategori(rs.getInt("id_kategori"));
            ka.setKode(rs.getString("kode"));
            ka.setNama_kategori(rs.getString("nama_kategori"));
            list.add(ka);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<KategoriAset> findByNama(String nama) throws SQLException {
        String sql = "SELECT * FROM tb_kategori where nama_kategori like CONCAT('%', ?, '%')";
        List<KategoriAset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            KategoriAset ka = new KategoriAset();
            ka.setId_kategori(rs.getInt("id_kategori"));
            ka.setKode(rs.getString("kode"));
            ka.setNama_kategori(rs.getString("nama_kategori"));
            list.add(ka);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
