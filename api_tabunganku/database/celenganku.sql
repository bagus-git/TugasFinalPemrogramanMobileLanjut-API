-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jun 2021 pada 05.03
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `celenganku`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_login`
--

CREATE TABLE `tabel_login` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `re_entry_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tabel_login`
--

INSERT INTO `tabel_login` (`id`, `email`, `password`, `re_entry_password`) VALUES
(1, 'bagus@gmail.com', '123', '123'),
(2, 'oky@gmail.com', '112', '112'),
(3, 'ade@gmail.com', '113', '113'),
(4, 'dhiemas@gmail.com', '114', '114'),
(5, 'wahyu@gmail.com', '115', '115');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_riwayat`
--

CREATE TABLE `tabel_riwayat` (
  `id_riwayat` int(11) NOT NULL,
  `nama_pengeluaran` varchar(50) NOT NULL,
  `jumlah_pengeluaran` int(11) NOT NULL,
  `tanggal_bulan_tahun` varchar(50) NOT NULL,
  `catatan_pengeluaran` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tabel_riwayat`
--

INSERT INTO `tabel_riwayat` (`id_riwayat`, `nama_pengeluaran`, `jumlah_pengeluaran`, `tanggal_bulan_tahun`, `catatan_pengeluaran`) VALUES
(1, 'Belanja Harian', 50000, '2021-06-10', 'ok'),
(2, 'uang saku', 25000, '2021-06-09', 'kurang'),
(3, 'THR ', 100, '2021-06-01', 'pas');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tabel_login`
--
ALTER TABLE `tabel_login`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tabel_riwayat`
--
ALTER TABLE `tabel_riwayat`
  ADD PRIMARY KEY (`id_riwayat`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tabel_login`
--
ALTER TABLE `tabel_login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `tabel_riwayat`
--
ALTER TABLE `tabel_riwayat`
  MODIFY `id_riwayat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
