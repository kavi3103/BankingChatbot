create database virtusachatbot;
use virtusachatbot;

CREATE TABLE `chat` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `loan_amount` varchar(100) DEFAULT NULL,
  `loan_type` varchar(100) DEFAULT NULL,
  `want_moratorium` varchar(100) DEFAULT NULL,
  `time_period` varchar(100) DEFAULT NULL,
  `type_work` varchar(100) DEFAULT NULL,
  `income` varchar(100) DEFAULT NULL,
  `affected_covid` varchar(100) DEFAULT NULL,
  `has_paid` varchar(100) DEFAULT NULL,
  `other_reasons` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'USER',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `userdetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phoneno` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into `user`(username, password, role) values ('admin','21232f297a57a5a743894a0e4a801fc3','ADMIN');

delimiter %
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletechat`(in user varchar(50))
begin
delete from chat where username = user;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteuser`(in user varchar(50))
begin
delete from user where username = user;
delete from userdetail where username = user;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `getallusers`()
begin
select * from userdetail;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `getfromchat`()
begin
select * from chat;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `getmychat`(in user varchar(50))
begin
select * from chat where username = user;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `getmyprofile`(in user varchar(50))
begin
select * from userdetail where username = user;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `getuser`(in user varchar(50))
begin
select * from user where username = user;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertchat`(IN username varchar(50),IN loan_amount varchar(100),IN loan_type varchar(100),IN want_moratorium varchar(100),IN time_period varchar(100),IN type_work varchar(100), in income varchar(100),in affected_covid varchar(100),in has_paid varchar(100),in other_reason varchar(500))
BEGIN
insert into chat(username,loan_amount,loan_type,want_moratorium,time_period,type_work,income,affected_covid,has_paid,other_reasons) values (username,loan_amount,loan_type,want_moratorium,time_period,type_work,income,affected_covid,has_paid,other_reason) ;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertdetail`(in username varchar(50),in name varchar(50),in address varchar(100),in phoneno varchar(11))
Begin
insert into userDetail(username,name,address,phoneno) values(username,name,address,phoneno);
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertuser`(in username varchar(50),in password varchar(100))
begin
insert into USER(username,password) values (username,password);
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `resetPasswordUser`(in user varchar(50), in password varchar(100))
begin
update user set password = password where username = user;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatechat2`(IN user varchar(50),IN loanamount varchar(100),IN loantype varchar(100),IN wantmoratorium varchar(100),IN timeperiod varchar(100),IN typework varchar(100), in income1 varchar(100),in affectedcovid varchar(100),in haspaid varchar(100),in otherreason varchar(500))
begin
  update chat set loan_amount = loanamount,loan_type = loantype,want_moratorium = wantmoratorium,time_period = timeperiod,type_work = typework,income = income1,affected_covid = affectedcovid,has_paid = haspaid,other_reasons = otherreason where username = user;
end%

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateuserdetail`(in user varchar(50),in name varchar(50),in address varchar(100),in phonenumber varchar(11))
begin
update userdetail set name = name, address = address, phoneno = phonenumber where username = user;
end%


