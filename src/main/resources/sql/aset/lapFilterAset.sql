/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  laptop
 * Created: Jun 6, 2019
 */

SELECT * FROM `v_aset` WHERE 
`nama_aset` LIKE "%%"
AND `nama_kategori` LIKE "%ben%"
AND `status_aset` LIKE "%%"
AND `nama_rak` LIKE "%%"
AND `lokasi_aset` LIKE "%%"
AND `nama_customer`LIKE "%%"
AND `username` LIKE "%%"