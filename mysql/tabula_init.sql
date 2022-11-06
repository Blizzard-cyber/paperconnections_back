CREATE TABLE IF NOT EXISTS `paper` (
`paper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '文章ID',
`title` varchar(50) COMMENT '文章标题',
`year` SMALLINT COMMENT '发表年份',
`others` varchar(50) COMMENT '其他信息，如发表期刊等',
PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8
  COMMENT='文章信息'; 

# INSERT INTO paper (title, year, others)
#                       VALUES
#         	   ('linkPrediction', '2022', 'joking' );

CREATE TABLE IF NOT EXISTS `link` (
`link_id` bigint NOT NULL AUTO_INCREMENT,
`paper_id` bigint NOT NULL,
`link_addr` varchar(100),
PRIMARY KEY (`link_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8; 

#INSERT INTO link (paper_id, link_addr)
#                       VALUES
#       	   ('1', 'joking');

CREATE TABLE IF NOT EXISTS `author` (
`author_id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(100),
PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8; 

CREATE TABLE IF NOT EXISTS `a_p_link` (
`aplink_id` bigint NOT NULL AUTO_INCREMENT,
`author_id` bigint NOT NULL,
`paper_id` bigint NOT NULL,
PRIMARY KEY (`aplink_id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8; 

CREATE TABLE IF NOT EXISTS `cited` (
`cite_id` bigint NOT NULL AUTO_INCREMENT,
`citepaper_id` bigint NOT NULL,
`paper_id` bigint NOT NULL,
PRIMARY KEY (`cite_id`)
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

