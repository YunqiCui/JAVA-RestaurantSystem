CREATE TABLE `employee` (
  `empno` integer(16) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `ftname` varchar(255),
  `lname` varchar(255),
  `gender` varchar(20),
  `address` varchar(255),
  `dob` date,
  `occup` varchar(60),
  `email` varchar(255),
  `phno` int(16),
  `redate` date,
  `retime` time,
  `remark` varchar(255)
);

INSERT INTO `employee` (`empno`, `ftname`, `lname`, `gender`, `address`, `dob`, `occup`, `email`, `phno`, `redate`, `retime`, `remark`) VALUES
  (1, 'yunqi', 'cui', 'male', '1/5 keith street oakleigh east VIC 3166', '1990-12-20', 'Manager', 'cuiyunqi@yahoo.com', 451220264, '2018-04-16', '09:30:34', 'Founder'),
  (2, 'wenchuan', 'wang', 'female', '1/5 keith street oakleigh east VIC 3166', '1990-10-01', 'Waitress', 'wangwenchuan@gmail.com', 444123456, '2018-04-16', '09:31:31', 'None'),
  (3, 'tao', 'ju', 'male', '2/5 marshall ave clayton 3168', '1990-01-15', 'cashier', 'taoju@gmail.com', 422678912, '2018-04-16', '09:35:18', 'None'),
  (4, 'yuan', 'ji', 'female', '7 hash street caulfield 3145', '1988-02-04', 'Waiter', 'yuanji@gmail.com', 410367235, '2018-04-17', '14:21:12', 'None'),
  (5, 'Ye', 'Han', 'Female', '1/5 keith street oakleigh east VIC 3166', '1995-02-26', 'Vice-President', 'hanye@gmail.com', 410229877, '2018-04-18', '18:24:52', 'None');

CREATE TABLE `loginauth` (
  `empno` integer(255) NOT NULL PRIMARY KEY ,
  `password` varchar(255) DEFAULT NULL
);
INSERT INTO `loginauth` (`empno`, `password`) VALUES
  (1, 'cuiyunqi90'),
  (2, 'abc123'),
  (3, 'efg456'),
  (4, 'hijk789'),
  (5, 'qianxirong92');

drop table loginauth;