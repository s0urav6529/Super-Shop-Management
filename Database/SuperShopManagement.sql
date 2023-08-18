-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               6.0.9-alpha-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2018-04-12 19:19:53
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for binarycareshop
CREATE DATABASE IF NOT EXISTS `binarycareshop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `binarycareshop`;


-- Dumping structure for table binarycareshop.tbcatagoryinfo
CREATE TABLE IF NOT EXISTS `tbcatagoryinfo` (
  `autoid` int(100) NOT NULL AUTO_INCREMENT,
  `catagoryid` char(100) NOT NULL DEFAULT '',
  `catagoryname` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `Entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`catagoryid`),
  UNIQUE KEY `Sl#` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbcatagoryinfo: 32 rows
/*!40000 ALTER TABLE `tbcatagoryinfo` DISABLE KEYS */;
INSERT INTO `tbcatagoryinfo` (`autoid`, `catagoryid`, `catagoryname`, `username`, `Entrytime`, `userip`) VALUES
	(5, 'cat-1', 'Ink', 'Sourav', '2017-07-25 17:55:42', ''),
	(6, 'cat-2', 'keyboard', 'Sourav', '2017-07-25 17:56:05', ''),
	(3, 'cat-3', 'bat', 'Sourav', '2017-07-25 15:09:40', ''),
	(4, 'cat-4', 'ball', 'Sourav', '2017-07-25 15:09:52', ''),
	(7, 'cat-5', 'Fan', 'Sourav', '2017-07-26 06:36:39', ''),
	(8, 'cat-6', 'Chaklet', 'Sourav', '2017-08-06 07:18:02', ''),
	(9, 'cat-7', 'Facewash', 'Sourav', '2017-08-06 07:18:19', ''),
	(18, 'cat-8', 'Crime', 'Sourav', '2017-08-16 21:05:41', ''),
	(11, 'cat-9', 'T-shirt', 'Sourav', '2017-08-06 07:18:47', ''),
	(12, 'cat-10', 'pant', 'Sourav', '2017-08-06 07:19:05', ''),
	(13, 'cat-11', 'Mobile', 'Sourav', '2017-08-10 20:16:34', ''),
	(14, 'cat-12', 'Light', 'Sourav', '2017-08-10 20:16:48', ''),
	(15, 'cat-13', 'Book', 'Sourav', '2017-08-10 20:17:09', ''),
	(16, 'cat-14', 'Shoe', 'Sourav', '2017-08-10 20:17:24', ''),
	(17, 'cat-15', 'Jarsy', 'Sourav', '2017-08-11 11:18:27', ''),
	(20, 'cat-16', 'Burger', 'Sourav', '2017-10-14 15:36:19', ''),
	(21, 'cat-17', 'pizza', 'Sourav', '2017-10-14 15:36:30', ''),
	(22, 'cat-18', 'Cake', 'Sourav', '2017-10-14 15:36:49', ''),
	(23, 'cat-19', 'Rice', 'Sourav', '2017-10-14 15:37:00', ''),
	(24, 'cat-20', 'Doll', 'Sourav', '2017-10-14 15:37:09', ''),
	(25, 'cat-21', 'Furniture', 'Sourav', '2017-10-14 15:37:23', ''),
	(26, 'cat-22', 'frame', 'Sourav', '2017-10-14 15:37:41', ''),
	(27, 'cat-23', 'EarPhone', 'Sourav', '2017-10-14 15:37:54', ''),
	(28, 'cat-24', 'Mouse', 'Sourav', '2017-10-14 15:38:35', ''),
	(29, 'cat-25', 'Colddrink', 'Sourav', '2017-10-14 15:38:45', ''),
	(30, 'cat-26', 'wallet', 'Sourav', '2017-10-14 15:39:09', ''),
	(31, 'cat-27', 'Stob', 'Sourav', '2017-10-14 19:58:35', ''),
	(32, 'cat-28', 'OverDrob', 'Sourav', '2017-10-15 14:01:04', ''),
	(33, 'cat-29', 'TV', 'Sourav', '2017-10-22 14:36:49', ''),
	(34, 'cat-30', 'umbralla', 'Sourav', '2017-10-22 22:42:08', ''),
	(35, 'cat-31', 'watch', 'Sourav', '2017-10-23 20:31:20', ''),
	(36, 'cat-32', 'Oven', 'Sourav', '2017-10-30 11:54:10', '');
/*!40000 ALTER TABLE `tbcatagoryinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbclientinfo
CREATE TABLE IF NOT EXISTS `tbclientinfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `ClientId` char(50) NOT NULL DEFAULT '',
  `clientname` char(50) DEFAULT NULL,
  `Gender` char(50) DEFAULT NULL,
  `FatherName` char(50) DEFAULT NULL,
  `MotherName` char(50) DEFAULT NULL,
  `Religion` char(50) DEFAULT NULL,
  `Birthdate` date DEFAULT NULL,
  `Joindate` date DEFAULT NULL,
  `Mobileno` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `picture` varchar(100) DEFAULT '0',
  `EmailId` varchar(100) DEFAULT NULL,
  `NationalId` varchar(100) DEFAULT NULL,
  `Nationality` varchar(100) DEFAULT NULL,
  `UserName` varchar(100) DEFAULT NULL,
  `ReferenceByid` varchar(100) DEFAULT NULL,
  `referencebyname` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ClientId`),
  UNIQUE KEY `sl` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbclientinfo: 14 rows
/*!40000 ALTER TABLE `tbclientinfo` DISABLE KEYS */;
INSERT INTO `tbclientinfo` (`autoid`, `ClientId`, `clientname`, `Gender`, `FatherName`, `MotherName`, `Religion`, `Birthdate`, `Joindate`, `Mobileno`, `Address`, `picture`, `EmailId`, `NationalId`, `Nationality`, `UserName`, `ReferenceByid`, `referencebyname`, `entrytime`, `userip`) VALUES
	(64, 'Client-1', 'Sourav Mojumder', 'Male', 'Arun Mojumder', 'Shilpy das', 'Hindus', '1997-07-05', '2016-07-02', '0186359977845', 'Ctg,Bangladesh', 'Client-1.jpg', 'Sourav@gmail.com', '555655695463', 'Bangladeshi', 'Sourav', 'User-1', 'Sourav Mojumder', '2017-10-25 19:01:05', ''),
	(62, 'Client-3', 'Shahinur Akter', 'Female', 'sa', 'dfs', 'Muslim', '2017-07-26', '2017-07-26', '0191919999214', 'Ctg', 'Client-3.jpg', 'Shahinur@gmail.com', '929829290193', 'BanglaDeshi', 'Sourav', 'User-2', 'Aiush Das', '2017-10-25 19:00:52', ''),
	(58, 'Client-4', 'Nur Nobi  Hridoy', 'Male', 'X.Alam', 'Y.Begom', 'Muslim', '1996-08-03', '2016-08-13', '0198512484272', 'Noakhali,Ctg', 'Client-4.jpg', 'Nobi@gmail.com', '09785485421589', 'Bangladeshi', 'Sourav', 'User-4', 'Mohammed Shahin', '2017-10-25 19:00:33', ''),
	(54, 'Client-5', 'Mizan', 'Male', 'Mr.x', 'Mrs.y', 'Muslim', '1993-10-15', '2016-10-07', '0178654345232', 'CTG', 'Client-5.jpg', 'J@gmail', '90191928281910228', 'BD', 'Sourav', 'User-4', 'Mohammed Shahin', '2017-10-25 19:00:12', ''),
	(57, 'Client-6', 'Nizam Islam', 'Male', 'MR.z', 'Mrs.h', 'Muslim', '1993-10-21', '2014-10-04', '0123345456681', 'Jessore', 'Client-6.jpg', 'J@gmail', '0909776654544', 'BD', 'Sourav', 'User-2', 'Aiush Das', '2017-10-25 19:00:29', ''),
	(65, 'Client-7', 'Zinath Khan', 'Female', 'Mr.s', 'Mrs.h', 'Muslim', '1986-10-17', '2014-10-09', '9029124585472', 'Feni', 'Client-7.jpg', 'Jd@gmail', '099099099090', 'Bd', 'Sourav', 'User-3', 'Pinash Barua', '2017-10-25 19:01:18', ''),
	(50, 'Client-9', 'Abdur X', 'Male', 'd', 'f', 'Muslim', '1978-10-26', '2015-10-02', '2222222222213', 'Feni', 'Client-9.jpg', 'h@gmail.com', '8892999999822222', 'bd', 'Sourav', 'User-5', 'Abdur Rahim', '2017-10-25 18:58:48', ''),
	(52, 'Client-10', 'Asraful Haque', 'Male', 'g', 'h', 'Muslim', '1982-10-02', '2016-10-01', '1222223455443', 'Rajshahi', 'Client-10.jpg', 'hkj@gmail.com', '533635234567', 'BD', 'Sourav', 'User-3', 'Pinash Barua', '2017-10-25 19:00:03', ''),
	(61, 'Client-2', 'Selim Uddin', 'Male', 'Kamal Uddin', 'Mehir Jannat', 'Muslim', '1993-07-09', '2016-07-16', '0197854245712', 'Ctg,Bangladesh', 'Client-2.jpg', 'Selim@gmail.Com', '08437439883429', 'Bangladehi', 'Sourav', 'User-1', 'Sourav Mojumder', '2017-10-25 19:00:48', ''),
	(56, 'Client-11', 'Nazml Islam', 'Male', 'uy', 'hh', 'Muslim', '2017-10-15', '2017-10-15', '1458756685247', 'darshna', 'Client-11.jpg', 'F@gmail.com', '087684635231', 'BD', 'Sourav', 'User-5', 'Abdur Rahim', '2017-10-25 19:00:22', ''),
	(63, 'Client-12', 'Shampa Roy', 'Female', 're', 'df', 'Hindus', '1988-10-08', '2016-10-14', '1245875412123', 'ctg', 'Client-12.jpg', 't@gmail.com', '1444444444477', 'bd', 'Sourav', 'User-2', 'Aiush Das', '2017-10-25 19:01:00', ''),
	(53, 'Client-13', 'FAHIM MAHMUD', 'Male', 'Mr.k', 'Mrs.k', 'Muslim', '1985-10-05', '2016-10-06', '3333333763333', 'ctg', 'Client-13.jpg', 'g@gmail.com', '0124105471', 'BD', 'Sourav', 'User-1', 'Sourav Mojumder', '2017-10-25 19:00:08', ''),
	(45, 'Client-14', 'Altaf Hossain', 'Male', 'f', 'c', 'Muslim', '1987-10-10', '2016-10-01', '0992901001', 'ctg', 'Client-14.jpg', 'x@gmail.com', '08432908074032', 'Bangladesh', 'Sourav', 'User-2', 'Aiush Das', '2017-10-25 18:50:46', ''),
	(66, 'Client-8', 'Anower Hossain', 'Male', 'x', 'r', 'Muslim', '1984-10-18', '2015-10-14', '0000001823812', 'ctg', 'Client-8.jpg', 'hh@gmail.com', '090989098989', 'BD', 'Sourav', 'User-4', 'Mohammed Shahin', '2017-11-11 12:41:17', '');
