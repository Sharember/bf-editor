DROP DATABASE IF EXISTS `editor`;
CREATE DATABASE `editor`;

USE  `editor`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY ,
  `user_name` VARCHAR (128) NOT NULL ,
  `user_password` VARCHAR (256) NOT NULL ,
  `user_role` VARCHAR(32) DEFAULT 'VISITOR' ,
  `user_phone` VARCHAR (32),
  `user_email` VARCHAR (64),
  `user_id_card` VARCHAR (32),
  `last_password_resetDate` DATETIME
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=10;

INSERT INTO `users` (`id`, `user_name`, `user_password`, `user_role`, `user_phone`, `user_email`, `last_password_resetDate`) 
VALUES (1, 'chengfan', '123456', 'VISITOR',  '12345678901', '123@qq.com', '2017-05-24 00:00:00');
INSERT INTO `users` (`id`, `user_name`, `user_password`, `user_role`, `user_phone`, `user_email`, `last_password_resetDate`) 
VALUES (2, 'ADMIN', '123456', 'ADMIN', '12345678901', '123@qq.com', '2017-05-24 00:00:01');

DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform`(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY ,
  `platform_name` VARCHAR (32) NOT NULL ,
  `platform_home` VARCHAR(64) NOT NULL ,
  `platform_id` INT(10) NOT NULL ,
  `platform_support` INT NOT NULL  -- 0:不支持；1:支持
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=10;

INSERT INTO platform (id, platform_name, platform_home, platform_id, platform_support)
VALUES (1, 'csdn', 'blog.csdn.net', 1, 0);
INSERT INTO platform (id, platform_name, platform_home, platform_id, platform_support)
VALUES (2, '网易博客', 'blog.163.com', 2, 1);


DROP TABLE IF EXISTS `user_binding`;
CREATE TABLE `user_binding`(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY ,
  `fk_user_id` INT(10) NOT NULL ,
  `fk_platform_id` INT(10) NOT NULL,
  `account_name` VARCHAR (64) NOT NULL ,
  `account_password` VARCHAR (64) NOT NULL ,
  `account_url` VARCHAR (128) ,
  `account_phone` VARCHAR (32),
  `account_email` VARCHAR (32),
  FOREIGN KEY(fk_user_id) REFERENCES users(id),
  FOREIGN KEY (fk_platform_id) REFERENCES platform(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=10;
INSERT INTO user_binding (id, fk_user_id,fk_platform_id, account_name,account_password,account_url,account_phone,account_email)
VALUES (1,1,1,'12345@gmail.com','123456','blog.csdn.net','12345678','12345@gmail.com');
INSERT INTO user_binding (id, fk_user_id,fk_platform_id,account_name,account_password,account_url,account_phone,account_email)
VALUES (2,1,2,'12345@gmail.com','123456','blog.163.com/','12345678','12345@gmail.com');


DROP TABLE IF EXISTS `user_dir`;
CREATE TABLE `user_dir`(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY ,
  `fk_user_id` INT(10) NOT NULL ,
  `dir_name` VARCHAR (64) NOT NULL ,
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6),
  foreign key(fk_user_id) references users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=10;

INSERT INTO user_dir (id, fk_user_id, dir_name, create_time)
VALUES (1, 1, 'test1', '2017-05-24 00:00:00');
INSERT INTO user_dir (id, fk_user_id, dir_name, create_time)
VALUES (2, 1, 'test2', '2017-05-24 00:00:01');


DROP TABLE IF EXISTS `user_article`;
CREATE TABLE `user_article` (
  `id` int(10) AUTO_INCREMENT PRIMARY KEY ,
  `fk_dir_id` int(10) NOT NULL ,
  `article_title` varchar(100) NOT NULL,
  `article_short_content` varchar(100) NOT NULL,
  `article_comments`  varchar(100) NOT NULL,
  `post_status` int DEFAULT 3, -- 1: 全部发布; 2: 部分发布; 3:未发布
  `post_lists` VARCHAR (32), -- 1|2|3 1.csdn;2.简书 platform_id
  `modify_status` int DEFAULT 3, -- 1: 全部修改; 2: 部分修改; 3:未修改
  `create_time` datetime(6) NOT NULL,
  `modify_time` datetime(6),
  foreign key(fk_dir_id) references user_dir(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user_article (id, fk_dir_id, article_title, article_short_content, article_comments, modify_status, post_status,create_time)
VALUES (1, 1, 'test', 'test1234', 'test12341234431',3,3,'2017-05-24 00:00:00');



