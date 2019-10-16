-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 16, 2019 at 10:50 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbaset2`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_aset`
--

CREATE TABLE IF NOT EXISTS `tb_aset` (
  `id_aset` varchar(10) NOT NULL,
  `nama_aset` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `id_kategori` int(3) NOT NULL,
  `id_status` int(3) NOT NULL,
  `id_lokasi` int(3) NOT NULL,
  `id_kepemilikan` int(3) NOT NULL,
  `qty` int(1) NOT NULL DEFAULT '1',
  `satuan` varchar(30) NOT NULL,
  `id_user` int(3) NOT NULL,
  PRIMARY KEY (`id_aset`),
  KEY `fk_aset_kategori` (`id_kategori`) USING BTREE,
  KEY `fk_aset_status` (`id_status`) USING BTREE,
  KEY `fk_aset_lokasi` (`id_lokasi`) USING BTREE,
  KEY `fk_aset_customer` (`id_kepemilikan`) USING BTREE,
  KEY `fk_aset_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_aset`
--

INSERT INTO `tb_aset` (`id_aset`, `nama_aset`, `tanggal`, `id_kategori`, `id_status`, `id_lokasi`, `id_kepemilikan`, `qty`, `satuan`, `id_user`) VALUES
('MD-0001', 'RING PLATE 21 - 11086-0', '2019-10-15', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0002', 'RING PLATE 21 - 12138-0', '2019-10-15', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0003', 'RING PLATE 28 - 19801-0', '2019-10-15', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0004', 'RING PLATE 28 - 19801-0', '2019-10-15', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0005', 'RING PLATE 21 - 10000-0', '2019-10-15', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0006', 'RETAINER 45932 - 370', '2019-10-15', 25, 2, 3, 6, 1, 'UNIT', 1),
('MD-0007', 'INNER BUSH 47901-432', '2019-10-15', 10, 3, 33, 6, 1, 'UNIT', 4),
('MD-0008', 'MOULD DIES DUST COVER 76 - T5731 - 60', '2019-10-15', 25, 2, 33, 6, 1, 'UNIT', 1),
('MD-0009', 'MOULD DIES DUST COVER 76 - T5731 - 60', '2019-10-15', 2, 2, 33, 6, 1, 'UNIT', 1),
('MD-0010', 'MOULD DIES DUST COVER 76 - T5731 - 60', '2019-10-15', 3, 2, 33, 6, 1, 'UNIT', 1),
('MD-0011', 'MOULD DIES DUST COVER 76 - T5735 - 60', '2019-10-15', 25, 2, 33, 6, 1, 'UNIT', 1),
('MD-0012', 'MOULD DIES DUST COVER 76 - T5735 - 60', '2019-10-15', 2, 2, 33, 6, 1, 'UNIT', 1),
('MD-0013', 'MOULD DIES DUST COVER 76 - T5735 - 60', '2019-10-15', 3, 2, 33, 6, 1, 'UNIT', 1),
('MD-0014', 'RING PLATE 21 - 10008', '2019-10-15', 24, 3, 3, 6, 1, 'UNIT', 1),
('MD-0015', 'OUTNER BUSH', '2019-10-15', 25, 1, 33, 6, 1, 'UNIT', 1),
('MD-0016', 'INNER BUSH', '2019-10-14', 25, 1, 33, 6, 1, 'UNIT', 4),
('MD-0017', 'METAL INSERT 15.5 MM SINGLE', '2019-10-15', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0018', 'METAL INSERT 20.5 MM SINGLE', '2019-10-15', 25, 2, 3, 4, 1, 'UNIT', 1),
('MD-0019', 'METAL INSERT 22 MM SINGLE', '2019-10-15', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0020', 'METAL INSERT 26 MM', '2019-10-15', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0021', 'METAL INSERT 30 MM B', '2019-10-15', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0022', 'METAL INSERT 34 MM SINGLE A', '2019-10-15', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0023', 'METAL INSERT 34 MM SINGLE C', '2019-10-15', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0024', 'METAL INSERT 37 MM SINGLE A', '2019-10-15', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0025', 'METAL INSERT 37 MM NEW', '2019-10-15', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0026', 'METAL INSERT 36 MM SINGLE', '2019-10-15', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0027', 'METAL INSERT  34 MM EMBOSH', '2019-10-15', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0028', 'METAL INSERT 20.5 MM 2IN1 A', '2019-10-15', 25, 2, 4, 4, 1, 'UNIT', 1),
('MD-0029', 'METAL INSERT 20.5 MM 2IN1 B', '2019-10-15', 25, 2, 4, 4, 1, 'UNIT', 1),
('MD-0030', 'METAL INSERT 34 MM 2IN1 A', '2019-10-15', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0031', 'METAL INSERT 34 MM 2IN1 B', '2019-10-15', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0032', 'METAL INSERT 34 MM 2IN1 C', '2019-10-15', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0033', 'METAL INSERT 36 MM 2IN1', '2019-10-15', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0034', 'TH 112', '2019-10-15', 7, 2, 5, 4, 1, 'UNIT', 1),
('MD-0035', 'TH 113', '2019-10-15', 7, 2, 5, 4, 1, 'UNIT', 1),
('MD-0036', 'TH 114', '2019-10-15', 7, 2, 33, 4, 1, 'UNIT', 1),
('MD-0037', 'MK 04', '2019-10-15', 7, 2, 33, 4, 1, 'UNIT', 1),
('MD-0038', 'MK 009 A', '2019-10-15', 7, 2, 5, 4, 1, 'UNIT', 1),
('MD-0039', 'MK 009 B', '2019-10-15', 25, 2, 22, 4, 1, 'UNIT', 1),
('MD-0040', 'BACK DOOR STOPPER', '2019-10-15', 5, 1, 6, 4, 1, 'UNIT', 1),
('MD-0041', 'BACK DOOR STOPPER', '2019-10-15', 12, 1, 6, 4, 1, 'UNIT', 1),
('MD-0042', 'BACK DOOR STOPPER', '2019-10-15', 13, 1, 6, 4, 1, 'UNIT', 1),
('MD-0043', 'BACK DOOR STOPPER', '2019-10-15', 28, 1, 6, 4, 1, 'UNIT', 1),
('MD-0044', 'BACK DOOR STOPPER', '2019-10-15', 1, 1, 6, 4, 1, 'UNIT', 1),
('MD-0045', 'BACK DOOR STOPPER', '2019-10-15', 17, 1, 6, 4, 1, 'UNIT', 1),
('MD-0046', 'RETAINER SHIFT', '2019-10-15', 21, 2, 23, 4, 1, 'UNIT', 1),
('MD-0047', 'RETAINER SHIFT', '2019-10-15', 10, 2, 23, 4, 1, 'UNIT', 1),
('MD-0048', 'RETAINER SHIFT', '2019-10-15', 5, 2, 23, 4, 1, 'UNIT', 1),
('MD-0049', 'PACKING GUIDE 17863', '2019-10-15', 24, 2, 15, 11, 1, 'UNIT', 1),
('MD-0050', 'PACKING GUIDE 17863', '2019-10-15', 15, 2, 15, 11, 1, 'UNIT', 1),
('MD-0051', 'WASHER 72001', '2019-10-15', 7, 2, 14, 11, 1, 'UNIT', 1),
('MD-0052', 'COVER FLANGE S 71044', '2019-10-15', 5, 2, 16, 11, 1, 'UNIT', 1),
('MD-0053', 'COVER FLANGE S 71044', '2019-10-15', 10, 2, 17, 11, 1, 'UNIT', 1),
('MD-0054', 'COVER FLANGE S 71044', '2019-10-15', 21, 2, 17, 11, 1, 'UNIT', 1),
('MD-0055', 'COVER S71053', '2019-10-15', 5, 2, 13, 11, 1, 'UNIT', 1),
('MD-0056', 'COVER S71053', '2019-10-15', 10, 2, 13, 11, 1, 'UNIT', 1),
('MD-0057', 'COVER S71053', '2019-10-15', 21, 2, 13, 11, 1, 'UNIT', 1),
('MD-0058', 'COVER S71054', '2019-10-15', 21, 2, 13, 11, 1, 'UNIT', 1),
('MD-0059', 'COVER S71058', '2019-10-15', 21, 2, 13, 11, 1, 'UNIT', 1),
('MD-0060', 'WASHER 72063', '2019-10-15', 24, 2, 16, 11, 1, 'UNIT', 1),
('MD-0061', 'COVER S74007-0', '2019-10-15', 29, 2, 15, 11, 1, 'UNIT', 1),
('MD-0062', 'COVER S74007-1', '2019-10-15', 29, 2, 15, 11, 1, 'UNIT', 1),
('MD-0063', 'COVER S74007-4', '2019-10-15', 29, 2, 15, 11, 1, 'UNIT', 1),
('MD-0064', 'COVER S74007-0-1', '2019-10-15', 8, 2, 15, 11, 1, 'UNIT', 1),
('MD-0065', 'COVER S74007-4', '2019-10-15', 8, 2, 15, 11, 1, 'UNIT', 1),
('MD-0066', 'COVER S74017', '2019-10-15', 29, 2, 14, 11, 1, 'UNIT', 1),
('MD-0067', 'COVER S74017', '2019-10-15', 1, 2, 14, 11, 1, 'UNIT', 1),
('MD-0068', 'COVER S74017', '2019-10-15', 8, 2, 14, 11, 1, 'UNIT', 1),
('MD-0069', 'BRACKET S81009', '2019-10-15', 5, 2, 14, 11, 1, 'UNIT', 1),
('MD-0070', 'BRACKET S81009', '2019-10-15', 1, 2, 14, 11, 1, 'UNIT', 1),
('MD-0071', 'BRACKET S81018', '2019-10-15', 24, 2, 14, 11, 1, 'UNIT', 1),
('MD-0072', 'BRACKET S81018', '2019-10-15', 1, 2, 14, 11, 1, 'UNIT', 1),
('MD-0073', 'WASHER S72006R', '2019-10-15', 24, 3, 30, 11, 1, 'UNIT', 1),
('MD-0074', 'WASHER S72006-1R', '2019-10-15', 24, 3, 18, 11, 1, 'UNIT', 1),
('MD-0075', 'WASHER S72067R', '2019-10-15', 24, 3, 18, 11, 1, 'UNIT', 1),
('MD-0079', 'COVER S71055-3', '2019-10-15', 5, 2, 16, 11, 1, 'UNIT', 1),
('MD-0080', 'COVER 71076', '2019-10-15', 24, 2, 17, 11, 1, 'UNIT', 1),
('MD-0081', 'TANK LID EP NIKKO 812EP80HN2T2', '2019-10-15', 21, 1, 9, 14, 1, 'UNIT', 1),
('MD-0082', 'TANK LID LP 60', '2019-10-15', 21, 2, 9, 14, 1, 'UNIT', 1),
('MD-0083', 'COVER PLATE 812AP60NC0', '2019-10-15', 7, 2, 9, 14, 1, 'UNIT', 1),
('MD-0084', 'COVER PLATE 812AP120NCO, AP80HC0', '2019-10-15', 21, 2, 9, 14, 1, 'UNIT', 1),
('MD-0085', 'TANK LID 812AP80WT0 , EP80HN2T3, 812EP120E2T2', '2019-10-15', 5, 2, 9, 14, 1, 'UNIT', 1),
('MD-0086', 'TANK LID 812EP120E2T2', '2019-10-15', 21, 2, 19, 14, 1, 'UNIT', 1),
('MD-0087', 'COVER PLATE 812AP120C0', '2019-10-15', 5, 2, 19, 14, 1, 'UNIT', 1),
('MD-0088', 'COVER PLATE AP 120 812MP100WYCOAY', '2019-10-15', 21, 2, 19, 14, 1, 'UNIT', 1),
('MD-0089', 'TANK LID LP LP 100, LP 60, LP 150', '2019-10-15', 5, 2, 20, 14, 1, 'UNIT', 1),
('MD-0090', 'TANK LID LP100, LP60', '2019-10-15', 21, 2, 20, 14, 1, 'UNIT', 1),
('MD-0091', 'TANK LID  812LP150N0', '2019-10-15', 21, 2, 20, 14, 1, 'UNIT', 1),
('MD-0092', 'COVER PLATE 812AP30C0, 60C0, 60C1,30COUL, 60COUL', '2019-10-15', 7, 2, 20, 14, 1, 'UNIT', 1),
('MD-0093', 'TANK LID  812AP30T0', '2019-10-15', 5, 2, 20, 14, 1, 'UNIT', 1),
('MD-0094', 'SOFT PEDAL LEVER NC00022669', '2019-10-15', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0095', 'LOUD PEDAL LEVER 116 / 121', '2019-10-15', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0096', 'LOUD PEDAL LEVER 116 / 121', '2019-10-15', 18, 2, 7, 12, 1, 'UNIT', 1),
('MD-0097', 'LOUD PEDAL LEVER 116 / 121', '2019-10-15', 23, 2, 7, 12, 1, 'UNIT', 1),
('MD-0098', 'LOUD PEDAL LEVER 116 / 121', '2019-10-15', 1, 2, 7, 12, 1, 'UNIT', 1),
('MD-0099', 'MUSIC ROCK SUPPORT HINGE', '2019-10-15', 25, 2, 33, 12, 1, 'UNIT', 1),
('MD-0100', 'SOFT PEDAL LEVER UP 121', '2019-10-15', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0101', 'LOUD PEDAL LEVER UP 116', '2019-10-15', 23, 2, 7, 12, 1, 'UNIT', 1),
('MD-0102', 'SOFT PEDAL LEVER UP 116', '2019-10-15', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0103', 'PUNCHING PLATE 5D9-E4450-00-30', '2019-10-15', 25, 2, 25, 13, 1, 'UNIT', 1),
('MD-0104', 'PUNCHING PLATE 5D9-E4450-00-30', '2019-10-15', 7, 2, 25, 13, 1, 'UNIT', 1),
('MD-0105', 'PUNCHING PLATE 54P-E4450-K01', '2019-10-15', 25, 2, 25, 13, 1, 'UNIT', 1),
('MD-0106', 'PUNCHING PLATE 54P-E4450-K01', '2019-10-15', 7, 2, 25, 13, 1, 'UNIT', 1),
('MD-0107', 'PLATE 1 11029-0724D-K01', '2019-10-15', 7, 2, 34, 13, 1, 'UNIT', 1),
('MD-0108', 'PLATE 2 11029-0724D-K04', '2019-10-15', 7, 2, 25, 13, 1, 'UNIT', 1),
('MD-0109', 'PUNCHING PLATE 52B-E4450-00-B', '2019-10-15', 25, 2, 26, 13, 1, 'UNIT', 1),
('MD-0110', 'PUNCHING PLATE 52B-E4450-00-B', '2019-10-15', 7, 2, 26, 13, 1, 'UNIT', 1),
('MD-0111', 'PUNCHING PLATE 11029-0724D-K02', '2019-10-15', 7, 2, 34, 13, 1, 'UNIT', 1),
('MD-0112', 'WASHER GP 7', '2019-10-15', 7, 2, 26, 13, 1, 'UNIT', 1),
('MD-0113', 'BINDER 11029-0724D-K03', '2019-10-15', 1, 3, 26, 13, 1, 'UNIT', 1),
('MD-0114', 'BINDER 11029-0724D-K03', '2019-10-15', 9, 3, 26, 13, 1, 'UNIT', 1),
('MD-0115', 'PUNCHING PLATE B74-E4451-00-30', '2019-10-15', 7, 2, 36, 13, 1, 'UNIT', 1),
('MD-0116', 'PUNCHING PLATE B65-E4451-K01', '2019-10-15', 7, 2, 36, 13, 1, 'UNIT', 4),
('MD-0117', 'PUNCHING PLATE B65-E4451-K01', '2019-10-15', 25, 2, 36, 13, 1, 'UNIT', 4),
('MD-0118', 'PUNCHING PLATE 53P-E4450-00-1-30', '2019-10-15', 25, 1, 33, 13, 1, 'UNIT', 1),
('MD-0119', 'PUNCHING PLATE 53P-E4450-00-1-30', '2019-10-15', 7, 1, 33, 13, 1, 'UNIT', 1),
('MD-0120', 'CN PLATE  C860 51  00Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0121', 'CN PLATE  C860 51  00Q999', '2019-10-15', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0122', 'CN PLATE  C390 05  00Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0123', 'CN PLATE  C390 05  00Q999', '2019-10-15', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0124', 'CN PLATE C137 05 00Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0125', 'CN PLATE C137 05 00Q999', '2019-10-15', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0126', 'CN PLATE C511 05 00Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0127', 'CN PLATE C511 05 00Q999', '2019-10-15', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0128', 'CN PLATE C128 05 00Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0129', 'CN PLATE C128 05 00Q999', '2019-10-15', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0130', 'STR PLATE 101801500000Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0131', 'STR PLATE 101803700000Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0132', 'STR PLATE 101800500000Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0133', 'STR PLATE 101800100000Q999', '2019-10-15', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0134', 'CN PLATE  C989 05L 00Q999', '2019-10-15', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0135', 'CN PLATE  C989 05L 00Q999', '2019-10-15', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0136', 'CNP  A 798 05, CNP A 226 05', '2019-10-15', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0137', 'CN PLATE A 798 05L 00Q999', '2019-10-15', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0138', 'CNP A 463 05 ,CNP D 168 05', '2019-10-15', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0139', 'CNP A 463 05 ,CNP D 168 05', '2019-10-15', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0140', 'CN PLATE D16805L   00Q999', '2019-10-15', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0141', 'WASHER 807105101000Q999', '2019-10-15', 7, 2, 2, 1, 1, 'UNIT', 1),
('MD-0142', 'WASHER 807106103000Q999', '2019-10-15', 7, 2, 2, 1, 1, 'UNIT', 1),
('MD-0143', 'WASHER 807108230000Q999', '2019-10-15', 7, 2, 2, 1, 1, 'UNIT', 1),
('MD-0144', 'WASHER 8071071610, WASHER 8071082020', '2019-10-15', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0145', 'CNP A 226 05', '2019-10-15', 1, 2, 3, 1, 1, 'UNIT', 1),
('MD-0146', 'BOTTOM PLUG 74-24731-50S', '2019-10-15', 25, 2, 27, 10, 1, 'UNIT', 1),
('MD-0147', 'BOTTOM PLUG 74-52831-50S', '2019-10-15', 25, 2, 27, 10, 1, 'UNIT', 1),
('MD-0148', 'BOTTOM PLUG 74-23011-50', '2019-10-15', 25, 2, 27, 10, 1, 'UNIT', 1),
('MD-0149', 'BOTTOM PLUG 74-71532-58S', '2019-10-15', 25, 2, 28, 10, 1, 'UNIT', 1),
('MD-0150', 'BOTTOM PLUG 74-43432-50', '2019-10-15', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0151', 'BOTTOM PLUG 74-24732-50', '2019-10-15', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0152', 'BOTTOM PLUG 74-51411-50', '2019-10-15', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0153', 'BOTTOM PLUG 74-24711-50', '2019-10-15', 25, 2, 30, 10, 1, 'UNIT', 1),
('MD-0154', 'BOTTOM PLUG 74-30531-50, 47511', '2019-10-15', 25, 2, 30, 10, 1, 'UNIT', 1),
('MD-0155', 'BOTTOM PLUG 74-72211-50', '2019-10-15', 25, 2, 30, 10, 1, 'UNIT', 1),
('MD-0156', 'BOTTOM PLUG 74-15532-50, 71432', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0157', 'BOTTOM PLUG 74-74712-50, 29311', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0158', 'BOTTOM PLUG 74-43111-50', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0159', 'BOTTOM PLUG 74-43932-50', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0160', 'BOTTOM PLUG 74-72411-58', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0161', 'BOTTOM PLUG 74-23411-50', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0162', 'BOTTOM PLUG 74-60332-50 , 66432, 61731', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0163', 'BOTTOM PLUG 74-41642-50, 46812', '2019-10-15', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0164', 'BOTTOM PLUG 74-30732-50', '2019-10-15', 25, 2, 32, 10, 1, 'UNIT', 1),
('MD-0165', 'BOTTOM PLUG 74-52832-50', '2019-10-15', 25, 2, 32, 10, 1, 'UNIT', 1),
('MD-0166', 'BOTTOM PLUG 74-36111-50', '2019-10-15', 25, 2, 32, 10, 1, 'UNIT', 1),
('MD-0167', 'BOTTOM PLUG 74-10611-50', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0168', 'BOTTOM PLUG T0832-350', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0169', 'BOTTOM PLUG 74-40211-50E', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0170', 'BOTTOM PLUG 74-51411-50', '2019-10-15', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0171', 'BOTTOM PLUG 74-14132', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0172', 'BOTTOM PLUG 74-74532', '2019-10-15', 25, 2, 24, 10, 1, 'UNIT', 1),
('MD-0173', 'BOTTOM PLUG 74-62032', '2019-10-15', 25, 2, 19, 10, 1, 'UNIT', 1),
('MD-0174', 'BOTTOM PLUG 74-70712-50E, 30731', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0175', 'WASHER 23413-420', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0176', 'WASHER 72313-420', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0177', 'WASHER 28013-420', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0178', 'BOTTOM PLUG 74-30511-50E', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0179', 'WASHER 81-38413-420', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0180', 'WASHER 81-62913-420', '2019-10-15', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0181', 'BOTTOM PLUG 74-27032-350M', '2019-10-15', 25, 2, 24, 10, 1, 'UNIT', 1),
('MD-0182', 'MC 3657 - 1', '2019-10-15', 5, 2, 12, 7, 1, 'UNIT', 1),
('MD-0183', 'MC 3657 - 1', '2019-10-15', 6, 3, 12, 7, 1, 'UNIT', 1),
('MD-0184', 'MC 3657 - 1 (2 IN 1)', '2019-10-15', 10, 2, 12, 7, 1, 'UNIT', 1),
('MD-0185', 'MC 3657 - 1 (2 IN 1)', '2019-10-15', 16, 2, 12, 7, 1, 'UNIT', 1),
('MD-0186', 'MC 3657 - 1 (2 IN 1)', '2019-10-15', 16, 2, 12, 7, 1, 'UNIT', 1),
('MD-0187', 'MC 3657 - 1 (2 IN 1)', '2019-10-15', 21, 2, 12, 7, 1, 'UNIT', 1),
('MD-0188', 'MC 3657 - 1 (2 IN 1)', '2019-10-15', 21, 2, 12, 7, 1, 'UNIT', 1),
('MD-0189', 'MC 3372', '2019-10-15', 25, 3, 28, 7, 1, 'UNIT', 1),
('MD-0190', 'MC 3372 - 1 - 1', '2019-10-15', 24, 3, 37, 7, 1, 'UNIT', 1),
('MD-0191', 'MC 3372 - 1 - 1', '2019-10-15', 5, 2, 37, 7, 1, 'UNIT', 1),
('MD-0192', 'MC 3372 - 1 - 1', '2019-10-15', 10, 2, 37, 7, 1, 'UNIT', 1),
('MD-0193', 'MC 3372 - 1 - 1', '2019-10-15', 11, 3, 37, 7, 1, 'UNIT', 1),
('MD-0194', 'MC 3372 - 1 - 1', '2019-10-15', 16, 2, 37, 7, 1, 'UNIT', 1),
('MD-0195', 'MC 3372 - 1 - 1', '2019-10-15', 21, 2, 37, 7, 1, 'UNIT', 1),
('MD-0196', 'MC 3372 - 1 - 1', '2019-10-15', 21, 3, 37, 7, 1, 'UNIT', 1),
('MD-0197', 'INSERT ROLL 0.5 X 16.5 MM , 16 MM', '2019-10-15', 25, 2, 33, 15, 1, 'UNIT', 1),
('MD-0198', 'SPCC-2D 0.5 X 29 MM ISUZU', '2019-10-15', 25, 1, 33, 15, 1, 'UNIT', 1),
('MD-0199', 'SPCC-2D 0.5 X 29 MM LAMA', '2019-10-15', 25, 1, 33, 15, 1, 'UNIT', 1),
('MD-0200', 'SPCC-2D 0.5 X 30.5 MM', '2019-10-15', 25, 1, 33, 15, 1, 'UNIT', 1),
('MD-0201', 'SPCC-2D 0.5 X 29 MM ISUZU', '2019-10-15', 25, 3, 33, 15, 1, 'UNIT', 1),
('MD-0202', 'SPCC-2D 0.5 X 29 MM LAMA', '2019-10-15', 25, 3, 33, 15, 1, 'UNIT', 1),
('MD-0203', 'WASHER AW3G007F0', '2019-10-15', 25, 2, 8, 3, 1, 'UNIT', 1),
('MD-0204', 'RETAINER GZ1G011F0', '2019-10-15', 25, 2, 8, 3, 1, 'UNIT', 1),
('MD-0205', 'RETAINER GZ1G013F0', '2019-10-15', 25, 2, 33, 3, 1, 'UNIT', 1),
('MD-0206', 'RETAINER GZ1V0030A0', '2019-10-15', 25, 2, 33, 3, 1, 'UNIT', 1),
('MD-0207', 'METAL INSERT 38 MM SINGLE A', '2019-10-15', 25, 2, 3, 9, 1, 'UNIT', 1),
('MD-0208', 'METAL INSERT 38 MM SINGLE B', '2019-10-15', 25, 3, 3, 9, 1, 'UNIT', 1),
('MD-0209', 'METAL INSERT 38 MM SINGLE C', '2019-10-15', 25, 3, 3, 9, 1, 'UNIT', 1),
('MD-0210', 'FORGING STRUT PISTON TYPE 4D34 (Y220000000)', '2019-10-15', 25, 2, 21, 2, 1, 'UNIT', 1),
('MD-0211', 'STRUT MTB 4D34 LOKAL  (SC02021004)', '2019-10-15', 18, 2, 21, 2, 1, 'UNIT', 1),
('MD-0212', 'WASHER 058814-01734', '2019-10-15', 25, 2, 33, 17, 1, 'UNIT', 1),
('MD-0213', 'NAKADOKO NAGATE PIPE 3A100027', '2019-10-15', 21, 2, 21, 8, 1, 'UNIT', 1),
('MD-0214', 'NAKADOKO NAGATE PIPE 3A10002700A0-000', '2019-10-15', 21, 2, 21, 8, 1, 'UNIT', 1),
('MD-0215', 'WASHER 13001-24727', '2019-10-15', 7, 2, 8, 5, 1, 'UNIT', 1),
('MD-0216', 'KBT 727V-02-02 (MMH3D)', '2019-10-15', 25, 1, 33, 16, 1, 'UNIT', 1),
('MD-0217', 'KB15LN-03-02 (MV4A2)', '2019-10-15', 25, 1, 33, 16, 1, 'UNIT', 1),
('MD-0218', 'FRAME 30A', '2019-10-15', 5, 2, 38, 11, 1, 'UNIT', 1),
('MD-0219', 'FRAME 30A', '2019-10-15', 21, 2, 38, 11, 1, 'UNIT', 1),
('MD-0220', 'FRAME 30A', '2019-10-15', 1, 2, 38, 11, 1, 'UNIT', 1),
('MD-0221', 'WASHER 13001-90406', '2019-10-15', 7, 2, 38, 5, 1, 'UNIT', 1),
('MD-0222', 'VALVE B10513 (A)', '2019-10-15', 27, 2, 38, 6, 1, 'UNIT', 1),
('MD-0223', 'WASHER 72048', '2019-10-15', 7, 2, 38, 11, 1, 'UNIT', 1),
('MD-0224', 'WASHER 72060', '2019-10-15', 25, 2, 38, 11, 1, 'UNIT', 1),
('MD-0225', 'WASHER D33001', '2019-10-15', 25, 2, 38, 11, 1, 'UNIT', 1),
('MD-0226', 'BRACKET S 81025', '2019-10-15', 5, 2, 38, 11, 1, 'UNIT', 1),
('MD-0227', 'FIXET PLATE S84026R', '2019-10-15', 5, 2, 38, 11, 1, 'UNIT', 1),
('MD-0228', 'FIXET PLATE S84026R', '2019-10-15', 2, 3, 38, 11, 1, 'UNIT', 1),
('MD-0229', 'FIXET PLATE S84026R', '2019-10-15', 3, 2, 38, 11, 1, 'UNIT', 1),
('MD-0230', 'WASHER S72046', '2019-10-15', 7, 2, 38, 11, 1, 'UNIT', 1),
('MD-0231', 'WAVI WASHER S71063', '2019-10-15', 7, 2, 38, 11, 1, 'UNIT', 1),
('MD-0232', 'METAL INSERT 37 MM SINGLE B', '2019-10-15', 25, 3, 38, 4, 1, 'UNIT', 1),
('MD-0233', 'TH 078', '2019-10-15', 7, 2, 38, 4, 1, 'UNIT', 1),
('MD-0234', 'TH 079', '2019-10-15', 7, 2, 38, 4, 1, 'UNIT', 1),
('MD-0235', 'TH 081', '2019-10-15', 7, 2, 38, 4, 1, 'UNIT', 1),
('MD-0236', 'TH 163', '2019-10-15', 7, 2, 38, 4, 1, 'UNIT', 1),
('MD-0237', 'TH 163', '2019-10-15', 1, 2, 38, 4, 1, 'UNIT', 1),
('MD-0238', 'TH 163', '2019-10-15', 19, 2, 38, 4, 1, 'UNIT', 1),
('MD-0239', 'TH 163', '2019-10-15', 17, 2, 38, 4, 1, 'UNIT', 1),
('MD-0240', 'SWITCH SPACER', '2019-10-15', 25, 2, 38, 14, 1, 'UNIT', 1),
('MD-0241', 'PLATE MP70WYCP', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0242', 'TANK LID AP 120 NT1/NTO/ 100WYTO', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0243', 'COVER S 71066', '2019-10-15', 24, 2, 38, 11, 1, 'UNIT', 1),
('MD-0244', 'COVER S 71066', '2019-10-15', 10, 2, 38, 11, 1, 'UNIT', 1),
('MD-0245', 'DC 43211', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0246', 'DC 43211', '2019-10-15', 2, 2, 38, 6, 1, 'UNIT', 1),
('MD-0247', 'DC 43211', '2019-10-15', 3, 2, 38, 6, 1, 'UNIT', 1),
('MD-0248', 'DC 22032-360', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0249', 'DC 22032-360', '2019-10-15', 2, 2, 38, 6, 1, 'UNIT', 1),
('MD-0250', 'DC 22032-360', '2019-10-15', 3, 2, 38, 6, 1, 'UNIT', 1),
('MD-0251', 'DUST COVER 51711 - 360', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0252', 'DUST COVER 51711 - 360', '2019-10-15', 2, 2, 38, 6, 1, 'UNIT', 1),
('MD-0253', 'DUST COVER 51711 - 360', '2019-10-15', 3, 2, 38, 6, 1, 'UNIT', 1),
('MD-0254', 'DUST COVER 72511 - 360', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0255', 'DUST COVER 72511 - 360', '2019-10-15', 1, 2, 38, 6, 1, 'UNIT', 1),
('MD-0256', 'DUST COVER 72511 - 360', '2019-10-15', 2, 2, 38, 6, 1, 'UNIT', 1),
('MD-0257', 'DUST COVER 72511 - 360', '2019-10-15', 3, 2, 38, 6, 1, 'UNIT', 1),
('MD-0258', 'WASHER MOUNTING A/B', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0259', 'RING PLATE 21 - 10003 - 0', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0260', 'RING PLATE 21 - 10008 - 0', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0261', 'DUST COVER 22932 - 360', '2019-10-15', 25, 2, 38, 6, 1, 'UNIT', 1),
('MD-0262', 'DUST COVER 22932 - 360', '2019-10-15', 2, 2, 38, 6, 1, 'UNIT', 1),
('MD-0263', 'DUST COVER 22932 - 360', '2019-10-15', 3, 2, 38, 6, 1, 'UNIT', 1),
('MD-0264', 'RING PLATE 21 - 10001 - 0', '2019-10-15', 7, 2, 38, 6, 1, 'UNIT', 1),
('MD-0265', 'RING PLATE 21 - 10032-0', '2019-10-15', 7, 2, 38, 6, 1, 'UNIT', 1),
('MD-0266', 'RING PLATE 28 - 19701-0', '2019-10-15', 7, 2, 38, 6, 1, 'UNIT', 1),
('MD-0267', 'RING PLATE 21 - 10016-0', '2019-10-15', 7, 2, 38, 6, 1, 'UNIT', 1),
('MD-0268', 'RING PLATE 21 - 10026-0 /-11139-0', '2019-10-15', 7, 2, 38, 6, 1, 'UNIT', 1),
('MD-0269', 'RING PLATE 21 - 21144-0', '2019-10-15', 7, 2, 38, 6, 1, 'UNIT', 1),
('MD-0270', 'INSERT PLATE (FCI)', '2019-10-15', 25, 2, 38, 4, 1, 'UNIT', 1),
('MD-0271', 'MI 37 MM 2 IN I A', '2019-10-15', 25, 2, 38, 4, 1, 'UNIT', 1),
('MD-0272', 'MK  004', '2019-10-15', 7, 2, 38, 4, 1, 'UNIT', 1),
('MD-0273', 'MK - 018', '2019-10-15', 7, 2, 38, 4, 1, 'UNIT', 1),
('MD-0274', 'MK 031  LOWER', '2019-10-15', 25, 2, 38, 4, 1, 'UNIT', 1),
('MD-0275', 'MK 031 A', '2019-10-15', 25, 2, 38, 4, 1, 'UNIT', 1),
('MD-0276', 'MI 37 MM 2 IN I B', '2019-10-15', 25, 3, 38, 4, 1, 'UNIT', 1),
('MD-0277', 'MC 3538 – 1 - 1', '2019-10-15', 5, 3, 38, 7, 1, 'UNIT', 1),
('MD-0278', 'MC 3538 – 1 - 1', '2019-10-15', 11, 3, 38, 7, 1, 'UNIT', 1),
('MD-0279', 'MC 3538 – 1 - 1', '2019-10-15', 21, 3, 38, 7, 1, 'UNIT', 1),
('MD-0280', 'MC 3423 - 0', '2019-10-15', 21, 3, 38, 7, 1, 'UNIT', 1),
('MD-0281', 'MC 3423 – 0', '2019-10-15', 14, 3, 38, 7, 1, 'UNIT', 1),
('MD-0282', 'MC 2144', '2019-10-15', 14, 3, 38, 7, 1, 'UNIT', 1),
('MD-0283', 'MC 2144', '2019-10-15', 21, 3, 38, 7, 1, 'UNIT', 1),
('MD-0284', 'MC 3373', '2019-10-15', 5, 3, 38, 7, 1, 'UNIT', 1),
('MD-0285', 'MC 3373', '2019-10-15', 10, 3, 38, 7, 1, 'UNIT', 1),
('MD-0286', 'MC 3373', '2019-10-15', 11, 3, 38, 7, 1, 'UNIT', 1),
('MD-0287', 'MC 3373', '2019-10-15', 21, 3, 38, 7, 1, 'UNIT', 1),
('MD-0288', 'MC 3526', '2019-10-15', 6, 3, 38, 7, 1, 'UNIT', 1),
('MD-0289', 'MC 3526', '2019-10-15', 21, 3, 38, 7, 1, 'UNIT', 1),
('MD-0290', 'MUF 038', '2019-10-15', 12, 3, 38, 7, 1, 'UNIT', 1),
('MD-0291', 'MUF 038', '2019-10-15', 13, 3, 38, 7, 1, 'UNIT', 1),
('MD-0292', 'MUF 038', '2019-10-15', 17, 3, 38, 7, 1, 'UNIT', 1),
('MD-0293', 'COVER FLANGE S 71072', '2019-10-15', 10, 2, 38, 11, 1, 'UNIT', 1),
('MD-0294', 'COVER FLANGE S 71072', '2019-10-15', 5, 2, 38, 11, 1, 'UNIT', 1),
('MD-0295', 'COVER PLATE OL/UL (812LP80HNTC0) A,B,C', '2019-10-15', 5, 2, 38, 14, 1, 'UNIT', 1),
('MD-0296', 'COVER PLATE OL/UL (812LP80HNTC0) A,B,C', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0297', 'TANK LID EP 100 MKX HN 2T3', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0298', 'TANK LID 812 AP 80 WTO EP 80 MKX', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0299', 'TANK LID BP 100', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0300', 'G BRACKET R 73002', '2019-10-15', 25, 2, 38, 11, 1, 'UNIT', 1),
('MD-0301', 'G BRACKET R 73002', '2019-10-15', 1, 2, 38, 11, 1, 'UNIT', 1),
('MD-0303', 'BP 74-22131-350', '2019-10-15', 25, 2, 38, 10, 1, 'UNIT', 1),
('MD-0304', 'CNP 2000530400', '2019-10-15', 25, 2, 38, 1, 1, 'UNIT', 1),
('MD-0305', 'CNP 2000530400', '2019-10-15', 1, 2, 38, 1, 1, 'UNIT', 1),
('MD-0306', 'CP CARRY  1,0', '2019-10-15', 5, 2, 38, 1, 1, 'UNIT', 1),
('MD-0307', 'CP CARRY  1,0', '2019-10-15', 22, 2, 38, 1, 1, 'UNIT', 1),
('MD-0308', 'CP CARRY  1,0', '2019-10-15', 23, 2, 38, 1, 1, 'UNIT', 1),
('MD-0309', 'CP CARRY  1,0', '2019-10-15', 30, 2, 38, 1, 1, 'UNIT', 1),
('MD-0310', 'CP HIJET 1,3', '2019-10-15', 5, 2, 38, 1, 1, 'UNIT', 1),
('MD-0311', 'CP HIJET 1,3', '2019-10-15', 22, 2, 38, 1, 1, 'UNIT', 1),
('MD-0312', 'CP HIJET 1,3', '2019-10-15', 23, 2, 38, 1, 1, 'UNIT', 1),
('MD-0313', 'CP HIJET 1,3', '2019-10-15', 31, 2, 38, 1, 1, 'UNIT', 1),
('MD-0314', 'CP HIJET 1,3', '2019-10-15', 30, 2, 38, 1, 1, 'UNIT', 1),
('MD-0315', 'CP JET STAR', '2019-10-15', 5, 2, 38, 1, 1, 'UNIT', 1),
('MD-0316', 'CP JET STAR', '2019-10-15', 22, 2, 38, 1, 1, 'UNIT', 1),
('MD-0317', 'CP JET STAR', '2019-10-15', 23, 2, 38, 1, 1, 'UNIT', 1),
('MD-0318', 'CP JET STAR', '2019-10-15', 30, 2, 38, 1, 1, 'UNIT', 1),
('MD-0319', 'RP CARRY 1,0', '2019-10-15', 5, 2, 38, 1, 1, 'UNIT', 1),
('MD-0320', 'RP CARRY 1,0', '2019-10-15', 22, 2, 38, 1, 1, 'UNIT', 1),
('MD-0321', 'RP CARRY 1,0', '2019-10-15', 23, 2, 38, 1, 1, 'UNIT', 1),
('MD-0322', 'RP CARRY 1,0', '2019-10-15', 31, 2, 38, 1, 1, 'UNIT', 1),
('MD-0323', 'RP CARRY 1,0', '2019-10-15', 30, 2, 38, 1, 1, 'UNIT', 1),
('MD-0324', 'CNP 2U00530210', '2019-10-15', 25, 2, 38, 1, 1, 'UNIT', 1),
('MD-0325', 'CNP 2U00530210', '2019-10-15', 1, 2, 38, 1, 1, 'UNIT', 1),
('MD-0326', 'CNP 94505', '2019-10-15', 25, 2, 38, 1, 1, 'UNIT', 1),
('MD-0327', 'CNP 94505', '2019-10-15', 1, 2, 38, 1, 1, 'UNIT', 1),
('MD-0328', 'MUF 038 / AHH 565', '2019-10-15', 5, 3, 38, 7, 1, 'UNIT', 1),
('MD-0329', 'AHH 565', '2019-10-15', 12, 2, 38, 7, 1, 'UNIT', 1),
('MD-0330', 'AHH 565', '2019-10-15', 17, 2, 38, 7, 1, 'UNIT', 1),
('MD-0331', 'AHH 565', '2019-10-15', 13, 2, 38, 7, 1, 'UNIT', 1),
('MD-0332', 'TANK LID AP 120 NT1 /60 NT0', '2019-10-15', 5, 2, 38, 14, 1, 'UNIT', 1),
('MD-0333', 'TANK LID AP 60 NTO / NT1', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0334', 'TANK LID AP 812 AP 30 T0, T1', '2019-10-15', 21, 2, 38, 14, 1, 'UNIT', 1),
('MD-0335', 'SEIZING PLATE', '2019-10-15', 20, 2, 38, 11, 1, 'UNIT', 1),
('MD-0336', 'BRACKET 3 F', '2019-10-15', 7, 2, 38, 13, 1, 'UNIT', 1),
('MD-0337', 'TRAP FLAME', '2019-10-15', 7, 2, 38, 13, 1, 'UNIT', 1),
('MD-0341', 'TANK LID AP 812 AP 30 TO', '2019-10-15', 5, 2, 38, 14, 1, 'UNIT', 1),
('MD-0346', 'COVER S 74007 -1', '2019-10-15', 29, 2, 38, 11, 1, 'UNIT', 1),
('MD-0347', 'COVER S 71065', '2019-10-15', 21, 2, 38, 11, 1, 'UNIT', 1),
('MD-0348', 'COVER S 71065', '2019-10-15', 10, 2, 38, 11, 1, 'UNIT', 1),
('MD-0349', 'COVER S 71065', '2019-10-15', 5, 2, 38, 11, 1, 'UNIT', 1),
('MD-0350', 'BRACKET S 81025', '2019-10-15', 1, 2, 38, 11, 1, 'UNIT', 1),
('MD-0351', 'METAL INSERT 34 MM SINGLE B', '2018-10-15', 25, 2, 38, 4, 1, 'UNIT', 4),
('MD-0352', 'COBA COBA', '2019-10-14', 2, 2, 2, 2, 1, 'UNIT', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tb_kategori`
--

CREATE TABLE IF NOT EXISTS `tb_kategori` (
  `id_kategori` int(3) NOT NULL AUTO_INCREMENT,
  `kode` varchar(4) NOT NULL,
  `nama_kategori` varchar(30) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `tb_kategori`
--

INSERT INTO `tb_kategori` (`id_kategori`, `kode`, `nama_kategori`) VALUES
(1, 'BD', 'Bending'),
(2, 'BD1', 'Bending 1'),
(3, 'BD2', 'Bending 2'),
(4, 'BDRL', 'Bending, Roll'),
(5, 'BL', 'Blank'),
(6, 'BLDR', 'Blank, Draw'),
(7, 'COM', 'Compound'),
(8, 'CUR', 'Curling'),
(9, 'CUT', 'Cutting'),
(10, 'DR', 'Draw '),
(11, 'DRFM', 'Draw ,Forming'),
(12, 'DR1', 'Draw 1'),
(13, 'DR2', 'Draw 2'),
(14, 'DRBL', 'Draw, Blank'),
(15, 'DRPC', 'Draw, Piercing'),
(16, 'FM', 'Forming'),
(17, 'GT', 'Gang Tool'),
(18, 'HUM', 'HUMMING'),
(19, 'PART', 'Parting'),
(20, 'PCCU', 'Piercing, Cutting'),
(21, 'PC', 'Piercing'),
(22, 'PC1', 'Piercing 1'),
(23, 'PC2', 'Piercing 2'),
(24, 'PCBL', 'Piercing, Blank'),
(25, 'PR', 'Progresive '),
(26, 'PRBD', 'Progresive, Bending'),
(27, 'SEPR', 'Semi Prog'),
(28, 'TR', 'Trimming'),
(29, 'TRBD', 'Trimming, Bending'),
(30, 'FL', 'Flanging'),
(31, 'PC', 'Percing tiga');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kepemilikan`
--

CREATE TABLE IF NOT EXISTS `tb_kepemilikan` (
  `id_kepemilikan` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(40) NOT NULL,
  `tlp` varchar(12) NOT NULL,
  `alamat` varchar(300) NOT NULL,
  `ket` varchar(300) NOT NULL,
  PRIMARY KEY (`id_kepemilikan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `tb_kepemilikan`
--

INSERT INTO `tb_kepemilikan` (`id_kepemilikan`, `nama`, `tlp`, `alamat`, `ket`) VALUES
(1, 'Exedy Manufacturing Indonesia', '02189114666', 'Kawasan Industri KIIC Lot EE-3, 5, Jalan Permata III, Sirnabaya, Telukjambe Timur, Sirnabaya, Kec. Telukjambe Tim., Kabupaten Karawang, Jawa Barat 41361', 'Pelanggan tetap'),
(2, 'Federal Izumi Manufacturing', '0218230355', 'Jl. Raya Narogong KM.23,8, Dayeuh, Kec. Cileungsi, Bogor, Jawa Barat 16820', 'Pelanggan tetap'),
(3, 'Hilex', '02129288411', 'Jl. Trembesi, Cicau, Cikarang Pusat, Cicau, Bekasi, Jawa Barat 17530', ''),
(4, 'Irc Inoac Indonesia', '0215903929', 'Komplek Gajah Tunggal, Jalan Gatot Subroto Km. 7, Pasir Jaya, Jatiuwung, Pasir Jaya, Kec. Jatiuwung, Kota Tangerang, Banten 15135', ''),
(5, 'Kayaba Indonesia', '0218981456', 'Jl. Jawa Blok II No.4, Kawasan Industri MM 2100, Cikarang Barat, Jatiwangi, Kec. Cikarang Bar., Bekasi, Jawa Barat 17520', 'Pelanggan Tetap'),
(6, 'Meiji Rubber Indonesia', '0218934465', 'JL Jababeka SFB, Cikarang Industrial Estate, Block C No.14H, Pasirgombong, Kec. Cikarang Utara, Bekasi, Jawa Barat 17530', 'Pelanggan Tetap'),
(7, 'Nok Indonesia', '0218981041', 'Kawasan Industri MM 2100 Jalan Sulawesi II Blok F3 & F4, Gandamekar, Kec. Cikarang Bar., Bekasi, Jawa Barat 17530', ''),
(8, 'Paramount Bed Indonesia', '0218981389', 'MM2100 Industrial Town Block M-1-1, Cikarang Barat, Bekasi, Gandamekar, Kec. Cikarang Bar., Bekasi, Jawa Barat 17520', ''),
(9, 'Pong Codan Indonesia', '0212342343', 'Jl. Sentul - Citeureup No.83, Leuwinutug, Kec. Citeureup, Bogor, Jawa Barat 16810', ''),
(10, 'Sankei Gohsyu Industries', '0218980111', 'MM2100 Industrial Town Blok J-8, Cikarang Barat, Gandamekar, Kec. Cikarang Bar., Bekasi, Jawa Barat 17155', ''),
(11, 'Surya Toto Indonesia', '02127635500', 'Jl. MH. Thamrin KM 7, Desa Pakulonan, Kecamatan Serpong Utara, Panunggangan, Tangerang, Panunggangan, Pakualam, Kec. Serpong Utara, Kota Tangerang, Banten 15325', ''),
(12, 'Yamaha Indonesia', '0213456732', 'Tidak ada	', '	'),
(13, 'Yasufuku Indonesia', '0218934950', 'Jl. Jababeka VII Blok L-8 Kawsan Industri Jababeka, Jl. Nasional 1, Harja Mekar, Kec. Cikarang Utara, Bekasi, Jawa Barat 17530', ''),
(14, 'Yasunaga Indonesia', '0254400306', 'Jl. Modern Industri Raya Kav. 24, Kawasan Industri Modern Cikande, Nambo Ilir, Serang, Nambo Ilir, Kec. Kibin, Serang, Banten 42186', ''),
(15, 'TTEC', '0217865432', 'Belum tau	', '	'),
(16, 'LELCO', '0215463764', 'Belum tau', ''),
(17, 'SANSHO', '0214542343', 'Belum tau	', '	');

-- --------------------------------------------------------

--
-- Table structure for table `tb_lokasi`
--

CREATE TABLE IF NOT EXISTS `tb_lokasi` (
  `id_lokasi` int(3) NOT NULL AUTO_INCREMENT,
  `nama_rak` varchar(10) NOT NULL,
  `lokasi` varchar(10) NOT NULL,
  PRIMARY KEY (`id_lokasi`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `tb_lokasi`
--

INSERT INTO `tb_lokasi` (`id_lokasi`, `nama_rak`, `lokasi`) VALUES
(1, 'A.1.1', 'Gedung 1'),
(2, 'A.1.2', 'Gedung 1'),
(3, 'A.1.3', 'Gedung 1'),
(4, 'B.1.2', 'Gedung 1'),
(5, 'B.1.3', 'Gedung 1'),
(6, 'B.1.1', 'Gedung 1'),
(7, 'C.1.1', 'Gedung 1'),
(8, 'C.1.2', 'Gedung 1'),
(9, 'C.1.3', 'Gedung 1'),
(10, 'D.1.1', 'Gedung 1'),
(11, 'D.1.2', 'Gedung 1'),
(12, 'D.1.3', 'Gedung 1'),
(13, 'E.1.1', 'Gedung 1'),
(14, 'E.1.2', 'Gedung 1'),
(15, 'E.1.3', 'Gedung 1'),
(16, 'F.1.1', 'Gedung 3'),
(17, 'F.1.2', 'Gedung 3'),
(18, 'F.1.3', 'Gedung 3'),
(19, 'G.1.1', 'Gedung 3'),
(20, 'G.1.2', 'Gedung 3'),
(21, 'H.1.1', 'Gedung 3'),
(22, 'H.1.2', 'Gedung 3'),
(23, 'H.1.3', 'Gedung 3'),
(24, 'J.1.1', 'Gedung 3'),
(25, 'J.1.2', 'Gedung 3'),
(26, 'J.1.3', 'Gedung 3'),
(27, 'K.1.1', 'Gedung 3'),
(28, 'K.1.2', 'Gedung 3'),
(29, 'L.1.1', 'Gedung 3'),
(30, 'L.1.2', 'Gedung 3'),
(31, 'M.1.1', 'Gedung 3'),
(32, 'M.1.2', 'Gedung 3'),
(33, 'Assy', 'Gedung 2'),
(34, 'Palet', 'Gedung 2'),
(35, 'G.1.3', 'Gedung 3'),
(36, 'I.1.1', 'Gedung 3'),
(37, 'Matres', 'Gedung 2'),
(38, 'Meja Dies', 'Gedung 1');

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE IF NOT EXISTS `tb_peminjaman` (
  `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(20) NOT NULL,
  `pembawa` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `ket` varchar(300) NOT NULL,
  `open` tinyint(1) NOT NULL DEFAULT '1',
  `id_user` int(3) NOT NULL,
  `approval` varchar(10) DEFAULT '',
  PRIMARY KEY (`id_peminjaman`),
  KEY `fk_pinjam_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman_detail`
--

CREATE TABLE IF NOT EXISTS `tb_peminjaman_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_peminjaman` int(11) NOT NULL,
  `id_aset` varchar(10) NOT NULL,
  `qty` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_beli_detai_aset` (`id_aset`),
  KEY `fk_pinjam_detai_pinjam` (`id_peminjaman`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian`
--

CREATE TABLE IF NOT EXISTS `tb_pengembalian` (
  `id_pengembalian` int(11) NOT NULL AUTO_INCREMENT,
  `kode` varchar(20) NOT NULL,
  `pembawa` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `ket` varchar(300) NOT NULL,
  `id_user` int(3) NOT NULL,
  `id_peminjaman` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pengembalian`),
  KEY `fk_balik_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian_detail`
--

CREATE TABLE IF NOT EXISTS `tb_pengembalian_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pengembalian` int(11) NOT NULL,
  `id_aset` varchar(10) NOT NULL,
  `qty` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_balik_detail_balik` (`id_pengembalian`),
  KEY `fk_balik_detail_aset` (`id_aset`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_status`
--

CREATE TABLE IF NOT EXISTS `tb_status` (
  `id_status` int(3) NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_status`
--

INSERT INTO `tb_status` (`id_status`, `status`) VALUES
(1, 'Titipan Customer'),
(2, 'Dibuat Soraya milik Customer'),
(3, 'Milik Soraya');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `jabatan` enum('Admin','Gudang','Kasir','Kepala') NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `uniq_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nama`, `username`, `password`, `jabatan`, `status`) VALUES
(1, 'Dhiskar', 'dhiskar', 'Admin1', 'Kepala', 1),
(2, 'Panji', 'panji', 'Gudang1', 'Gudang', 1),
(3, 'Jepy', 'jepy', 'Kasir1', 'Kasir', 1),
(4, 'Toni Saputraa', 'toni', 'Admin2', 'Admin', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_aset`
--
CREATE TABLE IF NOT EXISTS `v_aset` (
`kode_aset` varchar(10)
,`tanggal` date
,`nama_aset` varchar(50)
,`id_kategori` int(3)
,`kode_kategori` varchar(4)
,`nama_kategori` varchar(30)
,`id_status` int(3)
,`status_aset` varchar(30)
,`id_lokasi` int(3)
,`nama_rak` varchar(10)
,`lokasi_aset` varchar(10)
,`id_kepemilikan` int(11)
,`nama_kepemilikan` varchar(40)
,`tlp_kepemilikan` varchar(12)
,`alamat_kepemilikan` varchar(300)
,`ket_kepemilikan` varchar(300)
,`quantity` int(1)
,`satuan` varchar(30)
,`id_user` int(3)
,`nama_user` varchar(30)
,`username` varchar(8)
,`password` varchar(8)
,`jabatan_user` enum('Admin','Gudang','Kasir','Kepala')
,`status_user` tinyint(1)
);
-- --------------------------------------------------------

--
-- Structure for view `v_aset`
--
DROP TABLE IF EXISTS `v_aset`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_aset` AS select `tb_aset`.`id_aset` AS `kode_aset`,`tb_aset`.`tanggal` AS `tanggal`,`tb_aset`.`nama_aset` AS `nama_aset`,`tb_kategori`.`id_kategori` AS `id_kategori`,`tb_kategori`.`kode` AS `kode_kategori`,`tb_kategori`.`nama_kategori` AS `nama_kategori`,`tb_status`.`id_status` AS `id_status`,`tb_status`.`status` AS `status_aset`,`tb_lokasi`.`id_lokasi` AS `id_lokasi`,`tb_lokasi`.`nama_rak` AS `nama_rak`,`tb_lokasi`.`lokasi` AS `lokasi_aset`,`tb_kepemilikan`.`id_kepemilikan` AS `id_kepemilikan`,`tb_kepemilikan`.`nama` AS `nama_kepemilikan`,`tb_kepemilikan`.`tlp` AS `tlp_kepemilikan`,`tb_kepemilikan`.`alamat` AS `alamat_kepemilikan`,`tb_kepemilikan`.`ket` AS `ket_kepemilikan`,`tb_aset`.`qty` AS `quantity`,`tb_aset`.`satuan` AS `satuan`,`users`.`id_user` AS `id_user`,`users`.`nama` AS `nama_user`,`users`.`username` AS `username`,`users`.`password` AS `password`,`users`.`jabatan` AS `jabatan_user`,`users`.`status` AS `status_user` from (((((`tb_aset` left join `tb_kategori` on((`tb_aset`.`id_kategori` = `tb_kategori`.`id_kategori`))) left join `tb_status` on((`tb_aset`.`id_status` = `tb_status`.`id_status`))) left join `tb_lokasi` on((`tb_aset`.`id_lokasi` = `tb_lokasi`.`id_lokasi`))) left join `tb_kepemilikan` on((`tb_aset`.`id_kepemilikan` = `tb_kepemilikan`.`id_kepemilikan`))) left join `users` on((`tb_aset`.`id_user` = `users`.`id_user`)));

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_aset`
--
ALTER TABLE `tb_aset`
  ADD CONSTRAINT `tb_aset_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `tb_kategori` (`id_kategori`),
  ADD CONSTRAINT `tb_aset_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `tb_status` (`id_status`),
  ADD CONSTRAINT `tb_aset_ibfk_4` FOREIGN KEY (`id_lokasi`) REFERENCES `tb_lokasi` (`id_lokasi`),
  ADD CONSTRAINT `tb_aset_ibfk_5` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `tb_aset_ibfk_6` FOREIGN KEY (`id_kepemilikan`) REFERENCES `tb_kepemilikan` (`id_kepemilikan`);

--
-- Constraints for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD CONSTRAINT `tb_peminjaman_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `tb_peminjaman_detail`
--
ALTER TABLE `tb_peminjaman_detail`
  ADD CONSTRAINT `tb_peminjaman_detail_ibfk_2` FOREIGN KEY (`id_aset`) REFERENCES `tb_aset` (`id_aset`),
  ADD CONSTRAINT `tb_peminjaman_detail_ibfk_3` FOREIGN KEY (`id_peminjaman`) REFERENCES `tb_peminjaman` (`id_peminjaman`);

--
-- Constraints for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  ADD CONSTRAINT `tb_pengembalian_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `tb_pengembalian_detail`
--
ALTER TABLE `tb_pengembalian_detail`
  ADD CONSTRAINT `tb_pengembalian_detail_ibfk_2` FOREIGN KEY (`id_aset`) REFERENCES `tb_aset` (`id_aset`),
  ADD CONSTRAINT `tb_pengembalian_detail_ibfk_3` FOREIGN KEY (`id_pengembalian`) REFERENCES `tb_pengembalian` (`id_pengembalian`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