/*!40000 ALTER TABLE `tbclientinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbnewuserinfo
CREATE TABLE IF NOT EXISTS `tbnewuserinfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` char(50) NOT NULL DEFAULT '',
  `name` char(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `passwordhint` varchar(50) DEFAULT NULL,
  `Joindate` date DEFAULT NULL,
  `activation` varchar(50) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `nationalid` varchar(50) DEFAULT NULL,
  `usertype` varchar(100) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `picture` varchar(50) DEFAULT '0',
  `mobile` varchar(50) DEFAULT NULL,
  `EntryTime` datetime DEFAULT NULL,
  `UserIp` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `sl` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbnewuserinfo: 10 rows
/*!40000 ALTER TABLE `tbnewuserinfo` DISABLE KEYS */;
INSERT INTO `tbnewuserinfo` (`autoid`, `userid`, `name`, `username`, `designation`, `password`, `passwordhint`, `Joindate`, `activation`, `emailid`, `nationalid`, `usertype`, `address`, `picture`, `mobile`, `EntryTime`, `UserIp`) VALUES
	(34, 'User-3', 'Pinash Barua', 'Pinash Barua', 'no', 'pinash', 'pin', '2016-08-06', 'Yes', 'pinash@gmail.com', '02882929012', 'Admin', 'Fatikchari,Chittagong', 'User-3.jpg', '01938463728', '2017-11-09 21:31:30', ''),
	(43, 'User-1', 'Sourav', 'Sourav Mojumder', 'ok', 'sourav', 'sourav', '1991-07-13', 'Yes', 'Sourav2gmail.com', '0182309832', 'Admin', 'ctg', 'User-1.jpg', '018632526762', '2017-11-11 12:51:16', ''),
	(48, 'User-7', 'Usman Khan', 'Usman Khan', 'x', 'usman', 'usman', '1985-10-25', 'Yes', 'Usman Khan @gmail.com', '09998032709412', 'Admin', 'CTG,Bangladesh', 'User-7.jpg', '01987356472', '2018-01-29 22:34:35', ''),
	(37, 'User-4', 'Mohammed Shahin', 'Mohammed Shahin', 'no', 'jony', 'js', '1977-08-06', 'No', 'shahin@gmail.com', '9930200192038', 'Admin', 'Raojan,CTG', 'User-4.jpg', '01987678654', '2017-11-09 21:33:01', ''),
	(38, 'User-8', 'Hassan Ali', 'Hassan Ali', 'f', 'Hassan Ali', 'ali', '1991-10-05', 'No', 'Hassan Ali@gmail.com', '090988888849939', 'Admin', 'Dhaka,Bangladesh', 'User-8.jpg', '01897876567', '2017-11-09 21:33:09', ''),
	(39, 'User-6', 'Fahad', 'Fahad islam', 'x', 'islam', 'fislam', '1988-10-08', 'Yes', 'Fahad@gmail.com', '01278104521', 'Admin', 'Ctg', 'User-6.jpg', '01240121450', '2017-11-09 21:33:21', ''),
	(40, 'User-2', 'Aiush', 'Aiush Das', 'ok', 'Aiush', 'ash', '1990-07-14', 'Yes', 'Aiush@gmail.com', '145546445464563', 'Admin', 'Khulna,Bangladesh', 'User-2.jpg', '01875425698', '2017-11-09 21:33:33', ''),
	(41, 'User-5', 'Abdur Rahim', 'Abdur Rahim', 'Abdur', 'ABD', 'adb', '1983-08-13', 'Yes', 'Ab@Gmail.com', '0124585475641', 'Admin', 'Ctg', 'User-5.jpg', '0198547546214', '2017-11-09 21:33:43', ''),
	(47, 'User-9', 'Zahir Raihan', 'Zahir R. Musfiq', 'x', 'musfiq', 'musi', '2016-11-11', 'No', 'Zahir@gmail.com', '999091991002', 'Admin', 'CTG', 'User-9.jpg', '0919189919010', '2018-01-29 22:34:27', ''),
	(45, 'User-10', 'Farhan Rahman', 'Farhan Rahman47', 'x', 'farhan', 'far', '2017-11-19', 'Yes', 'R@gmail.com', '902999882992', 'Admin', 'Rangpur', 'User-10.jpg', '019888827732', '2017-11-19 12:03:46', '');
