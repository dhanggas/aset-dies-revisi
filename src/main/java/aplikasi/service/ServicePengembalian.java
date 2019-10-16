/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Aset;
import aplikasi.entity.KategoriAset;
import aplikasi.entity.Kepemilikan;
import aplikasi.entity.Pengembalian;
import aplikasi.entity.PengembalianDetail;
import aplikasi.entity.Users;
import aplikasi.repository.RepoPengembalian;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author laptop
 */
public class ServicePengembalian implements RepoPengembalian {

    private final DataSource ds;

    public ServicePengembalian(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Pengembalian save(Pengembalian p, List<PengembalianDetail> listPengembalian) throws SQLException {
        Pengembalian kembali = save(p);

        String sql = "INSERT INTO tb_pengembalian_detail (id_pengembalian, id_aset, qty) VALUES (?,?,?)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        for (PengembalianDetail pd : listPengembalian) {
            ps.setInt(1, kembali.getId());
            ps.setString(2, pd.getAset().getKode());
            ps.setInt(3, pd.getQty());
            ps.addBatch();
        }
        ps.executeBatch();
        ps.clearBatch();
        ps.close();

        sql = "UPDATE tb_aset SET qty = ? WHERE id_aset = ?";
        ps = connect.prepareStatement(sql);
        for (PengembalianDetail pd : listPengembalian) {
            Aset aset = pd.getAset();
            Integer stokSekarang = aset.getQty();
            ps.setInt(1, stokSekarang + pd.getQty());
            ps.setString(2, aset.getKode());
            ps.addBatch();
        }

        ps.executeBatch();
        ps.clearBatch();
        ps.close();

        connect.close();
        return p;
    }

