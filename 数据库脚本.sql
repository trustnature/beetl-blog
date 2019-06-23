/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 116.62.142.122:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 11/12/2018 21:53:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `img` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_flag` bit(1) NOT NULL DEFAULT b'0',
  `category` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES (1, '博客1', '内容1', 'img/1.jpg', '2018-12-11 20:01:41', '2018-12-11 20:02:22', b'0', 'java');
INSERT INTO `blog` VALUES (2, '博客2', '内容2', 'img/1.jpg', '2018-12-11 19:50:41', '2018-12-11 20:02:41', b'0', 'beetl');
INSERT INTO `blog` VALUES (3, '博客3', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:08', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (4, '博客4', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:11', b'0', 'beetl');
INSERT INTO `blog` VALUES (5, '555', '内容1', 'img/2.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:15', b'0', 'beetl');
INSERT INTO `blog` VALUES (6, '6666', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:19', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (7, '7777', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:23', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (8, '888', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:27', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (9, '999', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:29', b'0', 'beetl');
INSERT INTO `blog` VALUES (10, '1000', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:32', b'0', 'java');
INSERT INTO `blog` VALUES (11, '11111', '1', 'img/2.jpg', '2018-11-18 18:19:46', '2018-11-23 22:05:35', b'0', 'java');
INSERT INTO `blog` VALUES (12, '博222客2', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:04', b'0', 'beetl');
INSERT INTO `blog` VALUES (13, '博22客4', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:11', b'0', 'beetl');
INSERT INTO `blog` VALUES (14, '55335', '内容1', 'img/2.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:15', b'0', 'beetl');
INSERT INTO `blog` VALUES (15, '94499', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:29', b'0', 'beetl');
INSERT INTO `blog` VALUES (16, 'wreqq', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:08', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (17, 'eqeqe', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:19', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (18, '动手术', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:23', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (19, '人', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:27', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (20, '通融通融', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:00', b'0', 'java');
INSERT INTO `blog` VALUES (21, '突然TVVR温热温热无', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:32', b'0', 'java');
INSERT INTO `blog` VALUES (22, '范德萨范德萨范德萨', '1', 'img/2.jpg', '2018-11-18 18:19:46', '2018-11-23 22:05:35', b'0', 'java');
INSERT INTO `blog` VALUES (23, '博222客2', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:04', b'0', 'beetl');
INSERT INTO `blog` VALUES (24, '福克斯将很快肺结核萨科技的哈桑', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:11', b'0', 'beetl');
INSERT INTO `blog` VALUES (25, '发了顺丰快递设计开放厚大司考金凤凰肯定释放可视电话', '内容1', 'img/2.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:15', b'0', 'beetl');
INSERT INTO `blog` VALUES (26, '94499', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:29', b'0', 'beetl');
INSERT INTO `blog` VALUES (27, '反倒是开发看电视剧和福克斯的回复', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:08', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (28, 'eqeqe', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:19', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (29, '飞洒可能的卡萨丁看撒娇看到啥', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:23', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (30, '人', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:27', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (31, '发大水了附近的设计费抗裂砂浆地方了', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:00', b'0', 'java');
INSERT INTO `blog` VALUES (32, '突然TVVR温热温热无', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:32', b'0', 'java');
INSERT INTO `blog` VALUES (33, '风刀霜剑客户方科技的首付款大会上开发', '1', 'img/2.jpg', '2018-11-18 18:19:46', '2018-11-23 22:05:35', b'0', 'java');
INSERT INTO `blog` VALUES (34, '博222客2', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:04', b'0', 'beetl');
INSERT INTO `blog` VALUES (35, '发的所发生的开放接口的首付款', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:11', b'0', 'beetl');
INSERT INTO `blog` VALUES (36, '发大水了看法开始搭建丽枫酒店酸辣粉', '内容1', 'img/2.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:15', b'0', 'beetl');
INSERT INTO `blog` VALUES (37, '发大水了会计分录都是坑家乐福跨境电商', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:29', b'0', 'beetl');
INSERT INTO `blog` VALUES (38, '反倒是会计分录肯定是家乐福跨境电商', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:08', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (39, '佛挡杀佛几点睡了会计分录肯定是', '内容2', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:19', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (40, '发大水了会计分录看电视剧了疯狂就冻死了', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:23', b'0', 'beetlsql');
INSERT INTO `blog` VALUES (41, '反倒是垃圾分类见识到了开飞机上课了对方', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-12-11 20:40:29', b'0', '一起学Beetl');
INSERT INTO `blog` VALUES (42, '通融通融', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:00', b'0', 'java');
INSERT INTO `blog` VALUES (43, '突然TVVR温热温热无', '内容1', 'img/1.jpg', '2018-11-18 17:40:41', '2018-11-23 22:05:32', b'0', 'java');
INSERT INTO `blog` VALUES (44, '范德萨范德萨范德萨', '1', 'img/2.jpg', '2018-11-18 18:19:46', '2018-11-23 22:05:35', b'0', 'java');
INSERT INTO `blog` VALUES (45, '一起学Beetl', '一套适合新手的Beetl教程，不CUO', 'https://i2.hdslb.com/bfs/archive/9dfa30056bc95420bdd090094d58f81c9c841f13.jpg@560w_350h_100Q_1c.webp', '2018-12-11 21:05:26', '2018-12-11 21:05:26', b'0', 'java');
COMMIT;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blog_id` bigint(20) NOT NULL,
  `nick_name` varchar(30) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_flag` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
BEGIN;
INSERT INTO `message` VALUES (1, 1, 'JANE', '评论1', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (2, 1, 'JANE1', '评论1', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (3, 1, 'JANE2', '评论2', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (4, 1, 'JANE3', '评论3', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (5, 1, 'JANE4', '评论4', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (6, 1, 'JANE5', '评论5', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (7, 1, 'JANE6', '评论6', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (8, 1, 'JANE7', '评论7', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (9, 1, 'JANE1', '评论333', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (10, 1, 'JANE2', '评论4444', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (11, 1, 'JANE3', '评论5555', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (12, 1, 'JANE4', '评论6666', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (13, 1, 'JANE5', '评论7777', '2018-12-10 22:04:33', '2018-12-10 22:04:37', b'0');
INSERT INTO `message` VALUES (14, 1, 'JANE6', '评论8888', '2018-12-11 18:59:33', '2018-12-11 19:55:02', b'0');
INSERT INTO `message` VALUES (15, 1, 'JANE7', '评论99999', '2018-12-11 19:45:33', '2018-12-11 19:54:25', b'0');
INSERT INTO `message` VALUES (16, 1, 'GK', '不错的文章，支持一下 一起学Beetl', '2018-12-11 19:53:07', '2018-12-11 19:53:29', b'0');
INSERT INTO `message` VALUES (17, 45, 'GK', '文章真好', '2018-12-11 21:05:46', '2018-12-11 21:05:46', b'0');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_flag` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'gk', 'gk', '2018-11-23 23:05:16', '2018-11-23 23:05:19', b'0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
