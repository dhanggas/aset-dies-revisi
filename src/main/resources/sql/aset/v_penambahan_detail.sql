/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  laptop
 * Created: Jun 7, 2019
 */

CREATE VIEW v_penambahan_detail AS SELECT
    b.id_penambahan AS id_penambahan,
    b.kode AS kode_penambahan,
    b.pembawa AS pembawa,
    b.tanggal AS tanggal_penambahan,
    b.ket AS ket_penambahan,

    u.id_user AS id_user,
    u.nama as nama_user,
    u.username as username,
    
    bd.id AS id_penambahan_detail,
    bd.qty AS jumlah_penambahan,
    
    ast.id_aset AS id_aset,
    ast.nama_aset AS nama_aset,
    ast.satuan AS satuan_aset,
       
    kast.id_kategori AS id_kategori_aset,
    kast.kode AS kode_ketegori_aset,
    kast.nama_kategori AS nama_kategori_aset,
    
    s.id_status AS id_status_aset,
    s.status AS status_aset,
    
    l.id_lokasi AS id_lokasi_aset,
    l.nama_rak as nama_rak,
    l.lokasi AS lokasi_aset,
    
    c.id_kepemilikan AS id_kepemilikan,
    c.nama AS nama_kepemilikan,
    c.tlp AS tlp_kepemilikan,
    c.alamat AS alamat_kepemilikan
FROM
    tb_penambahan b
JOIN tb_penambahan_detail bd ON
    (b.id_penambahan = bd.id_penambahan)
JOIN users u ON
    (u.id_user = b.id_user)
JOIN tb_aset ast ON
    (bd.id_aset = ast.id_aset)
JOIN tb_kategori kast ON
    (kast.id_kategori = ast.id_kategori)
JOIN tb_status s ON
    (s.id_status = ast.id_status)
JOIN tb_lokasi l ON
    (l.id_lokasi = ast.id_lokasi)
JOIN tb_kepemilikan c ON
    (c.id_kepemilikan = ast.id_kepemilikan)