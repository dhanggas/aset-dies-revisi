/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Aset;
import aplikasi.entity.KategoriAset;
import aplikasi.entity.Kepemilikan;
import aplikasi.entity.Peminjaman;
import aplikasi.entity.PeminjamanDetail;
import aplikasi.entity.Users;
import aplikasi.repository.RepoPeminjaman;
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
public class ServicePeminjaman implements RepoPeminjaman {

    private final DataSource ds;

    public ServicePeminjaman(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Peminjaman save(Peminjaman p, List<PeminjamanDetail> listPeminjaman) throws SQLException {
        Peminjaman pinjam = save(p);

        String sql = "INSERT INTO tb_peminjaman_detail (id_peminjaman, id_aset, qty) VALUES (?,?,?)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
        for (PeminjamanDetail pd : listPeminjaman) {
            ps.setInt(1, pinjam.getId());
            ps.setString(2, pd.getAset().getKode());
            ps.setInt(3, pd.getQty());
            ps.addBatch();
        }
        ps.executeBatch();
        ps.clearBatch();
        ps.close();

        sql = "UPDATE tb_aset SET qty = ? WHERE id_aset = ?";
        ps = connect.prepareStatement(sql);
        for (PeminjamanDetail pd : listPeminjaman) {
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
        return p;
    }

    @Override
    public List<PeminjamanDetail> findPeminjamanByTglBetween(Date awal, Date akhir) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_peminjaman as id_peminjaman, \n"
                + "    b.kode as kode_peminjaman,\n"
                + "    b.pembawa as pembawa_peminjaman,\n"
                + "    b.tanggal as tanggal_peminjaman,\n"
                + "    b.ket as ket_peminjaman,\n"
                + "    bd.id_peminjaman as id_peminjaman_detail,\n"
                + "    bd.qty as jumlah_peminjaman,\n"
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
                + "FROM tb_peminjaman b JOIN tb_peminjaman_detail bd ON (b.id_peminjaman = bd.id_peminjaman)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.tanggal between ? AND ? ";
        List<PeminjamanDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, awal);
        ps.setDate(2, akhir);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PeminjamanDetail bd = new PeminjamanDetail();

            Peminjaman b = new Peminjaman();
            b.setId(rs.getInt("id_peminjaman"));
            b.setKode(rs.getString("kode_peminjaman"));
            b.setTanggal(rs.getDate("tanggal_peminjaman"));
            b.setKet(rs.getString("ket_peminjaman"));

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
            bd.setPeminjaman(b);
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_peminjaman"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<PeminjamanDetail> findPeminjamanDetailByPeminjamanKode(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_peminjaman as id_peminjaman, \n"
                + "    b.kode as kode_peminjaman,\n"
                + "    b.pembawa as pembawa_peminjaman,\n"
                + "    b.tanggal as tanggal_peminjaman,\n"
                + "    b.ket as ket_peminjaman,\n"
                + "    bd.id_peminjaman as id_peminjaman_detail,\n"
                + "    bd.qty as jumlah_peminjaman,\n"
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
                + "FROM tb_peminjaman b JOIN tb_peminjaman_detail bd ON (b.id_peminjaman = bd.id_peminjaman)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE b.kode = ?";
        List<PeminjamanDetail> list = new ArrayList<>();
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PeminjamanDetail bd = new PeminjamanDetail();

            Peminjaman b = new Peminjaman();
            b.setId(rs.getInt("id_peminjaman"));
            b.setKode(rs.getString("kode_peminjaman"));
            b.setTanggal(rs.getDate("tanggal_peminjaman"));
            b.setKet(rs.getString("ket_peminjaman"));

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
            bd.setId(rs.getInt("id_peminjaman_detail"));
            bd.setQty(rs.getInt("jumlah_peminjaman"));
            bd.setPeminjaman(b);
            bd.setAset(ast);
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<PeminjamanDetail> findPeminjamanDetailByTanggalLowerThen(Date tgl) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_peminjaman as id_peminjaman, \n"
                + "    b.kode as kode_peminjaman,\n"
                + "    b.pembawa as pembawa_peminjaman,\n"
                + "    b.tanggal as tanggal_peminjaman,\n"
                + "    b.ket as ket_peminjaman,\n"
                + "    bd.id_peminjaman as id_peminjaman_detail,\n"
                + "    bd.qty as jumlah_peminjaman,\n"
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
                + "FROM tb_peminjaman b JOIN tb_peminjaman_detail bd ON (b.id_peminjaman = bd.id_peminjaman)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.tanggal < ? ";
        List<PeminjamanDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, tgl);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PeminjamanDetail bd = new PeminjamanDetail();

