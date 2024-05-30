-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2024 at 05:03 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffeeshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `jenis` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `nama`, `harga`, `jenis`) VALUES
(1, 'Americano', 12000, 'Minuman'),
(2, 'Mochacchino', 15000, 'Minuman'),
(3, 'Hazelnut Latte', 20000, 'Minuman'),
(4, 'Vanilla Latte', 17000, 'Minuman'),
(5, 'Salted Caramel', 18000, 'Minuman'),
(7, 'Sea Salt', 23000, 'Additional'),
(9, 'Cow Milk', 5000, 'Additional'),
(11, 'susu', 5000000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `menu` varchar(100) NOT NULL,
  `ttlharga` varchar(100) NOT NULL,
  `size` varchar(10) NOT NULL,
  `hot_ice` varchar(11) NOT NULL,
  `sweetness` varchar(50) NOT NULL,
  `topping` set('Caramel Sauce','Caramel Crumble','Choco Granola','Sea Salt Cream') DEFAULT NULL,
  `dairy` varchar(10) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `nama`, `menu`, `ttlharga`, `size`, `hot_ice`, `sweetness`, `topping`, `dairy`, `note`) VALUES
(1, 'malin', 'vanilla latte', '32000', 'large', 'ice', 'normal swee', 'Caramel Sauce,Caramel Crumble,Choco Granola', NULL, NULL),
(2, 'alung', 'f', '10000', 'a', 'd', 'd', 'Caramel Crumble', 'Cow Milk', 'h'),
(3, 'frame0', 'Vanilla Latte', '10000', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Crumble', 'Cow Milk', 'sad'),
(4, 'alung', 'Mochacchino', '10000', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Sauce', 'Oat Milk', 'asdasd'),
(5, 'alung', 'Mochacchino', '10000', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Crumble', 'Oat Milk', 'asdasd'),
(6, 'asda', 'Mochacchino', '10000', 'Regular', 'Hot', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Cow Milk', 'asd'),
(7, 'asda', 'Sea Salt', '10000', 'Regular', 'Hot', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Cow Milk', 'asd'),
(8, 'asda', 'Americano', '10000', 'Regular', 'Hot', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Cow Milk', 'asd'),
(9, 'asd', 'Sea Salt', '10000', 'Regular', 'Hot', 'Normal Sweet', '', 'Cow Milk', 'sd'),
(10, 'sD', 'Sea Salt', '10000', 'Regular', 'Hot', 'Normal Sweet', '', '', 'ASD'),
(11, 'sD', 'Salted Caramel', '10000', 'Regular', 'Hot', 'Normal Sweet', '', '', 'ASD'),
(12, 'sD', 'Hazelnut Latte', '10000', 'Regular', 'Hot', 'Normal Sweet', '', '', 'ASD'),
(13, 'sD', 'Sea Salt', '10000', 'Regular', 'Hot', 'Normal Sweet', '', 'Oat Milk', 'ASD'),
(14, '', 'Hazelnut Latte', '10000', 'Regular', 'Hot', 'Normal Sweet', '', 'Cow Milk', ''),
(15, 'sasa', 'Salted Caramel', '36000', 'Large', 'Ice', 'Normal Sweet', 'Caramel Crumble,Sea Salt Cream', 'Oat Milk', 'as'),
(16, 'asd', 'Salted Caramel', '31000', 'Large', 'Ice', 'Normal Sweet', 'Caramel Crumble,Sea Salt Cream', 'Oat Milk', ''),
(17, 'zxc', 'Salted Caramel', '31000', 'Large', 'Hot', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble', 'Cow Milk', ''),
(18, 'sd', 'Salted Caramel', '36000', 'Large', 'Ice', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', ''),
(19, 'dsa', 'Salted Caramel', '36000', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', ''),
(20, 'asd', 'Salted Caramel', '36000', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', ''),
(21, 'q', 'Salted Caramel', '41400', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', ''),
(22, 'asAS', 'Salted Caramel', '50600', 'Large', 'Hot', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', ''),
(23, 'asa', 'Sea Salt', '41400', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', 'ASSA'),
(24, 'as', 'Salted Caramel', '41400', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', ''),
(25, 'd', 'Salted Caramel', '40250', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble,Sea Salt Cream', 'Cow Milk', ''),
(26, 'asd', 'Salted Caramel', '36800', 'Large', 'Hot', 'Less Sweet', 'Caramel Sauce', 'Oat Milk', 'd'),
(27, 's', 'Vanilla Latte', '35650', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce', 'Oat Milk', 's'),
(28, 'd', 'Vanilla Latte', '29900', 'Regular', 'Hot', 'Normal Sweet', 'Sea Salt Cream', 'Cow Milk', 'sd'),
(29, 'sd', 'Cow Milk', '35650', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'sds'),
(30, 'sds', 'Sea Salt', '47150', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', ''),
(31, 'ahlul', 'Salted Caramel', '41400', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble', 'Oat Milk', 'sendok 2'),
(32, 'asASasAS', 'Hazelnut Latte', '52900', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'As'),
(33, 'asdasd', 'Salted Caramel', '50600', 'Large', 'Hot', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Cow Milk', 'asd'),
(34, 'asdasd', 'Hazelnut Latte', '52900', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'asdasdasd'),
(35, 'asda', 'Americano', '33350', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble,Sea Salt Cream', 'Cow Milk', 'asd'),
(36, 'asd', 'Sea Salt', '46000', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola', 'Cow Milk', 'asd'),
(37, 'dawdaw', 'Salted Caramel', '20700', 'Regular', 'Hot', 'Normal Sweet', '', '', 'awd'),
(38, 'dawd', 'Salted Caramel', '26450', 'Large', 'Ice', 'Less Sweet', '', '', 'dawwad'),
(39, 'asdas', 'Salted Caramel', '50600', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'asd'),
(40, 'asd', 'Hazelnut Latte', '47150', 'Regular', 'Hot', 'Normal Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Cow Milk', 'asd'),
(41, 'aSD', 'Vanilla Latte', '44850', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola', 'Oat Milk', 'ASDASD'),
(42, 'SADASD', 'Vanilla Latte', '40250', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Choco Granola', 'Oat Milk', ''),
(43, 'asd', 'Cow Milk', '35650', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', ''),
(44, 'asdasd', 'Mochacchino', '28750', 'Large', 'Ice', 'Less Sweet', '', 'Oat Milk', ''),
(45, 'awdaw', 'Sea Salt', '51750', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Sea Salt Cream', 'Oat Milk', 'awd'),
(46, 'asdasd', 'Salted Caramel', '50600', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'asd'),
(47, 'awdawd', 'mangga', '32200', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'awda'),
(48, 'adasd', 'Vanilla Latte', '49450', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'asdas'),
(49, 'asdad', 'mangga', '32200', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'asd'),
(50, 'sdfsf', 'Vanilla Latte', '49450', 'Large', 'Ice', 'Less Sweet', 'Caramel Sauce,Caramel Crumble,Choco Granola,Sea Salt Cream', 'Oat Milk', 'sdfsdf'),
(51, 'asda', 'Sea Salt', '42780', 'Large', 'Ice', 'Normal Sweet', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
