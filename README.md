# ASET DIES SORAYA-APLIKASI

![ASET DIES SORAYA-APLIKASI](/imgs/aset_dies.jpg)

## Hal yang harus dilakukan

* Install Java Runtime Environment
* Install Database [MySQL]
* Extract ASET DIES SORAYA-APLIKASI
* Membuat launcher
* Jalankan aplikasi

## Install Java Runtime Environment (JRE)

* Pastikan laptop / pc sudah terintal Java

## Install Database Mysql

* Pastikan sudah menginstal data base mySQL, disini saya menggunakan XAMPP
* Aplikasi saya set menggunakan password muntuk terkoneksi dengan database, Setting Password root ```hacked17.``` 

## Import SQL file ke MySQL database

* Membuat database dengan nama ```dbaset```
* kemudian kita import filenya ke database dbaset dalam MySQL
* caranya kita login dulu ke user ```root``` dan pilih database ```dbaset2```
* pada tap import pilih \aset-dies-revisi\src\main\resources\sql\dbaset.sql kemudian klik go
* Setelah itu kita check sql yg telah dibuat dengan perintah sebagai berikut:
maka hasilnya seperti berikut

```bash
MariaDB [dbaset]> show tables;
+------------------------+
| Tables_in_dbaset       |
+------------------------+
| tb_aset                |
| tb_kategori            |
| tb_kepemilikan         |
| tb_lokasi              |
| tb_peminjaman          |
| tb_peminjaman_detail   |
| tb_pengembalian        |
| tb_pengembalian_detail |
| tb_status              |
| users                  |
| v_aset                 |
| v_penambahan_detail    |
+------------------------+
12 rows in set (0.00 sec)
```

* Untuk menjalankan sebenarnya ada banyak cara yaitu menggunakan terminal atau command prompt dan menggunakan cara biasa yaitu double klik (klik 2x)
* Lokasi file ada di \aset-dies-c\target

### Menggunakan terminal atau command promnt

* peraintah dasar

```bash
java -jar aset-dies-soraya-in-1.0-jar-with-dependencies.jar
```

### Menggunakan double click (klik 2x)

* Klik kanan ```aset-dies-soraya-in-1.0-jar-with-dependencies.jar``` -> Open with -> Java (TM) Platform SE Binary


### Username dan Password pilih salah satu pengguna / user

```bash
MariaDB [dbaset]> show tables;
+---------+---------------+----------+----------+---------+--------+
| id_user | nama          | username | password | jabatan | status |
+---------+---------------+----------+----------+---------+--------+
|       1 | Dhiskar       | dhiskar  | Admin1   | Kepala  |      1 |
|       2 | Panji         | panji    | Gudang1  | Gudang  |      1 |
|       3 | Jepy          | jepy     | Kasir1   | Kasir   |      1 |
|       4 | Toni Saputraa | toni     | Admin2   | Admin   |      1 |
+---------+---------------+----------+----------+---------+--------+
4 rows in set (0.00 sec)
```