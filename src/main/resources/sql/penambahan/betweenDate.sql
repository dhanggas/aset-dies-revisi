/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  laptop
 * Created: Jun 4, 2019
 */

SELECT 
                b.id_penambahan as id_penambahan, 
                b.kode as kode_penambahan,
                b.pembawa as pembawa_penambahan,
                b.tanggal as tanggal_penambahan,

                bd.id_penambahan as id_penambahan_detail,
                bd.qty as jumlah_penambahan,
                
                ast.id_aset as id_aset,
                ast.nama_aset as nama_aset,
                ast.qty as stok_aset,
                ast.satuan as satuan_aset,
                
                kast.id_kategori as id_kategori_aset,
                kast.kode as kode_ketegori_aset,
                kast.nama_kategori as nama_kategori_aset
                
               FROM tb_penambahan b JOIN tb_penambahan_detail bd ON (b.id_penambahan = bd.id_penambahan)
               JOIN tb_aset ast ON (bd.id_aset = ast.id_aset)
               JOIN tb_kategori kast ON (kast.id_kategori = ast.id_kategori)
               WHERE b.tanggal between 12/12/18 AND 12/12/19