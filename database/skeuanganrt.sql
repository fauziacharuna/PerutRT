-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25 Apr 2018 pada 16.49
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `skeuanganrt`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `deposit`
--

CREATE TABLE `deposit` (
  `deposit_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `deposit_Nominal` double NOT NULL,
  `user_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `deposit`
--

INSERT INTO `deposit` (`deposit_id`, `deposit_Nominal`, `user_id`) VALUES
(0150001, 15000, 0250001),
(0150002, 12000, 0250002),
(0150003, 4000, 0250003),
(0150004, 1000, 0250004),
(0150005, 21000, 0250005),
(0150006, 12000, 0250006),
(0150007, 2000, 0250007),
(0150008, 2500, 0250008),
(0150009, 7000, 0250009),
(0150010, 4500, 0250010);

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran`
--

CREATE TABLE `iuran` (
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Nama` varchar(50) NOT NULL,
  `iuran_Nominal` double NOT NULL,
  `iuran_Tanggal` date NOT NULL,
  `iuran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `iuran`
--

INSERT INTO `iuran` (`iuran_id`, `iuran_Nama`, `iuran_Nominal`, `iuran_Tanggal`, `iuran_Kategori_id`, `iuran_Jenis_id`) VALUES
(0350001, 'Iuran Pokok Bulan April', 15000, '2018-04-24', 0650001, 0750001),
(0350002, 'iuran Sampah bulan April', 10000, '2018-04-23', 0650001, 0750003),
(0350003, 'iuran sosial bulan april', 5000, '2018-04-24', 0650001, 0750002),
(0350004, 'iuran 17-an', 40000, '2018-04-23', 0650002, 0750005),
(0350005, 'iuran pembangunan pos kamling', 100000, '2018-04-15', 0650002, 0750006);

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran_jenis`
--

CREATE TABLE `iuran_jenis` (
  `iuran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Jenis_Nama` varchar(35) NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `iuran_jenis`
--

INSERT INTO `iuran_jenis` (`iuran_Jenis_id`, `iuran_Jenis_Nama`, `iuran_id`) VALUES
(0750001, 'Iuran Pokok', 0000000),
(0750002, 'Iuran Sosial', 0000000),
(0750003, 'Iuran Sampah', 0000000),
(0750004, 'iuran syawalan', 0000000),
(0750005, 'iuran 17-an', 0000000),
(0750006, 'iuran pembangunan', 0000000),
(0750007, 'sumbangan', 0000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran_kategori`
--

CREATE TABLE `iuran_kategori` (
  `iuran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Kategori_Nama` varchar(35) NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `iuran_kategori`
--

INSERT INTO `iuran_kategori` (`iuran_Kategori_id`, `iuran_Kategori_Nama`, `iuran_id`) VALUES
(0650001, 'Iuran Rutin', 0000000),
(0650002, 'iuran insidental', 0000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran_perubahan`
--

CREATE TABLE `iuran_perubahan` (
  `iuran_Perubahan_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Perubahan_Nama` varchar(17) NOT NULL,
  `iuran_Perubahan_Nominal` double NOT NULL,
  `iuran_Perubahan_Tanggal` date NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran_user`
--

CREATE TABLE `iuran_user` (
  `iuran_User_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_User_Status` tinyint(1) NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `user_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `iuran_user`
--

INSERT INTO `iuran_user` (`iuran_User_id`, `iuran_User_Status`, `iuran_id`, `user_id`) VALUES
(0350005, 1, 0350005, 0250010),
(0450001, 1, 0350001, 0250009),
(0450002, 1, 0350002, 0250005),
(0450003, 1, 0350003, 0250006),
(0450004, 1, 0350004, 0250008);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Nama` varchar(50) NOT NULL,
  `pengeluaran_Nominal` double NOT NULL,
  `pengeluaran_Tanggal` date NOT NULL,
  `pengeluaran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`pengeluaran_id`, `pengeluaran_Nama`, `pengeluaran_Nominal`, `pengeluaran_Tanggal`, `pengeluaran_Kategori_id`, `pengeluaran_Jenis_id`) VALUES
(0550001, 'iuran pokok rw bulan april', 50000, '2018-04-04', 0950001, 0850001),
(0550002, 'pemeliharaan makam', 25000, '2018-04-24', 0950001, 0850003);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran_jenis`
--

CREATE TABLE `pengeluaran_jenis` (
  `pengeluaan_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Jenis_Nama` varchar(50) NOT NULL,
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengeluaran_jenis`
--

INSERT INTO `pengeluaran_jenis` (`pengeluaan_Jenis_id`, `pengeluaran_Jenis_Nama`, `pengeluaran_id`) VALUES
(0850001, 'iuran pokok rw bulan april', 0550001),
(0850003, 'pemeliharaan makam', 0550002);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran_kategori`
--

CREATE TABLE `pengeluaran_kategori` (
  `pengeluaran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Kategori_Nama` varchar(25) NOT NULL,
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengeluaran_kategori`
--

INSERT INTO `pengeluaran_kategori` (`pengeluaran_Kategori_id`, `pengeluaran_Kategori_Nama`, `pengeluaran_id`) VALUES
(0950001, 'iuran rutin', 0550001),
(0950002, 'iuran insidental', 0550002);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran_perubahan`
--

CREATE TABLE `pengeluaran_perubahan` (
  `pengeluaran_Perubahan_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Perubahan_Nama` varchar(35) NOT NULL,
  `pengeluaran_Perubahan_Nominal` double NOT NULL,
  `pengeluaran_Perubahan_Tanggal` date NOT NULL,
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `transaksi_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `transaksi_Tanggal` date NOT NULL,
  `transaksi_Nama` varchar(35) NOT NULL,
  `transaksi_Nominal` double NOT NULL,
  `user_id` int(7) UNSIGNED ZEROFILL DEFAULT NULL,
  `user_Username` varchar(20) DEFAULT NULL,
  `transaksi_tipe` enum('iuran','pengeluaran') NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL DEFAULT NULL,
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`transaksi_id`, `transaksi_Tanggal`, `transaksi_Nama`, `transaksi_Nominal`, `user_id`, `user_Username`, `transaksi_tipe`, `iuran_id`, `pengeluaran_id`) VALUES
(0660001, '2018-04-24', 'iuran pokok bulan april', 15000, 0250009, 'alfimupik', 'iuran', 0350001, NULL),
(0660002, '2018-04-23', 'iuran sampah bulan april', 10000, 0250005, 'tentinblap', 'iuran', 0350002, NULL),
(0660003, '2018-04-24', 'iuran sosial bulan april', 5000, 0250006, 'lerianaei', 'iuran', 0350003, NULL),
(0660004, '2018-04-15', 'iuran pembangunan pos kamling', 100000, 0250010, 'agylryan', 'iuran', 0350005, NULL),
(0660005, '2018-04-23', 'iuan 17-an', 40000, 0250008, 'ghanghan', 'iuran', 0350004, NULL),
(0660006, '2018-04-04', 'iuran pokok rw bulan april', 50000, NULL, NULL, 'pengeluaran', NULL, 0550001),
(0660007, '2018-04-24', 'pengelola pemeliharaan makam', 25000, NULL, NULL, 'pengeluaran', NULL, 0550002);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `user_Username` varchar(35) NOT NULL,
  `user_Password` varchar(35) NOT NULL,
  `user_Nama_Lengkap` varchar(30) NOT NULL,
  `user_KTP` varchar(35) NOT NULL,
  `user_Alamat` varchar(50) NOT NULL,
  `user_Tanggal_lahir` date NOT NULL,
  `user_Tipe_User` enum('admin','operator','warga') NOT NULL DEFAULT 'warga',
  `user_Gender` enum('laki-laki','perempuan') NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `user_NoHP` varchar(15) NOT NULL,
  `deposit_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `user_Username`, `user_Password`, `user_Nama_Lengkap`, `user_KTP`, `user_Alamat`, `user_Tanggal_lahir`, `user_Tipe_User`, `user_Gender`, `user_email`, `user_NoHP`, `deposit_id`) VALUES
(0250001, 'titisnad', '1234567', 'Titis Nadela', '321560870061234567', 'Pogung Dalangan No. 76 Sleman Yogyakarta', '1998-04-03', 'operator', 'perempuan', 'titisnadela.tn@gmail.com', '082244067730', 0150001),
(0250002, 'fauziah', '2345678', 'Fauzi Ahmad Ha', '35126780098003017', 'Sendowo no. 45 Sleman Yogyakarta', '1998-05-23', 'admin', 'laki-laki', 'fauziahmadha78@gmail.com', '087765897012', 0150002),
(0250003, 'desiset', '3456789', 'Desi Setyawati', '3521670890012002', 'Pogung Dalangan No. 76 Sleman Yogyakarta', '1997-12-02', 'operator', 'perempuan', 'desiset123@gmail.com', '082134563876', 0150003),
(0250004, 'anggihintani', '4567891', 'Anggih Intani', '3452001789039801', 'KarangMalang no. 17 Sleman Yogyakarta', '1998-04-16', 'operator', 'perempuan', 'anggihintani23@gmail.com', '082623498712', 0150004),
(0250005, 'tentinblap', '9876543', 'Msy Yustenti Nabila', '35267819876498008', 'Pogung Baru no. 45 Sleman Yogyakarta', '1998-09-02', 'warga', 'perempuan', 'yustentinabila@gmail.com', '082110004521', 0150005),
(0250006, 'lerianaei', '8765432', 'Leriana Thufailah', '3527816549800607', 'Belimbingsari no 123 Sleman Yogyakarta', '1998-09-21', 'warga', 'perempuan', 'lerianaei23@gmail.com', '081234567892', 0150006),
(0250007, 'andriap', '3456789', 'Andri Cahya', '3512676900769008', 'Sendowo no 89 Sleman Yogyakarta', '1998-01-12', 'warga', 'laki-laki', 'andricahya25@gmail.com', '081234543765', 0150007),
(0250008, 'ghanghan', '4567891', 'Ghani Erlangga', '35219870098748900', 'Jln Kaliurang no 89 Sleman Yogyakarta', '1998-08-05', 'warga', 'laki-laki', 'ghanighani67@gmail.com', '082345674123', 0150008),
(0250009, 'alfimupik', '5678912', 'Alfi Triana Mufidah', '3512765437890087', 'Pogung Baru no. 45 Sleman Yogyakarta', '1998-10-19', 'warga', 'perempuan', 'alfitriana67@gmail.com', '083452673123', 0150009),
(0250010, 'agylryan', '6789123', 'Agyl Ryan Pradipta', '35127650098760098', 'Pogung Rejo no. 34 Sleman Yogyakarta', '1998-04-19', 'warga', 'laki-laki', 'agylryan12@gmail.com', '086345123098', 0150010);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deposit`
--
ALTER TABLE `deposit`
  ADD PRIMARY KEY (`deposit_id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Indexes for table `iuran`
--
ALTER TABLE `iuran`
  ADD PRIMARY KEY (`iuran_id`),
  ADD UNIQUE KEY `iuran_Kategori_id` (`iuran_Kategori_id`,`iuran_Jenis_id`),
  ADD KEY `iuran_Jenis_id` (`iuran_Jenis_id`);

--
-- Indexes for table `iuran_jenis`
--
ALTER TABLE `iuran_jenis`
  ADD PRIMARY KEY (`iuran_Jenis_id`);

--
-- Indexes for table `iuran_kategori`
--
ALTER TABLE `iuran_kategori`
  ADD PRIMARY KEY (`iuran_Kategori_id`);

--
-- Indexes for table `iuran_perubahan`
--
ALTER TABLE `iuran_perubahan`
  ADD PRIMARY KEY (`iuran_Perubahan_id`),
  ADD UNIQUE KEY `iuran_id` (`iuran_id`);

--
-- Indexes for table `iuran_user`
--
ALTER TABLE `iuran_user`
  ADD PRIMARY KEY (`iuran_User_id`),
  ADD UNIQUE KEY `iuran_id` (`iuran_id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Indexes for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`pengeluaran_id`),
  ADD UNIQUE KEY `pengeluaran_Kategori_id` (`pengeluaran_Kategori_id`,`pengeluaran_Jenis_id`),
  ADD KEY `pengeluaran_Jenis_id` (`pengeluaran_Jenis_id`);

--
-- Indexes for table `pengeluaran_jenis`
--
ALTER TABLE `pengeluaran_jenis`
  ADD PRIMARY KEY (`pengeluaan_Jenis_id`),
  ADD UNIQUE KEY `pengeluaran_id` (`pengeluaran_id`);

--
-- Indexes for table `pengeluaran_kategori`
--
ALTER TABLE `pengeluaran_kategori`
  ADD PRIMARY KEY (`pengeluaran_Kategori_id`),
  ADD UNIQUE KEY `pengeluaran_id` (`pengeluaran_id`);

--
-- Indexes for table `pengeluaran_perubahan`
--
ALTER TABLE `pengeluaran_perubahan`
  ADD PRIMARY KEY (`pengeluaran_Perubahan_id`),
  ADD UNIQUE KEY `pengeluaran_id` (`pengeluaran_id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`transaksi_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `iuran_id` (`iuran_id`,`pengeluaran_id`),
  ADD KEY `pengeluaran_id` (`pengeluaran_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `deposit_id` (`deposit_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deposit`
--
ALTER TABLE `deposit`
  MODIFY `deposit_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=150011;
--
-- AUTO_INCREMENT for table `iuran`
--
ALTER TABLE `iuran`
  MODIFY `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=350006;
--
-- AUTO_INCREMENT for table `iuran_jenis`
--
ALTER TABLE `iuran_jenis`
  MODIFY `iuran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=750008;
--
-- AUTO_INCREMENT for table `iuran_kategori`
--
ALTER TABLE `iuran_kategori`
  MODIFY `iuran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=750002;
--
-- AUTO_INCREMENT for table `iuran_perubahan`
--
ALTER TABLE `iuran_perubahan`
  MODIFY `iuran_Perubahan_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `iuran_user`
--
ALTER TABLE `iuran_user`
  MODIFY `iuran_User_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=450005;
--
-- AUTO_INCREMENT for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=550003;
--
-- AUTO_INCREMENT for table `pengeluaran_jenis`
--
ALTER TABLE `pengeluaran_jenis`
  MODIFY `pengeluaan_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=850004;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `transaksi_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=660008;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=250011;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `deposit`
--
ALTER TABLE `deposit`
  ADD CONSTRAINT `deposit_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `iuran`
--
ALTER TABLE `iuran`
  ADD CONSTRAINT `iuran_ibfk_1` FOREIGN KEY (`iuran_Jenis_id`) REFERENCES `iuran_jenis` (`iuran_Jenis_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `iuran_ibfk_2` FOREIGN KEY (`iuran_Kategori_id`) REFERENCES `iuran_kategori` (`iuran_Kategori_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `iuran_perubahan`
--
ALTER TABLE `iuran_perubahan`
  ADD CONSTRAINT `iuran_perubahan_ibfk_2` FOREIGN KEY (`iuran_id`) REFERENCES `iuran` (`iuran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `iuran_user`
--
ALTER TABLE `iuran_user`
  ADD CONSTRAINT `iuran_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `iuran_user_ibfk_2` FOREIGN KEY (`iuran_id`) REFERENCES `iuran` (`iuran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_2` FOREIGN KEY (`pengeluaran_Jenis_id`) REFERENCES `pengeluaran_jenis` (`pengeluaan_Jenis_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pengeluaran_ibfk_3` FOREIGN KEY (`pengeluaran_Kategori_id`) REFERENCES `pengeluaran_kategori` (`pengeluaran_Kategori_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran_perubahan`
--
ALTER TABLE `pengeluaran_perubahan`
  ADD CONSTRAINT `pengeluaran_perubahan_ibfk_1` FOREIGN KEY (`pengeluaran_id`) REFERENCES `pengeluaran` (`pengeluaran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`iuran_id`) REFERENCES `iuran` (`iuran_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`pengeluaran_id`) REFERENCES `pengeluaran` (`pengeluaran_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
