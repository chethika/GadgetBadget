-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2021 at 05:47 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer1`
--

CREATE TABLE `customer1` (
  `pID` int(11) NOT NULL,
  `pName` varchar(255) NOT NULL,
  `pAddress` varchar(255) NOT NULL,
  `pEmail` varchar(255) NOT NULL,
  `pDate` varchar(255) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `pno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer1`
--

INSERT INTO `customer1` (`pID`, `pName`, `pAddress`, `pEmail`, `pDate`, `gender`, `pno`) VALUES
(2, 'qff', 'erfe', 'efqe', 'fewf', 'ewf', 'jtgyj'),
(3, 'qff', 'erfe', 'efqe', 'fewf', 'ewf', 'jtgyj'),
(4, 'Saman', 'No15', '@.com', '2020-05-7', 'Male', '4455');

-- --------------------------------------------------------

--
-- Table structure for table `funding_bodies`
--

CREATE TABLE `funding_bodies` (
  `fid` int(10) NOT NULL,
  `des` varchar(20) NOT NULL,
  `amount` float NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funding_bodies`
--

INSERT INTO `funding_bodies` (`fid`, `des`, `amount`, `date`) VALUES
(1, 'ee', 1000, 'rere'),
(2, 'tert', 5000, '2020-05-10'),
(4, 'ee', 1000, 'rere');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `pdate` varchar(20) NOT NULL,
  `pdes` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `pname`, `pdate`, `pdes`) VALUES
(2, 'ttt', '22', 'we');

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `rid` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `pid` int(10) NOT NULL,
  `date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`rid`, `name`, `pname`, `pid`, `date`) VALUES
(1, 'saman', 'it', 1, '2020-03-11'),
(2, 'saman', 'it', 1, '2020-03-11'),
(3, 'kamal', 'se', 2, '2021-03-04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer1`
--
ALTER TABLE `customer1`
  ADD PRIMARY KEY (`pID`);

--
-- Indexes for table `funding_bodies`
--
ALTER TABLE `funding_bodies`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`rid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer1`
--
ALTER TABLE `customer1`
  MODIFY `pID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `funding_bodies`
--
ALTER TABLE `funding_bodies`
  MODIFY `fid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `rid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
