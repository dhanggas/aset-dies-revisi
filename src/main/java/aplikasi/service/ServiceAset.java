/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Aset;
import aplikasi.entity.KategoriAset;
import aplikasi.entity.LokasiAset;
import aplikasi.entity.Kepemilikan;
import aplikasi.entity.StatusAset;
import aplikasi.entity.Users;
import aplikasi.repository.RepoAset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author dhiskar
 */
public class ServiceAset implements RepoAset {

    private DataSource ds;

    public ServiceAset(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Aset> findByKategoriKode(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aset save(Aset a) throws SQLException {
        String sql = "INSERT INTO tb_aset (id_aset,nama_aset,tanggal, id_kategori, id_status, id_lokasi, id_kepemilikan, qty,satuan,id_user)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, a.getKode());
        ps.setString(2, a.getNama());
        ps.setDate(3, a.getTanggal());
        ps.setInt(4, a.getKategoriAset().getId_kategori());
        ps.setInt(5, a.getStatusAset().getId());
        ps.setInt(6, a.getLokasiAset().getId_lokasi());
        ps.setInt(7, a.getKepemilikan().getId_kepemilikan());
        ps.setInt(8, a.getQty());
        ps.setString(9, a.getSatuan());
        ps.setInt(10, a.getUsers().getId_user());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return a;
    }

    @Override
    public Aset update(Aset b) throws SQLException {
        String sql = "UPDATE tb_aset SET nama_aset = ?, tanggal = ?, id_kategori = ?, id_status = ?, "
                + "id_lokasi = ?, id_kepemilikan = ?, qty = ? , satuan = ?, id_user =  ? WHERE id_aset = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, b.getNama());
        ps.setDate(2, b.getTanggal());
        ps.setInt(3, b.getKategoriAset().getId_kategori());
        ps.setInt(4, b.getStatusAset().getId());
        ps.setInt(5, b.getLokasiAset().getId_lokasi());
        ps.setInt(6, b.getKepemilikan().getId_kepemilikan());
        ps.setInt(7, b.getQty());
        ps.setString(8, b.getSatuan());
        ps.setInt(9, b.getUsers().getId_user());
        ps.setString(10, b.getKode());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return b;
    }

    @Override
    public List<Aset> findAll() throws SQLException {
        String sql = "SELECT * FROM v_aset";
        List<Aset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Aset a = new Aset();
            a.setKode(rs.getString("kode_aset"));
            a.setNama(rs.getString("nama_aset"));
            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            KategoriAset k = new KategoriAset();
            k.setId_kategori(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama_kategori(rs.getString("nama_kategori"));
            a.setKategoriAset(k);

            StatusAset s = new StatusAset();
            s.setId(rs.getInt("id_status"));
            s.setStatus(rs.getString("status_aset"));
            a.setStatusAset(s);

            LokasiAset l = new LokasiAset();
            l.setId_lokasi(rs.getInt("id_lokasi"));
            l.setNama_rak(rs.getString("nama_rak"));
            l.setLokasi(rs.getString("lokasi_aset"));
            a.setLokasiAset(l);

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));
            p.setTlp(rs.getString("tlp_kepemilikan"));
            p.setAlamat(rs.getString("alamat_kepemilikan"));
            p.setKet(rs.getString("ket_kepemilikan"));
            a.setKepemilikan(p);

            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setStatus(rs.getBoolean("status_user"));
            a.setUsers(u);

            list.add(a);
        }

        st.close();
        rs.close();
        connect.close();

        return list;
    }

