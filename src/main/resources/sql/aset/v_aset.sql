/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dhiskar
 * Created: May 21, 2019
 */
-- CREATE VIEW v_aset
-- AS
-- SELECT
--     tb_aset.id_aset as 'kode_aset',
--     tb_aset.nama_aset as 'nama_aset',
--     tb_status.status as 'status_aset',
--     tb_lokasi.nama_rak as 'nama_rak',
--     tb_lokasi.lokasi as 'lokasi_aset',
--     tb_kepemilikan.nama as 'nama_kepemilikan',
--     tb_aset.qty as 'quantity',
--     tb_aset.satuan as 'satuan',
--     users.nama as 'nama_user'
-- FROM
--     tb_aset
-- LEFT JOIN tb_status USING(id_status)
-- LEFT JOIN tb_lokasi USING(id_lokasi)
-- LEFT JOIN tb_kepemilikan USING(id_kepemilikan)
-- LEFT JOIN users USING(id_user)

CREATE VIEW v_aset AS SELECT
    tb_aset.id_aset AS 'kode_aset',
    tb_aset.tanggal AS 'tanggal',
    tb_aset.nama_aset AS 'nama_aset',

    tb_kategori.id_kategori AS 'id_kategori',
    tb_kategori.kode AS 'kode_kategori',
    tb_kategori.nama_kategori as 'nama_kategori',

    tb_status.id_status AS 'id_status',
    tb_status.status AS 'status_aset',

    tb_lokasi.id_lokasi AS 'id_lokasi',
    tb_lokasi.nama_rak AS 'nama_rak',
    tb_lokasi.lokasi AS 'lokasi_aset',

    tb_kepemilikan.id_kepemilikan AS 'id_kepemilikan',
    tb_kepemilikan.nama AS 'nama_kepemilikan',
    tb_kepemilikan.tlp AS 'tlp_kepemilikan',
    tb_kepemilikan.alamat AS 'alamat_kepemilikan',
    tb_kepemilikan.ket AS 'ket_kepemilikan',

    tb_aset.qty AS 'quantity',
    tb_aset.satuan AS 'satuan',

    users.id_user AS 'id_user',
    users.nama AS 'nama_user',
    users.username AS 'username',
    users.password AS 'password',
    users.jabatan AS 'jabatan_user',
    users.status AS 'status_user'
FROM
    tb_aset
LEFT JOIN tb_kategori USING(id_kategori)
LEFT JOIN tb_status USING(id_status)
LEFT JOIN tb_lokasi USING(id_lokasi)
LEFT JOIN tb_kepemilikan USING(id_kepemilikan)
LEFT JOIN users USING(id_user)