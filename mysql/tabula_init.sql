CREATE DATABASE p;
USE p;

CREATE TABLE IF NOT EXISTS `paper` (
`paper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '文章ID',
`title` varchar(50) COMMENT '文章标题',
`journal` varchar(15),
`date` varchar(20),
'commit' varchar(20),
'doi' varchar(20),
'author' varchar(20),
'category' varchar(10),
'abstract' TEXT,
PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `user` (
`user_id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(20),
`pwd` varchar(20),
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `tag` (
`tag_id` bigint NOT NULL AUTO_INCREMENT,
`content` varchar(20),
PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `u_t_link` (
`utlink_id` bigint NOT NULL AUTO_INCREMENT,
`tag_id` bigint NOT NULL,
`user_id` bigint NOT NULL,
PRIMARY KEY (`utlink_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `u_p_link` (
`uplink_id` bigint NOT NULL AUTO_INCREMENT,
`paper_id` bigint NOT NULL,
`user_id` bigint NOT NULL,
PRIMARY KEY (`uplink_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `u_u_link` (
`uulink_id` bigint NOT NULL AUTO_INCREMENT,
`user2_id` bigint NOT NULL,
`user1_id` bigint NOT NULL,
PRIMARY KEY (`uulink_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `p_t_link` (
`ptlink_id` bigint NOT NULL AUTO_INCREMENT,
`paper_id` bigint NOT NULL,
`tag_id` bigint NOT NULL,
PRIMARY KEY (`ptlink_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8;

