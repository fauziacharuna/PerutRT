-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24 Apr 2018 pada 12.10
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
  `user_id` int(7) NOT NULL,
  `deposit_jumlah` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `deposit`
--

INSERT INTO `deposit` (`deposit_id`, `user_id`, `deposit_jumlah`) VALUES
(0001234, 25755, 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran`
--

CREATE TABLE `iuran` (
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Nama` varchar(35) NOT NULL,
  `iuran_Nominal` double NOT NULL,
  `iuran_Tanggal` date NOT NULL,
  `iuran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran_jenis`
--

CREATE TABLE `iuran_jenis` (
  `iuran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Jenis_Nama` varchar(35) NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `iuran_kategori`
--

CREATE TABLE `iuran_kategori` (
  `iuran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `iuran_Kategori_Nama` varchar(35) NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Nama` varchar(17) NOT NULL,
  `pengeluaran_Nominal` double NOT NULL,
  `pengeluaran_Tanggal` date NOT NULL,
  `pengeluaran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran_jenis`
--

CREATE TABLE `pengeluaran_jenis` (
  `pengeluaan_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Jenis_Nama` varchar(35) NOT NULL,
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran_kategori`
--

CREATE TABLE `pengeluaran_kategori` (
  `pengeluaran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Kategori_Nama` varchar(25) NOT NULL,
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran_perubahan`
--

CREATE TABLE `pengeluaran_perubahan` (
  `pengeluaran_Perubahan_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_Perubahan_Nama` varchar(25) NOT NULL,
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
  `transaksi_Nama` varchar(15) NOT NULL,
  `transaksi_Nominal` double NOT NULL,
  `user_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `user_Username` varchar(7) NOT NULL,
  `transaksi_tipe` enum('iuran','pengeluaran') NOT NULL,
  `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `transaksi_Saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` int(7) UNSIGNED ZEROFILL NOT NULL,
  `user_Username` varchar(7) NOT NULL,
  `user_Password` varchar(12) NOT NULL,
  `user_Nama_Lengkap` varchar(30) NOT NULL,
  `user_KTP` int(17) NOT NULL,
  `user_Alamat` varchar(50) NOT NULL,
  `user_Tanggal_lahir` date NOT NULL,
  `user_Tipe_User` enum('admin','operator','warga') NOT NULL DEFAULT 'warga',
  `user_Gender` enum('laki-laki','perempuan') NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `user_NoHP` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD UNIQUE KEY `iuran_Kategori_id` (`iuran_Kategori_id`,`iuran_Jenis_id`);

--
-- Indexes for table `iuran_jenis`
--
ALTER TABLE `iuran_jenis`
  ADD PRIMARY KEY (`iuran_Jenis_id`),
  ADD UNIQUE KEY `iuran_id` (`iuran_id`);

--
-- Indexes for table `iuran_kategori`
--
ALTER TABLE `iuran_kategori`
  ADD PRIMARY KEY (`iuran_Kategori_id`),
  ADD UNIQUE KEY `iuran_id` (`iuran_id`);

--
-- Indexes for table `iuran_perubahan`
--
ALTER TABLE `iuran_perubahan`
  ADD PRIMARY KEY (`iuran_Perubahan_id`),
  ADD UNIQUE KEY `iuran_id` (`iuran_id`);

--
-- Indexes for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`pengeluaran_id`),
  ADD UNIQUE KEY `pengeluaran_Kategori_id` (`pengeluaran_Kategori_id`,`pengeluaran_Jenis_id`);

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
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deposit`
--
ALTER TABLE `deposit`
  MODIFY `deposit_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20002;
--
-- AUTO_INCREMENT for table `iuran`
--
ALTER TABLE `iuran`
  MODIFY `iuran_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `iuran_jenis`
--
ALTER TABLE `iuran_jenis`
  MODIFY `iuran_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `iuran_kategori`
--
ALTER TABLE `iuran_kategori`
  MODIFY `iuran_Kategori_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `iuran_perubahan`
--
ALTER TABLE `iuran_perubahan`
  MODIFY `iuran_Perubahan_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `pengeluaran_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pengeluaran_jenis`
--
ALTER TABLE `pengeluaran_jenis`
  MODIFY `pengeluaan_Jenis_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `transaksi_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(7) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20002;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `iuran`
--
ALTER TABLE `iuran`
  ADD CONSTRAINT `iuran_ibfk_1` FOREIGN KEY (`iuran_id`) REFERENCES `transaksi` (`iuran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `iuran_jenis`
--
ALTER TABLE `iuran_jenis`
  ADD CONSTRAINT `iuran_jenis_ibfk_1` FOREIGN KEY (`iuran_id`) REFERENCES `iuran` (`iuran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `iuran_kategori`
--
ALTER TABLE `iuran_kategori`
  ADD CONSTRAINT `iuran_kategori_ibfk_1` FOREIGN KEY (`iuran_id`) REFERENCES `iuran` (`iuran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `iuran_perubahan`
--
ALTER TABLE `iuran_perubahan`
  ADD CONSTRAINT `iuran_perubahan_ibfk_1` FOREIGN KEY (`iuran_id`) REFERENCES `iuran` (`iuran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`pengeluaran_id`) REFERENCES `transaksi` (`pengeluaran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran_jenis`
--
ALTER TABLE `pengeluaran_jenis`
  ADD CONSTRAINT `pengeluaran_jenis_ibfk_1` FOREIGN KEY (`pengeluaran_id`) REFERENCES `pengeluaran` (`pengeluaran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran_kategori`
--
ALTER TABLE `pengeluaran_kategori`
  ADD CONSTRAINT `pengeluaran_kategori_ibfk_1` FOREIGN KEY (`pengeluaran_id`) REFERENCES `pengeluaran` (`pengeluaran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengeluaran_perubahan`
--
ALTER TABLE `pengeluaran_perubahan`
  ADD CONSTRAINT `pengeluaran_perubahan_ibfk_1` FOREIGN KEY (`pengeluaran_id`) REFERENCES `pengeluaran` (`pengeluaran_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `deposit` (`deposit_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