    @Override
    public List<PengembalianDetail> findPengembalianDetailByPengembalianId(Integer idPengembalian) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PengembalianDetail> findPengembalianDetailBetweenTanggal(Date awal, Date akhir) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_pengembalian as id_pengembalian, \n"
                + "    b.kode as kode_pengembalian,\n"
                + "    b.pembawa as pembawa_pengembalian,\n"
                + "    b.tanggal as tanggal_pengembalian,\n"
                + "    b.ket as ket_pengembalian,\n"
                + "    bd.id_pengembalian as id_pengembalian_detail,\n"
                + "    bd.qty as jumlah_pengembalian,\n"
                + "    ast.id_aset as id_aset,\n"
                + "    ast.nama_aset as nama_aset,\n"
                + "    ast.qty as stok_aset,\n"
                + "    ast.satuan as satuan_aset,\n"
                + "    kast.id_kategori as id_kategori_aset,\n"
                + "    kast.kode as kode_ketegori_aset,\n"
                + "    kast.nama_kategori as nama_kategori_aset,\n"
                + "    c.id_kepemilikan as id_kepemilikan,\n"
                + "    c.nama as nama_kepemilikan,\n"
                + "    u.id_user as id_user,\n"
                + "    u.username as username\n"
                + "FROM tb_pengembalian b JOIN tb_pengembalian_detail bd ON (b.id_pengembalian = bd.id_pengembalian)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.tanggal between ? AND ? ";
        List<PengembalianDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, awal);
        ps.setDate(2, akhir);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PengembalianDetail bd = new PengembalianDetail();

            Pengembalian b = new Pengembalian();
            b.setId(rs.getInt("id_pengembalian"));
            b.setKode(rs.getString("kode_pengembalian"));
            b.setTanggal(rs.getDate("tanggal_pengembalian"));
            b.setKet(rs.getString("ket_pengembalian"));

            Aset ast = new Aset();
            ast.setKode(rs.getString("id_aset"));
            ast.setNama(rs.getString("nama_aset"));
            ast.setSatuan(rs.getString("satuan_aset"));

            KategoriAset kb = new KategoriAset();
            kb.setId_kategori(rs.getInt("id_kategori_aset"));
            kb.setKode(rs.getString("kode_ketegori_aset"));
            kb.setNama_kategori(rs.getString("nama_kategori_aset"));

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));

            ast.setKepemilikan(p);
            ast.setKategoriAset(kb);
            b.setUser(u);
            bd.setPengembalian(b);
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_pengembalian"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<PengembalianDetail> findPengembalianDetailByTanggalLowerThen(Date tanggal) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_pengembalian as id_pengembalian, \n"
                + "    b.kode as kode_pengembalian,\n"
                + "    b.pembawa as pembawa_pengembalian,\n"
                + "    b.tanggal as tanggal_pengembalian,\n"
                + "    bd.id_pengembalian as id_pengembalian_detail,\n"
                + "    bd.qty as jumlah_pengembalian,\n"
                + "    ast.id_aset as id_aset,\n"
                + "    ast.nama_aset as nama_aset,\n"
                + "    ast.qty as stok_aset,\n"
                + "    ast.satuan as satuan_aset,\n"
                + "    kast.id_kategori as id_kategori_aset,\n"
                + "    kast.kode as kode_ketegori_aset,\n"
                + "    kast.nama_kategori as nama_kategori_aset,\n"
                + "    c.id_kepemilikan as id_kepemilikan,\n"
                + "    c.nama as nama_kepemilikan,\n"
                + "    u.id_user as id_user,\n"
                + "    u.username as username\n"
                + "FROM tb_pengembalian b JOIN tb_pengembalian_detail bd ON (b.id_pengembalian = bd.id_pengembalian)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.tanggal < ? ";
        List<PengembalianDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, tanggal);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PengembalianDetail bd = new PengembalianDetail();

            Pengembalian b = new Pengembalian();
            b.setId(rs.getInt("id_pengembalian"));
            b.setKode(rs.getString("kode_pengembalian"));
            b.setTanggal(rs.getDate("tanggal_pengembalian"));

            Aset ast = new Aset();
            ast.setKode(rs.getString("id_aset"));
            ast.setNama(rs.getString("nama_aset"));
            ast.setSatuan(rs.getString("satuan_aset"));

            KategoriAset kb = new KategoriAset();
            kb.setId_kategori(rs.getInt("id_kategori_aset"));
            kb.setKode(rs.getString("kode_ketegori_aset"));
            kb.setNama_kategori(rs.getString("nama_kategori_aset"));

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));

            ast.setKepemilikan(p);
            ast.setKategoriAset(kb);
            b.setUser(u);
            bd.setPengembalian(b);
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_pengembalian"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Pengembalian save(Pengembalian value) throws SQLException {
        String sql = "INSERT INTO tb_pengembalian (kode, pembawa, tanggal, ket , id_user, id_peminjaman) VALUES (?,?,?,?,?,?)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getKode());
        ps.setString(2, value.getPembawa());
        ps.setDate(3, (Date) value.getTanggal());
        ps.setString(4, value.getKet());
        ps.setInt(5, value.getUser().getId_user());
        ps.setInt(6, value.getIdPeminjaman());

        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            value.setId(rs.getInt(1));
        }

        ps.close();
        rs.close();
        connect.close();
        return value;
    }

    @Override
    public Pengembalian update(Pengembalian value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pengembalian> findAll() throws SQLException {
        String sql = "SELECT p.id_pengembalian,"
                + "p.kode,"
                + "p.pembawa,"
                + "p.tanggal,"
                + "p.ket,"
                + "p.id_peminjaman,"
                + "u.id_user,"
                + "u.nama,"
                + "u.username,"
                + "u.password,"
                + "u.jabatan,"
                + "u.status "
                + "FROM tb_pengembalian p JOIN users u ON (p.id_user = u.id_user)";
        Connection connect = ds.getConnection();
        List<Pengembalian> list = new ArrayList<>();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pengembalian j = new Pengembalian();
            j.setId(rs.getInt("id_pengembalian"));
            j.setKode(rs.getString("kode"));
            j.setPembawa(rs.getString("pembawa"));
            j.setTanggal(rs.getDate("tanggal"));
            j.setKet(rs.getString("ket"));
            j.setIdPeminjaman(rs.getInt("id_peminjaman"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setNama(rs.getString("nama"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("jabatan"));
            u.setStatus(rs.getBoolean("status"));
            j.setUser(u);
            list.add(j);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Pengembalian findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM tb_pengembalian_detail WHERE id_pengembalian = ?";
        String sql2 = "DELETE FROM tb_pengembalian WHERE id_pengembalian = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        PreparedStatement ps2 = connect.prepareStatement(sql2);
        ps.setInt(1, id);
        ps2.setInt(1, id);
        ps.executeUpdate();
        ps2.executeUpdate();

        ps.close();
        ps2.close();
        connect.close();
    }

    @Override
    public List<Pengembalian> findMaxValue() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PengembalianDetail> findPengembalianDetailFilter(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_pengembalian as id_pengembalian, \n"
                + "    b.kode as kode_pengembalian,\n"
                + "    b.pembawa as pembawa_pengembalian,\n"
                + "    b.tanggal as tanggal_pengembalian,\n"
                + "    bd.id as id_pengembalian_detail,\n"
                + "    bd.qty as jumlah_pengembalian,\n"
                + "    ast.id_aset as id_aset,\n"
                + "    ast.nama_aset as nama_aset,\n"
                + "    ast.qty as stok_aset,\n"
                + "    ast.satuan as satuan_aset,\n"
                + "    kast.id_kategori as id_kategori_aset,\n"
                + "    kast.kode as kode_ketegori_aset,\n"
                + "    kast.nama_kategori as nama_kategori_aset,\n"
                + "    c.id_kepemilikan as id_kepemilikan,\n"
                + "    c.nama as nama_kepemilikan,\n"
                + "    u.id_user as id_user,\n"
                + "    u.username as username\n"
                + "FROM tb_pengembalian b JOIN tb_pengembalian_detail bd ON (b.id_pengembalian = bd.id_pengembalian)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.kode like CONCAT('%', ?, '%')";
        List<PengembalianDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PengembalianDetail bd = new PengembalianDetail();

            Pengembalian b = new Pengembalian();
            b.setId(rs.getInt("id_pengembalian"));
            b.setKode(rs.getString("kode_pengembalian"));
            b.setTanggal(rs.getDate("tanggal_pengembalian"));

            Aset ast = new Aset();
            ast.setKode(rs.getString("id_aset"));
            ast.setNama(rs.getString("nama_aset"));
            ast.setQty(rs.getInt("stok_aset"));
            ast.setSatuan(rs.getString("satuan_aset"));

            KategoriAset kb = new KategoriAset();
            kb.setId_kategori(rs.getInt("id_kategori_aset"));
            kb.setKode(rs.getString("kode_ketegori_aset"));
            kb.setNama_kategori(rs.getString("nama_kategori_aset"));

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));

            ast.setKepemilikan(p);
            ast.setKategoriAset(kb);
            b.setUser(u);
            bd.setPengembalian(b);
            bd.setId(rs.getInt("id_pengembalian_detail"));
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_pengembalian"));
            list.add(bd);
        }
        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<PengembalianDetail> findPengembalianDetailByIdAset(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_pengembalian as id_pengembalian, \n"
                + "    b.kode as kode_pengembalian,\n"
                + "    b.pembawa as pembawa_pengembalian,\n"
                + "    b.tanggal as tanggal_pengembalian,\n"
                + "    b.ket as ket_pengembalian,\n"
                + "    bd.id_pengembalian as id_pengembalian_detail,\n"
                + "    bd.qty as jumlah_pengembalian\n"
                + "FROM tb_pengembalian b JOIN tb_pengembalian_detail bd ON (b.id_pengembalian = bd.id_pengembalian)\n"
                + "WHERE  bd.id_aset = ? ";
        List<PengembalianDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PengembalianDetail bd = new PengembalianDetail();

            Pengembalian b = new Pengembalian();
            b.setId(rs.getInt("id_pengembalian"));
            b.setKode(rs.getString("kode_pengembalian"));
            b.setTanggal(rs.getDate("tanggal_pengembalian"));
            b.setKet(rs.getString("ket_pengembalian"));

            bd.setPengembalian(b);
            bd.setQty(rs.getInt("jumlah_pengembalian"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public void deletePengembalianDetail(List<PengembalianDetail> listPengembalian) throws SQLException {
        String sql = "DELETE FROM tb_pengembalian_detail WHERE id_pengembalian = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        for (PengembalianDetail pd : listPengembalian) {
            ps.setInt(1, pd.getPengembalian().getId());
        }
        ps.executeUpdate();
        ps.close();

        sql = "DELETE FROM tb_pengembalian WHERE id_pengembalian = ?";
        connect = ds.getConnection();
        ps = connect.prepareStatement(sql);
        for (PengembalianDetail pd : listPengembalian) {
            ps.setInt(1, pd.getPengembalian().getId());
        }
        ps.executeUpdate();
        ps.close();

        sql = "UPDATE tb_aset SET qty = ? WHERE id_aset = ?";
        ps = connect.prepareStatement(sql);
        for (PengembalianDetail pd : listPengembalian) {
            Aset aset = pd.getAset();
            Integer stokSekarang = aset.getQty();
            ps.setInt(1, stokSekarang - pd.getQty());
            ps.setString(2, aset.getKode());
            ps.addBatch();
        }

        ps.executeBatch();
        ps.clearBatch();
        ps.close();
        connect.close();
    }

    @Override
    public void updateStatusPeminjaman(Pengembalian pengembalian) throws SQLException {
        String sql = "UPDATE tb_peminjaman SET open = ? WHERE id_peminjaman = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setBoolean(1, true);
        ps.setInt(2, pengembalian.getIdPeminjaman());
        ps.executeUpdate();
        ps.close();
        connect.close();
    }

    @Override
    public List<PengembalianDetail> findPengembalianDetailBetweenTanggalByKategoriByKepemilikan(Date awal, Date akhir, String kategori, String kepemilikan) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_pengembalian as id_pengembalian, \n"
                + "    b.kode as kode_pengembalian,\n"
                + "    b.pembawa as pembawa_pengembalian,\n"
                + "    b.tanggal as tanggal_pengembalian,\n"
                + "    b.ket as ket_pengembalian,\n"
                + "    bd.id_pengembalian as id_pengembalian_detail,\n"
                + "    bd.qty as jumlah_pengembalian,\n"
                + "    ast.id_aset as id_aset,\n"
                + "    ast.nama_aset as nama_aset,\n"
                + "    ast.qty as stok_aset,\n"
                + "    ast.satuan as satuan_aset,\n"
                + "    kast.id_kategori as id_kategori_aset,\n"
                + "    kast.kode as kode_ketegori_aset,\n"
                + "    kast.nama_kategori as nama_kategori_aset,\n"
                + "    c.id_kepemilikan as id_kepemilikan,\n"
                + "    c.nama as nama_kepemilikan,\n"
                + "    u.id_user as id_user,\n"
                + "    u.username as username\n"
                + "FROM tb_pengembalian b JOIN tb_pengembalian_detail bd ON (b.id_pengembalian = bd.id_pengembalian)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.tanggal between ? AND ? \n"
                + "AND kast.nama_kategori LIKE ? \n"
                + "AND c.nama LIKE ? ";
        List<PengembalianDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, awal);
        ps.setDate(2, akhir);
        ps.setString(3, kategori);
        ps.setString(4, kepemilikan);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PengembalianDetail bd = new PengembalianDetail();

            Pengembalian b = new Pengembalian();
            b.setId(rs.getInt("id_pengembalian"));
            b.setKode(rs.getString("kode_pengembalian"));
            b.setTanggal(rs.getDate("tanggal_pengembalian"));
            b.setKet(rs.getString("ket_pengembalian"));

            Aset ast = new Aset();
            ast.setKode(rs.getString("id_aset"));
            ast.setNama(rs.getString("nama_aset"));
            ast.setSatuan(rs.getString("satuan_aset"));

            KategoriAset kb = new KategoriAset();
            kb.setId_kategori(rs.getInt("id_kategori_aset"));
            kb.setKode(rs.getString("kode_ketegori_aset"));
            kb.setNama_kategori(rs.getString("nama_kategori_aset"));

            Kepemilikan p = new Kepemilikan();
            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
            p.setNama(rs.getString("nama_kepemilikan"));

            Users u = new Users();
            u.setId_user(rs.getInt("id_user"));
            u.setUsername(rs.getString("username"));

            ast.setKepemilikan(p);
            ast.setKategoriAset(kb);
            b.setUser(u);
            bd.setPengembalian(b);
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_pengembalian"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

}
