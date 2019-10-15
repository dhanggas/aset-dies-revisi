-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
<<<<<<< HEAD
-- Generation Time: Sep 21, 2019 at 04:47 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9
=======
-- Generation Time: Aug 29, 2019 at 04:55 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8
>>>>>>> dbaset sebelum resign

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbaset`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_aset`
--

CREATE TABLE `tb_aset` (
  `id_aset` varchar(10) NOT NULL,
  `nama_aset` varchar(50) NOT NULL,
  `id_kategori` int(3) NOT NULL,
  `id_status` int(3) NOT NULL,
  `id_lokasi` int(3) NOT NULL,
  `id_kepemilikan` int(3) NOT NULL,
  `qty` int(1) NOT NULL DEFAULT '0',
  `satuan` varchar(30) NOT NULL,
  `id_user` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_aset`
--

INSERT INTO `tb_aset` (`id_aset`, `nama_aset`, `id_kategori`, `id_status`, `id_lokasi`, `id_kepemilikan`, `qty`, `satuan`, `id_user`) VALUES
<<<<<<< HEAD
('MD-0001', 'Ring Plate 21 - 11086-0', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0002', 'Ring Plate 21 - 12138-0', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0003', 'Ring Plate 28 - 19801-0', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0004', 'Ring Plate 28 - 19801-0', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0005', 'Ring Plate 21 - 10000-0', 25, 3, 3, 6, 1, 'UNIT', 1),
('MD-0006', 'Retainer 45932 - 370', 25, 2, 3, 6, 1, 'UNIT', 1),
('MD-0007', 'INNER BUSH 47901-432', 10, 3, 33, 6, 1, 'UNIT', 1),
('MD-0008', 'Mould Dies Dust Cover 76 - T5731 - 60', 25, 2, 33, 6, 1, 'UNIT', 1),
('MD-0009', 'Mould Dies Dust Cover 76 - T5731 - 60', 2, 2, 33, 6, 1, 'UNIT', 1),
('MD-0010', 'Mould Dies Dust Cover 76 - T5731 - 60', 3, 2, 33, 6, 1, 'UNIT', 1),
('MD-0011', 'Mould Dies Dust Cover 76 - T5735 - 60', 25, 2, 33, 6, 1, 'UNIT', 1),
('MD-0012', 'Mould Dies Dust Cover 76 - T5735 - 60', 2, 2, 33, 6, 1, 'UNIT', 1),
('MD-0013', 'Mould Dies Dust Cover 76 - T5735 - 60', 3, 2, 33, 6, 1, 'UNIT', 1),
('MD-0014', 'Ring Plate 21 - 10008', 24, 3, 3, 6, 1, 'UNIT', 1),
('MD-0015', 'Outner Bush', 25, 1, 33, 6, 1, 'UNIT', 1),
('MD-0016', 'Inner Bush', 25, 1, 33, 6, 1, 'UNIT', 1),
('MD-0017', 'Metal Insert 15.5 mm Single', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0018', 'Metal Insert 20.5 mm Single', 25, 2, 3, 4, 1, 'UNIT', 1),
('MD-0019', 'Metal Insert 22 mm Single', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0020', 'Metal Insert 26 mm', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0021', 'Metal Insert 30 mm B', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0022', 'Metal Insert 34 mm Single A', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0023', 'Metal Insert 34 mm Single C', 25, 2, 6, 4, 1, 'UNIT', 1),
('MD-0024', 'Metal Insert 36 mm Single', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0025', 'Metal Insert  34 mm Embosh', 25, 3, 6, 4, 1, 'UNIT', 1),
('MD-0026', 'Metal Insert 20.5 mm 2in1 A', 25, 2, 4, 4, 1, 'UNIT', 1),
('MD-0027', 'Metal Insert 20.5 mm 2in1 B', 25, 2, 4, 4, 1, 'UNIT', 1),
('MD-0028', 'Metal Insert 34 mm 2in1 A', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0029', 'Metal Insert 34 mm 2in1 B', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0030', 'Metal Insert 34 mm 2in1 C', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0031', 'Metal Insert 36 mm 2in1', 25, 3, 4, 4, 1, 'UNIT', 1),
('MD-0032', 'TH 112', 7, 2, 5, 4, 1, 'UNIT', 1),
('MD-0033', 'TH 113', 7, 2, 5, 4, 1, 'UNIT', 1),
('MD-0034', 'TH 114', 7, 2, 33, 4, 1, 'UNIT', 1),
('MD-0035', 'MK 04', 7, 2, 33, 4, 1, 'UNIT', 1),
('MD-0036', 'MK 009 A', 7, 2, 5, 4, 1, 'UNIT', 1),
('MD-0037', 'MK 009 B', 25, 2, 22, 4, 1, 'UNIT', 1),
('MD-0038', 'Back Door Stopper', 5, 1, 6, 4, 1, 'UNIT', 1),
('MD-0039', 'Back Door Stopper', 12, 1, 6, 4, 1, 'UNIT', 1),
('MD-0040', 'Back Door Stopper', 13, 1, 6, 4, 1, 'UNIT', 1),
('MD-0041', 'Back Door Stopper', 28, 1, 6, 4, 1, 'UNIT', 1),
('MD-0042', 'Back Door Stopper', 1, 1, 6, 4, 1, 'UNIT', 1),
('MD-0043', 'Back Door Stopper', 17, 1, 6, 4, 1, 'UNIT', 1),
('MD-0044', 'Retainer Shift', 21, 2, 23, 4, 1, 'UNIT', 1),
('MD-0045', 'Retainer Shift', 10, 2, 23, 4, 1, 'UNIT', 1),
('MD-0046', 'Retainer Shift', 5, 2, 23, 4, 1, 'UNIT', 1),
('MD-0047', 'Packing Guide 17863', 24, 2, 15, 11, 1, 'UNIT', 1),
('MD-0048', 'Packing Guide 17863', 15, 2, 15, 11, 1, 'UNIT', 1),
('MD-0049', 'Washer 72001', 7, 2, 14, 11, 1, 'UNIT', 1),
('MD-0050', 'Cover S71053', 5, 2, 13, 11, 1, 'UNIT', 1),
('MD-0051', 'Cover S71053', 10, 2, 13, 11, 1, 'UNIT', 1),
('MD-0052', 'Cover S71053', 21, 2, 13, 11, 1, 'UNIT', 1),
('MD-0053', 'Cover S71054', 21, 2, 13, 11, 1, 'UNIT', 1),
('MD-0054', 'Cover S71058', 21, 2, 13, 11, 1, 'UNIT', 1),
('MD-0055', 'Cover S74007-0', 29, 2, 15, 11, 1, 'UNIT', 1),
('MD-0056', 'Cover S74007-1', 29, 2, 15, 11, 1, 'UNIT', 1),
('MD-0057', 'Cover S74007-4', 29, 2, 15, 11, 1, 'UNIT', 1),
('MD-0058', 'Cover S74007-0-1', 8, 2, 15, 11, 1, 'UNIT', 1),
('MD-0059', 'Cover S74007-4', 8, 2, 15, 11, 1, 'UNIT', 1),
('MD-0060', 'Cover S74017', 29, 2, 14, 11, 1, 'UNIT', 1),
('MD-0061', 'Cover S74017', 1, 2, 14, 11, 1, 'UNIT', 1),
('MD-0062', 'Cover S74017', 8, 2, 14, 11, 1, 'UNIT', 1),
('MD-0063', 'Washer S72006R', 24, 3, 30, 11, 1, 'UNIT', 1),
('MD-0064', 'Washer S72006-1R', 24, 3, 18, 11, 1, 'UNIT', 1),
('MD-0065', 'Washer S72067R', 24, 3, 18, 11, 1, 'UNIT', 1),
('MD-0066', 'Cover S71055-3', 5, 2, 16, 11, 1, 'UNIT', 1),
('MD-0067', 'Cover 71076', 24, 2, 17, 11, 1, 'UNIT', 1),
('MD-0068', 'TANK LID EP NIKKO 812EP80HN2T2', 21, 1, 9, 14, 1, 'UNIT', 1),
('MD-0069', 'TANK LID LP 60', 21, 2, 9, 14, 1, 'UNIT', 1),
('MD-0070', 'COVER PLATE 812AP60NC0', 7, 2, 9, 14, 1, 'UNIT', 1),
('MD-0071', 'COVER PLATE 812AP120NCO, AP80HC0', 21, 2, 9, 14, 1, 'UNIT', 1),
('MD-0072', 'COVER PLATE 812AP120C0', 5, 2, 19, 14, 1, 'UNIT', 1),
('MD-0073', 'COVER PLATE AP 120 812MP100WYCOAY', 21, 2, 19, 14, 1, 'UNIT', 1),
('MD-0074', 'TANK LID LP LP 100, LP 60, LP 150', 5, 2, 20, 14, 1, 'UNIT', 1),
('MD-0075', 'TANK LID LP100, LP60', 21, 2, 20, 14, 1, 'UNIT', 1),
('MD-0076', 'TANK LID  812LP150N0', 21, 2, 20, 14, 1, 'UNIT', 1),
('MD-0077', 'COVER PLATE 812AP30C0, 60C0, 60C1,30COUL, 60coul', 7, 2, 20, 14, 1, 'UNIT', 1),
('MD-0078', 'TANK LID  812AP30T0', 5, 2, 20, 14, 1, 'UNIT', 1),
('MD-0079', 'SOFT PEDAL LEVER NC00022669', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0080', 'LOUD PEDAL LEVER 116 / 121', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0081', 'LOUD PEDAL LEVER 116 / 121', 18, 2, 7, 12, 1, 'UNIT', 1),
('MD-0082', 'LOUD PEDAL LEVER 116 / 121', 23, 2, 7, 12, 1, 'UNIT', 1),
('MD-0083', 'LOUD PEDAL LEVER 116 / 121', 1, 2, 7, 12, 1, 'UNIT', 1),
('MD-0084', 'SOFT PEDAL LEVER UP 121', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0085', 'LOUD PEDAL LEVER UP 116', 23, 2, 7, 12, 1, 'UNIT', 1),
('MD-0086', 'SOFT PEDAL LEVER UP 116', 22, 2, 7, 12, 1, 'UNIT', 1),
('MD-0087', 'Punching Plate 5D9-E4450-00-30', 25, 2, 25, 13, 1, 'UNIT', 1),
('MD-0088', 'Punching Plate 5D9-E4450-00-30', 7, 2, 25, 13, 1, 'UNIT', 1),
('MD-0089', 'Punching Plate 54P-E4450-K01', 25, 2, 25, 13, 1, 'UNIT', 1),
('MD-0090', 'Punching Plate 54P-E4450-K01', 7, 2, 25, 13, 1, 'UNIT', 1),
('MD-0091', 'Plate 1 11029-0724D-K01', 7, 2, 34, 13, 1, 'UNIT', 1),
('MD-0092', 'Plate 2 11029-0724D-K04', 7, 2, 25, 13, 1, 'UNIT', 1),
('MD-0093', 'Punching Plate 52B-E4450-00-B', 25, 2, 26, 13, 1, 'UNIT', 1),
('MD-0094', 'Punching Plate 52B-E4450-00-B', 7, 2, 26, 13, 1, 'UNIT', 1),
('MD-0095', 'Punching Plate 11029-0724D-K02', 7, 2, 34, 13, 1, 'UNIT', 1),
('MD-0096', 'Washer GP 7', 7, 2, 26, 13, 1, 'UNIT', 1),
('MD-0097', 'Binder 11029-0724D-K03', 1, 3, 26, 13, 1, 'UNIT', 1),
('MD-0098', 'Binder 11029-0724D-K03', 9, 3, 26, 13, 1, 'UNIT', 1),
('MD-0099', 'Punching Plate B74-E4451-00-30', 7, 2, 36, 13, 1, 'UNIT', 1),
('MD-0100', 'Punching Plate B65-E4451-00-30', 7, 2, 36, 13, 1, 'UNIT', 1),
('MD-0101', 'Punching Plate B74-E4451-00-30 , B65', 25, 2, 36, 13, 1, 'UNIT', 1),
('MD-0102', 'Punching Plate 53P-E4450-00-1-30', 25, 1, 33, 13, 1, 'UNIT', 1),
('MD-0103', 'Punching Plate 53P-E4450-00-1-30', 7, 1, 33, 13, 1, 'UNIT', 1),
('MD-0104', 'CN PLATE  C860 51  00Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0105', 'CN PLATE  C860 51  00Q999', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0106', 'CN PLATE  C390 05  00Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0107', 'CN PLATE  C390 05  00Q999', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0108', 'CN PLATE C137 05 00Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0109', 'CN PLATE C137 05 00Q999', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0110', 'CN PLATE C511 05 00Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0111', 'CN PLATE C511 05 00Q999', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0112', 'CN PLATE C128 05 00Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0113', 'CN PLATE C128 05 00Q999', 1, 2, 1, 1, 1, 'UNIT', 1),
('MD-0114', 'STR PLATE 101801500000Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0115', 'STR PLATE 101803700000Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0116', 'STR PLATE 101800500000Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0117', 'STR PLATE 101800100000Q999', 25, 2, 1, 1, 1, 'UNIT', 1),
('MD-0118', 'CN PLATE  C989 05L 00Q999', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0119', 'CN PLATE  C989 05L 00Q999', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0120', 'CNP  A 798 05, CNP A 226 05', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0121', 'CN PLATE A 798 05L 00Q999', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0122', 'CNP A 463 05 ,CNP D 168 05', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0123', 'CNP A 463 05 ,CNP D 168 05', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0124', 'CN PLATE D16805L   00Q999', 1, 2, 2, 1, 1, 'UNIT', 1),
('MD-0125', 'WASHER 807105101000Q999', 7, 2, 2, 1, 1, 'UNIT', 1),
('MD-0126', 'WASHER 807106103000Q999', 7, 2, 2, 1, 1, 'UNIT', 1),
('MD-0127', 'WASHER 807108230000Q999', 7, 2, 2, 1, 1, 'UNIT', 1),
('MD-0128', 'WASHER 8071071610, WASHER 8071082020', 25, 2, 2, 1, 1, 'UNIT', 1),
('MD-0129', 'CNP A 226 05', 1, 2, 3, 1, 1, 'UNIT', 1),
('MD-0130', 'Bottom Plug 74-24731-50S', 25, 2, 27, 10, 1, 'UNIT', 1),
('MD-0131', 'Bottom Plug 74-52831-50S', 25, 2, 27, 10, 1, 'UNIT', 1),
('MD-0132', 'Bottom Plug 74-23011-50', 25, 2, 27, 10, 1, 'UNIT', 1),
('MD-0133', 'Bottom Plug 74-71532-58S', 25, 2, 28, 10, 1, 'UNIT', 1),
('MD-0134', 'Bottom Plug 74-43432-50', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0135', 'Bottom Plug 74-24732-50', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0136', 'Bottom Plug 74-51411-50', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0137', 'Bottom Plug 74-24711-50', 25, 2, 30, 10, 1, 'UNIT', 1),
('MD-0138', 'Bottom Plug 74-30531-50, 47511', 25, 2, 30, 10, 1, 'UNIT', 1),
('MD-0139', 'Bottom Plug 74-72211-50', 25, 2, 30, 10, 1, 'UNIT', 1),
('MD-0140', 'Bottom Plug 74-15532-50, 71432', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0141', 'Bottom Plug 74-74712-50, 29311', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0142', 'Bottom Plug 74-43111-50', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0143', 'Bottom Plug 74-43932-50', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0144', 'Bottom Plug 74-72411-58', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0145', 'Bottom Plug 74-23411-50', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0146', 'Bottom Plug 74-60332-50 , 66432, 61731', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0147', 'Bottom Plug 74-41642-50, 46812', 25, 2, 31, 10, 1, 'UNIT', 1),
('MD-0148', 'Bottom Plug 74-30732-50', 25, 2, 32, 10, 1, 'UNIT', 1),
('MD-0149', 'Bottom Plug 74-52832-50', 25, 2, 32, 10, 1, 'UNIT', 1),
('MD-0150', 'Bottom Plug 74-36111-50', 25, 2, 32, 10, 1, 'UNIT', 1),
('MD-0151', 'Bottom Plug 74-10611-50', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0152', 'Bottom Plug T0832-350', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0153', 'Bottom Plug 74-40211-50E', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0154', 'Bottom Plug 74-51411-50', 25, 2, 29, 10, 1, 'UNIT', 1),
('MD-0155', 'Bottom Plug 74-14132', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0156', 'Bottom Plug 74-74532', 25, 2, 24, 10, 1, 'UNIT', 1),
('MD-0157', 'Bottom Plug 74-62032', 25, 2, 19, 10, 1, 'UNIT', 1),
('MD-0158', 'Bottom Plug 74-70712-50E, 30731', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0159', 'Washer 23413-420', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0160', 'Washer 72313-420', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0161', 'Washer 28013-420', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0162', 'Bottom Plug 74-30511-50E', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0163', 'Washer 81-38413-420', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0164', 'Washer 81-62913-420', 25, 2, 33, 10, 1, 'UNIT', 1),
('MD-0165', 'Bottom Plug 74-27032-350M', 25, 2, 24, 10, 1, 'UNIT', 1),
('MD-0166', 'MC 3657 - 1', 5, 2, 12, 7, 1, 'UNIT', 1),
('MD-0167', 'MC 3657 - 1', 6, 3, 12, 7, 1, 'UNIT', 1),
('MD-0168', 'MC 3657 - 1 (2 IN 1)', 10, 2, 12, 7, 1, 'UNIT', 1),
('MD-0169', 'MC 3657 - 1 (2 IN 1)', 16, 2, 12, 7, 1, 'UNIT', 1),
('MD-0170', 'MC 3657 - 1 (2 IN 1)', 16, 2, 12, 7, 1, 'UNIT', 1),
('MD-0171', 'MC 3657 - 1 (2 IN 1)', 21, 2, 12, 7, 1, 'UNIT', 1),
('MD-0172', 'MC 3657 - 1 (2 IN 1)', 21, 2, 12, 7, 1, 'UNIT', 1),
('MD-0173', 'MC 3372', 25, 3, 28, 7, 1, 'UNIT', 1),
('MD-0174', 'MC 3372 - 1 - 1', 24, 3, 37, 7, 1, 'UNIT', 1),
('MD-0175', 'MC 3372 - 1 - 1', 5, 2, 37, 7, 1, 'UNIT', 1),
('MD-0176', 'MC 3372 - 1 - 1', 10, 2, 37, 7, 1, 'UNIT', 1),
('MD-0177', 'MC 3372 - 1 - 1', 11, 3, 37, 7, 1, 'UNIT', 1),
('MD-0178', 'MC 3372 - 1 - 1', 16, 2, 37, 7, 1, 'UNIT', 1),
('MD-0179', 'MC 3372 - 1 - 1', 21, 2, 37, 7, 1, 'UNIT', 1),
('MD-0180', 'MC 3372 - 1 - 1', 21, 3, 37, 7, 1, 'UNIT', 1),
('MD-0181', 'INSERT ROLL 0.5 X 16.5 MM , 16 MM', 25, 2, 33, 15, 1, 'UNIT', 1),
('MD-0182', 'SPCC-2D 0.5 X 29 MM ISUZU', 25, 1, 33, 15, 1, 'UNIT', 1),
('MD-0183', 'SPCC-2D 0.5 X 29 MM LAMA', 25, 1, 33, 15, 1, 'UNIT', 1),
('MD-0184', 'SPCC-2D 0.5 X 30.5 MM', 25, 1, 33, 15, 1, 'UNIT', 1),
('MD-0185', 'SPCC-2D 0.5 X 29 MM ISUZU', 25, 3, 33, 15, 1, 'UNIT', 1),
('MD-0186', 'SPCC-2D 0.5 X 29 MM LAMA', 25, 3, 33, 15, 1, 'UNIT', 1),
('MD-0187', 'Washer AW3G007F0', 25, 2, 8, 3, 1, 'UNIT', 1),
('MD-0188', 'Retainer GZ1G011F0', 25, 2, 8, 3, 1, 'UNIT', 1),
('MD-0189', 'Retainer GZ1G013F0', 25, 2, 33, 3, 1, 'UNIT', 1),
('MD-0190', 'Retainer GZ1V0030A0', 25, 2, 33, 3, 1, 'UNIT', 1),
('MD-0191', 'METAL INSERT 38 MM SINGLE A', 25, 2, 3, 9, 1, 'UNIT', 1),
('MD-0192', 'METAL INSERT 38 MM SINGLE B', 25, 3, 3, 9, 1, 'UNIT', 1),
('MD-0193', 'METAL INSERT 38 MM SINGLE C', 25, 3, 3, 9, 1, 'UNIT', 1),
('MD-0194', 'Forging Strut Piston TYPE 4D34 (Y220000000)', 25, 2, 21, 2, 1, 'UNIT', 1),
('MD-0195', 'STRUT MTB 4D34 LOKAL  (SC02021004)', 18, 2, 21, 2, 1, 'UNIT', 1),
('MD-0196', 'WASHER 058814-01734', 25, 2, 33, 17, 1, 'UNIT', 1),
('MD-0197', 'Nakadoko Nagate Pipe 3A100027', 21, 2, 21, 8, 1, 'UNIT', 1),
('MD-0198', 'NAKADOKO NAGATE PIPE 3A10002700A0-000', 21, 2, 21, 8, 1, 'UNIT', 1),
('MD-0199', 'Washer 13001-24727', 7, 2, 8, 5, 1, 'UNIT', 1),
('MD-0200', 'KBT 727V-02-02 (MMH3D)', 25, 1, 33, 16, 1, 'UNIT', 1),
('MD-0201', 'KB15LN-03-02 (MV4A2)', 25, 1, 33, 16, 1, 'UNIT', 1),
('MD-0202', 'Trial aset 1', 4, 3, 37, 3, 0, 'UNIT', 4),
('MD-0203', 'Trial Aset 2', 3, 3, 37, 3, 0, 'UNIT', 4),
('MD-0204', 'Trial Aset 3', 8, 3, 37, 3, 1, 'UNIT', 4);
=======
('MD-0001', 'Ring Plate 21 - 11086-0', 25, 3, 3, 6, 1, 'SET', 1),
('MD-0002', 'Ring Plate 21 - 12138-0', 25, 3, 3, 6, 0, 'SET', 1),
('MD-0003', 'Ring Plate 28 - 19801-0', 25, 3, 3, 6, 1, 'SET', 1),
('MD-0004', 'Ring Plate 28 - 19801-0', 25, 3, 3, 6, 1, 'SET', 1),
('MD-0005', 'Ring Plate 21 - 10000-0', 25, 3, 3, 6, 1, 'SET', 1),
('MD-0006', 'Retainer 45932 - 370', 25, 2, 3, 6, 1, 'SET', 1),
('MD-0007', 'INNER BUSH 47901-432', 10, 3, 33, 6, 1, 'SET', 1),
('MD-0008', 'Mould Dies Dust Cover 76 - T5731 - 60', 25, 2, 33, 6, 1, 'SET', 1),
('MD-0009', 'Mould Dies Dust Cover 76 - T5731 - 60', 2, 2, 33, 6, 1, 'SET', 1),
('MD-0010', 'Mould Dies Dust Cover 76 - T5731 - 60', 3, 2, 33, 6, 1, 'SET', 1),
('MD-0011', 'Mould Dies Dust Cover 76 - T5735 - 60', 25, 2, 33, 6, 1, 'SET', 1),
('MD-0012', 'Mould Dies Dust Cover 76 - T5735 - 60', 2, 2, 33, 6, 1, 'SET', 1),
('MD-0013', 'Mould Dies Dust Cover 76 - T5735 - 60', 3, 2, 33, 6, 1, 'SET', 1),
('MD-0014', 'Ring Plate 21 - 10008', 24, 3, 3, 6, 1, 'SET', 1),
('MD-0015', 'Outner Bush', 25, 1, 33, 6, 1, 'SET', 1),
('MD-0016', 'Inner Bush', 25, 1, 33, 6, 1, 'SET', 1),
('MD-0017', 'Metal Insert 15.5 mm Single', 25, 3, 6, 4, 1, 'SET', 1),
('MD-0018', 'Metal Insert 20.5 mm Single', 25, 2, 3, 4, 1, 'SET', 1),
('MD-0019', 'Metal Insert 22 mm Single', 25, 2, 6, 4, 1, 'SET', 1),
('MD-0020', 'Metal Insert 26 mm', 25, 2, 6, 4, 1, 'SET', 1),
('MD-0021', 'Metal Insert 30 mm B', 25, 3, 6, 4, 1, 'SET', 1),
('MD-0022', 'Metal Insert 34 mm Single A', 25, 2, 6, 4, 1, 'SET', 1),
('MD-0023', 'Metal Insert 34 mm Single C', 25, 2, 6, 4, 1, 'SET', 1),
('MD-0024', 'Metal Insert 37 mm Single A', 25, 3, 6, 4, 0, 'SET', 1),
('MD-0025', 'Metal Insert 37 mm New', 25, 3, 6, 4, 0, 'SET', 1),
('MD-0026', 'Metal Insert 36 mm Single', 25, 3, 6, 4, 1, 'SET', 1),
('MD-0027', 'Metal Insert  34 mm Embosh', 25, 3, 6, 4, 1, 'SET', 1),
('MD-0028', 'Metal Insert 20.5 mm 2in1 A', 25, 2, 4, 4, 1, 'SET', 1),
('MD-0029', 'Metal Insert 20.5 mm 2in1 B', 25, 2, 4, 4, 1, 'SET', 1),
('MD-0030', 'Metal Insert 34 mm 2in1 A', 25, 3, 4, 4, 1, 'SET', 1),
('MD-0031', 'Metal Insert 34 mm 2in1 B', 25, 3, 4, 4, 1, 'SET', 1),
('MD-0032', 'Metal Insert 34 mm 2in1 C', 25, 3, 4, 4, 1, 'SET', 1),
('MD-0033', 'Metal Insert 36 mm 2in1', 25, 3, 4, 4, 1, 'SET', 1),
('MD-0034', 'TH 112', 7, 2, 5, 4, 1, 'SET', 1),
('MD-0035', 'TH 113', 7, 2, 5, 4, 1, 'SET', 1),
('MD-0036', 'TH 114', 7, 2, 33, 4, 1, 'SET', 1),
('MD-0037', 'MK 04', 7, 2, 33, 4, 1, 'SET', 1),
('MD-0038', 'MK 009 A', 7, 2, 5, 4, 1, 'SET', 1),
('MD-0039', 'MK 009 B', 25, 2, 22, 4, 1, 'SET', 1),
('MD-0040', 'Back Door Stopper', 5, 1, 6, 4, 1, 'SET', 1),
('MD-0041', 'Back Door Stopper', 12, 1, 6, 4, 1, 'SET', 1),
('MD-0042', 'Back Door Stopper', 13, 1, 6, 4, 1, 'SET', 1),
('MD-0043', 'Back Door Stopper', 28, 1, 6, 4, 1, 'SET', 1),
('MD-0044', 'Back Door Stopper', 1, 1, 6, 4, 1, 'SET', 1),
('MD-0045', 'Back Door Stopper', 17, 1, 6, 4, 1, 'SET', 1),
('MD-0046', 'Retainer Shift', 21, 2, 23, 4, 1, 'SET', 1),
('MD-0047', 'Retainer Shift', 10, 2, 23, 4, 1, 'SET', 1),
('MD-0048', 'Retainer Shift', 5, 2, 23, 4, 1, 'SET', 1),
('MD-0049', 'Packing Guide 17863', 24, 2, 15, 11, 1, 'SET', 1),
('MD-0050', 'Packing Guide 17863', 15, 2, 15, 11, 1, 'SET', 1),
('MD-0051', 'Washer 72001', 7, 2, 14, 11, 1, 'SET', 1),
('MD-0052', 'Cover Flange S 71044', 5, 2, 16, 11, 0, 'SET', 1),
('MD-0053', 'Cover Flange S 71044', 10, 2, 17, 11, 0, 'SET', 1),
('MD-0054', 'Cover Flange S 71044', 21, 2, 17, 11, 0, 'SET', 1),
('MD-0055', 'Cover S71053', 5, 2, 13, 11, 1, 'SET', 1),
('MD-0056', 'Cover S71053', 10, 2, 13, 11, 1, 'SET', 1),
('MD-0057', 'Cover S71053', 21, 2, 13, 11, 1, 'SET', 1),
('MD-0058', 'Cover S71054', 21, 2, 13, 11, 1, 'SET', 1),
('MD-0059', 'Cover S71058', 21, 2, 13, 11, 1, 'SET', 1),
('MD-0060', 'Washer 72063', 24, 2, 16, 11, 0, 'SET', 1),
('MD-0061', 'Cover S74007-0', 29, 2, 15, 11, 1, 'SET', 1),
('MD-0062', 'Cover S74007-1', 29, 2, 15, 11, 1, 'SET', 1),
('MD-0063', 'Cover S74007-4', 29, 2, 15, 11, 1, 'SET', 1),
('MD-0064', 'Cover S74007-0-1', 8, 2, 15, 11, 1, 'SET', 1),
('MD-0065', 'Cover S74007-4', 8, 2, 15, 11, 1, 'SET', 1),
('MD-0066', 'Cover S74017', 29, 2, 14, 11, 1, 'SET', 1),
('MD-0067', 'Cover S74017', 1, 2, 14, 11, 1, 'SET', 1),
('MD-0068', 'Cover S74017', 8, 2, 14, 11, 1, 'SET', 1),
('MD-0069', 'Bracket S81009', 5, 2, 14, 11, 0, 'SET', 1),
('MD-0070', 'Bracket S81009', 1, 2, 14, 11, 0, 'SET', 1),
('MD-0071', 'Bracket S81018', 24, 2, 14, 11, 0, 'SET', 1),
('MD-0072', 'Bracket S81018', 1, 2, 14, 11, 0, 'SET', 1),
('MD-0073', 'Washer S72006R', 24, 3, 30, 11, 1, 'SET', 1),
('MD-0074', 'Washer S72006-1R', 24, 3, 18, 11, 1, 'SET', 1),
('MD-0075', 'Washer S72067R', 24, 3, 18, 11, 1, 'SET', 1),
('MD-0079', 'Cover S71055-3', 5, 2, 16, 11, 1, 'SET', 1),
('MD-0080', 'Cover 71076', 24, 2, 17, 11, 1, 'SET', 1),
('MD-0081', 'TANK LID EP NIKKO 812EP80HN2T2', 21, 1, 9, 14, 1, 'SET', 1),
('MD-0082', 'TANK LID LP 60', 21, 2, 9, 14, 1, 'SET', 1),
('MD-0083', 'COVER PLATE 812AP60NC0', 7, 2, 9, 14, 1, 'SET', 1),
('MD-0084', 'COVER PLATE 812AP120NCO, AP80HC0', 21, 2, 9, 14, 1, 'SET', 1),
('MD-0085', 'TANK LID 812AP80WT0 , EP80HN2T3, 812EP120E2T2', 5, 2, 9, 14, 0, 'SET', 1),
('MD-0086', 'TANK LID 812EP120E2T2', 21, 2, 19, 14, 0, 'SET', 1),
('MD-0087', 'COVER PLATE 812AP120C0', 5, 2, 19, 14, 1, 'SET', 1),
('MD-0088', 'COVER PLATE AP 120 812MP100WYCOAY', 21, 2, 19, 14, 1, 'SET', 1),
('MD-0089', 'TANK LID LP LP 100, LP 60, LP 150', 5, 2, 20, 14, 1, 'SET', 1),
('MD-0090', 'TANK LID LP100, LP60', 21, 2, 20, 14, 1, 'SET', 1),
('MD-0091', 'TANK LID  812LP150N0', 21, 2, 20, 14, 1, 'SET', 1),
('MD-0092', 'COVER PLATE 812AP30C0, 60C0, 60C1,30COUL, 60coul', 7, 2, 20, 14, 1, 'SET', 1),
('MD-0093', 'TANK LID  812AP30T0', 5, 2, 20, 14, 1, 'SET', 1),
('MD-0094', 'SOFT PEDAL LEVER NC00022669', 22, 2, 7, 12, 1, 'SET', 1),
('MD-0095', 'LOUD PEDAL LEVER 116 / 121', 22, 2, 7, 12, 1, 'SET', 1),
('MD-0096', 'LOUD PEDAL LEVER 116 / 121', 18, 2, 7, 12, 1, 'SET', 1),
('MD-0097', 'LOUD PEDAL LEVER 116 / 121', 23, 2, 7, 12, 1, 'SET', 1),
('MD-0098', 'LOUD PEDAL LEVER 116 / 121', 1, 2, 7, 12, 1, 'SET', 1),
('MD-0099', 'MUSIC ROCK SUPPORT HINGE', 25, 2, 33, 12, 0, 'SET', 1),
('MD-0100', 'SOFT PEDAL LEVER UP 121', 22, 2, 7, 12, 1, 'SET', 1),
('MD-0101', 'LOUD PEDAL LEVER UP 116', 23, 2, 7, 12, 1, 'SET', 1),
('MD-0102', 'SOFT PEDAL LEVER UP 116', 22, 2, 7, 12, 1, 'SET', 1),
('MD-0103', 'Punching Plate 5D9-E4450-00-30', 25, 2, 25, 13, 1, 'SET', 1),
('MD-0104', 'Punching Plate 5D9-E4450-00-30', 7, 2, 25, 13, 1, 'SET', 1),
('MD-0105', 'Punching Plate 54P-E4450-K01', 25, 2, 25, 13, 1, 'SET', 1),
('MD-0106', 'Punching Plate 54P-E4450-K01', 7, 2, 25, 13, 1, 'SET', 1),
('MD-0107', 'Plate 1 11029-0724D-K01', 7, 2, 34, 13, 1, 'SET', 1),
('MD-0108', 'Plate 2 11029-0724D-K04', 7, 2, 25, 13, 1, 'SET', 1),
('MD-0109', 'Punching Plate 52B-E4450-00-B', 25, 2, 26, 13, 1, 'SET', 1),
('MD-0110', 'Punching Plate 52B-E4450-00-B', 7, 2, 26, 13, 1, 'SET', 1),
('MD-0111', 'Punching Plate 11029-0724D-K02', 7, 2, 34, 13, 1, 'SET', 1),
('MD-0112', 'Washer GP 7', 7, 2, 26, 13, 1, 'SET', 1),
('MD-0113', 'Binder 11029-0724D-K03', 1, 3, 26, 13, 1, 'SET', 1),
('MD-0114', 'Binder 11029-0724D-K03', 9, 3, 26, 13, 1, 'SET', 1),
('MD-0115', 'Punching Plate B74-E4451-00-30', 7, 2, 36, 13, 1, 'SET', 1),
('MD-0116', 'Punching Plate B65-E4451-00-30', 7, 2, 36, 13, 1, 'SET', 1),
('MD-0117', 'Punching Plate B74-E4451-00-30 , B65', 25, 2, 36, 13, 1, 'SET', 1),
('MD-0118', 'Punching Plate 53P-E4450-00-1-30', 25, 1, 33, 13, 1, 'SET', 1),
('MD-0119', 'Punching Plate 53P-E4450-00-1-30', 7, 1, 33, 13, 1, 'SET', 1),
('MD-0120', 'CN PLATE  C860 51  00Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0121', 'CN PLATE  C860 51  00Q999', 1, 2, 1, 1, 1, 'SET', 1),
('MD-0122', 'CN PLATE  C390 05  00Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0123', 'CN PLATE  C390 05  00Q999', 1, 2, 1, 1, 1, 'SET', 1),
('MD-0124', 'CN PLATE C137 05 00Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0125', 'CN PLATE C137 05 00Q999', 1, 2, 1, 1, 1, 'SET', 1),
('MD-0126', 'CN PLATE C511 05 00Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0127', 'CN PLATE C511 05 00Q999', 1, 2, 1, 1, 1, 'SET', 1),
('MD-0128', 'CN PLATE C128 05 00Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0129', 'CN PLATE C128 05 00Q999', 1, 2, 1, 1, 1, 'SET', 1),
('MD-0130', 'STR PLATE 101801500000Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0131', 'STR PLATE 101803700000Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0132', 'STR PLATE 101800500000Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0133', 'STR PLATE 101800100000Q999', 25, 2, 1, 1, 1, 'SET', 1),
('MD-0134', 'CN PLATE  C989 05L 00Q999', 25, 2, 2, 1, 1, 'SET', 1),
('MD-0135', 'CN PLATE  C989 05L 00Q999', 1, 2, 2, 1, 1, 'SET', 1),
('MD-0136', 'CNP  A 798 05, CNP A 226 05', 25, 2, 2, 1, 1, 'SET', 1),
('MD-0137', 'CN PLATE A 798 05L 00Q999', 1, 2, 2, 1, 1, 'SET', 1),
('MD-0138', 'CNP A 463 05 ,CNP D 168 05', 25, 2, 2, 1, 1, 'SET', 1),
('MD-0139', 'CNP A 463 05 ,CNP D 168 05', 1, 2, 2, 1, 1, 'SET', 1),
('MD-0140', 'CN PLATE D16805L   00Q999', 1, 2, 2, 1, 1, 'SET', 1),
('MD-0141', 'WASHER 807105101000Q999', 7, 2, 2, 1, 1, 'SET', 1),
('MD-0142', 'WASHER 807106103000Q999', 7, 2, 2, 1, 1, 'SET', 1),
('MD-0143', 'WASHER 807108230000Q999', 7, 2, 2, 1, 1, 'SET', 1),
('MD-0144', 'WASHER 8071071610, WASHER 8071082020', 25, 2, 2, 1, 1, 'SET', 1),
('MD-0145', 'CNP A 226 05', 1, 2, 3, 1, 1, 'SET', 1),
('MD-0146', 'Bottom Plug 74-24731-50S', 25, 2, 27, 10, 1, 'SET', 1),
('MD-0147', 'Bottom Plug 74-52831-50S', 25, 2, 27, 10, 1, 'SET', 1),
('MD-0148', 'Bottom Plug 74-23011-50', 25, 2, 27, 10, 1, 'SET', 1),
('MD-0149', 'Bottom Plug 74-71532-58S', 25, 2, 28, 10, 1, 'SET', 1),
('MD-0150', 'Bottom Plug 74-43432-50', 25, 2, 29, 10, 1, 'SET', 1),
('MD-0151', 'Bottom Plug 74-24732-50', 25, 2, 29, 10, 1, 'SET', 1),
('MD-0152', 'Bottom Plug 74-51411-50', 25, 2, 29, 10, 1, 'SET', 1),
('MD-0153', 'Bottom Plug 74-24711-50', 25, 2, 30, 10, 1, 'SET', 1),
('MD-0154', 'Bottom Plug 74-30531-50, 47511', 25, 2, 30, 10, 1, 'SET', 1),
('MD-0155', 'Bottom Plug 74-72211-50', 25, 2, 30, 10, 1, 'SET', 1),
('MD-0156', 'Bottom Plug 74-15532-50, 71432', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0157', 'Bottom Plug 74-74712-50, 29311', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0158', 'Bottom Plug 74-43111-50', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0159', 'Bottom Plug 74-43932-50', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0160', 'Bottom Plug 74-72411-58', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0161', 'Bottom Plug 74-23411-50', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0162', 'Bottom Plug 74-60332-50 , 66432, 61731', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0163', 'Bottom Plug 74-41642-50, 46812', 25, 2, 31, 10, 1, 'SET', 1),
('MD-0164', 'Bottom Plug 74-30732-50', 25, 2, 32, 10, 1, 'SET', 1),
('MD-0165', 'Bottom Plug 74-52832-50', 25, 2, 32, 10, 1, 'SET', 1),
('MD-0166', 'Bottom Plug 74-36111-50', 25, 2, 32, 10, 1, 'SET', 1),
('MD-0167', 'Bottom Plug 74-10611-50', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0168', 'Bottom Plug T0832-350', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0169', 'Bottom Plug 74-40211-50E', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0170', 'Bottom Plug 74-51411-50', 25, 2, 29, 10, 1, 'SET', 1),
('MD-0171', 'Bottom Plug 74-14132', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0172', 'Bottom Plug 74-74532', 25, 2, 24, 10, 1, 'SET', 1),
('MD-0173', 'Bottom Plug 74-62032', 25, 2, 19, 10, 1, 'SET', 1),
('MD-0174', 'Bottom Plug 74-70712-50E, 30731', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0175', 'Washer 23413-420', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0176', 'Washer 72313-420', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0177', 'Washer 28013-420', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0178', 'Bottom Plug 74-30511-50E', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0179', 'Washer 81-38413-420', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0180', 'Washer 81-62913-420', 25, 2, 33, 10, 1, 'SET', 1),
('MD-0181', 'Bottom Plug 74-27032-350M', 25, 2, 24, 10, 1, 'SET', 1),
('MD-0182', 'MC 3657 - 1', 5, 2, 12, 7, 1, 'SET', 1),
('MD-0183', 'MC 3657 - 1', 6, 3, 12, 7, 1, 'SET', 1),
('MD-0184', 'MC 3657 - 1 (2 IN 1)', 10, 2, 12, 7, 1, 'SET', 1),
('MD-0185', 'MC 3657 - 1 (2 IN 1)', 16, 2, 12, 7, 1, 'SET', 1),
('MD-0186', 'MC 3657 - 1 (2 IN 1)', 16, 2, 12, 7, 1, 'SET', 1),
('MD-0187', 'MC 3657 - 1 (2 IN 1)', 21, 2, 12, 7, 1, 'SET', 1),
('MD-0188', 'MC 3657 - 1 (2 IN 1)', 21, 2, 12, 7, 1, 'SET', 1),
('MD-0189', 'MC 3372', 25, 3, 28, 7, 1, 'SET', 1),
('MD-0190', 'MC 3372 - 1 - 1', 24, 3, 37, 7, 1, 'SET', 1),
('MD-0191', 'MC 3372 - 1 - 1', 5, 2, 37, 7, 1, 'SET', 1),
('MD-0192', 'MC 3372 - 1 - 1', 10, 2, 37, 7, 1, 'SET', 1),
('MD-0193', 'MC 3372 - 1 - 1', 11, 3, 37, 7, 1, 'SET', 1),
('MD-0194', 'MC 3372 - 1 - 1', 16, 2, 37, 7, 1, 'SET', 1),
('MD-0195', 'MC 3372 - 1 - 1', 21, 2, 37, 7, 1, 'SET', 1),
('MD-0196', 'MC 3372 - 1 - 1', 21, 3, 37, 7, 1, 'SET', 1),
('MD-0197', 'INSERT ROLL 0.5 X 16.5 MM , 16 MM', 25, 2, 33, 15, 1, 'SET', 1),
('MD-0198', 'SPCC-2D 0.5 X 29 MM ISUZU', 25, 1, 33, 15, 1, 'SET', 1),
('MD-0199', 'SPCC-2D 0.5 X 29 MM LAMA', 25, 1, 33, 15, 1, 'SET', 1),
('MD-0200', 'SPCC-2D 0.5 X 30.5 MM', 25, 1, 33, 15, 1, 'SET', 1),
('MD-0201', 'SPCC-2D 0.5 X 29 MM ISUZU', 25, 3, 33, 15, 1, 'SET', 1),
('MD-0202', 'SPCC-2D 0.5 X 29 MM LAMA', 25, 3, 33, 15, 1, 'SET', 1),
('MD-0203', 'Washer AW3G007F0', 25, 2, 8, 3, 1, 'SET', 1),
('MD-0204', 'Retainer GZ1G011F0', 25, 2, 8, 3, 1, 'SET', 1),
('MD-0205', 'Retainer GZ1G013F0', 25, 2, 33, 3, 1, 'SET', 1),
('MD-0206', 'Retainer GZ1V0030A0', 25, 2, 33, 3, 1, 'SET', 1),
('MD-0207', 'METAL INSERT 38 MM SINGLE A', 25, 2, 3, 9, 1, 'SET', 1),
('MD-0208', 'METAL INSERT 38 MM SINGLE B', 25, 3, 3, 9, 1, 'SET', 1),
('MD-0209', 'METAL INSERT 38 MM SINGLE C', 25, 3, 3, 9, 1, 'SET', 1),
('MD-0210', 'Forging Strut Piston TYPE 4D34 (Y220000000)', 25, 2, 21, 2, 1, 'SET', 1),
('MD-0211', 'STRUT MTB 4D34 LOKAL  (SC02021004)', 18, 2, 21, 2, 1, 'SET', 1),
('MD-0212', 'WASHER 058814-01734', 25, 2, 33, 17, 1, 'SET', 1),
('MD-0213', 'Nakadoko Nagate Pipe 3A100027', 21, 2, 21, 8, 1, 'SET', 1),
('MD-0214', 'NAKADOKO NAGATE PIPE 3A10002700A0-000', 21, 2, 21, 8, 1, 'SET', 1),
('MD-0215', 'Washer 13001-24727', 7, 2, 8, 5, 1, 'SET', 1),
('MD-0216', 'KBT 727V-02-02 (MMH3D)', 25, 1, 33, 16, 1, 'SET', 1),
('MD-0217', 'KB15LN-03-02 (MV4A2)', 25, 1, 33, 16, 1, 'SET', 1),
('MD-0218', 'Frame 30A', 5, 2, 38, 11, 0, 'SET', 1),
('MD-0219', 'Frame 30A', 21, 2, 38, 11, 0, 'SET', 1),
('MD-0220', 'Frame 30A', 1, 2, 38, 11, 0, 'SET', 1),
('MD-0221', 'Washer 13001-90406', 7, 2, 38, 5, 0, 'SET', 1),
('MD-0222', 'Valve B10513 (A)', 27, 2, 38, 6, 0, 'SET', 1),
('MD-0223', 'Washer 72048', 7, 2, 38, 11, 0, 'SET', 1),
('MD-0224', 'Washer 72060', 25, 2, 38, 11, 0, 'SET', 1),
('MD-0225', 'Washer D33001', 25, 2, 38, 11, 0, 'SET', 1),
('MD-0226', 'Bracket S 81025', 5, 2, 38, 11, 0, 'SET', 1),
('MD-0227', 'Fixet Plate S84026R', 5, 2, 38, 11, 0, 'SET', 1),
('MD-0228', 'Fixet Plate S84026R', 2, 3, 38, 11, 0, 'SET', 1),
('MD-0229', 'Fixet Plate S84026R', 3, 2, 38, 11, 0, 'SET', 1),
('MD-0230', 'Washer S72046', 7, 2, 38, 11, 0, 'SET', 1),
('MD-0231', 'Wavi Washer S71063', 7, 2, 38, 11, 0, 'SET', 1),
('MD-0232', 'Metal Insert 37 mm Single B', 25, 3, 38, 4, 0, 'SET', 1),
('MD-0233', 'TH 078', 7, 2, 38, 4, 0, 'SET', 1),
('MD-0234', 'TH 079', 7, 2, 38, 4, 0, 'SET', 1),
('MD-0235', 'TH 081', 7, 2, 38, 4, 0, 'SET', 1),
('MD-0236', 'TH 163', 7, 2, 38, 4, 0, 'SET', 1),
('MD-0237', 'TH 163', 1, 2, 38, 4, 0, 'SET', 1),
('MD-0238', 'TH 163', 19, 2, 38, 4, 0, 'SET', 1),
('MD-0239', 'TH 163', 17, 2, 38, 4, 0, 'SET', 1),
('MD-0240', 'Switch Spacer', 25, 2, 38, 14, 0, 'SET', 1),
('MD-0241', 'Plate MP70WYCP', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0242', 'Tank Lid Ap 120 NT1/NTO/ 100WYTO', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0243', 'COVER S 71066', 24, 2, 38, 11, 0, 'SET', 1),
('MD-0244', 'COVER S 71066', 10, 2, 38, 11, 0, 'SET', 1),
('MD-0245', 'DC 43211', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0246', 'DC 43211', 2, 2, 38, 6, 0, 'SET', 1),
('MD-0247', 'DC 43211', 3, 2, 38, 6, 0, 'SET', 1),
('MD-0248', 'DC 22032-360', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0249', 'DC 22032-360', 2, 2, 38, 6, 0, 'SET', 1),
('MD-0250', 'DC 22032-360', 3, 2, 38, 6, 0, 'SET', 1),
('MD-0251', 'Dust Cover 51711 - 360', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0252', 'Dust Cover 51711 - 360', 2, 2, 38, 6, 0, 'SET', 1),
('MD-0253', 'Dust Cover 51711 - 360', 3, 2, 38, 6, 0, 'SET', 1),
('MD-0254', 'Dust Cover 72511 - 360', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0255', 'Dust Cover 72511 - 360', 1, 2, 38, 6, 0, 'SET', 1),
('MD-0256', 'Dust Cover 72511 - 360', 2, 2, 38, 6, 0, 'SET', 1),
('MD-0257', 'Dust Cover 72511 - 360', 3, 2, 38, 6, 0, 'SET', 1),
('MD-0258', 'Washer Mounting A/B', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0259', 'Ring Plate 21 - 10003 - 0', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0260', 'Ring Plate 21 - 10008 - 0', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0261', 'Dust Cover 22932 - 360', 25, 2, 38, 6, 0, 'SET', 1),
('MD-0262', 'Dust Cover 22932 - 360', 2, 2, 38, 6, 0, 'SET', 1),
('MD-0263', 'Dust Cover 22932 - 360', 3, 2, 38, 6, 0, 'SET', 1),
('MD-0264', 'Ring Plate 21 - 10001 - 0', 7, 2, 38, 6, 0, 'SET', 1),
('MD-0265', 'Ring Plate 21 - 10032-0', 7, 2, 38, 6, 0, 'SET', 1),
('MD-0266', 'Ring Plate 28 - 19701-0', 7, 2, 38, 6, 0, 'SET', 1),
('MD-0267', 'Ring Plate 21 - 10016-0', 7, 2, 38, 6, 0, 'SET', 1),
('MD-0268', 'Ring Plate 21 - 10026-0 /-11139-0', 7, 2, 38, 6, 0, 'SET', 1),
('MD-0269', 'Ring Plate 21 - 21144-0', 7, 2, 38, 6, 0, 'SET', 1),
('MD-0270', 'INSERT PLATE (FCI)', 25, 2, 38, 4, 0, 'SET', 1),
('MD-0271', 'MI 37 MM 2 IN I A', 25, 2, 38, 4, 0, 'SET', 1),
('MD-0272', 'MK  004', 7, 2, 38, 4, 0, 'SET', 1),
('MD-0273', 'MK - 018', 7, 2, 38, 4, 0, 'SET', 1),
('MD-0274', 'MK 031  Lower', 25, 2, 38, 4, 0, 'SET', 1),
('MD-0275', 'MK 031 A', 25, 2, 38, 4, 0, 'SET', 1),
('MD-0276', 'MI 37 MM 2 IN I B', 25, 3, 38, 4, 0, 'SET', 1),
('MD-0277', 'MC 3538 – 1 - 1', 5, 3, 38, 7, 0, 'SET', 1),
('MD-0278', 'MC 3538 – 1 - 1', 11, 3, 38, 7, 0, 'SET', 1),
('MD-0279', 'MC 3538 – 1 - 1', 21, 3, 38, 7, 0, 'SET', 1),
('MD-0280', 'MC 3423 - 0', 21, 3, 38, 7, 0, 'SET', 1),
('MD-0281', 'MC 3423 – 0', 14, 3, 38, 7, 0, 'SET', 4),
('MD-0282', 'MC 2144', 14, 3, 38, 7, 0, 'SET', 1),
('MD-0283', 'MC 2144', 21, 3, 38, 7, 0, 'SET', 1),
('MD-0284', 'MC 3373', 5, 3, 38, 7, 0, 'SET', 1),
('MD-0285', 'MC 3373', 10, 3, 38, 7, 0, 'SET', 1),
('MD-0286', 'MC 3373', 11, 3, 38, 7, 0, 'SET', 1),
('MD-0287', 'MC 3373', 21, 3, 38, 7, 0, 'SET', 1),
('MD-0288', 'MC 3526', 6, 3, 38, 7, 0, 'SET', 1),
('MD-0289', 'MC 3526', 21, 3, 38, 7, 0, 'SET', 1),
('MD-0290', 'MUF 038', 12, 3, 38, 7, 0, 'SET', 1),
('MD-0291', 'MUF 038', 13, 3, 38, 7, 0, 'SET', 1),
('MD-0292', 'MUF 038', 17, 3, 38, 7, 0, 'SET', 1),
('MD-0293', 'Cover Flange S 71072', 10, 2, 38, 11, 0, 'SET', 1),
('MD-0294', 'Cover Flange S 71072', 5, 2, 38, 11, 0, 'SET', 1),
('MD-0295', 'COVER PLATE OL/UL (812LP80HNTC0) A,B,C', 5, 2, 38, 14, 0, 'SET', 1),
('MD-0296', 'COVER PLATE OL/UL (812LP80HNTC0) A,B,C', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0297', 'TANK LID EP 100 MKX HN 2T3', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0298', 'TANK LID 812 AP 80 WTO EP 80 MKX', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0299', 'TANK LID BP 100', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0300', 'G Bracket R 73002', 25, 2, 38, 11, 0, 'SET', 1),
('MD-0301', 'G Bracket R 73002', 1, 2, 38, 11, 0, 'SET', 1),
('MD-0303', 'BP 74-22131-350', 25, 2, 38, 10, 0, 'SET', 1),
('MD-0304', 'CNP 2000530400', 25, 2, 38, 1, 0, 'SET', 1),
('MD-0305', 'CNP 2000530400', 1, 2, 38, 1, 0, 'SET', 1),
('MD-0306', 'CP Carry  1,0', 5, 2, 38, 1, 0, 'SET', 1),
('MD-0307', 'CP Carry  1,0', 22, 2, 38, 1, 0, 'SET', 1),
('MD-0308', 'CP Carry  1,0', 23, 2, 38, 1, 0, 'SET', 1),
('MD-0309', 'CP Carry  1,0', 30, 2, 38, 1, 0, 'SET', 1),
('MD-0310', 'CP Hijet 1,3', 5, 2, 38, 1, 0, 'SET', 1),
('MD-0311', 'CP Hijet 1,3', 22, 2, 38, 1, 0, 'SET', 1),
('MD-0312', 'CP Hijet 1,3', 23, 2, 38, 1, 0, 'SET', 1),
('MD-0313', 'CP Hijet 1,3', 31, 2, 38, 1, 0, 'SET', 1),
('MD-0314', 'CP Hijet 1,3', 30, 2, 38, 1, 0, 'SET', 1),
('MD-0315', 'CP Jet Star', 5, 2, 38, 1, 0, 'SET', 1),
('MD-0316', 'CP Jet Star', 22, 2, 38, 1, 0, 'SET', 1),
('MD-0317', 'CP Jet Star', 23, 2, 38, 1, 0, 'SET', 1),
('MD-0318', 'CP Jet Star', 30, 2, 38, 1, 0, 'SET', 1),
('MD-0319', 'RP Carry 1,0', 5, 2, 38, 1, 0, 'SET', 1),
('MD-0320', 'RP Carry 1,0', 22, 2, 38, 1, 0, 'SET', 1),
('MD-0321', 'RP Carry 1,0', 23, 2, 38, 1, 0, 'SET', 1),
('MD-0322', 'RP Carry 1,0', 31, 2, 38, 1, 0, 'SET', 1),
('MD-0323', 'RP Carry 1,0', 30, 2, 38, 1, 0, 'SET', 1),
('MD-0324', 'CNP 2U00530210', 25, 2, 38, 1, 0, 'SET', 1),
('MD-0325', 'CNP 2U00530210', 1, 2, 38, 1, 0, 'SET', 1),
('MD-0326', 'CNP 94505', 25, 2, 38, 1, 0, 'SET', 1),
('MD-0327', 'CNP 94505', 1, 2, 38, 1, 0, 'SET', 1),
('MD-0328', 'MUF 038 / AHH 565', 5, 3, 38, 7, 0, 'SET', 1),
('MD-0329', 'AHH 565', 12, 2, 38, 7, 0, 'SET', 1),
('MD-0330', 'AHH 565', 17, 2, 38, 7, 0, 'SET', 1),
('MD-0331', 'AHH 565', 13, 2, 38, 7, 0, 'SET', 1),
('MD-0332', 'TANK LID AP 120 NT1 /60 NT0', 5, 2, 38, 14, 0, 'SET', 1),
('MD-0333', 'TANK LID AP 60 NTO / NT1', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0334', 'TANK LID AP 812 AP 30 T0, T1', 21, 2, 38, 14, 0, 'SET', 1),
('MD-0335', 'SEIZING PLATE', 20, 2, 38, 11, 0, 'SET', 1),
('MD-0336', 'BRACKET 3 F', 7, 2, 38, 13, 0, 'SET', 1),
('MD-0337', 'Trap Flame', 7, 2, 38, 13, 0, 'SET', 1),
('MD-0341', 'TANK LID AP 812 AP 30 TO', 5, 2, 38, 14, 0, 'SET', 1),
('MD-0346', 'COVER S 74007 -1', 29, 2, 38, 11, 0, 'SET', 1),
('MD-0347', 'COVER S 71065', 21, 2, 38, 11, 0, 'SET', 1),
('MD-0348', 'COVER S 71065', 10, 2, 38, 11, 0, 'SET', 1),
('MD-0349', 'COVER S 71065', 5, 2, 38, 11, 0, 'SET', 1),
('MD-0350', 'Bracket S 81025', 1, 2, 38, 11, 0, 'SET', 1),
('MD-0351', 'Metal Insert 34 mm Single B', 25, 2, 38, 4, 0, 'SET', 4);
>>>>>>> dbaset sebelum resign

-- --------------------------------------------------------

--
-- Table structure for table `tb_kategori`
--

CREATE TABLE `tb_kategori` (
  `id_kategori` int(3) NOT NULL,
  `kode` varchar(4) NOT NULL,
  `nama_kategori` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `tb_kepemilikan` (
  `id_kepemilikan` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `tlp` varchar(12) NOT NULL,
  `alamat` varchar(300) NOT NULL,
  `ket` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(9, 'Pong Codan Indonesia', '021', 'Jl. Sentul - Citeureup No.83, Leuwinutug, Kec. Citeureup, Bogor, Jawa Barat 16810', ''),
(10, 'Sankei Gohsyu Industries', '0218980111', 'MM2100 Industrial Town Blok J-8, Cikarang Barat, Gandamekar, Kec. Cikarang Bar., Bekasi, Jawa Barat 17155', ''),
(11, 'Surya Toto Indonesia', '02127635500', 'Jl. MH. Thamrin KM 7, Desa Pakulonan, Kecamatan Serpong Utara, Panunggangan, Tangerang, Panunggangan, Pakualam, Kec. Serpong Utara, Kota Tangerang, Banten 15325', ''),
(12, 'Yamaha Indonesia', '021', 'Tidak ada', ''),
(13, 'Yasufuku Indonesia', '0218934950', 'Jl. Jababeka VII Blok L-8 Kawsan Industri Jababeka, Jl. Nasional 1, Harja Mekar, Kec. Cikarang Utara, Bekasi, Jawa Barat 17530', ''),
(14, 'Yasunaga Indonesia', '0254400306', 'Jl. Modern Industri Raya Kav. 24, Kawasan Industri Modern Cikande, Nambo Ilir, Serang, Nambo Ilir, Kec. Kibin, Serang, Banten 42186', ''),
(15, 'TTEC', '021', 'Belum tau', ''),
(16, 'LELCO', '021', 'Belum tau', ''),
(17, 'SANSHO', '021', 'Belum tau', '');

-- --------------------------------------------------------

--
-- Table structure for table `tb_lokasi`
--

CREATE TABLE `tb_lokasi` (
  `id_lokasi` int(3) NOT NULL,
  `nama_rak` varchar(10) NOT NULL,
  `lokasi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(38, 'Kosong', 'Kosong');

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE `tb_peminjaman` (
  `id_peminjaman` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `pembawa` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `ket` varchar(300) NOT NULL,
  `open` tinyint(1) NOT NULL DEFAULT '1',
  `id_user` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_peminjaman`
--

INSERT INTO `tb_peminjaman` (`id_peminjaman`, `kode`, `pembawa`, `tanggal`, `ket`, `open`, `id_user`) VALUES
(1, 'PMJ-190921-001', 'Iqbal', '2019-09-21', 'Untuk di modifikasi (trial data)', 0, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman_detail`
--

CREATE TABLE `tb_peminjaman_detail` (
  `id` int(11) NOT NULL,
  `id_peminjaman` int(11) NOT NULL,
  `id_aset` varchar(10) NOT NULL,
  `qty` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_peminjaman_detail`
--

INSERT INTO `tb_peminjaman_detail` (`id`, `id_peminjaman`, `id_aset`, `qty`) VALUES
(1, 1, 'MD-0204', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_penambahan`
--

CREATE TABLE `tb_penambahan` (
  `id_penambahan` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `pembawa` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `ket` varchar(300) DEFAULT NULL,
  `id_user` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penambahan`
--

INSERT INTO `tb_penambahan` (`id_penambahan`, `kode`, `pembawa`, `tanggal`, `ket`, `id_user`) VALUES
(1, '01/290919/01', 'Ahmad', '2019-09-21', 'Qty awal sistem', 4),
(2, '02/210919/01', 'Vera', '2019-09-21', 'Dies Baru (trial data)', 4),
(3, '03/210919/01', 'Vera', '2019-09-21', 'Dies Baru (trial data)', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tb_penambahan_detail`
--

CREATE TABLE `tb_penambahan_detail` (
  `id` int(11) NOT NULL,
  `id_penambahan` int(11) NOT NULL,
  `id_aset` varchar(10) NOT NULL,
  `qty` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penambahan_detail`
--

INSERT INTO `tb_penambahan_detail` (`id`, `id_penambahan`, `id_aset`, `qty`) VALUES
(1, 1, 'MD-0001', 1),
(2, 1, 'MD-0002', 1),
(3, 1, 'MD-0003', 1),
(4, 1, 'MD-0004', 1),
(5, 1, 'MD-0005', 1),
(6, 1, 'MD-0006', 1),
(7, 1, 'MD-0007', 1),
(8, 1, 'MD-0008', 1),
(9, 1, 'MD-0009', 1),
(10, 1, 'MD-0010', 1),
(11, 1, 'MD-0011', 1),
(12, 1, 'MD-0012', 1),
(13, 1, 'MD-0013', 1),
(14, 1, 'MD-0014', 1),
(15, 1, 'MD-0015', 1),
(16, 1, 'MD-0016', 1),
(17, 1, 'MD-0017', 1),
(18, 1, 'MD-0018', 1),
(19, 1, 'MD-0019', 1),
(20, 1, 'MD-0020', 1),
(21, 1, 'MD-0021', 1),
(22, 1, 'MD-0022', 1),
(23, 1, 'MD-0023', 1),
(24, 1, 'MD-0024', 1),
(25, 1, 'MD-0025', 1),
(26, 1, 'MD-0026', 1),
(27, 1, 'MD-0027', 1),
(28, 1, 'MD-0028', 1),
(29, 1, 'MD-0029', 1),
(30, 1, 'MD-0030', 1),
(31, 1, 'MD-0031', 1),
(32, 1, 'MD-0032', 1),
(33, 1, 'MD-0033', 1),
(34, 1, 'MD-0034', 1),
(35, 1, 'MD-0035', 1),
(36, 1, 'MD-0036', 1),
(37, 1, 'MD-0037', 1),
(38, 1, 'MD-0038', 1),
(39, 1, 'MD-0039', 1),
(40, 1, 'MD-0040', 1),
(41, 1, 'MD-0041', 1),
(42, 1, 'MD-0042', 1),
(43, 1, 'MD-0043', 1),
(44, 1, 'MD-0044', 1),
(45, 1, 'MD-0045', 1),
(46, 1, 'MD-0046', 1),
(47, 1, 'MD-0047', 1),
(48, 1, 'MD-0048', 1),
(49, 1, 'MD-0049', 1),
(50, 1, 'MD-0050', 1),
(51, 1, 'MD-0051', 1),
(52, 1, 'MD-0052', 1),
(53, 1, 'MD-0053', 1),
(54, 1, 'MD-0054', 1),
(55, 1, 'MD-0055', 1),
(56, 1, 'MD-0056', 1),
(57, 1, 'MD-0057', 1),
(58, 1, 'MD-0058', 1),
(59, 1, 'MD-0059', 1),
(60, 1, 'MD-0060', 1),
(61, 1, 'MD-0061', 1),
(62, 1, 'MD-0062', 1),
(63, 1, 'MD-0063', 1),
(64, 1, 'MD-0064', 1),
(65, 1, 'MD-0065', 1),
(66, 1, 'MD-0066', 1),
(67, 1, 'MD-0067', 1),
(68, 1, 'MD-0068', 1),
(69, 1, 'MD-0069', 1),
(70, 1, 'MD-0070', 1),
(71, 1, 'MD-0071', 1),
(72, 1, 'MD-0072', 1),
(73, 1, 'MD-0073', 1),
(74, 1, 'MD-0074', 1),
(75, 1, 'MD-0075', 1),
(76, 1, 'MD-0076', 1),
(77, 1, 'MD-0077', 1),
(78, 1, 'MD-0078', 1),
(79, 1, 'MD-0079', 1),
(80, 1, 'MD-0080', 1),
(81, 1, 'MD-0081', 1),
(82, 1, 'MD-0082', 1),
(83, 1, 'MD-0083', 1),
(84, 1, 'MD-0084', 1),
(85, 1, 'MD-0085', 1),
(86, 1, 'MD-0086', 1),
(87, 1, 'MD-0087', 1),
(88, 1, 'MD-0088', 1),
(89, 1, 'MD-0089', 1),
(90, 1, 'MD-0090', 1),
(91, 1, 'MD-0091', 1),
(92, 1, 'MD-0092', 1),
(93, 1, 'MD-0093', 1),
(94, 1, 'MD-0094', 1),
(95, 1, 'MD-0095', 1),
(96, 1, 'MD-0096', 1),
(97, 1, 'MD-0097', 1),
(98, 1, 'MD-0098', 1),
(99, 1, 'MD-0099', 1),
(100, 1, 'MD-0100', 1),
(101, 1, 'MD-0101', 1),
(102, 1, 'MD-0102', 1),
(103, 1, 'MD-0103', 1),
(104, 1, 'MD-0104', 1),
(105, 1, 'MD-0105', 1),
(106, 1, 'MD-0106', 1),
(107, 1, 'MD-0107', 1),
(108, 1, 'MD-0108', 1),
(109, 1, 'MD-0109', 1),
(110, 1, 'MD-0110', 1),
(111, 1, 'MD-0111', 1),
(112, 1, 'MD-0112', 1),
(113, 1, 'MD-0113', 1),
(114, 1, 'MD-0114', 1),
(115, 1, 'MD-0115', 1),
(116, 1, 'MD-0116', 1),
(117, 1, 'MD-0117', 1),
(118, 1, 'MD-0118', 1),
(119, 1, 'MD-0119', 1),
(120, 1, 'MD-0120', 1),
(121, 1, 'MD-0121', 1),
(122, 1, 'MD-0122', 1),
(123, 1, 'MD-0123', 1),
(124, 1, 'MD-0124', 1),
(125, 1, 'MD-0125', 1),
(126, 1, 'MD-0126', 1),
(127, 1, 'MD-0127', 1),
(128, 1, 'MD-0128', 1),
(129, 1, 'MD-0129', 1),
(130, 1, 'MD-0130', 1),
(131, 1, 'MD-0131', 1),
(132, 1, 'MD-0132', 1),
(133, 1, 'MD-0133', 1),
(134, 1, 'MD-0134', 1),
(135, 1, 'MD-0135', 1),
(136, 1, 'MD-0136', 1),
(137, 1, 'MD-0137', 1),
(138, 1, 'MD-0138', 1),
(139, 1, 'MD-0139', 1),
(140, 1, 'MD-0140', 1),
(141, 1, 'MD-0141', 1),
(142, 1, 'MD-0142', 1),
(143, 1, 'MD-0143', 1),
(144, 1, 'MD-0144', 1),
(145, 1, 'MD-0145', 1),
(146, 1, 'MD-0146', 1),
(147, 1, 'MD-0147', 1),
(148, 1, 'MD-0148', 1),
(149, 1, 'MD-0149', 1),
(150, 1, 'MD-0150', 1),
(151, 1, 'MD-0151', 1),
(152, 1, 'MD-0152', 1),
(153, 1, 'MD-0153', 1),
(154, 1, 'MD-0154', 1),
(155, 1, 'MD-0155', 1),
(156, 1, 'MD-0156', 1),
(157, 1, 'MD-0157', 1),
(158, 1, 'MD-0158', 1),
(159, 1, 'MD-0159', 1),
(160, 1, 'MD-0160', 1),
(161, 1, 'MD-0161', 1),
(162, 1, 'MD-0162', 1),
(163, 1, 'MD-0163', 1),
(164, 1, 'MD-0164', 1),
(165, 1, 'MD-0165', 1),
(166, 1, 'MD-0166', 1),
(167, 1, 'MD-0167', 1),
(168, 1, 'MD-0168', 1),
(169, 1, 'MD-0169', 1),
(170, 1, 'MD-0170', 1),
(171, 1, 'MD-0171', 1),
(172, 1, 'MD-0172', 1),
(173, 1, 'MD-0173', 1),
(174, 1, 'MD-0174', 1),
(175, 1, 'MD-0175', 1),
(176, 1, 'MD-0176', 1),
(177, 1, 'MD-0177', 1),
(178, 1, 'MD-0178', 1),
(179, 1, 'MD-0179', 1),
(180, 1, 'MD-0180', 1),
(181, 1, 'MD-0181', 1),
(182, 1, 'MD-0182', 1),
(183, 1, 'MD-0183', 1),
(184, 1, 'MD-0184', 1),
(185, 1, 'MD-0185', 1),
(186, 1, 'MD-0186', 1),
(187, 1, 'MD-0187', 1),
(188, 1, 'MD-0188', 1),
(189, 1, 'MD-0189', 1),
(190, 1, 'MD-0190', 1),
(191, 1, 'MD-0191', 1),
(192, 1, 'MD-0192', 1),
(193, 1, 'MD-0193', 1),
(194, 1, 'MD-0194', 1),
(195, 1, 'MD-0195', 1),
(196, 1, 'MD-0196', 1),
(197, 1, 'MD-0197', 1),
(198, 1, 'MD-0198', 1),
(199, 1, 'MD-0199', 1),
(200, 1, 'MD-0200', 1),
(201, 1, 'MD-0201', 1),
(202, 2, 'MD-0202', 1),
(203, 2, 'MD-0203', 1),
(204, 3, 'MD-0204', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian`
--

CREATE TABLE `tb_pengembalian` (
  `id_pengembalian` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `pembawa` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `ket` varchar(300) NOT NULL,
  `id_user` int(3) NOT NULL,
  `id_peminjaman` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pengembalian`
--

INSERT INTO `tb_pengembalian` (`id_pengembalian`, `kode`, `pembawa`, `tanggal`, `ket`, `id_user`, `id_peminjaman`) VALUES
(1, '01/01', 'Iqbal', '2019-09-21', 'Selesai modifikasi (trial data)', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengembalian_detail`
--

CREATE TABLE `tb_pengembalian_detail` (
  `id` int(11) NOT NULL,
  `id_pengembalian` int(11) NOT NULL,
  `id_aset` varchar(10) NOT NULL,
  `qty` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pengembalian_detail`
--

INSERT INTO `tb_pengembalian_detail` (`id`, `id_pengembalian`, `id_aset`, `qty`) VALUES
(1, 1, 'MD-0204', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_penghapusan`
--

CREATE TABLE `tb_penghapusan` (
  `id_penghapusan` int(11) NOT NULL,
  `kode` varchar(20) NOT NULL,
  `pembawa` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `ket` varchar(300) NOT NULL,
<<<<<<< HEAD
  `id_user` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
=======
  `id_user` int(3) NOT NULL,
  PRIMARY KEY (`id_penghapusan`),
  KEY `fk_hapus_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;
>>>>>>> dbaset sebelum resign

--
-- Dumping data for table `tb_penghapusan`
--

INSERT INTO `tb_penghapusan` (`id_penghapusan`, `kode`, `pembawa`, `tanggal`, `ket`, `id_user`) VALUES
<<<<<<< HEAD
(1, 'HPS-190921-001', 'Ahmad', '2019-09-21', 'Di PRF (trial data) ', 4);
=======
(1, 'HPS-190705-001', 'Febrian', '2015-08-14', 'Kembali ke customer', 1),
(2, 'HPS-190705-001', 'Febrian', '2015-08-19', 'Kembali ke customer', 1),
(3, 'HPS-190705-001', 'Febrian', '2015-08-21', 'Kemabli ke customer', 1),
(4, 'HPS-190705-001', 'Febrian', '2015-08-26', 'Kembali ke customer', 1),
(5, 'HPS-190705-001', 'Febrian', '2015-12-02', 'Kembali ke customer', 1),
(6, 'HPS-190705-001', 'Febrian', '2016-03-23', 'Kembali ke customer', 1),
(7, 'HPS-190705-001', 'Febrian', '2017-10-17', 'Kembali ke customer', 1),
(8, 'HPS-190705-001', 'Febrian', '2017-07-21', 'Kembali ke customer', 1),
(9, 'HPS-190705-001', 'Febrian', '2017-07-26', 'Kembali ke customer', 1),
(10, 'HPS-190705-001', 'Febrian', '2017-09-12', 'Kembali ke customer', 1),
(11, 'HPS-190705-001', 'Febrian', '2018-02-26', 'Di PRF', 1),
(12, 'HPS-190705-001', 'Febrian', '2018-02-27', 'Di PRF', 1),
(13, 'HPS-190705-001', 'Febrian', '2018-03-20', 'Kembali ke customer', 1),
(14, 'HPS-190705-001', 'Febrian', '2018-03-22', 'Kembali ke customer', 1),
(15, 'HPS-190705-001', 'Febrian', '2018-04-16', 'Kembali ke customer', 1),
(16, 'HPS-190705-001', 'Febrian', '2018-05-17', 'Kembali ke customer', 1),
(17, 'HPS-190705-001', 'Febrian', '2018-05-25', 'Kembali ke customer', 1),
(18, 'HPS-190705-001', 'Dhiskar', '2018-07-12', 'Di PRF', 1),
(19, 'HPS-190705-001', 'Febrian', '2018-07-12', 'Kembali ke customer', 1),
(20, 'HPS-190705-001', 'Febrian', '2018-09-07', 'Kembali ke customer', 1),
(21, 'HPS-190705-001', 'Febrian', '2019-03-11', 'Kemabli ke customer', 1),
(22, 'HPS-190705-001', 'Ahmad', '2019-04-08', 'Kembali ke cutomer', 1),
(23, 'HPS-190705-001', 'Ahmad', '2019-04-25', 'Kembali ke customer', 1),
(24, 'HPS-190705-001', 'Ahmad', '2019-08-07', 'Kembali ke customer', 1),
(25, 'HPS-190705-001', 'Ahmad', '2019-05-10', 'Kembali ke cutomer', 1),
(27, 'HPS-190705-001', 'Ahmad', '2019-05-13', 'Kembali ke customer', 1),
(28, 'HPS-190705-001', 'Ahmad', '2019-05-07', 'Kembali ke customer', 1),
(31, 'HPS-190724-001', 'Dhiskar', '2019-07-24', 'Di PRF / di scarp', 1),
(32, 'HPS-190815-001', 'Jesisca', '2019-08-15', 'Kembali ke Customer', 4);
>>>>>>> dbaset sebelum resign

-- --------------------------------------------------------

--
-- Table structure for table `tb_penghapusan_detail`
--

CREATE TABLE `tb_penghapusan_detail` (
  `id` int(11) NOT NULL,
  `id_penghapusan` int(11) NOT NULL,
  `id_aset` varchar(10) NOT NULL,
<<<<<<< HEAD
  `qty` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
=======
  `qty` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hapus_detail_hapus` (`id_penghapusan`),
  KEY `fk_hapus_detail_aset` (`id_aset`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=153 ;
>>>>>>> dbaset sebelum resign

--
-- Dumping data for table `tb_penghapusan_detail`
--

INSERT INTO `tb_penghapusan_detail` (`id`, `id_penghapusan`, `id_aset`, `qty`) VALUES
<<<<<<< HEAD
(1, 1, 'MD-0202', 1),
(2, 1, 'MD-0203', 1);
=======
(1, 1, 'MD-0218', 1),
(2, 1, 'MD-0219', 1),
(3, 1, 'MD-0220', 1),
(4, 1, 'MD-0221', 1),
(5, 1, 'MD-0222', 1),
(6, 1, 'MD-0223', 1),
(7, 1, 'MD-0224', 1),
(8, 1, 'MD-0225', 1),
(9, 1, 'MD-0226', 1),
(10, 1, 'MD-0350', 1),
(11, 1, 'MD-0227', 1),
(12, 1, 'MD-0228', 1),
(13, 1, 'MD-0229', 1),
(14, 1, 'MD-0230', 1),
(15, 1, 'MD-0231', 1),
(16, 2, 'MD-0351', 1),
(17, 2, 'MD-0024', 1),
(21, 4, 'MD-0233', 1),
(22, 4, 'MD-0234', 1),
(23, 4, 'MD-0235', 1),
(24, 4, 'MD-0236', 1),
(25, 4, 'MD-0237', 1),
(26, 4, 'MD-0238', 1),
(27, 4, 'MD-0239', 1),
(28, 5, 'MD-0240', 1),
(29, 5, 'MD-0241', 1),
(30, 6, 'MD-0242', 1),
(31, 7, 'MD-0243', 1),
(32, 7, 'MD-0244', 1),
(33, 8, 'MD-0245', 1),
(34, 8, 'MD-0246', 1),
(35, 8, 'MD-0247', 1),
(36, 9, 'MD-0248', 1),
(37, 9, 'MD-0249', 1),
(38, 9, 'MD-0250', 1),
(39, 10, 'MD-0265', 1),
(40, 10, 'MD-0266', 1),
(41, 10, 'MD-0267', 1),
(42, 10, 'MD-0268', 1),
(43, 10, 'MD-0269', 1),
(44, 10, 'MD-0251', 1),
(45, 10, 'MD-0252', 1),
(46, 10, 'MD-0253', 1),
(47, 10, 'MD-0254', 1),
(48, 10, 'MD-0255', 1),
(49, 10, 'MD-0256', 1),
(50, 10, 'MD-0257', 1),
(51, 10, 'MD-0258', 1),
(52, 10, 'MD-0259', 1),
(53, 10, 'MD-0260', 1),
(54, 10, 'MD-0261', 1),
(55, 10, 'MD-0262', 1),
(56, 10, 'MD-0263', 1),
(57, 10, 'MD-0264', 1),
(58, 11, 'MD-0270', 1),
(59, 11, 'MD-0271', 1),
(60, 11, 'MD-0272', 1),
(61, 11, 'MD-0273', 1),
(62, 11, 'MD-0274', 1),
(63, 11, 'MD-0275', 1),
(64, 11, 'MD-0276', 1),
(65, 11, 'MD-0277', 1),
(66, 11, 'MD-0278', 1),
(67, 11, 'MD-0279', 1),
(68, 11, 'MD-0280', 1),
(69, 11, 'MD-0281', 1),
(70, 11, 'MD-0282', 1),
(71, 11, 'MD-0283', 1),
(72, 12, 'MD-0284', 1),
(73, 12, 'MD-0285', 1),
(74, 12, 'MD-0286', 1),
(75, 12, 'MD-0287', 1),
(76, 12, 'MD-0288', 1),
(77, 12, 'MD-0289', 1),
(78, 12, 'MD-0290', 1),
(79, 12, 'MD-0291', 1),
(80, 12, 'MD-0292', 1),
(81, 13, 'MD-0293', 1),
(82, 13, 'MD-0294', 1),
(83, 14, 'MD-0295', 1),
(84, 14, 'MD-0296', 1),
(85, 14, 'MD-0297', 1),
(86, 14, 'MD-0298', 1),
(87, 14, 'MD-0299', 1),
(88, 15, 'MD-0300', 1),
(89, 15, 'MD-0060', 1),
(90, 15, 'MD-0301', 1),
(91, 16, 'MD-0303', 1),
(92, 17, 'MD-0304', 1),
(93, 17, 'MD-0305', 1),
(94, 17, 'MD-0306', 1),
(95, 17, 'MD-0307', 1),
(96, 17, 'MD-0308', 1),
(97, 17, 'MD-0309', 1),
(98, 17, 'MD-0310', 1),
(99, 17, 'MD-0311', 1),
(100, 17, 'MD-0312', 1),
(101, 17, 'MD-0313', 1),
(102, 17, 'MD-0314', 1),
(103, 17, 'MD-0315', 1),
(104, 17, 'MD-0316', 1),
(105, 17, 'MD-0317', 1),
(106, 17, 'MD-0318', 1),
(107, 17, 'MD-0319', 1),
(108, 17, 'MD-0320', 1),
(109, 17, 'MD-0321', 1),
(110, 17, 'MD-0322', 1),
(111, 17, 'MD-0323', 1),
(112, 17, 'MD-0324', 1),
(113, 17, 'MD-0325', 1),
(114, 17, 'MD-0326', 1),
(115, 17, 'MD-0327', 1),
(116, 18, 'MD-0328', 1),
(117, 19, 'MD-0329', 1),
(118, 19, 'MD-0330', 1),
(119, 19, 'MD-0331', 1),
(120, 20, 'MD-0332', 1),
(121, 20, 'MD-0333', 1),
(122, 20, 'MD-0334', 1),
(123, 21, 'MD-0335', 1),
(124, 22, 'MD-0336', 1),
(125, 23, 'MD-0337', 1),
(126, 24, 'MD-0099', 1),
(127, 25, 'MD-0085', 1),
(128, 25, 'MD-0086', 1),
(129, 25, 'MD-0341', 1),
(138, 27, 'MD-0071', 1),
(139, 27, 'MD-0072', 1),
(140, 27, 'MD-0069', 1),
(141, 27, 'MD-0070', 1),
(142, 27, 'MD-0346', 1),
(143, 27, 'MD-0347', 1),
(144, 27, 'MD-0348', 1),
(145, 27, 'MD-0349', 1),
(146, 27, 'MD-0052', 1),
(147, 27, 'MD-0053', 1),
(148, 27, 'MD-0054', 1),
(150, 31, 'MD-0232', 1),
(151, 31, 'MD-0025', 1),
(152, 32, 'MD-0002', 1);
>>>>>>> dbaset sebelum resign

-- --------------------------------------------------------

--
-- Table structure for table `tb_status`
--

CREATE TABLE `tb_status` (
  `id_status` int(3) NOT NULL,
  `status` varchar(30) NOT NULL
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

CREATE TABLE `users` (
  `id_user` int(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `jabatan` enum('Admin','Gudang','Kasir') NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nama`, `username`, `password`, `jabatan`, `status`) VALUES
(1, 'Dhiskar', 'dhiskar', 'Admin1', 'Admin', 1),
(2, 'Panji', 'panji', 'Gudang1', 'Gudang', 1),
(3, 'Jepy', 'jepy', 'Kasir1', 'Kasir', 1),
(4, 'Toni', 'toni', 'Admin2', 'Admin', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_aset`
-- (See below for the actual view)
--
CREATE TABLE `v_aset` (
`kode_aset` varchar(10)
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
,`jabatan_user` enum('Admin','Gudang','Kasir')
,`status_user` tinyint(1)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_penambahan_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_penambahan_detail` (
`id_penambahan` int(11)
,`kode_penambahan` varchar(20)
,`pembawa` varchar(30)
,`tanggal_penambahan` date
,`ket_penambahan` varchar(300)
,`id_user` int(3)
,`nama_user` varchar(30)
,`username` varchar(8)
,`id_penambahan_detail` int(11)
,`jumlah_penambahan` int(1)
,`id_aset` varchar(10)
,`nama_aset` varchar(50)
,`satuan_aset` varchar(30)
,`id_kategori_aset` int(3)
,`kode_ketegori_aset` varchar(4)
,`nama_kategori_aset` varchar(30)
,`id_status_aset` int(3)
,`status_aset` varchar(30)
,`id_lokasi_aset` int(3)
,`nama_rak` varchar(10)
,`lokasi_aset` varchar(10)
,`id_kepemilikan` int(11)
,`nama_kepemilikan` varchar(40)
,`tlp_kepemilikan` varchar(12)
,`alamat_kepemilikan` varchar(300)
);

-- --------------------------------------------------------

--
-- Structure for view `v_aset`
--
DROP TABLE IF EXISTS `v_aset`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_aset`  AS  select `tb_aset`.`id_aset` AS `kode_aset`,`tb_aset`.`nama_aset` AS `nama_aset`,`tb_kategori`.`id_kategori` AS `id_kategori`,`tb_kategori`.`kode` AS `kode_kategori`,`tb_kategori`.`nama_kategori` AS `nama_kategori`,`tb_status`.`id_status` AS `id_status`,`tb_status`.`status` AS `status_aset`,`tb_lokasi`.`id_lokasi` AS `id_lokasi`,`tb_lokasi`.`nama_rak` AS `nama_rak`,`tb_lokasi`.`lokasi` AS `lokasi_aset`,`tb_kepemilikan`.`id_kepemilikan` AS `id_kepemilikan`,`tb_kepemilikan`.`nama` AS `nama_kepemilikan`,`tb_kepemilikan`.`tlp` AS `tlp_kepemilikan`,`tb_kepemilikan`.`alamat` AS `alamat_kepemilikan`,`tb_kepemilikan`.`ket` AS `ket_kepemilikan`,`tb_aset`.`qty` AS `quantity`,`tb_aset`.`satuan` AS `satuan`,`users`.`id_user` AS `id_user`,`users`.`nama` AS `nama_user`,`users`.`username` AS `username`,`users`.`password` AS `password`,`users`.`jabatan` AS `jabatan_user`,`users`.`status` AS `status_user` from (((((`tb_aset` left join `tb_kategori` on((`tb_aset`.`id_kategori` = `tb_kategori`.`id_kategori`))) left join `tb_status` on((`tb_aset`.`id_status` = `tb_status`.`id_status`))) left join `tb_lokasi` on((`tb_aset`.`id_lokasi` = `tb_lokasi`.`id_lokasi`))) left join `tb_kepemilikan` on((`tb_aset`.`id_kepemilikan` = `tb_kepemilikan`.`id_kepemilikan`))) left join `users` on((`tb_aset`.`id_user` = `users`.`id_user`))) ;

-- --------------------------------------------------------

--
-- Structure for view `v_penambahan_detail`
--
DROP TABLE IF EXISTS `v_penambahan_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_penambahan_detail`  AS  select `b`.`id_penambahan` AS `id_penambahan`,`b`.`kode` AS `kode_penambahan`,`b`.`pembawa` AS `pembawa`,`b`.`tanggal` AS `tanggal_penambahan`,`b`.`ket` AS `ket_penambahan`,`u`.`id_user` AS `id_user`,`u`.`nama` AS `nama_user`,`u`.`username` AS `username`,`bd`.`id` AS `id_penambahan_detail`,`bd`.`qty` AS `jumlah_penambahan`,`ast`.`id_aset` AS `id_aset`,`ast`.`nama_aset` AS `nama_aset`,`ast`.`satuan` AS `satuan_aset`,`kast`.`id_kategori` AS `id_kategori_aset`,`kast`.`kode` AS `kode_ketegori_aset`,`kast`.`nama_kategori` AS `nama_kategori_aset`,`s`.`id_status` AS `id_status_aset`,`s`.`status` AS `status_aset`,`l`.`id_lokasi` AS `id_lokasi_aset`,`l`.`nama_rak` AS `nama_rak`,`l`.`lokasi` AS `lokasi_aset`,`c`.`id_kepemilikan` AS `id_kepemilikan`,`c`.`nama` AS `nama_kepemilikan`,`c`.`tlp` AS `tlp_kepemilikan`,`c`.`alamat` AS `alamat_kepemilikan` from (((((((`tb_penambahan` `b` join `tb_penambahan_detail` `bd` on((`b`.`id_penambahan` = `bd`.`id_penambahan`))) join `users` `u` on((`u`.`id_user` = `b`.`id_user`))) join `tb_aset` `ast` on((`bd`.`id_aset` = `ast`.`id_aset`))) join `tb_kategori` `kast` on((`kast`.`id_kategori` = `ast`.`id_kategori`))) join `tb_status` `s` on((`s`.`id_status` = `ast`.`id_status`))) join `tb_lokasi` `l` on((`l`.`id_lokasi` = `ast`.`id_lokasi`))) join `tb_kepemilikan` `c` on((`c`.`id_kepemilikan` = `ast`.`id_kepemilikan`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_aset`
--
ALTER TABLE `tb_aset`
  ADD PRIMARY KEY (`id_aset`),
  ADD KEY `fk_aset_kategori` (`id_kategori`) USING BTREE,
  ADD KEY `fk_aset_status` (`id_status`) USING BTREE,
  ADD KEY `fk_aset_lokasi` (`id_lokasi`) USING BTREE,
  ADD KEY `fk_aset_customer` (`id_kepemilikan`) USING BTREE,
  ADD KEY `fk_aset_user` (`id_user`);

--
-- Indexes for table `tb_kategori`
--
ALTER TABLE `tb_kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `tb_kepemilikan`
--
ALTER TABLE `tb_kepemilikan`
  ADD PRIMARY KEY (`id_kepemilikan`);

--
-- Indexes for table `tb_lokasi`
--
ALTER TABLE `tb_lokasi`
  ADD PRIMARY KEY (`id_lokasi`);

--
-- Indexes for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `fk_pinjam_user` (`id_user`);

--
-- Indexes for table `tb_peminjaman_detail`
--
ALTER TABLE `tb_peminjaman_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_beli_detai_aset` (`id_aset`),
  ADD KEY `fk_pinjam_detai_pinjam` (`id_peminjaman`) USING BTREE;

--
-- Indexes for table `tb_penambahan`
--
ALTER TABLE `tb_penambahan`
  ADD PRIMARY KEY (`id_penambahan`),
  ADD KEY `fk_tambah_user` (`id_user`) USING BTREE,
  ADD KEY `kode2` (`kode`);

--
-- Indexes for table `tb_penambahan_detail`
--
ALTER TABLE `tb_penambahan_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tambah_detail_tambah` (`id_penambahan`),
  ADD KEY `fk_tambah_detial_aset` (`id_aset`);

--
-- Indexes for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `fk_balik_user` (`id_user`);

--
-- Indexes for table `tb_pengembalian_detail`
--
ALTER TABLE `tb_pengembalian_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_balik_detail_balik` (`id_pengembalian`),
  ADD KEY `fk_balik_detail_aset` (`id_aset`) USING BTREE;

--
-- Indexes for table `tb_penghapusan`
--
ALTER TABLE `tb_penghapusan`
  ADD PRIMARY KEY (`id_penghapusan`),
  ADD KEY `fk_hapus_user` (`id_user`);

--
-- Indexes for table `tb_penghapusan_detail`
--
ALTER TABLE `tb_penghapusan_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_hapus_detail_hapus` (`id_penghapusan`),
  ADD KEY `fk_hapus_detail_aset` (`id_aset`) USING BTREE;

--
-- Indexes for table `tb_status`
--
ALTER TABLE `tb_status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `uniq_username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_kategori`
--
ALTER TABLE `tb_kategori`
  MODIFY `id_kategori` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `tb_kepemilikan`
--
ALTER TABLE `tb_kepemilikan`
  MODIFY `id_kepemilikan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tb_lokasi`
--
ALTER TABLE `tb_lokasi`
  MODIFY `id_lokasi` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_peminjaman_detail`
--
ALTER TABLE `tb_peminjaman_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_penambahan`
--
ALTER TABLE `tb_penambahan`
  MODIFY `id_penambahan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_penambahan_detail`
--
ALTER TABLE `tb_penambahan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- AUTO_INCREMENT for table `tb_pengembalian`
--
ALTER TABLE `tb_pengembalian`
  MODIFY `id_pengembalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_pengembalian_detail`
--
ALTER TABLE `tb_pengembalian_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_penghapusan`
--
ALTER TABLE `tb_penghapusan`
  MODIFY `id_penghapusan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_penghapusan_detail`
--
ALTER TABLE `tb_penghapusan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
-- Constraints for table `tb_penambahan`
--
ALTER TABLE `tb_penambahan`
  ADD CONSTRAINT `tb_penambahan_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `tb_penambahan_detail`
--
ALTER TABLE `tb_penambahan_detail`
  ADD CONSTRAINT `tb_penambahan_detail_ibfk_1` FOREIGN KEY (`id_penambahan`) REFERENCES `tb_penambahan` (`id_penambahan`),
  ADD CONSTRAINT `tb_penambahan_detail_ibfk_2` FOREIGN KEY (`id_aset`) REFERENCES `tb_aset` (`id_aset`);

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

--
-- Constraints for table `tb_penghapusan`
--
ALTER TABLE `tb_penghapusan`
  ADD CONSTRAINT `tb_penghapusan_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `tb_penghapusan_detail`
--
ALTER TABLE `tb_penghapusan_detail`
  ADD CONSTRAINT `tb_penghapusan_detail_ibfk_1` FOREIGN KEY (`id_penghapusan`) REFERENCES `tb_penghapusan` (`id_penghapusan`),
  ADD CONSTRAINT `tb_penghapusan_detail_ibfk_2` FOREIGN KEY (`id_aset`) REFERENCES `tb_aset` (`id_aset`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