    @Override
    public Aset findOne(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM tb_aset WHERE id_aset = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<Aset> findMaxValue() throws SQLException {
        String sql = "SELECT * FROM `tb_aset` order BY id_aset DESC LIMIT 1";

        List<Aset> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Aset a = new Aset();
        while (rs.next()) {
            a.setKode(rs.getString("id_aset"));
            a.setNama(rs.getString("nama_aset"));
            a.setTanggal(rs.getDate("tanggal"));
            a.setQty(rs.getInt("id_kategori"));
            a.setSatuan(rs.getString("id_status"));

            a.setQty(rs.getInt("qty"));
            a.setSatuan(rs.getString("satuan"));

            list.add(a);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<Aset> findByQtyOneByName(String nama) throws SQLException {
        List<Aset> list = new ArrayList<>();
        String sql = "SELECT * FROM v_aset \n"
                + "WHERE nama_aset like CONCAT('%', ?, '%') AND quantity = 1";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Aset a = new Aset();
            a.setKode(rs.getString("kode_aset"));
            a.setNama(rs.getString("nama_aset"));
            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            KategoriAset k = new KategoriAset();
            k.setId_kategori(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama_kategori(rs.getString("nama_kategori"));
            a.setKategoriAset(k);

            StatusAset s = new StatusAset();
            s.setId(rs.getInt("id_status"));
            s.setStatus(rs.getString("status_aset"));
            a.setStatusAset(s);

            LokasiAset l = new LokasiAset();
            l.setId_lokasi(rs.getInt("id_lokasi"));
            l.setNama_rak(rs.getString("nama_rak"));
            l.setLokasi(rs.getString("lokasi_aset"));
            a.setLokasiAset(l);

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));
            p.setTlp(rs.getString("tlp_kepemilikan"));
            p.setAlamat(rs.getString("alamat_kepemilikan"));
            p.setKet(rs.getString("ket_kepemilikan"));
            a.setKepemilikan(p);

            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setStatus(rs.getBoolean("status_user"));
            a.setUsers(u);

            list.add(a);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<Aset> findByQtyZeroByName(String nama) throws SQLException {
        List<Aset> list = new ArrayList<>();
        String sql = "SELECT * FROM v_aset \n"
                + "WHERE nama_aset like CONCAT('%', ?, '%') AND quantity = 0";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Aset a = new Aset();
            a.setKode(rs.getString("kode_aset"));
            a.setNama(rs.getString("nama_aset"));
            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            KategoriAset k = new KategoriAset();
            k.setId_kategori(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama_kategori(rs.getString("nama_kategori"));
            a.setKategoriAset(k);

            StatusAset s = new StatusAset();
            s.setId(rs.getInt("id_status"));
            s.setStatus(rs.getString("status_aset"));
            a.setStatusAset(s);

            LokasiAset l = new LokasiAset();
            l.setId_lokasi(rs.getInt("id_lokasi"));
            l.setNama_rak(rs.getString("nama_rak"));
            l.setLokasi(rs.getString("lokasi_aset"));
            a.setLokasiAset(l);

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));
            p.setTlp(rs.getString("tlp_kepemilikan"));
            p.setAlamat(rs.getString("alamat_kepemilikan"));
            p.setKet(rs.getString("ket_kepemilikan"));
            a.setKepemilikan(p);

            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setStatus(rs.getBoolean("status_user"));
            a.setUsers(u);

            list.add(a);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<Aset> findFilterAlll(String nama, String kategori, String status, String namaRak, String lokasi, String namaCus, String qty, String username) throws SQLException {
        List<Aset> list = new ArrayList<>();

        String sql = "SELECT * FROM v_aset \n"
                + "WHERE nama_aset like CONCAT('%', ?, '%') \n"
                + "AND nama_kategori LIKE ? \n"
                + "AND status_aset LIKE ? \n"
                + "AND nama_rak LIKE CONCAT('%', ?, '%') \n"
                + "AND lokasi_aset LIKE ? \n"
                + "AND nama_kepemilikan LIKE ? \n"
                + "AND quantity >=? and quantity <= ? \n"
                + "AND username LIKE ? order by kode_aset asc ";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);
        ps.setString(2, kategori);
        ps.setString(3, status);
        ps.setString(4, namaRak);
        ps.setString(5, lokasi);
        ps.setString(6, namaCus);
        int c, b;
        if (qty.equals("%")) {
            c = 0;
            b = 100;
        } else {
            c = Integer.valueOf(qty);
            b = Integer.valueOf(qty);
        }
        ps.setInt(7, c);
        ps.setInt(8, b);
        ps.setString(9, username);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Aset a = new Aset();
            a.setKode(rs.getString("kode_aset"));
            a.setNama(rs.getString("nama_aset"));
            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            KategoriAset k = new KategoriAset();
            k.setId_kategori(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama_kategori(rs.getString("nama_kategori"));
            a.setKategoriAset(k);

            StatusAset s = new StatusAset();
            s.setId(rs.getInt("id_status"));
            s.setStatus(rs.getString("status_aset"));
            a.setStatusAset(s);

            LokasiAset l = new LokasiAset();
            l.setId_lokasi(rs.getInt("id_lokasi"));
            l.setNama_rak(rs.getString("nama_rak"));
            l.setLokasi(rs.getString("lokasi_aset"));
            a.setLokasiAset(l);

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));
            p.setTlp(rs.getString("tlp_kepemilikan"));
            p.setAlamat(rs.getString("alamat_kepemilikan"));
            p.setKet(rs.getString("ket_kepemilikan"));
            a.setKepemilikan(p);

            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setStatus(rs.getBoolean("status_user"));
            a.setUsers(u);

            list.add(a);
        }
        ps.close();
        rs.close();
        connect.close();

        return list;
    }

    @Override
    public List<Aset> findByNama(String nama) throws SQLException {
        List<Aset> list = new ArrayList<>();
        String sql = "SELECT * FROM v_aset \n"
                + "WHERE nama_aset like CONCAT('%', ?, '%') ";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Aset a = new Aset();
            a.setKode(rs.getString("kode_aset"));
            a.setTanggal(rs.getDate("tanggal"));
            a.setNama(rs.getString("nama_aset"));
            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            KategoriAset k = new KategoriAset();
            k.setId_kategori(rs.getInt("id_kategori"));
            k.setKode(rs.getString("kode_kategori"));
            k.setNama_kategori(rs.getString("nama_kategori"));
            a.setKategoriAset(k);

            StatusAset s = new StatusAset();
            s.setId(rs.getInt("id_status"));
            s.setStatus(rs.getString("status_aset"));
            a.setStatusAset(s);

            LokasiAset l = new LokasiAset();
            l.setId_lokasi(rs.getInt("id_lokasi"));
            l.setNama_rak(rs.getString("nama_rak"));
            l.setLokasi(rs.getString("lokasi_aset"));
            a.setLokasiAset(l);

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));
            p.setTlp(rs.getString("tlp_kepemilikan"));
            p.setAlamat(rs.getString("alamat_kepemilikan"));
            p.setKet(rs.getString("ket_kepemilikan"));
            a.setKepemilikan(p);

            a.setQty(rs.getInt("quantity"));
            a.setSatuan(rs.getString("satuan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama_user"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setStatus(rs.getBoolean("status_user"));
            a.setUsers(u);

            list.add(a);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }
}
