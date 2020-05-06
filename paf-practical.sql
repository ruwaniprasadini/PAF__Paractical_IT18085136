-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 04:48 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf-practical`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctordetails`
--

CREATE TABLE `doctordetails` (
  `DID` int(11) NOT NULL,
  `DoctorName` varchar(50) NOT NULL,
  `Email` varchar(70) NOT NULL,
  `Specialization` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctordetails`
--

INSERT INTO `doctordetails` (`DID`, `DoctorName`, `Email`, `Specialization`, `Password`) VALUES
(9, 'Prasadini', 'Prasadini123@gmail.com', 'cardiologist', 'pRasaa12'),
(10, 'harshika', 'harshika123@gmail.com', 'Dental Surgeons', 'hArshik12'),
(11, 'Shamudi', 'shamudi12@gmail.com', 'Nephrologists', 'prAsA12a'),
(12, 'Kavindi', 'kavi12@gmail.com', 'Urologist', 'Kavind12'),
(13, 'navoda', 'navoda12@gmail.com', 'cardiologists', 'navoda12A'),
(14, 'Kawshani', 'kawshani@fmail.com', 'Eye Specialists', 'Kawsha12'),
(15, 'Ruwani', 'ruwani8@gmail.com', 'Physician', 'Ruwani12'),
(16, 'Buddhi', 'buddhi12@gmail.com', 'Psychiatrist', 'Buddhi12'),
(17, 'Hirunu', 'hiruni97@gmail.com', 'Radiologists', 'Hiruni97'),
(18, 'Sithara', 'sithara12@gmail.com', 'Vascular Surgeon', 'Sithar12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctordetails`
--
ALTER TABLE `doctordetails`
  ADD PRIMARY KEY (`DID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctordetails`
--
ALTER TABLE `doctordetails`
  MODIFY `DID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