            Peminjaman b = new Peminjaman();
            b.setId(rs.getInt("id_peminjaman"));
            b.setKode(rs.getString("kode_peminjaman"));
            b.setTanggal(rs.getDate("tanggal_peminjaman"));
            b.setKet(rs.getString("ket_peminjaman"));

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
            bd.setPeminjaman(b);
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_peminjaman"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Peminjaman findByPelangganOrderByTanggalAscLastTransaction(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PeminjamanDetail> findPeminjamanDetailByPelangganKode(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Peminjaman save(Peminjaman value) throws SQLException {
        String sql = "INSERT INTO tb_peminjaman (kode, pembawa, tanggal, ket, id_user) VALUES (?,?,?,?,?)";
        Connection connect = ds.getConnection();

        PreparedStatement ps = connect.prepareStatement(sql);
//        ps.setInt(1, value.getId());
        ps.setString(1, value.getKode());
        ps.setString(2, value.getPembawa());
        ps.setDate(3, (Date) value.getTanggal());
        ps.setString(4, value.getKet());
        ps.setInt(5, value.getUser().getId_user());

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
    public Peminjaman update(Peminjaman value) throws SQLException {
        String sql = "UPDATE tb_peminjaman SET  = ? WHERE id_peminjaman = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setBoolean(1, value.isOpen());
        ps.setInt(2, value.getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<Peminjaman> findAll() throws SQLException {
        String sql = "SELECT p.id_peminjaman,"
                + "p.kode,"
                + "p.pembawa,"
                + "p.tanggal,"
                + "p.ket,"
                + "p.open,"
                + "u.id_user,"
                + "u.nama,"
                + "u.username,"
                + "u.password,"
                + "u.jabatan,"
                + "u.status, "
                + "p.approval "
                + "FROM tb_peminjaman p JOIN users u ON (p.id_user = u.id_user)";
        Connection connect = ds.getConnection();
        List<Peminjaman> list = new ArrayList<>();
        PreparedStatement ps = connect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Peminjaman j = new Peminjaman();
            j.setId(rs.getInt("id_peminjaman"));
            j.setKode(rs.getString("kode"));
            j.setPembawa(rs.getString("pembawa"));
            j.setTanggal(rs.getDate("tanggal"));
            j.setKet(rs.getString("ket"));
            j.setOpen(rs.getBoolean("open"));
            j.setApproval(rs.getString("approval"));

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
    public Peminjaman findOne(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
    }

    @Override
    public List<Peminjaman> findMaxValue() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PeminjamanDetail> findPeminjamanDetailFilter(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_peminjaman as id_peminjaman, \n"
                + "    b.kode as kode_peminjaman,\n"
                + "    b.pembawa as pembawa_peminjaman,\n"
                + "    b.tanggal as tanggal_peminjaman,\n"
                + "    b.ket as ket_peminjaman,\n"
                + "    bd.id as id_peminjaman_detail,\n"
                + "    bd.qty as jumlah_peminjaman,\n"
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
                + "FROM tb_peminjaman b JOIN tb_peminjaman_detail bd ON (b.id_peminjaman = bd.id_peminjaman)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.kode like CONCAT('%', ?, '%')";
        List<PeminjamanDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PeminjamanDetail bd = new PeminjamanDetail();

            Peminjaman b = new Peminjaman();
            b.setId(rs.getInt("id_peminjaman"));
            b.setKode(rs.getString("kode_peminjaman"));
            b.setTanggal(rs.getDate("tanggal_peminjaman"));
            b.setKet(rs.getString("ket_peminjaman"));

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
            bd.setPeminjaman(b);
            bd.setId(rs.getInt("id_peminjaman_detail"));
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_peminjaman"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<Peminjaman> findPeminjamanByTanggal(Date tgl) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_peminjaman as id_peminjaman, \n"
                + "    b.kode as kode_peminjaman,\n"
                + "    b.pembawa as pembawa_peminjaman,\n"
                + "    b.tanggal as tanggal_peminjaman,\n"
                + "    b.ket as ket_peminjaman\n"
                //                + "    bd.id_peminjaman as id_peminjaman_detail,\n"
                //                + "    bd.qty as jumlah_peminjaman,\n"
                //                + "    ast.id_aset as id_aset,\n"
                //                + "    ast.nama_aset as nama_aset,\n"
                //                + "    ast.qty as stok_aset,\n"
                //                + "    ast.satuan as satuan_aset,\n"
                //                + "    kast.id_kategori as id_kategori_aset,\n"
                //                + "    kast.kode as kode_ketegori_aset,\n"
                //                + "    kast.nama_kategori as nama_kategori_aset,\n"
                //                + "    c.id_kepemilikan as id_kepemilikan,\n"
                //                + "    c.nama as nama_kepemilikan,\n"
                //                + "    u.id_user as id_user,\n"
                //                + "    u.username as username\n"
                //                + "FROM tb_peminjaman b JOIN tb_peminjaman_detail bd ON (b.id_peminjaman = bd.id_peminjaman)\n"
                //                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                //                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                //                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                //                + "    JOIN users u ON (u.id_user = b.id_user)\n"

                + "FROM tb_peminjaman b \n"
                + "WHERE b.tanggal = ? ";
        List<Peminjaman> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, tgl);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PeminjamanDetail bd = new PeminjamanDetail();

            Peminjaman b = new Peminjaman();
            b.setId(rs.getInt("id_peminjaman"));
            b.setKode(rs.getString("kode_peminjaman"));
            b.setTanggal(rs.getDate("tanggal_peminjaman"));
            b.setKet(rs.getString("ket_peminjaman"));

//            Aset ast = new Aset();
//            ast.setKode(rs.getString("id_aset"));
//            ast.setNama(rs.getString("nama_aset"));
//            ast.setSatuan(rs.getString("satuan_aset"));
//
//            KategoriAset kb = new KategoriAset();
//            kb.setId_kategori(rs.getInt("id_kategori_aset"));
//            kb.setKode(rs.getString("kode_ketegori_aset"));
//            kb.setNama_kategori(rs.getString("nama_kategori_aset"));
//
//            Kepemilikan p = new Kepemilikan();
//            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
//            p.setNama(rs.getString("nama_kepemilikan"));
//
//            Users u = new Users();
//            u.setId_user(rs.getInt("id_user"));
//            u.setUsername(rs.getString("username"));
//
//            ast.setKepemilikan(p);
//            ast.setKategoriAset(kb);
//            b.setUser(u);
//            bd.setPeminjaman(b);
//            bd.setAset(ast);
//            bd.setQty(rs.getInt("jumlah_peminjaman"));
            list.add(b);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<PeminjamanDetail> findPeminjamanDetailByIdAset(String kode) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_peminjaman as id_peminjaman, \n"
                + "    b.kode as kode_peminjaman,\n"
                + "    b.pembawa as pembawa_peminjaman,\n"
                + "    b.tanggal as tanggal_peminjaman,\n"
                + "    b.ket as ket_peminjaman,\n"
                + "    bd.id_peminjaman as id_peminjaman_detail,\n"
                + "    bd.qty as jumlah_peminjaman\n"
                + "FROM tb_peminjaman b JOIN tb_peminjaman_detail bd ON (b.id_peminjaman = bd.id_peminjaman)\n"
                + "WHERE bd.id_aset = ? ";
        List<PeminjamanDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PeminjamanDetail bd = new PeminjamanDetail();

            Peminjaman b = new Peminjaman();
            b.setId(rs.getInt("id_peminjaman"));
            b.setKode(rs.getString("kode_peminjaman"));
            b.setTanggal(rs.getDate("tanggal_peminjaman"));
            b.setKet(rs.getString("ket_peminjaman"));

            bd.setPeminjaman(b);
            bd.setQty(rs.getInt("jumlah_peminjaman"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public void deletePeminjamanDetail(List<PeminjamanDetail> listPeminjaman) throws SQLException {
        String sql = "DELETE FROM tb_peminjaman_detail WHERE id_peminjaman = ?";
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        for (PeminjamanDetail pd : listPeminjaman) {
            ps.setInt(1, pd.getPeminjaman().getId());
        }
        ps.executeUpdate();
        ps.close();

        sql = "DELETE FROM tb_peminjaman WHERE id_peminjaman = ?";
        connect = ds.getConnection();
        ps = connect.prepareStatement(sql);
        for (PeminjamanDetail pd : listPeminjaman) {
            ps.setInt(1, pd.getPeminjaman().getId());
        }
        ps.executeUpdate();
        ps.close();

        sql = "UPDATE tb_aset SET qty = ? WHERE id_aset = ?";
        ps = connect.prepareStatement(sql);
        for (PeminjamanDetail pd : listPeminjaman) {
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
    }

    @Override
    public List<Peminjaman> findPeminjamanByStatus() throws SQLException {
        String sql = "SELECT \n"
                + "    j.id_peminjaman as id_peminjaman,\n"
                + "    j.kode as kode_peminjaman,\n"
                + "    j.pembawa as pembawa,\n"
                + "    j.tanggal as tanggal_peminjaman,"
                + "     j.open as open_peminjaman, "
                + "     j.ket as ket_peminjaman \n"
                + "FROM tb_peminjaman j "
                + "where j.open = ?";
        Connection connect = ds.getConnection();
        List<Peminjaman> list = new ArrayList<>();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setBoolean(1, true);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Peminjaman j = new Peminjaman();
            j.setId(rs.getInt("id_peminjaman"));
            j.setKode(rs.getString("kode_peminjaman"));
            j.setPembawa(rs.getString("pembawa"));
            j.setTanggal(rs.getDate("tanggal_peminjaman"));
            j.setOpen(rs.getBoolean("open_peminjaman"));
            j.setKet(rs.getString("ket_peminjaman"));

            list.add(j);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<PeminjamanDetail> findPeminjamanByTglBetweenByKategoriByKepemilikan(Date awal, Date akhir, String kategori, String kepemilikan) throws SQLException {
        String sql = "SELECT \n"
                + "    b.id_peminjaman as id_peminjaman, \n"
                + "    b.kode as kode_peminjaman,\n"
                + "    b.pembawa as pembawa_peminjaman,\n"
                + "    b.tanggal as tanggal_peminjaman,\n"
                + "    b.ket as ket_peminjaman,\n"
                + "    bd.id_peminjaman as id_peminjaman_detail,\n"
                + "    bd.qty as jumlah_peminjaman,\n"
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
                + "FROM tb_peminjaman b JOIN tb_peminjaman_detail bd ON (b.id_peminjaman = bd.id_peminjaman)\n"
                + "    JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)\n"
                + "    JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)\n"
                + "    JOIN tb_kepemilikan c ON (c.id_kepemilikan = ast.id_kepemilikan)\n"
                + "    JOIN users u ON (u.id_user = b.id_user)\n"
                + "WHERE  b.tanggal between ? AND ? \n"
                + "AND kast.nama_kategori LIKE ? \n"
                + "AND c.nama LIKE ? ";
        List<PeminjamanDetail> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, awal);
        ps.setDate(2, akhir);
        ps.setString(3, kategori);
        ps.setString(4, kepemilikan);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PeminjamanDetail bd = new PeminjamanDetail();

            Peminjaman b = new Peminjaman();
            b.setId(rs.getInt("id_peminjaman"));
            b.setKode(rs.getString("kode_peminjaman"));
            b.setTanggal(rs.getDate("tanggal_peminjaman"));
            b.setKet(rs.getString("ket_peminjaman"));

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
            bd.setPeminjaman(b);
            bd.setAset(ast);
            bd.setQty(rs.getInt("jumlah_peminjaman"));
            list.add(bd);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Peminjaman updateApproval(Peminjaman p) throws SQLException {
        String sql = "UPDATE tb_peminjaman SET approval = ? WHERE id_peminjaman = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, p.getApproval());
        ps.setInt(2, p.getId());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return p;
    }

    @Override
    public void updatePeminjamanDetail(List<PeminjamanDetail> listPeminjaman) throws SQLException {
//        String sql = "DELETE FROM tb_peminjaman_detail WHERE id_peminjaman = ?";
        Connection connect = ds.getConnection();
//        for (PeminjamanDetail pd : listPeminjaman) {
//            ps.setInt(1, pd.getPeminjaman().getId());
//        }
//        ps.executeUpdate();
//        ps.close();

        String sql = "UPDATE tb_peminjaman SET approval = ? WHERE id_peminjaman = ?";
        connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        for (PeminjamanDetail pd : listPeminjaman) {
            ps.setString(1, "Ditolak");
            ps.setInt(2, pd.getPeminjaman().getId());
        }
        ps.executeUpdate();
        ps.close();

        sql = "UPDATE tb_aset SET qty = ? WHERE id_aset = ?";
        ps = connect.prepareStatement(sql);
        for (PeminjamanDetail pd : listPeminjaman) {
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
    }

}