/*!40000 ALTER TABLE `tbnewuserinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbopeningstockinfo
CREATE TABLE IF NOT EXISTS `tbopeningstockinfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `StockId` char(50) NOT NULL DEFAULT '0',
  `Productid` varchar(100) DEFAULT '0',
  `productname` varchar(100) DEFAULT '0',
  `Catagoryid` varchar(100) DEFAULT '0',
  `catagoryname` varchar(100) DEFAULT '0',
  `Subcatagoryid` varchar(100) DEFAULT '0',
  `Subcatagoryname` varchar(100) DEFAULT '0',
  `Unit` bigint(20) DEFAULT '0',
  `StockQuentity` bigint(20) DEFAULT '0',
  `dealerrate` bigint(20) DEFAULT '0',
  `Amount` double DEFAULT '0',
  `StockDate` date DEFAULT NULL,
  `Supplierid` varchar(100) DEFAULT '0',
  `SupplierName` varchar(100) DEFAULT '0',
  `UserName` varchar(100) DEFAULT '0',
  `EntryTime` datetime DEFAULT NULL,
  `UserIp` varchar(100) DEFAULT '0',
  PRIMARY KEY (`StockId`),
  UNIQUE KEY `Sl` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbopeningstockinfo: 58 rows
/*!40000 ALTER TABLE `tbopeningstockinfo` DISABLE KEYS */;
INSERT INTO `tbopeningstockinfo` (`autoid`, `StockId`, `Productid`, `productname`, `Catagoryid`, `catagoryname`, `Subcatagoryid`, `Subcatagoryname`, `Unit`, `StockQuentity`, `dealerrate`, `Amount`, `StockDate`, `Supplierid`, `SupplierName`, `UserName`, `EntryTime`, `UserIp`) VALUES
	(39, 'Stock-17', 'Pro-20', 'Chapple', 'cat-14', 'Shoe', 'Subcat-21', 'Bata', 100, 1200, 1700, 2040000, '2017-08-28', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-22 14:04:58', ''),
	(80, 'Stock-5', 'Pro-1', 'Big', 'cat-3', 'bat', 'Subcat-10', 'Adidas', 1, 230, 2300, 529000, '2017-08-02', 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-10-22 14:35:49', ''),
	(102, 'Stock-7', 'Pro-4', 'P@R', 'cat-4', 'ball', 'Subcat-11', 'Jumboplan', 1, 300, 24, 7200, '2017-08-02', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-22 22:44:50', ''),
	(91, 'Stock-18', 'Pro-10', 'Dairy-milk hm', 'cat-6', 'Chaklet', 'Subcat-15', 'Dairy-Milk', 24, 1000, 15, 15000, '2017-08-28', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-22 15:14:00', ''),
	(98, 'Stock-19', 'Pro-14', 'Fhillips Gtr', 'cat-12', 'Light', 'Subcat-23', 'Fhillps', 100, 505, 230, 116150, '2017-10-12', 'Sup-5', 'TIpu Barua', 'Sourav', '2017-10-22 22:10:47', ''),
	(103, 'Stock-9', 'Pro-3', 'KB HG', 'cat-5', 'Fan', 'Subcat-8', 'KB', 2, 100, 1300, 130000, '2017-08-02', 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-22 22:44:59', ''),
	(58, 'Stock-28', 'Pro-43', 'tbfan', 'cat-5', 'Fan', 'Subcat-42', 'coldwar', 17, 500, 1260, 630000, '2017-10-22', 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-22 14:13:31', ''),
	(38, 'Stock-11', 'Pro-8', 'BH Fine', 'cat-4', 'ball', 'Subcat-5', 'bounch high', 1, 1200, 23, 27600, '2017-08-06', 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-22 14:04:47', ''),
	(57, 'Stock-27', 'Pro-24', 'Zenax Puma', 'cat-10', 'pant', 'Subcat-35', 'Pumatx', 45, 400, 1800, 720000, '2017-10-22', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-22 14:13:02', ''),
	(48, 'Stock-13', 'Pro-11', 'Ponds-mirrakel', 'cat-8', 'Crime', 'Subcat-16', 'Ponds', 50, 500, 130, 65000, '2017-08-08', 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-22 14:06:52', ''),
	(30, 'Stock-14', 'Pro-17', 'Real Madrid', 'cat-15', 'Jarsy', 'Subcat-29', 'Football', 1000, 970, 650, 630500, '2017-08-11', 'Sup-5', 'TIpu Barua', 'Sourav', '2017-08-11 11:42:40', ''),
	(49, 'Stock-15', 'Pro-18', 'Samsung j7', 'cat-11', 'Mobile', 'Subcat-30', 'SmartPhone', 20, 330, 17990, 5936700, '2017-08-18', 'Sup-5', 'Tipu Barua', 'Sourav', '2017-10-22 14:07:03', ''),
	(32, 'Stock-16', 'Pro-15', 'SunShine X', 'cat-12', 'Light', 'Subcat-26', 'Sunshine', 230, 300, 230, 69000, '2017-08-24', 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-08-24 16:16:43', ''),
	(50, 'Stock-20', 'Pro-35', 'Delicius burger', 'cat-16', 'Burger', 'Subcat-40', 'hot Chess', 20, 500, 80, 40000, '2017-10-22', 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-22 14:07:49', ''),
	(51, 'Stock-21', 'Pro-26', 'Dell Mouse', 'cat-24', 'Mouse', 'Subcat-34', 'Dell', 20, 400, 390, 156000, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-22 14:08:05', ''),
	(52, 'Stock-22', 'Pro-30', 'Wodder', 'cat-14', 'Shoe', 'Subcat-28', 'Wood Land', 5, 200, 480, 96000, '2017-10-22', 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-22 14:08:18', ''),
	(53, 'Stock-23', 'Pro-36', 'Arsenal', 'cat-15', 'Jarsy', 'Subcat-29', 'Football', 200, 500, 550, 275000, '2017-10-22', 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-22 14:08:34', ''),
	(54, 'Stock-24', 'Pro-22', 'Atop Rice', 'cat-19', 'Rice', 'Subcat-33', 'MInicat', 10, 500, 2700, 1350000, '2017-10-22', 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-22 14:08:57', ''),
	(55, 'Stock-25', 'Pro-2', '18inch', 'cat-2', 'keyboard', 'Subcat-7', 'A4tech', 2, 300, 460, 138000, '2017-10-22', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-22 14:09:15', ''),
	(59, 'Stock-29', 'Pro-46', 'Navana', 'cat-27', 'Stob', 'Subcat-44', 'gas Stob', 20, 350, 3200, 1120000, '2017-10-22', 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-10-22 14:14:03', ''),
	(93, 'Stock-30', 'Pro-28', 'shahitto konika', 'cat-13', 'Book', 'Subcat-22', 'Bangla', 32, 1000, 180, 180000, '2017-10-22', 'Sup-5', 'Tipu Barua', 'Sourav', '2017-10-22 15:14:21', ''),
	(61, 'Stock-31', 'Pro-21', 'Electric Doll', 'cat-20', 'Doll', 'Subcat-36', 'Xdoll', 20, 500, 300, 150000, '2017-10-22', 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-22 14:15:04', ''),
	(62, 'Stock-32', 'Pro-47', 'Sahhi Metal', 'cat-28', 'OverDrob', 'Subcat-45', 'Shahi', 5, 100, 6000, 600000, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-22 14:16:01', ''),
	(87, 'Stock-53', 'Pro-51', 'penasonic', 'cat-29', 'TV', 'Subcat-47', 'monitor', 2, 100, 27000, 2700000, '2017-10-22', 'Sup-13', 'Fahad Isak', 'Sourav', '2017-10-22 14:55:53', ''),
	(64, 'Stock-34', 'Pro-23', 'Mango Flaver choklet', 'cat-6', 'Chaklet', 'Subcat-14', 'Candy-bar', 23, 500, 20, 10000, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-22 14:20:38', ''),
	(65, 'Stock-35', 'Pro-39', 'Moto X', 'cat-11', 'Mobile', 'Subcat-30', 'SmartPhone', 15, 200, 6300, 1260000, '2017-10-22', 'Sup-9', 'NIsham Islam', 'Sourav', '2017-10-22 14:21:03', ''),
	(66, 'Stock-36', 'Pro-38', 'Pant', 'cat-9', 'T-shirt', 'Subcat-17', 'Addidas', 45, 470, 1200, 564000, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-22 14:21:39', ''),
	(67, 'Stock-37', 'Pro-25', 'PIzza dos', 'cat-17', 'pizza', 'Subcat-32', 'smail tripizza', 10, 300, 90, 27000, '2017-10-22', 'Sup-9', 'NIsham Islam', 'Sourav', '2017-10-22 14:22:06', ''),
	(68, 'Stock-38', 'Pro-40', 'Polo mate', 'cat-3', 'bat', 'Subcat-10', 'Adidas', 15, 400, 18000, 7200000, '2017-10-22', 'Sup-7', 'Sanju Roy', 'Sourav', '2017-10-22 14:23:03', ''),
	(69, 'Stock-39', 'Pro-19', 'pum Shoe', 'cat-14', 'Shoe', 'Subcat-21', 'Bata', 220, 500, 1500, 750000, '2017-10-22', 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-10-22 14:23:29', ''),
	(70, 'Stock-40', 'Pro-31', 't-star', 'cat-15', 'Jarsy', 'Subcat-29', 'Football', 25, 240, 400, 96000, '2017-10-22', 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-22 14:24:05', ''),
	(71, 'Stock-41', 'Pro-45', 'Nova', 'cat-27', 'Stob', 'Subcat-44', 'gas Stob', 45, 300, 2900, 870000, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-22 14:25:05', ''),
	(72, 'Stock-42', 'Pro-32', 'formal Bata', 'cat-14', 'Shoe', 'Subcat-21', 'Bata', 15, 200, 1100, 220000, '2017-10-22', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-22 14:29:53', ''),
	(73, 'Stock-43', 'Pro-34', 'Galexy A7', 'cat-11', 'Mobile', 'Subcat-30', 'SmartPhone', 10, 100, 16900, 1690000, '2017-10-22', 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-10-22 14:31:05', ''),
	(74, 'Stock-44', 'Pro-9', 'Ganieer-x', 'cat-7', 'Facewash', 'Subcat-12', 'Ganieer', 12, 300, 260, 78000, '2017-10-22', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-22 14:31:41', ''),
	(75, 'Stock-45', 'Pro-5', 'GT Ak', 'cat-2', 'keyboard', 'Subcat-4', 'Goldtuch', 2, 150, 300, 45000, '2017-10-22', 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-10-22 14:32:24', ''),
	(76, 'Stock-46', 'Pro-41', 'Himel R', 'cat-7', 'Facewash', 'Subcat-43', 'himel', 23, 500, 170, 85000, '2017-10-22', 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-22 14:33:14', ''),
	(77, 'Stock-47', 'Pro-33', 'Hot Chiss Pizza', 'cat-17', 'pizza', 'Subcat-32', 'smail tripizza', 40, 200, 97, 19400, '2017-10-22', 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-10-22 14:33:39', ''),
	(78, 'Stock-48', 'Pro-27', 'Hot Pizza', 'cat-17', 'pizza', 'Subcat-32', 'smail tripizza', 40, 150, 67, 10050, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-22 14:33:52', ''),
	(79, 'Stock-49', 'Pro-12', 'Lotto-nk', 'cat-9', 'T-shirt', 'Subcat-18', 'Lotto', 35, 150, 490, 73500, '2017-10-22', 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-10-22 14:34:17', ''),
	(84, 'Stock-50', 'Pro-49', 'sony', 'cat-29', 'TV', 'Subcat-46', 'LED', 5, 100, 34000, 3400000, '2017-10-22', 'Sup-11', 'Oishi Khan', 'Sourav', '2017-10-22 14:46:18', ''),
	(83, 'Stock-51', 'Pro-48', 'walton', 'cat-29', 'TV', 'Subcat-47', 'monitor', 10, 120, 12000, 1440000, '2017-10-22', 'Sup-16', 'Sudipto Das', 'Sourav', '2017-10-22 14:45:26', ''),
	(113, 'Stock-52', 'Pro-37', 'Alcote X', 'cat-10', 'pant', 'Subcat-19', 'Alcote', 35, 500, 1800, 900000, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-30 12:37:42', ''),
	(88, 'Stock-54', 'Pro-50', 'samsung', 'cat-29', 'TV', 'Subcat-47', 'monitor', 1, 50, 23000, 1150000, '2017-10-22', 'Sup-14', 'Arian Isak', 'Sourav', '2017-10-22 14:56:06', ''),
	(89, 'Stock-55', 'Pro-42', 'Airmate XR', 'cat-5', 'Fan', 'Subcat-41', 'Airmate', 35, 50, 1200, 60000, '2017-10-22', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-22 15:12:48', ''),
	(90, 'Stock-56', 'Pro-29', 'Kitkat', 'cat-6', 'Chaklet', 'Subcat-39', 'parledel', 35, 200, 45, 9000, '2017-10-22', 'Sup-7', 'Sanju Roy', 'Sourav', '2017-10-22 15:13:38', ''),
	(95, 'Stock-57', 'Pro-16', 'SunPower Xl', 'cat-12', 'Light', 'Subcat-27', 'Sunpower', 23, 200, 300, 60000, '2017-10-22', 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-22 22:07:27', ''),
	(96, 'Stock-58', 'Pro-44', 'RFl', 'cat-27', 'Stob', 'Subcat-44', 'gas Stob', 120, 50, 2500, 125000, '2017-10-22', 'Sup-9', 'NIsham Islam', 'Sourav', '2017-10-22 22:08:05', ''),
	(97, 'Stock-59', 'Pro-7', 'NB Ek', 'cat-3', 'bat', 'Subcat-6', 'NB', 2, 50, 2400, 120000, '2017-10-22', 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-10-22 22:08:50', ''),
	(99, 'Stock-60', 'Pro-52', 'asraf umbralla', 'cat-30', 'umbralla', 'Subcat-49', 'asraf', 4, 190, 300, 57000, '2017-10-22', 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-22 22:44:18', ''),
	(100, 'Stock-61', 'Pro-53', 'sharif umbralla', 'cat-30', 'umbralla', 'Subcat-48', 'sharif', 5, 50, 500, 25000, '2017-10-22', 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-22 22:44:28', ''),
	(105, 'Stock-62', 'Pro-55', 'citizen-hour', 'cat-31', 'watch', 'Subcat-50', 'citizen', 5, 200, 2600, 520000, '2017-10-23', 'Sup-14', 'Arian Isak', 'Sourav', '2017-10-23 20:56:03', ''),
	(106, 'Stock-63', 'Pro-54', 'fasttrack-hr', 'cat-31', 'watch', 'Subcat-51', 'fasttrack', 10, 100, 1600, 160000, '2017-10-23', 'Sup-14', 'Arian Isak', 'Sourav', '2017-10-23 20:56:18', ''),
	(108, 'Stock-64', 'Pro-13', 'Adidas Hj', 'cat-3', 'bat', 'Subcat-10', 'Adidas', 3, 1500, 2400, 3600000, '2017-10-23', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-23 21:16:40', ''),
	(109, 'Stock-65', 'Pro-56', 'Micro-nava', 'cat-32', 'Oven', 'Subcat-52', 'Micro-oven', 5, 65, 5400, 351000, '2017-10-30', 'Sup-16', 'Sudipto Das', 'Sourav', '2017-10-30 12:01:30', ''),
	(110, 'Stock-66', 'Pro-4', 'Jumboplan-P@R', 'cat-4', 'ball', 'Subcat-11', 'Jumboplan', 1, 350, 24, 8400, '2017-10-30', 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-30 12:26:45', ''),
	(111, 'Stock-67', 'Pro-6', 'Jumboplan XZ', 'cat-4', 'ball', 'Subcat-11', 'Jumboplan', 30, 400, 54, 21600, '2017-10-30', 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-30 12:26:55', ''),
	(112, 'Stock-68', 'Pro-37', 'Alcote X', 'cat-10', 'pant', 'Subcat-19', 'Alcote', 35, 500, 1800, 900000, '2017-10-30', 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-30 12:36:17', '');
/*!40000 ALTER TABLE `tbopeningstockinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbproductinfo
CREATE TABLE IF NOT EXISTS `tbproductinfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `ProductId` char(100) NOT NULL DEFAULT '',
  `Catagoryid` varchar(100) DEFAULT NULL,
  `catagoryname` varchar(100) DEFAULT NULL,
  `SubCatagoryid` varchar(100) DEFAULT NULL,
  `Subcatagoryname` varchar(100) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  `ProductDescription` varchar(100) DEFAULT NULL,
  `Unit` int(50) DEFAULT NULL,
  `dealerprice` double NOT NULL,
  `tradeprice` double NOT NULL,
  `ProfitPerUnit` double NOT NULL,
  `Supplierid` varchar(100) DEFAULT NULL,
  `Suppliername` varchar(100) DEFAULT NULL,
  `UserName` varchar(100) DEFAULT NULL,
  `EntryTime` datetime DEFAULT NULL,
  `UserIp` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ProductId`),
  UNIQUE KEY `Sl` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbproductinfo: 56 rows
/*!40000 ALTER TABLE `tbproductinfo` DISABLE KEYS */;
INSERT INTO `tbproductinfo` (`autoid`, `ProductId`, `Catagoryid`, `catagoryname`, `SubCatagoryid`, `Subcatagoryname`, `ProductName`, `ProductDescription`, `Unit`, `dealerprice`, `tradeprice`, `ProfitPerUnit`, `Supplierid`, `Suppliername`, `UserName`, `EntryTime`, `UserIp`) VALUES
	(16, 'Pro-3', 'cat-5', 'Fan', 'Subcat-8', 'KB', 'KB HG', '36",48"', 2, 1300, 1400, 100, 'Sup-2', 'Selim uddin', 'Sourav', '2017-08-01 15:41:57', ''),
	(30, 'Pro-6', 'cat-4', 'ball', 'Subcat-11', 'Jumboplan', 'Jumboplan XZ', 'High XZ', 30, 54, 60, 6, 'Sup-2', 'Selim uddin', 'Sourav', '2017-08-11 11:38:16', ''),
	(19, 'Pro-5', 'cat-2', 'keyboard', 'Subcat-4', 'Goldtuch', 'GT Ak', 'Large', 2, 350, 400, 50, 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-08-03 07:42:51', ''),
	(18, 'Pro-8', 'cat-4', 'ball', 'Subcat-5', 'bounch high', 'BH Fine', 'Big', 1, 35, 40, 5, 'Sup-2', 'Selim uddin', 'Sourav', '2017-08-03 07:42:16', ''),
	(20, 'Pro-9', 'cat-7', 'Facewash', 'Subcat-12', 'Ganieer', 'Ganieer-x', 'Crime-type', 12, 170, 185, 15, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-08-06 07:24:48', ''),
	(21, 'Pro-10', 'cat-6', 'Chaklet', 'Subcat-15', 'Dairy-Milk', 'Dairy-milk hm', 'Long size', 24, 15, 18, 3, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-08-06 07:26:26', ''),
	(22, 'Pro-11', 'cat-8', 'Crime', 'Subcat-16', 'Ponds', 'Ponds-mirrakel', 'medium', 50, 75, 90, 15, 'Sup-2', 'Selim uddin', 'Sourav', '2017-08-06 08:07:10', ''),
	(23, 'Pro-12', 'cat-9', 'T-shirt', 'Subcat-18', 'Lotto', 'Lotto-nk', 'X', 35, 950, 1100, 150, 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-08-06 08:08:12', ''),
	(24, 'Pro-13', 'cat-3', 'bat', 'Subcat-10', 'Adidas', 'Adidas Hj', 'in size', 3, 2400, 2700, 300, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-08-09 13:07:43', ''),
	(27, 'Pro-14', 'cat-12', 'Light', 'Subcat-23', 'Fhillps', 'Fhillips Gtr', '20 watt', 100, 230, 260, 30, 'Sup-5', 'TIpu Barua', 'Sourav', '2017-08-10 20:35:05', ''),
	(26, 'Pro-15', 'cat-12', 'Light', 'Subcat-26', 'Sunshine', 'SunShine X', '16 watt', 230, 260, 280, 20, 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-08-10 20:34:47', ''),
	(28, 'Pro-16', 'cat-12', 'Light', 'Subcat-27', 'Sunpower', 'SunPower Xl', '10 watt', 23, 300, 340, 40, 'Sup-2', 'Selim uddin', 'Sourav', '2017-08-10 20:35:47', ''),
	(29, 'Pro-17', 'cat-15', 'Jarsy', 'Subcat-29', 'Football', 'Real Madrid', 'XXL', 1000, 550, 600, 50, 'Sup-5', 'TIpu Barua', 'Sourav', '2017-08-11 11:21:34', ''),
	(85, 'Pro-18', 'cat-11', 'Mobile', 'Subcat-30', 'SmartPhone', 'Samsung j7', '4gb ram,16gb rom,octa-core,lolipop verson', 20, 16990, 17990, 1000, 'Sup-5', 'Tipu Barua', 'Sourav', '2017-10-23 20:42:42', ''),
	(32, 'Pro-19', 'cat-14', 'Shoe', 'Subcat-21', 'Bata', 'pum Shoe', 'black', 220, 1650, 1800, 150, 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-08-20 21:01:27', ''),
	(34, 'Pro-21', 'cat-20', 'Doll', 'Subcat-36', 'Xdoll', 'Electric Doll', 'small', 20, 230, 270, 40, 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-14 16:23:53', ''),
	(35, 'Pro-22', 'cat-19', 'Rice', 'Subcat-33', 'MInicat', 'Atop Rice', '50 kg', 10, 3310, 3400, 90, 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-14 16:24:30', ''),
	(36, 'Pro-23', 'cat-6', 'Chaklet', 'Subcat-14', 'Candy-bar', 'Mango Flaver choklet', 'large', 23, 20, 25, 5, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-14 16:25:35', ''),
	(37, 'Pro-24', 'cat-10', 'pant', 'Subcat-35', 'Pumatx', 'Zenax Puma', '35\'', 45, 2300, 2700, 400, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-14 16:26:38', ''),
	(79, 'Pro-25', 'cat-17', 'pizza', 'Subcat-32', 'smail tripizza', 'Pizza dos', 'large', 10, 60, 80, 20, 'Sup-9', 'NIsham Islam', 'Sourav', '2017-10-23 20:39:43', ''),
	(39, 'Pro-26', 'cat-24', 'Mouse', 'Subcat-34', 'Dell', 'Dell Mouse', 'small', 20, 390, 490, 100, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-14 16:28:02', ''),
	(40, 'Pro-27', 'cat-17', 'pizza', 'Subcat-32', 'smail tripizza', 'Hot Pizza', 'small', 40, 45, 55, 10, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-14 16:29:07', ''),
	(41, 'Pro-28', 'cat-13', 'Book', 'Subcat-22', 'Bangla', 'shahitto konika', 'class-a', 32, 180, 220, 40, 'Sup-5', 'Tipu Barua', 'Sourav', '2017-10-14 16:29:59', ''),
	(42, 'Pro-29', 'cat-6', 'Chaklet', 'Subcat-39', 'parledel', 'Kitkat', 'small', 35, 45, 60, 15, 'Sup-7', 'Sanju Roy', 'Sourav', '2017-10-14 16:30:42', ''),
	(44, 'Pro-31', 'cat-15', 'Jarsy', 'Subcat-29', 'Football', 't-star', 'large', 25, 456, 800, 344, 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-14 16:32:24', ''),
	(45, 'Pro-32', 'cat-14', 'Shoe', 'Subcat-21', 'Bata', 'formal Bata', 'leder', 15, 3400, 3800, 400, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-14 16:33:16', ''),
	(46, 'Pro-33', 'cat-17', 'pizza', 'Subcat-32', 'smail tripizza', 'Hot Chiss Pizza', 'Medium', 40, 50, 65, 15, 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-10-14 19:38:50', ''),
	(48, 'Pro-35', 'cat-16', 'Burger', 'Subcat-40', 'hot Chess', 'Delicius burger', 'small', 20, 150, 170, 20, 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-14 19:43:43', ''),
	(49, 'Pro-36', 'cat-15', 'Jarsy', 'Subcat-29', 'Football', 'Arsenal', 'full', 200, 750, 800, 50, 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-14 19:44:52', ''),
	(50, 'Pro-37', 'cat-10', 'pant', 'Subcat-19', 'Alcote', 'Alcote X', 'Large', 35, 1800, 2000, 200, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-14 19:45:25', ''),
	(61, 'Pro-40', 'cat-3', 'bat', 'Subcat-10', 'Adidas', 'Polo mate', '19', 15, 23000, 25000, 2000, 'Sup-7', 'Sanju Roy', 'Sourav', '2017-10-18 11:16:15', ''),
	(54, 'Pro-41', 'cat-7', 'Facewash', 'Subcat-43', 'himel', 'Himel R', 'lager', 23, 230, 250, 20, 'Sup-2', 'Selim uddin', 'Sourav', '2017-10-14 19:56:15', ''),
	(55, 'Pro-42', 'cat-5', 'Fan', 'Subcat-41', 'Airmate', 'Airmate XR', 'tbfan', 35, 1200, 1400, 200, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-14 19:56:52', ''),
	(56, 'Pro-43', 'cat-5', 'Fan', 'Subcat-42', 'coldwar', 'tbfan', 'High x', 17, 1300, 1600, 300, 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-14 19:57:33', ''),
	(80, 'Pro-44', 'cat-27', 'Stob', 'Subcat-44', 'gas Stob', 'RFL', '2b-11bc', 120, 2500, 2750, 250, 'Sup-9', 'NIsham Islam', 'Sourav', '2017-10-23 20:40:07', ''),
	(58, 'Pro-45', 'cat-27', 'Stob', 'Subcat-44', 'gas Stob', 'Nova', '2b-12cc', 45, 3200, 3800, 600, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-14 20:00:43', ''),
	(59, 'Pro-46', 'cat-27', 'Stob', 'Subcat-44', 'gas Stob', 'Navana', '3B-211C', 20, 3500, 4100, 600, 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-10-15 13:59:35', ''),
	(60, 'Pro-47', 'cat-28', 'OverDrob', 'Subcat-45', 'Shahi', 'Sahhi Metal', 'Big', 5, 15500, 17000, 1500, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-15 14:02:24', ''),
	(83, 'Pro-50', 'cat-29', 'TV', 'Subcat-47', 'monitor', 'Samsung', '32 inch', 1, 23000, 25000, 2000, 'Sup-14', 'Arian Isak', 'Sourav', '2017-10-23 20:42:03', ''),
	(65, 'Pro-51', 'cat-29', 'TV', 'Subcat-47', 'monitor', 'penasonic', '23\'', 2, 27000, 31000, 4000, 'Sup-13', 'Fahad Isak', 'Sourav', '2017-10-22 14:54:48', ''),
	(66, 'Pro-52', 'cat-30', 'umbralla', 'Subcat-49', 'asraf', 'asraf umbralla', 'x', 4, 300, 340, 40, 'Sup-8', 'Rimon Khan', 'Sourav', '2017-10-22 22:43:19', ''),
	(67, 'Pro-53', 'cat-30', 'umbralla', 'Subcat-48', 'sharif', 'sharif umbralla', 'x', 5, 500, 560, 60, 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-22 22:43:57', ''),
	(68, 'Pro-54', 'cat-31', 'watch', 'Subcat-51', 'fasttrack', 'fasttrack-hr', 'stainless', 10, 1600, 1900, 300, 'Sup-14', 'Arian Isak', 'Sourav', '2017-10-23 20:32:44', ''),
	(70, 'Pro-2', 'cat-2', 'keyboard', 'Subcat-7', 'A4tech', 'a4tech18', 'white', 2, 1800, 2000, 200, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-23 20:34:12', ''),
	(71, 'Pro-1', 'cat-3', 'bat', 'Subcat-10', 'Adidas', 'Big-add', 'White,black', 1, 200, 230, 30, 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-10-23 20:34:55', ''),
	(72, 'Pro-20', 'cat-14', 'Shoe', 'Subcat-21', 'Bata', 'Chapple-track', 'blue', 100, 560, 790, 230, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-23 20:35:14', ''),
	(73, 'Pro-55', 'cat-31', 'watch', 'Subcat-50', 'citizen', 'citizen-hour', 'still', 5, 2600, 2950, 350, 'Sup-14', 'Arian Isak', 'Sourav', '2017-10-23 20:35:25', ''),
	(74, 'Pro-34', 'cat-11', 'Mobile', 'Subcat-30', 'SmartPhone', 'Galexy A7', '4gb ram,16gb rom,octa-core,kitkat verson', 10, 16599, 17599, 1000, 'Sup-4', 'Hisbul Haque', 'Sourav', '2017-10-23 20:36:34', ''),
	(75, 'Pro-39', 'cat-11', 'Mobile', 'Subcat-30', 'SmartPhone', 'Moto X', '2gb ram,8gb rom,quad-core,kitkat verson', 15, 6000, 7900, 1900, 'Sup-9', 'NIsham Islam', 'Sourav', '2017-10-23 20:38:02', ''),
	(76, 'Pro-7', 'cat-3', 'bat', 'Subcat-6', 'NB', 'NB Ek', 'New balance', 2, 2400, 2600, 200, 'Sup-1', 'Sourav Mojumder', 'Sourav', '2017-10-23 20:38:35', ''),
	(77, 'Pro-4', 'cat-4', 'ball', 'Subcat-11', 'Jumboplan', 'Jumboplan-P@R', 'Simple', 1, 24, 30, 6, 'Sup-3', 'Moniul Islam', 'Sourav', '2017-10-23 20:39:04', ''),
	(78, 'Pro-38', 'cat-9', 'T-shirt', 'Subcat-17', 'Addidas', 'Pant-Add', 'max', 45, 1560, 1890, 330, 'Sup-6', 'Ifteker Rahman', 'Sourav', '2017-10-23 20:39:23', ''),
	(86, 'Pro-49', 'cat-29', 'TV', 'Subcat-46', 'LED', 'sony', '42 inch', 5, 34000, 37000, 3000, 'Sup-11', 'Oishi Khan', 'Sourav', '2017-10-23 20:43:02', ''),
	(87, 'Pro-48', 'cat-29', 'TV', 'Subcat-47', 'monitor', 'walton', '17 inch', 10, 12000, 13000, 1000, 'Sup-16', 'Sudipto Das', 'Sourav', '2017-10-23 20:43:44', ''),
	(88, 'Pro-30', 'cat-14', 'Shoe', 'Subcat-28', 'Wood Land', 'Wodder track', 'sponz', 5, 3500, 4100, 600, 'Sup-10', 'Foisal Mahabub', 'Sourav', '2017-10-23 20:44:24', ''),
	(89, 'Pro-56', 'cat-32', 'Oven', 'Subcat-52', 'Micro-oven', 'Micro-nava', '52 d', 5, 5400, 6500, 1100, 'Sup-16', 'Sudipto Das', 'Sourav', '2017-10-30 11:58:10', '');
/*!40000 ALTER TABLE `tbproductinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbpurchaserecipentdetails
CREATE TABLE IF NOT EXISTS `tbpurchaserecipentdetails` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `invoiceno` char(100) NOT NULL DEFAULT '',
  `productid` char(100) DEFAULT NULL,
  `productname` varchar(200) DEFAULT NULL,
  `unit` char(50) DEFAULT NULL,
  `stock` double DEFAULT NULL,
  `dealerrate` double DEFAULT NULL,
  `invoiceqty` double DEFAULT NULL,
  `receiveqty` double DEFAULT NULL,
  `shortoverqty` double DEFAULT NULL,
  `presentstock` double DEFAULT NULL,
  `supplierid` char(100) DEFAULT NULL,
  `suppliername` varchar(200) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbpurchaserecipentdetails: 30 rows
/*!40000 ALTER TABLE `tbpurchaserecipentdetails` DISABLE KEYS */;
INSERT INTO `tbpurchaserecipentdetails` (`autoid`, `invoiceno`, `productid`, `productname`, `unit`, `stock`, `dealerrate`, `invoiceqty`, `receiveqty`, `shortoverqty`, `presentstock`, `supplierid`, `suppliername`, `amount`, `remark`, `entrytime`, `userip`) VALUES
	(63, 'Invoice-10', 'Pro-31', 't-star', '25', 240, 456, 100, 100, 0, 340, 'Sup-8', 'Rimon Khan', 45600, 'vv', '2017-10-22 14:24:38', ''),
	(62, 'Invoice-9', 'Pro-2', '18inch', '2', 369, 1800, 200, 200, 0, 569, 'Sup-3', 'Moniul Islam', 360000, 'vf', '2017-10-22 14:19:52', ''),
	(58, 'Invoice-8', 'Pro-20', 'Chapple', '100', 123, 1700, 123, 123, 0, 246, 'Sup-3', 'Moniul Islam', 209100, 'x', '2017-10-14 12:11:08', ''),
	(61, 'Invoice-9', 'Pro-28', 'shahitto konika', '32', 10000, 180, 100, 99, 1, 10099, 'Sup-5', 'Tipu Barua', 17820, 'vf', '2017-10-22 14:19:52', ''),
	(81, 'Invoice-6', 'Pro-18', 'Samsung j7', '20', 33, 16000, 12, 12, 0, 45, 'Sup-5', 'Tipu Barua', 192000, 'x', '2017-10-29 14:19:26', ''),
	(54, 'Invoice-7', 'Pro-11', 'Ponds-mirrakel', '50', 23, 170, 123, 123, 0, 146, 'Sup-2', 'Selim uddin', 20910, 'x', '2017-08-28 13:18:59', ''),
	(59, 'Invoice-5', 'Pro-17', 'Real Madrid', '1000', 970, 1100, 200, 200, 0, 1170, 'Sup-5', 'TIpu Barua', 220000, 'x', '2017-10-21 21:22:21', ''),
	(57, 'Invoice-4', 'Pro-15', 'SunShine X', '230', 300, 240, 23, 23, 0, 323, 'Sup-1', 'Sourav Mojumder', 5520, 'x', '2017-10-14 12:10:02', ''),
	(60, 'Invoice-5', 'Pro-4', 'P@R', '1', 23, 35, 340, 339, 1, 362, 'Sup-3', 'Moniul Islam', 11865, 'x', '2017-10-21 21:22:21', ''),
	(56, 'Invoice-4', 'Pro-18', 'Samsung j7', '20', 33, 16000, 10, 10, 0, 43, 'Sup-5', 'Tipu Barua', 160000, 'x', '2017-10-14 12:10:02', ''),
	(82, 'Invoice-3', 'Pro-6', 'Jumboplan XZ', '30', 4, 30, 200, 200, 0, 204, 'Sup-2', 'Selim uddin', 6000, 'x', '2017-10-30 12:26:19', ''),
	(46, 'Invoice-2', 'Pro-1', 'Big', '1', 23, 2300, 20, 20, 0, 43, 'Sup-4', 'Hisbul Haque', 46000, 'x', '2017-08-28 13:00:35', ''),
	(45, 'Invoice-2', 'Pro-3', 'KB HG', '2', 12, 1400, 30, 23, 7, 35, 'Sup-2', 'Selim uddin', 32200, 'x', '2017-08-28 13:00:35', ''),
	(39, 'Invoice-1', 'Pro-2', '18inch', '2', 23, 460, 123, 123, 0, 146, 'Sup-3', 'Moniul Islam', 56580, 'x', '2017-08-28 12:58:20', ''),
	(40, 'Invoice-1', 'Pro-8', 'BH Fine', '1', 12, 36, 200, 200, 0, 212, 'Sup-2', 'Selim uddin', 7200, 'x', '2017-08-28 12:58:20', ''),
	(64, 'Invoice-10', 'Pro-40', 'Polo mate', '15', 400, 23000, 40, 30, 10, 430, 'Sup-7', 'Sanju Roy', 690000, 'vf', '2017-10-22 14:24:38', ''),
	(65, 'Invoice-11', 'Pro-46', 'Navana', '20', 348, 3500, 30, 30, 0, 378, 'Sup-1', 'Sourav Mojumder', 105000, 'er', '2017-10-22 14:26:49', ''),
	(66, 'Invoice-11', 'Pro-45', 'Nova', '45', 295, 3200, 20, 20, 0, 315, 'Sup-6', 'Ifteker Rahman', 64000, 'fv', '2017-10-22 14:26:49', ''),
	(67, 'Invoice-11', 'Pro-47', 'Sahhi Metal', '5', 100, 15500, 100, 100, 0, 200, 'Sup-6', 'Ifteker Rahman', 1550000, 'fb', '2017-10-22 14:26:49', ''),
	(73, 'Invoice-12', 'Pro-33', 'Hot Chiss Pizza', '40', 200, 50, 100, 100, 0, 300, 'Sup-1', 'Sourav Mojumder', 5000, 'gg', '2017-10-22 14:50:15', ''),
	(72, 'Invoice-12', 'Pro-23', 'Mango Flaver choklet', '23', 500, 20, 30, 29, 1, 529, 'Sup-6', 'Ifteker Rahman', 580, 'gg', '2017-10-22 14:50:15', ''),
	(71, 'Invoice-12', 'Pro-27', 'Hot Pizza', '40', 150, 45, 50, 50, 0, 200, 'Sup-6', 'Ifteker Rahman', 2250, 'fg', '2017-10-22 14:50:15', ''),
	(74, 'Invoice-13', 'Pro-51', 'penasonic', '2', 100, 27000, 10, 10, 0, 110, 'Sup-13', 'Fahad Isak', 270000, 'g', '2017-10-22 14:56:49', ''),
	(75, 'Invoice-13', 'Pro-50', 'samsung', '1', 50, 23000, 50, 49, 1, 99, 'Sup-14', 'Arian Isak', 1127000, 'gg', '2017-10-22 14:56:49', ''),
	(76, 'Invoice-14', 'Pro-42', 'Airmate XR', '35', 39, 1200, 11, 11, 0, 50, 'Sup-6', 'Ifteker Rahman', 13200, 'd', '2017-10-22 15:19:35', ''),
	(77, 'Invoice-14', 'Pro-3', 'KB HG', '2', 1223, 1300, 77, 77, 0, 1300, 'Sup-2', 'Selim uddin', 100100, 'b', '2017-10-22 15:19:35', ''),
	(78, 'Invoice-15', 'Pro-37', 'Alcote X', '35', -156, 1800, 600, 600, 0, 444, 'Sup-6', 'Ifteker Rahman', 1080000, 'f', '2017-10-23 13:26:48', ''),
	(79, 'Invoice-16', 'Pro-54', 'fasttrack-hr', '10', 100, 1600, 10, 10, 0, 110, 'Sup-14', 'Arian Isak', 16000, 're', '2017-10-23 20:56:52', ''),
	(80, 'Invoice-16', 'Pro-55', 'citizen-hour', '5', 200, 2600, 5, 4, 1, 204, 'Sup-14', 'Arian Isak', 10400, 're', '2017-10-23 20:56:52', ''),
	(83, 'Invoice-3', 'Pro-4', 'Jumboplan-P@R', '1', 614, 24, 50, 49, 1, 663, 'Sup-3', 'Moniul Islam', 1176, '', '2017-10-30 12:26:19', '');
/*!40000 ALTER TABLE `tbpurchaserecipentdetails` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbpurchaserecipentinfo
CREATE TABLE IF NOT EXISTS `tbpurchaserecipentinfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `invoiceno` char(100) NOT NULL DEFAULT '0',
  `invoicedate` date DEFAULT NULL,
  `currentdate` date DEFAULT NULL,
  `totalamount` double DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`invoiceno`),
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbpurchaserecipentinfo: 16 rows
/*!40000 ALTER TABLE `tbpurchaserecipentinfo` DISABLE KEYS */;
INSERT INTO `tbpurchaserecipentinfo` (`autoid`, `invoiceno`, `invoicedate`, `currentdate`, `totalamount`, `username`, `entrytime`, `userip`) VALUES
	(38, 'Invoice-10', '2017-10-22', '2017-10-22', 735600, 'Sourav', '2017-10-22 14:24:38', ''),
	(23, 'Invoice-1', '2017-08-24', '2017-08-24', 63780, 'Sourav', '2017-08-28 12:58:20', ''),
	(26, 'Invoice-2', '2017-08-24', '2017-08-24', 78200, 'Sourav', '2017-08-28 13:00:35', ''),
	(47, 'Invoice-3', '2017-08-24', '2017-08-24', 7176, 'Sourav', '2017-10-30 12:26:19', ''),
	(34, 'Invoice-4', '2017-08-24', '2017-08-24', 165520, 'Sourav', '2017-10-14 12:10:02', ''),
	(36, 'Invoice-5', '2017-08-24', '2017-08-24', 231865, 'Sourav', '2017-10-21 21:22:21', ''),
	(46, 'Invoice-6', '2017-08-28', '2017-08-28', 192000, 'Sourav', '2017-10-29 14:19:26', ''),
	(32, 'Invoice-7', '2017-08-28', '2017-08-28', 20910, 'Sourav', '2017-08-28 13:18:59', ''),
	(35, 'Invoice-8', '2017-08-28', '2017-08-28', 209100, 'Sourav', '2017-10-14 12:11:08', ''),
	(37, 'Invoice-9', '2017-10-22', '2017-10-22', 377820, 'Sourav', '2017-10-22 14:19:52', ''),
	(39, 'Invoice-11', '2017-10-22', '2017-10-22', 1719000, 'Sourav', '2017-10-22 14:26:49', ''),
	(41, 'Invoice-12', '2017-10-22', '2017-10-22', 7830, 'Sourav', '2017-10-22 14:50:15', ''),
	(42, 'Invoice-13', '2017-10-22', '2017-10-22', 1397000, 'Sourav', '2017-10-22 14:56:49', ''),
	(43, 'Invoice-14', '2017-10-22', '2017-10-22', 113300, 'Sourav', '2017-10-22 15:19:35', ''),
	(44, 'Invoice-15', '2017-10-23', '2017-10-23', 1080000, 'Sourav', '2017-10-23 13:26:48', ''),
	(45, 'Invoice-16', '2017-10-23', '2017-10-23', 26400, 'Sourav', '2017-10-23 20:56:52', '');
/*!40000 ALTER TABLE `tbpurchaserecipentinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbretrurntosupplierdetails
CREATE TABLE IF NOT EXISTS `tbretrurntosupplierdetails` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `returnno` varchar(100) DEFAULT NULL,
  `productid` varchar(100) DEFAULT NULL,
  `productname` varchar(100) DEFAULT NULL,
  `Supplierid` varchar(100) DEFAULT NULL,
  `suppliername` varchar(100) DEFAULT NULL,
  `stockqty` double DEFAULT NULL,
  `returnqty` double DEFAULT NULL,
  `dealerprice` double DEFAULT NULL,
  `unit` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(10) DEFAULT NULL,
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbretrurntosupplierdetails: ~12 rows (approximately)
/*!40000 ALTER TABLE `tbretrurntosupplierdetails` DISABLE KEYS */;
INSERT INTO `tbretrurntosupplierdetails` (`autoid`, `returnno`, `productid`, `productname`, `Supplierid`, `suppliername`, `stockqty`, `returnqty`, `dealerprice`, `unit`, `amount`, `remark`, `entrytime`, `userip`) VALUES
	(39, 'ReturnNo-2', 'Pro-13', 'Adidas Hj', 'Sup-3', 'Moniul Islam', 1476, 4, 2400, 3, 9600, '', '2017-10-29 14:56:22', ''),
	(40, 'ReturnNo-2', 'Pro-14', 'Fhillips Gtr', 'Sup-5', 'TIpu Barua', 502, 3, 230, 100, 690, '', '2017-10-29 14:56:22', ''),
	(41, 'ReturnNo-3', 'Pro-15', 'SunShine X', 'Sup-1', 'Sourav Mojumder', 298, 4, 260, 230, 1040, '', '2017-10-29 14:56:34', ''),
	(42, 'ReturnNo-3', 'Pro-19', 'pum Shoe', 'Sup-1', 'Sourav Mojumder', 463, 2, 1650, 220, 3300, '', '2017-10-29 14:56:34', ''),
	(43, 'ReturnNo-3', 'Pro-17', 'Real Madrid', 'Sup-5', 'TIpu Barua', 1155, 3, 550, 1000, 1650, '', '2017-10-29 14:56:34', ''),
	(44, 'ReturnNo-4', 'Pro-46', 'Navana', 'Sup-1', 'Sourav Mojumder', 368, 2, 3500, 20, 7000, '', '2017-10-29 14:56:44', ''),
	(45, 'ReturnNo-4', 'Pro-45', 'Nova', 'Sup-6', 'Ifteker Rahman', 304, 1, 3200, 45, 3200, '', '2017-10-29 14:56:44', ''),
	(46, 'ReturnNo-5', 'Pro-17', 'Real Madrid', 'Sup-5', 'TIpu Barua', 1155, 12, 550, 1000, 6600, '', '2017-10-29 14:56:57', ''),
	(47, 'ReturnNo-5', 'Pro-19', 'pum Shoe', 'Sup-1', 'Sourav Mojumder', 463, 10, 1650, 220, 16500, '', '2017-10-29 14:56:57', ''),
	(48, 'ReturnNo-5', 'Pro-15', 'SunShine X', 'Sup-1', 'Sourav Mojumder', 298, 21, 260, 230, 5460, '', '2017-10-29 14:56:57', ''),
	(49, 'ReturnNo-1', 'Pro-20', 'Chapple', 'Sup-3', 'Moniul Islam', 1218, 5, 560, 100, 2800, '', '2017-10-29 14:57:15', ''),
	(50, 'ReturnNo-1', 'Pro-24', 'Zenax Puma', 'Sup-3', 'Moniul Islam', 395, 4, 2300, 45, 9200, '', '2017-10-29 14:57:15', '');
/*!40000 ALTER TABLE `tbretrurntosupplierdetails` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbretrurntosupplierinfo
CREATE TABLE IF NOT EXISTS `tbretrurntosupplierinfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `returnno` varchar(100) NOT NULL DEFAULT '0',
  `currentdate` date DEFAULT NULL,
  `returndate` date DEFAULT NULL,
  `totalamount` double DEFAULT NULL,
  `username` varchar(100) NOT NULL DEFAULT '0',
  `entreytime` datetime DEFAULT NULL,
  `Userip` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`returnno`),
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbretrurntosupplierinfo: ~5 rows (approximately)
/*!40000 ALTER TABLE `tbretrurntosupplierinfo` DISABLE KEYS */;
INSERT INTO `tbretrurntosupplierinfo` (`autoid`, `returnno`, `currentdate`, `returndate`, `totalamount`, `username`, `entreytime`, `Userip`) VALUES
	(22, 'ReturnNo-1', '2017-10-29', '2017-10-29', 12000, '0', '2017-10-29 14:57:15', ''),
	(18, 'ReturnNo-2', '2017-10-29', '2017-10-29', 10290, '0', '2017-10-29 14:56:22', ''),
	(19, 'ReturnNo-3', '2017-10-29', '2017-10-29', 5990, '0', '2017-10-29 14:56:34', ''),
	(20, 'ReturnNo-4', '2017-10-29', '2017-10-29', 10200, '0', '2017-10-29 14:56:44', ''),
	(21, 'ReturnNo-5', '2017-10-29', '2017-10-29', 28560, '0', '2017-10-29 14:56:57', '');
/*!40000 ALTER TABLE `tbretrurntosupplierinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbsalesdetails
CREATE TABLE IF NOT EXISTS `tbsalesdetails` (
  `autoid` int(50) NOT NULL AUTO_INCREMENT,
  `salesno` varchar(100) NOT NULL DEFAULT '',
  `productid` char(50) DEFAULT NULL,
  `productname` varchar(100) DEFAULT NULL,
  `unit` char(100) DEFAULT NULL,
  `stockqty` int(100) DEFAULT NULL,
  `salesqty` int(100) DEFAULT NULL,
  `dealerprice` double DEFAULT NULL,
  `tradeprice` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbsalesdetails: ~30 rows (approximately)
/*!40000 ALTER TABLE `tbsalesdetails` DISABLE KEYS */;
INSERT INTO `tbsalesdetails` (`autoid`, `salesno`, `productid`, `productname`, `unit`, `stockqty`, `salesqty`, `dealerprice`, `tradeprice`, `amount`, `remark`, `username`, `entrytime`, `userip`) VALUES
	(4, 'Sales-3', 'Pro-2', '18inch', '2', 116, 12, 1800, 2000, 24000, 'null', 'Sourav', '2017-10-18 16:48:38', ''),
	(6, 'Sales-4', 'Pro-37', 'Alcote X', '35', 800, 57, 1800, 2000, 114000, '', 'Sourav', '2017-10-22 22:14:48', ''),
	(12, 'Sales-6', 'Pro-33', 'Hot Chiss Pizza', '40', 300, 10, 50, 65, 650, '', 'Sourav', '2017-10-22 22:17:56', ''),
	(13, 'Sales-6', 'Pro-27', 'Hot Pizza', '40', 200, 25, 45, 55, 1375, '', 'Sourav', '2017-10-22 22:17:56', ''),
	(14, 'Sales-6', 'Pro-23', 'Mango Flaver choklet', '23', 500, 30, 20, 25, 750, '', 'Sourav', '2017-10-22 22:17:56', ''),
	(15, 'Sales-7', 'Pro-45', 'Nova', '45', 315, 15, 3200, 3800, 57000, '', 'Sourav', '2017-10-22 22:39:35', ''),
	(16, 'Sales-7', 'Pro-46', 'Navana', '20', 378, 10, 3500, 4100, 41000, '', 'Sourav', '2017-10-22 22:39:35', ''),
	(17, 'Sales-7', 'Pro-47', 'Sahhi Metal', '5', 200, 10, 15500, 17000, 170000, '', 'Sourav', '2017-10-22 22:39:35', ''),
	(24, 'Sales-10', 'Pro-50', 'Samsung', '1', 89, 3, 23000, 25000, 75000, '', 'Sourav', '2017-10-23 21:37:50', ''),
	(25, 'Sales-10', 'Pro-49', 'sony', '5', 100, 2, 34000, 37000, 74000, '', 'Sourav', '2017-10-23 21:37:50', ''),
	(26, 'Sales-11', 'Pro-28', 'shahitto konika', '32', 1099, 99, 180, 220, 21780, '', 'Sourav', '2017-10-27 16:41:31', ''),
	(28, 'Sales-9', 'Pro-55', 'citizen-hour', '5', 204, 4, 2600, 2950, 11800, '', 'Sourav', '2017-10-27 16:59:33', ''),
	(29, 'Sales-9', 'Pro-54', 'fasttrack-hr', '10', 110, 5, 1600, 1900, 9500, '', 'Sourav', '2017-10-27 16:59:33', ''),
	(30, 'Sales-8', 'Pro-34', 'Galexy A7', '10', 100, 5, 16599, 17599, 87995, '', 'Sourav', '2017-10-27 17:07:16', ''),
	(31, 'Sales-8', 'Pro-50', 'samsung', '1', 99, 10, 23000, 25000, 250000, '', 'Sourav', '2017-10-27 17:07:16', ''),
	(32, 'Sales-8', 'Pro-18', 'Samsung j7', '20', 352, 5, 16990, 17990, 89950, '', 'Sourav', '2017-10-27 17:07:16', ''),
	(34, 'Sales-13', 'Pro-52', 'asraf umbralla', '4', 190, 3, 300, 340, 1020, '', 'Sourav', '2017-10-27 17:21:25', ''),
	(35, 'Sales-13', 'Pro-54', 'fasttrack-hr', '10', 105, 5, 1600, 1900, 9500, '', 'Sourav', '2017-10-27 17:21:25', ''),
	(36, 'Sales-2', 'Pro-13', 'Adidas Hj', '3', 1476, 23, 2400, 2700, 62100, '', 'Sourav', '2017-10-29 14:19:54', ''),
	(37, 'Sales-2', 'Pro-37', 'Alcote X', '35', 444, 343, 1800, 2000, 686000, '', 'Sourav', '2017-10-29 14:19:54', ''),
	(38, 'Sales-1', 'Pro-42', 'Airmate XR', '35', 50, 23, 1200, 1400, 32200, '', 'Sourav', '2017-10-29 14:20:11', ''),
	(39, 'Sales-14', 'Pro-20', 'Chapple-track', '100', 1318, 100, 560, 790, 79000, '', 'Sourav', '2017-10-29 14:21:59', ''),
	(40, 'Sales-14', 'Pro-32', 'formal Bata', '15', 200, 20, 3400, 3800, 76000, '', 'Sourav', '2017-10-29 14:21:59', ''),
	(41, 'Sales-14', 'Pro-19', 'pum Shoe', '220', 498, 25, 1650, 1800, 45000, '', 'Sourav', '2017-10-29 14:21:59', ''),
	(42, 'Sales-15', 'Pro-53', 'sharif umbralla', '5', 44, 10, 500, 560, 5600, '', 'Sourav', '2017-10-29 14:24:26', ''),
	(43, 'Sales-15', 'Pro-8', 'BH Fine', '1', 1400, 100, 35, 40, 4000, '', 'Sourav', '2017-10-29 14:24:26', ''),
	(44, 'Sales-12', 'Pro-53', 'sharif umbralla', '5', 34, 6, 500, 560, 3360, '', 'Sourav', '2017-10-29 14:40:45', ''),
	(45, 'Sales-5', 'Pro-12', 'Lotto-nk', '35', 140, 10, 950, 1100, 11000, '', 'Sourav', '2017-10-29 14:58:45', ''),
	(46, 'Sales-5', 'Pro-36', 'Arsenal', '200', 480, 20, 750, 800, 16000, '', 'Sourav', '2017-10-29 14:58:45', ''),
	(47, 'Sales-16', 'Pro-56', 'Micro-nava', '5', 65, 3, 5400, 6500, 19500, '', 'Sourav', '2017-10-30 12:02:44', '');
/*!40000 ALTER TABLE `tbsalesdetails` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbsalesinfo
CREATE TABLE IF NOT EXISTS `tbsalesinfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `salesno` varchar(100) NOT NULL DEFAULT '',
  `ClientType` varchar(50) DEFAULT NULL,
  `clientid` varchar(100) DEFAULT '',
  `clientname` varchar(100) DEFAULT '',
  `salesdate` date DEFAULT NULL,
  `paymentprotocol` varchar(50) DEFAULT NULL,
  `totalamount` double DEFAULT NULL,
  `paidamount` double DEFAULT NULL,
  `discountamount` double DEFAULT NULL,
  `dueamount` double DEFAULT NULL,
  `reference` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`salesno`),
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbsalesinfo: ~16 rows (approximately)
/*!40000 ALTER TABLE `tbsalesinfo` DISABLE KEYS */;
INSERT INTO `tbsalesinfo` (`autoid`, `salesno`, `ClientType`, `clientid`, `clientname`, `salesdate`, `paymentprotocol`, `totalamount`, `paidamount`, `discountamount`, `dueamount`, `reference`, `username`, `entrytime`, `userip`) VALUES
	(21, 'Sales-1', 'UnRegisterClient', 'No client', 'No client', '2017-10-29', 'Bikash', 32200, 32200, 23, 0, 'fd', 'Sourav', '2017-10-29 14:20:11', ''),
	(13, 'Sales-10', 'UnRegisterClient', 'No client', 'No client', '2017-10-23', 'Bikash', 149000, 149000, 0, 0, 're', 'Sourav', '2017-10-23 21:37:50', ''),
	(14, 'Sales-11', 'UnRegisterClient', 'No client', 'No client', '2017-10-27', 'Bikash', 21780, 21780, 0, 0, '34', 'Sourav', '2017-10-27 16:41:31', ''),
	(24, 'Sales-12', 'RegisterClient', 'Client-6', 'Nizam Islam', '2017-10-29', 'Cash', 3360, 3360, 0, 0, '', 'Sourav', '2017-10-29 14:40:45', ''),
	(19, 'Sales-13', 'RegisterClient', 'Client-9', 'Abdur X', '2017-10-27', 'Cash', 10520, 10520, 0, 0, '', 'Sourav', '2017-10-27 17:21:25', ''),
	(22, 'Sales-14', 'UnRegisterClient', 'No client', 'No client', '2017-10-29', 'Cash', 200000, 199500, 500, 0, '', 'Sourav', '2017-10-29 14:21:59', ''),
	(23, 'Sales-15', 'RegisterClient', 'Client-13', 'FAHIM MAHMUD', '2017-10-29', 'Debit Card', 9600, 9600, 200, 0, 'rf', 'Sourav', '2017-10-29 14:24:26', ''),
	(26, 'Sales-16', 'RegisterClient', 'Client-7', 'Zinath Khan', '2017-10-30', 'Debit Card', 19500, 19450, 50, 0, 'rf', 'Sourav', '2017-10-30 12:02:44', ''),
	(20, 'Sales-2', 'RegisterClient', 'Client-4', 'Nur Nobi  Hridoy', '2017-10-29', 'Cash', 748100, 748100, 0, 745665, '', 'Sourav', '2017-10-29 14:19:54', ''),
	(3, 'Sales-3', 'UnRegisterClient', 'No client', 'No client', '2017-10-18', 'Cash', 24000, 24000, 0, 0, '12', 'Sourav', '2017-10-18 16:48:38', ''),
	(5, 'Sales-4', 'UnRegisterClient', 'No client', 'No client', '2017-10-22', 'Cash', 114000, 114000, 0, 0, '234', 'Sourav', '2017-10-22 22:14:48', ''),
	(25, 'Sales-5', 'UnRegisterClient', 'No client', 'No client', '2017-10-29', 'Cash', 27000, 27000, 0, 0, '', 'Sourav', '2017-10-29 14:58:45', ''),
	(8, 'Sales-6', 'RegisterClient', 'Client-4', 'Nur Nobi  Hridoy', '2017-10-22', 'Cash', 2775, 2775, 0, 0, '234', 'Sourav', '2017-10-22 22:17:56', ''),
	(9, 'Sales-7', 'UnRegisterClient', 'No client', 'No client', '2017-10-22', 'Cash', 268000, 268000, 0, 0, 'x', 'Sourav', '2017-10-22 22:39:35', ''),
	(17, 'Sales-8', 'RegisterClient', 'Client-7', 'Zinath Khan', '2017-10-22', 'Debit Card', 427945, 427945, 0, 0, 'f', 'Sourav', '2017-10-27 17:07:16', ''),
	(16, 'Sales-9', 'RegisterClient', 'Client-5', 'Mizan', '2017-10-23', 'Cash', 21300, 21300, 0, 0, '', 'Sourav', '2017-10-27 16:59:33', '');
/*!40000 ALTER TABLE `tbsalesinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbsalesreturndetails
CREATE TABLE IF NOT EXISTS `tbsalesreturndetails` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `salesreturnno` varchar(100) DEFAULT NULL,
  `salesno` char(100) DEFAULT NULL,
  `productid` varchar(100) DEFAULT NULL,
  `productname` varchar(100) DEFAULT NULL,
  `stockqty` double DEFAULT NULL,
  `alreadyreceive` double DEFAULT NULL,
  `traderprice` double DEFAULT NULL,
  `unit` double DEFAULT NULL,
  `salesqty` double DEFAULT NULL,
  `receiveqty` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` char(50) DEFAULT NULL,
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbsalesreturndetails: ~6 rows (approximately)
/*!40000 ALTER TABLE `tbsalesreturndetails` DISABLE KEYS */;
INSERT INTO `tbsalesreturndetails` (`autoid`, `salesreturnno`, `salesno`, `productid`, `productname`, `stockqty`, `alreadyreceive`, `traderprice`, `unit`, `salesqty`, `receiveqty`, `amount`, `remark`, `entrytime`, `userip`) VALUES
	(5, 'SalesReturnNo-1', 'Sales-1', 'Pro-42', 'Airmate XR', 50, 12, 1400, 35, 23, 12, 16800, '', '2017-10-29 15:13:32', ''),
	(9, 'SalesReturnNo-3', 'Sales-9', 'Pro-55', 'citizen-hour', 203, 3, 2950, 5, 4, 3, 8850, '', '2017-10-29 15:19:23', ''),
	(10, 'SalesReturnNo-4', 'Sales-7', 'Pro-46', 'Navana', 368, 0, 4100, 20, 10, 1, 4100, '', '2017-10-29 15:20:34', ''),
	(11, 'SalesReturnNo-4', 'Sales-3', 'Pro-2', '18inch', 569, 0, 2000, 2, 12, 2, 4000, '', '2017-10-29 15:20:34', ''),
	(12, 'SalesReturnNo-2', 'Sales-10', 'Pro-50', 'Samsung', 86, 0, 25000, 1, 3, 1, 25000, '', '2017-10-29 15:28:56', ''),
	(13, 'SalesReturnNo-2', 'Sales-10', 'Pro-49', 'sony', 99, 1, 37000, 5, 2, 1, 37000, '', '2017-10-29 15:28:56', '');
/*!40000 ALTER TABLE `tbsalesreturndetails` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbsalesreturninfo
CREATE TABLE IF NOT EXISTS `tbsalesreturninfo` (
  `autoid` int(10) NOT NULL AUTO_INCREMENT,
  `salesreturnno` varchar(100) NOT NULL DEFAULT '0',
  `currentdate` date DEFAULT NULL,
  `Returndate` date DEFAULT NULL,
  `totalamount` double DEFAULT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `Userip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`salesreturnno`),
  UNIQUE KEY `autoid` (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbsalesreturninfo: ~4 rows (approximately)
/*!40000 ALTER TABLE `tbsalesreturninfo` DISABLE KEYS */;
INSERT INTO `tbsalesreturninfo` (`autoid`, `salesreturnno`, `currentdate`, `Returndate`, `totalamount`, `Username`, `entrytime`, `Userip`) VALUES
	(3, 'SalesReturnNo-1', '2017-10-29', '2017-10-29', 16800, 'Sourav', '2017-10-29 15:13:32', ''),
	(11, 'SalesReturnNo-2', '2017-10-29', '2017-10-29', 62000, 'Sourav', '2017-10-29 15:28:56', ''),
	(9, 'SalesReturnNo-3', '2017-10-29', '2017-10-29', 8850, 'Sourav', '2017-10-29 15:19:23', ''),
	(10, 'SalesReturnNo-4', '2017-10-29', '2017-10-29', 8100, 'Sourav', '2017-10-29 15:20:34', '');
/*!40000 ALTER TABLE `tbsalesreturninfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbsubcatagoryinfo
CREATE TABLE IF NOT EXISTS `tbsubcatagoryinfo` (
  `autoid` int(100) NOT NULL AUTO_INCREMENT,
  `catagoryid` varchar(100) DEFAULT '0',
  `catagoryname` varchar(100) DEFAULT '0',
  `subcatagoryid` varchar(100) NOT NULL DEFAULT '',
  `subcatagoryname` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`subcatagoryid`),
  UNIQUE KEY `Sl#` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbsubcatagoryinfo: 50 rows
/*!40000 ALTER TABLE `tbsubcatagoryinfo` DISABLE KEYS */;
INSERT INTO `tbsubcatagoryinfo` (`autoid`, `catagoryid`, `catagoryname`, `subcatagoryid`, `subcatagoryname`, `username`, `entrytime`, `userip`) VALUES
	(9, 'cat-2', 'keyboard', 'Subcat-4', 'Goldtuch', 'Sourav', '2017-07-25 17:56:48', ''),
	(10, 'cat-3', 'bat', 'Subcat-6', 'NB', 'Sourav', '2017-07-25 17:57:03', ''),
	(11, 'cat-4', 'ball', 'Subcat-5', 'bounch high', 'Sourav', '2017-07-25 17:57:42', ''),
	(8, 'cat-2', 'keyboard', 'Subcat-7', 'A4tech', 'Sourav', '2017-07-25 17:56:28', ''),
	(12, 'cat-5', 'Fan', 'Subcat-8', 'KB', 'Sourav', '2017-07-26 06:36:51', ''),
	(13, 'cat-5', 'Fan', 'Subcat-9', 'Prodip', 'Sourav', '2017-07-26 06:37:11', ''),
	(14, 'cat-3', 'bat', 'Subcat-10', 'Adidas', 'Sourav', '2017-07-26 06:37:44', ''),
	(15, 'cat-4', 'ball', 'Subcat-11', 'Jumboplan', 'Sourav', '2017-07-26 06:38:09', ''),
	(16, 'cat-7', 'Facewash', 'Subcat-12', 'Ganieer', 'Sourav', '2017-08-06 07:19:35', ''),
	(17, 'cat-7', 'Facewash', 'Subcat-13', 'Himaloya', 'Sourav', '2017-08-06 07:19:55', ''),
	(18, 'cat-6', 'Chaklet', 'Subcat-14', 'Candy-bar', 'Sourav', '2017-08-06 07:20:27', ''),
	(19, 'cat-6', 'Chaklet', 'Subcat-15', 'Dairy-Milk', 'Sourav', '2017-08-06 07:20:55', ''),
	(20, 'cat-8', 'Crime', 'Subcat-16', 'Ponds', 'Sourav', '2017-08-06 07:21:13', ''),
	(21, 'cat-9', 'T-shirt', 'Subcat-17', 'Addidas', 'Sourav', '2017-08-06 07:21:38', ''),
	(22, 'cat-9', 'T-shirt', 'Subcat-18', 'Lotto', 'Sourav', '2017-08-06 07:21:53', ''),
	(23, 'cat-10', 'pant', 'Subcat-19', 'Alcote', 'Sourav', '2017-08-06 07:22:11', ''),
	(24, 'cat-10', 'pant', 'Subcat-20', 'NIke', 'Sourav', '2017-08-06 07:22:30', ''),
	(25, 'cat-14', 'Shoe', 'Subcat-21', 'Bata', 'Sourav', '2017-08-10 20:17:42', ''),
	(26, 'cat-13', 'Book', 'Subcat-22', 'Bangla', 'Sourav', '2017-08-10 20:17:57', ''),
	(27, 'cat-12', 'Light', 'Subcat-23', 'Fhillps', 'Sourav', '2017-08-10 20:18:16', ''),
	(28, 'cat-14', 'Shoe', 'Subcat-24', 'Data', 'Sourav', '2017-08-10 20:18:28', ''),
	(29, 'cat-14', 'Shoe', 'Subcat-25', 'Lotto', 'Sourav', '2017-08-10 20:18:39', ''),
	(30, 'cat-12', 'Light', 'Subcat-26', 'Sunshine', 'Sourav', '2017-08-10 20:18:58', ''),
	(31, 'cat-12', 'Light', 'Subcat-27', 'Sunpower', 'Sourav', '2017-08-10 20:19:40', ''),
	(32, 'cat-14', 'Shoe', 'Subcat-28', 'Wood Land', 'Sourav', '2017-08-10 20:29:21', ''),
	(33, 'cat-15', 'Jarsy', 'Subcat-29', 'Football', 'Sourav', '2017-08-11 11:20:02', ''),
	(34, 'cat-11', 'Mobile', 'Subcat-30', 'SmartPhone', 'Sourav', '2017-08-18 19:51:50', ''),
	(35, 'cat-26', 'wallet', 'Subcat-31', 'Puma', 'Sourav', '2017-10-14 15:39:25', ''),
	(36, 'cat-17', 'pizza', 'Subcat-32', 'smail tripizza', 'Sourav', '2017-10-14 15:39:52', ''),
	(37, 'cat-19', 'Rice', 'Subcat-33', 'MInicat', 'Sourav', '2017-10-14 15:40:14', ''),
	(38, 'cat-24', 'Mouse', 'Subcat-34', 'Dell', 'Sourav', '2017-10-14 15:40:23', ''),
	(39, 'cat-10', 'pant', 'Subcat-35', 'Pumatx', 'Sourav', '2017-10-14 15:40:38', ''),
	(40, 'cat-20', 'Doll', 'Subcat-36', 'Xdoll', 'Sourav', '2017-10-14 15:40:58', ''),
	(41, 'cat-25', 'Colddrink', 'Subcat-37', 'Cokacola', 'Sourav', '2017-10-14 15:41:08', ''),
	(42, 'cat-23', 'EarPhone', 'Subcat-38', 'Samsung', 'Sourav', '2017-10-14 15:41:20', ''),
	(43, 'cat-6', 'Chaklet', 'Subcat-39', 'parledel', 'Sourav', '2017-10-14 15:41:39', ''),
	(44, 'cat-16', 'Burger', 'Subcat-40', 'hot Chess', 'Sourav', '2017-10-14 19:42:13', ''),
	(45, 'cat-5', 'Fan', 'Subcat-41', 'Airmate', 'Sourav', '2017-10-14 19:55:20', ''),
	(46, 'cat-5', 'Fan', 'Subcat-42', 'coldwar', 'Sourav', '2017-10-14 19:55:31', ''),
	(47, 'cat-7', 'Facewash', 'Subcat-43', 'himel', 'Sourav', '2017-10-14 19:55:42', ''),
	(48, 'cat-27', 'Stob', 'Subcat-44', 'gas Stob', 'Sourav', '2017-10-14 19:58:47', ''),
	(49, 'cat-28', 'OverDrob', 'Subcat-45', 'Shahi', 'Sourav', '2017-10-15 14:01:23', ''),
	(50, 'cat-29', 'TV', 'Subcat-46', 'LED', 'Sourav', '2017-10-22 14:37:04', ''),
	(51, 'cat-29', 'TV', 'Subcat-47', 'monitor', 'Sourav', '2017-10-22 14:37:15', ''),
	(52, 'cat-30', 'umbralla', 'Subcat-48', 'sharif', 'Sourav', '2017-10-22 22:42:24', ''),
	(53, 'cat-30', 'umbralla', 'Subcat-49', 'asraf', 'Sourav', '2017-10-22 22:42:34', ''),
	(54, 'cat-31', 'watch', 'Subcat-50', 'citizen', 'Sourav', '2017-10-23 20:31:35', ''),
	(55, 'cat-31', 'watch', 'Subcat-51', 'fasttrack', 'Sourav', '2017-10-23 20:31:49', ''),
	(56, 'cat-32', 'Oven', 'Subcat-52', 'Micro-oven', 'Sourav', '2017-10-30 11:56:16', ''),
	(58, 'cat-16', 'Burger', 'Subcat-53', 'Chizzy Barger', 'Sourav Mojumder', '2017-11-09 23:42:42', '');
/*!40000 ALTER TABLE `tbsubcatagoryinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbsupplierinfo
CREATE TABLE IF NOT EXISTS `tbsupplierinfo` (
  `autoid` int(100) NOT NULL AUTO_INCREMENT,
  `Supplierid` char(100) NOT NULL DEFAULT '',
  `suppliername` char(100) DEFAULT NULL,
  `MailId` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `phonenumber` varchar(100) DEFAULT NULL,
  `picture` varchar(100) DEFAULT '0',
  `user` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Supplierid`),
  UNIQUE KEY `sl` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbsupplierinfo: 16 rows
/*!40000 ALTER TABLE `tbsupplierinfo` DISABLE KEYS */;
INSERT INTO `tbsupplierinfo` (`autoid`, `Supplierid`, `suppliername`, `MailId`, `Address`, `phonenumber`, `picture`, `user`, `entrytime`, `userip`) VALUES
	(27, 'Sup-2', 'Selim uddin', 'Selim@gmail.com', 'dhaka,bangladesh', '02389349802', 'Sup-2.jpg', 'Sourav', '2017-10-15 14:09:54', ''),
	(8, 'Sup-3', 'Moniul Islam', 'moniul@gmail.com', 'Dhaka,bangladesh', '01975435354', 'Sup-3.jpg', 'Sourav', '2017-07-26 06:40:24', ''),
	(6, 'Sup-1', 'Sourav Mojumder', 'Sourav@gmail.com', 'ctg,bangladesh', '01879546321', 'Sup-1.jpg', 'Sourav', '2017-07-25 17:48:49', ''),
	(9, 'Sup-4', 'Hisbul Haque', 'Hisbul@gmail.com', 'jessore,Bangladesh', '01864257954', 'Sup-4.jpg', 'Sourav', '2017-07-26 06:42:26', ''),
	(28, 'Sup-5', 'Tipu Barua', 'tipu@gmial.com', 'Ctg', '01985472614', 'Sup-5.jpg', 'Sourav', '2017-10-15 14:10:10', ''),
	(24, 'Sup-6', 'Ifteker Rahman', 'x@gmail', 'ctg', '01982782823', 'Sup-6.jpg', 'Sourav', '2017-10-15 14:09:24', ''),
	(13, 'Sup-7', 'Sanju Roy', 'T@gmail', 'Dhaka,BD', '01927288192', 'Sup-7.jpg', 'Sourav', '2017-10-14 15:43:29', ''),
	(15, 'Sup-9', 'NIsham Islam', 'k@gmail', 'Chittagong,BD', '01928282872', 'Sup-9.jpg', 'Sourav', '2017-10-14 15:45:19', ''),
	(16, 'Sup-10', 'Foisal Mahabub', 'J@gmail', 'Gazipur', '01234677854', 'Sup-10.jpg', 'Sourav', '2017-10-14 15:48:59', ''),
	(17, 'Sup-11', 'Oishi Khan', 'O@gmail.com', 'Dhaka', '01992983929', 'Sup-11.jpg', 'Sourav', '2017-10-15 14:04:09', ''),
	(25, 'Sup-12', 'Nisa islam', 'n@gmail.com', 'CTG', '12222226478', 'Sup-12.jpg', 'Sourav', '2017-10-15 14:09:38', ''),
	(23, 'Sup-13', 'Fahad Isak', 'F@gmail.com', 'Ctg', '11113421235', 'Sup-13.jpg', 'Sourav', '2017-10-15 14:09:16', ''),
	(21, 'Sup-14', 'Arian Isak', 'Fg@gmail.com', 'Gazipur', '12322343211', 'Sup-14.jpg', 'Sourav', '2017-10-15 14:07:40', ''),
	(26, 'Sup-8', 'Rimon Khan', 'J@gmail', 'Dhaka,BD', '01991883920', 'Sup-8.jpg', 'Sourav', '2017-10-15 14:09:46', ''),
	(31, 'Sup-15', 'Mayeen Islam', 'M@gmail.com', 'Coxs Bazer', '02229328382', 'Sup-15.jpg', 'Sourav', '2017-10-15 14:14:27', ''),
	(32, 'Sup-16', 'Sudipto Das', 'F@gmail.com', 'Ctg', '12343567876', 'Sup-16.jpg', 'Sourav', '2017-10-15 14:15:25', '');
/*!40000 ALTER TABLE `tbsupplierinfo` ENABLE KEYS */;


-- Dumping structure for table binarycareshop.tbwastageinfo
CREATE TABLE IF NOT EXISTS `tbwastageinfo` (
  `autoid` int(50) NOT NULL AUTO_INCREMENT,
  `wastageno` char(50) NOT NULL DEFAULT '0',
  `productype` char(100) DEFAULT NULL,
  `productid` varchar(100) DEFAULT NULL,
  `productname` varchar(100) DEFAULT NULL,
  `catagoryid` varchar(100) DEFAULT NULL,
  `catgoryname` varchar(100) DEFAULT NULL,
  `subcatagoryid` varchar(100) DEFAULT NULL,
  `subcatagoryname` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `totalstock` bigint(20) DEFAULT NULL,
  `watagedate` date DEFAULT NULL,
  `watageqty` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `user` varchar(100) DEFAULT NULL,
  `entrytime` datetime DEFAULT NULL,
  `userip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`wastageno`),
  UNIQUE KEY `sl` (`autoid`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table binarycareshop.tbwastageinfo: 7 rows
/*!40000 ALTER TABLE `tbwastageinfo` DISABLE KEYS */;
INSERT INTO `tbwastageinfo` (`autoid`, `wastageno`, `productype`, `productid`, `productname`, `catagoryid`, `catgoryname`, `subcatagoryid`, `subcatagoryname`, `unit`, `totalstock`, `watagedate`, `watageqty`, `rate`, `amount`, `remarks`, `user`, `entrytime`, `userip`) VALUES
	(3, 'Waste-2', 'Broken', 'Pro-1', 'Big', 'cat-2', 'keyboard', 'Subcat-4', 'Goldtuch', '1', 30, '2017-08-02', 11, 10, 110, 'beje', 'Sourav', '2017-08-02 13:52:37', ''),
	(15, 'Waste-1', 'Broken', 'Pro-1', 'Big', 'cat-3', 'bat', 'Subcat-10', 'Adidas', '1', 23, '2017-08-02', 10, 24, 240, 'bej', 'Sourav', '2017-08-04 07:38:45', ''),
	(4, 'Waste-3', 'Wastege', 'Pro-4', 'P@R', 'Pro-4', 'P@R', 'Pro-4', 'P@R', '1', 120, '2017-08-02', 23, 12, 276, 'bght', 'Sourav', '2017-08-02 14:23:06', ''),
	(11, 'Waste-4', 'Wastege', 'Pro-2', '18inch', 'Pro-2', '18inch', 'Pro-2', '18inch', '2', 123, '2017-08-02', 42, 10, 420, 'Nothing', 'Sourav', '2017-08-03 07:09:48', ''),
	(14, 'Waste-5', 'Broken', 'Pro-1', 'Big', 'Pro-1', 'Big', 'Pro-1', 'Big', '1', 23, '2017-08-02', 10, 23, 230, 'Good', 'Sourav', '2017-08-04 07:29:25', ''),
	(16, 'Waste-7', 'Broken', 'Pro-4', 'P@R', 'cat-4', 'ball', 'Subcat-11', 'Jumboplan', '1', 40, '2017-08-06', 2, 35, 70, 'this is good', 'Sourav', '2017-08-06 07:07:03', ''),
	(17, 'Waste-6', 'Wastege', 'Pro-5', 'GT Ak', 'cat-2', 'keyboard', 'Subcat-4', 'Goldtuch', '2', 123, '2017-08-03', 23, 250, 5750, 'yes', 'Sourav', '2017-08-06 07:13:54', '');
/*!40000 ALTER TABLE `tbwastageinfo` ENABLE KEYS */;


-- Dumping structure for function binarycareshop.totalstock
DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `totalstock`(`pid` varchar(50)) RETURNS double
begin

	Declare openningstock double ;
	Declare purchaserecipent double ;
	Declare salesreturn double ;
	Declare sales double ;
	Declare returntosupplier double ;
	Declare broken double ;
	Declare tstock double ;
		set openningstock=(select ifnull(sum(StockQuentity),0) sum from tbopeningstockinfo where productid=pid);
		set purchaserecipent=(select ifnull(sum(receiveqty),0) sum from tbpurchaserecipentdetails where productid=pid);
		set salesreturn=(select ifnull(sum(receiveqty),0) sum from tbsalesreturndetails where productid=pid);
		set sales=(select ifnull(sum(salesqty),0) sum from tbsalesdetails where productid=pid);
		set returntosupplier=(select ifnull(sum(returnqty),0) sum from tbretrurntosupplierdetails where productid=pid);
		set broken=(select ifnull(sum(watageqty),0) sum from tbwastageinfo where productid=pid);
		set tstock=((openningstock+purchaserecipent+salesreturn)-(sales+returntosupplier+broken));
		return tstock;
end//
DELIMITER ;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
