/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2017-09-21 11:08:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `c_id` int(11) NOT NULL auto_increment,
  `c_name` varchar(255) default NULL,
  `teacher_id` int(11) default NULL,
  PRIMARY KEY  (`c_id`),
  KEY `fk_teacher_id` (`teacher_id`),
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', 'class_1', '1');
INSERT INTO `class` VALUES ('2', 'class_2', '2');
INSERT INTO `class` VALUES ('3', 'class_3', '3');
INSERT INTO `class` VALUES ('4', 'calss_4', '4');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL auto_increment,
  `s_name` varchar(255) default NULL,
  `class_id` int(11) default NULL,
  PRIMARY KEY  (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'student_A', '1');
INSERT INTO `student` VALUES ('2', 'student_B', '1');
INSERT INTO `student` VALUES ('3', 'student_C', '1');
INSERT INTO `student` VALUES ('4', 'student_D', '2');
INSERT INTO `student` VALUES ('5', 'student_E', '2');
INSERT INTO `student` VALUES ('6', 'student_F', '2');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL auto_increment,
  `t_name` varchar(255) default NULL,
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'teacher_1');
INSERT INTO `teacher` VALUES ('2', '啊噶而过');
INSERT INTO `teacher` VALUES ('3', 'teacher_3');
INSERT INTO `teacher` VALUES ('4', 'ddd');

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES ('1', 'cs', '123456', '18');
INSERT INTO `user_t` VALUES ('2', 'SSM', '1234', '111');
INSERT INTO `user_t` VALUES ('3', 'not', '123', '18');
INSERT INTO `user_t` VALUES ('4', 'not', '123', '18');
INSERT INTO `user_t` VALUES ('5', 'ppt', '123', '1');
INSERT INTO `user_t` VALUES ('7', 'bless', '123', '1');

-- ----------------------------
-- Procedure structure for cs
-- ----------------------------
DROP PROCEDURE IF EXISTS `cs`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cs`(id varchar(255))
BEGIN
	#Routine body goes here...
	select * from class c inner join teacher t on  c.teacher_id = t.t_id inner join student s on c.c_id = s.class_id where c.c_id = id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for onetomroe
-- ----------------------------
DROP PROCEDURE IF EXISTS `onetomroe`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `onetomroe`(pp int)
BEGIN
	#Routine body goes here...
	#select * from student where cid = (select id from class where name = tname);

	#select s.* from class c,student s where c.id = s.cid and c.name = tname; 
select * from class c,teacher t,student s where c.teacher_id = t.t_id and c.c_id = s.class_id and c.c_id = pp;
END
;;
DELIMITER ;
