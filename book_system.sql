/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : book_system

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 25/09/2023 16:21:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL COMMENT '序号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `adminType` int(20) NULL DEFAULT NULL COMMENT '类型（教务处、教师、学生、系统管理员）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `password`(`password`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'jwc01', '123456', 1);
INSERT INTO `admin` VALUES (2, 'xs01', '123456', 3);
INSERT INTO `admin` VALUES (3, 'js01', '123456', 2);
INSERT INTO `admin` VALUES (4, 'gly01', '12345', 0);
INSERT INTO `admin` VALUES (5, 'jwc02', '1234567', 1);
INSERT INTO `admin` VALUES (6, 'gly02', '123456', 0);
INSERT INTO `admin` VALUES (7, 'js02', '123456', 2);
INSERT INTO `admin` VALUES (8, 'js03', '123456', 2);
INSERT INTO `admin` VALUES (9, 'xs02', '123456', 3);
INSERT INTO `admin` VALUES (10, 'xs03', '123456', 3);
INSERT INTO `admin` VALUES (11, 'xs04', '12', 3);
INSERT INTO `admin` VALUES (12, 'gly03', '12345', 0);
INSERT INTO `admin` VALUES (13, 'jwc03', '123456', 1);
INSERT INTO `admin` VALUES (15, 'xs12', '123456', 3);
INSERT INTO `admin` VALUES (23, 'js04', '123456', 2);

-- ----------------------------
-- Table structure for apply1
-- ----------------------------
DROP TABLE IF EXISTS `apply1`;
CREATE TABLE `apply1`  (
  `id` int(11) NOT NULL COMMENT '编码',
  `bookId` int(11) NULL DEFAULT NULL COMMENT '教材编码',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `courseId` int(11) NULL DEFAULT NULL COMMENT '课程编码',
  `courseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  `type` int(255) NULL DEFAULT NULL COMMENT '审核状态（正在审核、申请通过、申请驳回）',
  `teaId` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ap01`(`bookId`) USING BTREE,
  INDEX `ap03`(`courseId`) USING BTREE,
  CONSTRAINT `ap01` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap03` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教材申请记录表（教师）' ROW_FORMAT = Redundant;

-- ----------------------------
-- Records of apply1
-- ----------------------------
INSERT INTO `apply1` VALUES (1, 5002, '离散数学', 4001, '离散数学', 2, '2023-06-05 11:05:29', 1, 2001);
INSERT INTO `apply1` VALUES (2, 5004, '高等数学', 4002, '高等数学', 2, '2023-06-23 23:46:00', 1, 2001);
INSERT INTO `apply1` VALUES (3, 5007, '概率论与数理统计', 4004, '概率论与数理统计', 2, '2023-06-27 12:40:00', 1, 2001);
INSERT INTO `apply1` VALUES (21, 5004, '高等数学', 4002, '高等数学', 4, '2023-06-23 23:47:00', 1, 2002);
INSERT INTO `apply1` VALUES (22, 5005, '高等数学第二版', 4002, '高等数学', 3, '2023-06-27 12:44:00', 2, 2002);
INSERT INTO `apply1` VALUES (31, 5007, '概率论与数理统计', 4004, '概率论与数理统计', 1, '2023-09-20 00:55:00', 1, 2003);

-- ----------------------------
-- Table structure for apply2
-- ----------------------------
DROP TABLE IF EXISTS `apply2`;
CREATE TABLE `apply2`  (
  `id` int(11) NOT NULL COMMENT '编码',
  `bookId` int(11) NULL DEFAULT NULL COMMENT '教材编码',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `courseId` int(11) NULL DEFAULT NULL COMMENT '课程编码',
  `courseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  `type` int(255) NULL DEFAULT NULL COMMENT '审核状态（正在审核、申请通过、申请驳回）',
  `stuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ap011`(`bookId`) USING BTREE,
  INDEX `ap013`(`courseId`) USING BTREE,
  CONSTRAINT `ap011` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap013` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply2
-- ----------------------------
INSERT INTO `apply2` VALUES (101, 5002, '企业资源管理', 4003, '企业资源管理', 2, '2023-06-23 23:55:00', 1, 3001);
INSERT INTO `apply2` VALUES (121, 5004, '高等数学', 4002, '高等数学', 3, '2023-06-23 23:59:00', 2, 3002);
INSERT INTO `apply2` VALUES (131, 5004, '高等数学', 4002, '高等数学', 5, '2023-06-27 13:12:00', 1, 3003);

-- ----------------------------
-- Table structure for audit1
-- ----------------------------
DROP TABLE IF EXISTS `audit1`;
CREATE TABLE `audit1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL COMMENT '教材编码',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `courseId` int(11) NULL DEFAULT NULL COMMENT '课程编码',
  `courseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `teaId` int(11) NULL DEFAULT NULL COMMENT '教师工号',
  `teaName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `number` int(255) NULL DEFAULT NULL COMMENT '教材数量',
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '教材单价',
  `sum` float(10, 2) NULL DEFAULT NULL COMMENT '教材总价',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `type` int(255) NULL DEFAULT NULL COMMENT '审核状态（通过、驳回、待审核）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audit1
-- ----------------------------
INSERT INTO `audit1` VALUES (1, 5002, '离散数学', 4001, '离散数学', 2001, '李四', 2, 32.00, 64.00, '2023-06-05 11:05:29', 1);
INSERT INTO `audit1` VALUES (2, 5004, '高等数学', 4002, '高等数学', 2001, '李四', 2, 51.00, 102.00, '2023-06-23 23:46:00', 1);
INSERT INTO `audit1` VALUES (3, 5007, '概率论与数理统计', 4004, '概率论与数理统计', 2001, '李四', 2, 34.00, 68.00, '2023-06-27 12:40:00', 1);
INSERT INTO `audit1` VALUES (21, 5004, '高等数学', 4002, '高等数学', 2002, '余词', 4, 51.00, 204.00, '2023-06-23 23:47:00', 1);
INSERT INTO `audit1` VALUES (22, 5005, '高等数学第二版', 4002, '高等数学', 2002, '余词', 3, 41.00, 123.00, '2023-06-27 12:44:00', 2);
INSERT INTO `audit1` VALUES (31, 5007, '概率论与数理统计', 4004, '概率论与数理统计', 2003, '顾滴', 1, 34.00, 34.00, '2023-09-20 00:55:00', 1);

-- ----------------------------
-- Table structure for audit2
-- ----------------------------
DROP TABLE IF EXISTS `audit2`;
CREATE TABLE `audit2`  (
  `id` int(11) NOT NULL,
  `bookId` int(11) NULL DEFAULT NULL COMMENT '教材编码',
  `bookName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `courseId` int(11) NULL DEFAULT NULL COMMENT '课程编号',
  `courseName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `grade` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `stuId` int(11) NULL DEFAULT NULL COMMENT '负责人学号',
  `stuName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `number` int(11) NULL DEFAULT NULL COMMENT '教材数量',
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '教材单价',
  `sum` float(50, 2) NULL DEFAULT NULL COMMENT '教材总价',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `type` int(50) NULL DEFAULT NULL COMMENT '审核状态（通过、驳回、待审核）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audit2
-- ----------------------------
INSERT INTO `audit2` VALUES (101, 5002, '企业资源管理', 4003, '企业资源管理', '工程管理20-01班', 3001, '张三', 2, 32.00, 64.00, '2023-06-23 23:55:00', 1);
INSERT INTO `audit2` VALUES (121, 5004, '高等数学', 4002, '高等数学', '土木工程20-01班', 3002, '李思', 3, 51.00, 153.00, '2023-06-23 23:59:00', 2);
INSERT INTO `audit2` VALUES (131, 5004, '高等数学', 4002, '高等数学', '建筑系21-01班', 3003, '王物', 5, 51.00, 255.00, '2023-06-27 13:12:00', 1);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookId` int(11) NOT NULL COMMENT '教材编号',
  `bookName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `datail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`bookId`) USING BTREE,
  INDEX `bookName`(`bookName`) USING BTREE,
  INDEX `price`(`price`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (5001, '数据库系统概论', '王珊', '高等教育出版社', 29.00, '');
INSERT INTO `book` VALUES (5002, '离散数学', '左玲', '高等教育出版社', 32.00, '');
INSERT INTO `book` VALUES (5003, '企业资源管理', '任兰', '高等教育出版社', 34.00, '');
INSERT INTO `book` VALUES (5004, '高等数学', '宁荣健', '高等教育出版社', 51.00, NULL);
INSERT INTO `book` VALUES (5005, '高等数学第二版', '同济大学系', '高等教育出版社', 41.00, NULL);
INSERT INTO `book` VALUES (5006, '大学英语', '赫西', '高等教育出版社', 31.00, NULL);
INSERT INTO `book` VALUES (5007, '概率论与数理统计', '王秀男', '高等教育出版社', 35.00, '无');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseId` int(11) NOT NULL COMMENT '课程编号',
  `courseName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `faculty` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课院系',
  `major` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课专业',
  PRIMARY KEY (`courseId`) USING BTREE,
  INDEX `1`(`faculty`) USING BTREE,
  INDEX `2`(`major`) USING BTREE,
  INDEX `courseName`(`courseName`) USING BTREE,
  CONSTRAINT `1` FOREIGN KEY (`faculty`) REFERENCES `grade` (`faculty`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `2` FOREIGN KEY (`major`) REFERENCES `grade` (`major`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (4001, '离散数学', '管理学院', '信息管理与信息系统');
INSERT INTO `course` VALUES (4002, '高等数学', '管理学院', '工程管理');
INSERT INTO `course` VALUES (4003, '企业资源管理', '管理学院', '信息管理与信息系统');
INSERT INTO `course` VALUES (4004, '概率论与数理统计', '管理学院', '会计系');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(20) NOT NULL,
  `campus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校区',
  `faculty` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系\r\n',
  `major` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `grade` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `sum` int(50) NULL DEFAULT NULL COMMENT '学生人数',
  `stuId` int(50) NULL DEFAULT NULL COMMENT '负责人学号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `faculty`(`faculty`) USING BTREE,
  INDEX `major`(`major`) USING BTREE,
  INDEX `grade`(`grade`) USING BTREE,
  INDEX `201`(`stuId`) USING BTREE,
  CONSTRAINT `201` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (7001, '南区', '管理学院', '工程管理', '工程管理20-01班', 30, 3001);
INSERT INTO `grade` VALUES (7002, '北区', '土木学院', '土木工程', '土木工程20-01班', 40, 3002);
INSERT INTO `grade` VALUES (7003, '南区', '建筑学院', '建筑系', '建筑系21-01班', 35, 3003);
INSERT INTO `grade` VALUES (7004, '南区', '管理学院', '会计系', '会计系22-02班', 32, NULL);
INSERT INTO `grade` VALUES (7005, '南区', '管理学院', '信息管理与信息系统', '信息管理与信息系统20-01班', 40, 3004);

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `bookId` int(11) NOT NULL COMMENT '教材编号',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `number` int(255) NULL DEFAULT NULL COMMENT '教材数量',
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '教材单价',
  `sum` float(255, 0) NULL DEFAULT NULL COMMENT '教材总价',
  PRIMARY KEY (`bookId`) USING BTREE,
  INDEX `in3`(`price`) USING BTREE,
  INDEX `in2`(`bookName`) USING BTREE,
  CONSTRAINT `in1` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES (5001, '数据库系统概论', 11, 29.00, 319);
INSERT INTO `inventory` VALUES (5002, '离散数学', 3, 32.00, 160);
INSERT INTO `inventory` VALUES (5003, '企业资源管理', 0, 34.00, 0);
INSERT INTO `inventory` VALUES (5004, '高等数学', 2, 51.00, 102);
INSERT INTO `inventory` VALUES (5005, '高等数学第二版', 0, 41.00, 0);
INSERT INTO `inventory` VALUES (5006, '大学英语', 0, 31.00, 0);
INSERT INTO `inventory` VALUES (5007, '概率论与数理统计', 0, 35.00, 0);

-- ----------------------------
-- Table structure for officer
-- ----------------------------
DROP TABLE IF EXISTS `officer`;
CREATE TABLE `officer`  (
  `offId` int(20) NOT NULL COMMENT '工号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `offName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `offSex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `offPost` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `offPhone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`offId`) USING BTREE,
  INDEX `o1`(`username`) USING BTREE,
  CONSTRAINT `o1` FOREIGN KEY (`username`) REFERENCES `admin` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of officer
-- ----------------------------
INSERT INTO `officer` VALUES (1001, 'jwc01', '123456', '刘钱', '女', '一级职员', '11231241212');
INSERT INTO `officer` VALUES (1002, 'jwc02', '1234567', '杨兰', '男', '一级职员', '85333819376');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `bookId` int(11) NULL DEFAULT NULL COMMENT '教材编号',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `type` int(255) NULL DEFAULT NULL COMMENT '类型（学生征订、教师征订）',
  `reId` int(11) NULL DEFAULT NULL COMMENT '负责人id',
  `store` int(11) NULL DEFAULT NULL COMMENT '库存状态',
  `number` int(11) NULL DEFAULT NULL COMMENT '订单数量',
  `state` int(255) NULL DEFAULT NULL COMMENT '订单状态（待发出、已发出、已完成）',
  `startDate` datetime(0) NULL DEFAULT NULL COMMENT '发出时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 5002, '离散数学', 0, 2001, 5, 2, 2, '2023-06-13 16:42:17');
INSERT INTO `order` VALUES (21, 5004, '高等数学', 0, 2002, 2, 4, 0, NULL);
INSERT INTO `order` VALUES (2, 5004, '高等数学', 0, 2001, 2, 2, 2, '2023-09-23 17:15:28');
INSERT INTO `order` VALUES (101, 5003, '企业资源管理', 1, 3001, 0, 2, 2, '2023-06-24 16:16:00');
INSERT INTO `order` VALUES (131, 5004, '高等数学', 1, 3003, 2, 5, 1, '2023-09-19 17:24:59');
INSERT INTO `order` VALUES (3, 5007, '概率论与数理统计', 0, 2001, 0, 2, 0, NULL);
INSERT INTO `order` VALUES (31, 5007, '概率论与数理统计', 0, 2003, 0, 1, 0, NULL);

-- ----------------------------
-- Table structure for prepare
-- ----------------------------
DROP TABLE IF EXISTS `prepare`;
CREATE TABLE `prepare`  (
  `bookId` int(11) NOT NULL COMMENT '教材编码',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `storage` int(255) NULL DEFAULT NULL COMMENT '库存数量',
  `needNum` int(11) NULL DEFAULT NULL COMMENT '征订需求',
  `suggestNum` int(11) NULL DEFAULT NULL COMMENT '购货建议',
  PRIMARY KEY (`bookId`) USING BTREE,
  INDEX `p2`(`bookName`) USING BTREE,
  CONSTRAINT `p1` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `p2` FOREIGN KEY (`bookName`) REFERENCES `book` (`bookName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prepare
-- ----------------------------
INSERT INTO `prepare` VALUES (5001, '数据库系统概论', 11, 0, 0);
INSERT INTO `prepare` VALUES (5002, '离散数学', 3, 0, 2);
INSERT INTO `prepare` VALUES (5003, '企业资源管理', 0, 0, 5);
INSERT INTO `prepare` VALUES (5004, '高等数学', 2, 4, 7);
INSERT INTO `prepare` VALUES (5005, '高等数学第二版', 0, 0, 5);
INSERT INTO `prepare` VALUES (5006, '大学英语', 0, 0, 5);
INSERT INTO `prepare` VALUES (5007, '概率论与数理统计', 0, 3, 8);

-- ----------------------------
-- Table structure for receive1
-- ----------------------------
DROP TABLE IF EXISTS `receive1`;
CREATE TABLE `receive1`  (
  `id` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `bookId` int(11) NULL DEFAULT NULL COMMENT '教材编号',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `courseId` int(11) NULL DEFAULT NULL COMMENT '课程编号',
  `courseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `sum` int(255) NULL DEFAULT NULL COMMENT '教材数量',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '审核通过时间',
  `type` int(255) NOT NULL COMMENT '状态（备货中、已发货、已收货）',
  `teaId` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of receive1
-- ----------------------------
INSERT INTO `receive1` VALUES (1, 5002, '离散数学', 4001, '离散数学', 2, '2023-06-13 14:04:32', 2, 2001);
INSERT INTO `receive1` VALUES (21, 5004, '高等数学', 4002, '高等数学', 4, '2023-06-24 15:52:31', 0, 2002);
INSERT INTO `receive1` VALUES (2, 5004, '高等数学', 4002, '高等数学', 2, '2023-06-24 15:53:37', 2, 2001);
INSERT INTO `receive1` VALUES (3, 5007, '概率论与数理统计', 4004, '概率论与数理统计', 2, '2023-06-27 17:39:52', 0, 2001);
INSERT INTO `receive1` VALUES (31, 5007, '概率论与数理统计', 4004, '概率论与数理统计', 1, '2023-09-19 17:17:02', 0, 2003);

-- ----------------------------
-- Table structure for receive2
-- ----------------------------
DROP TABLE IF EXISTS `receive2`;
CREATE TABLE `receive2`  (
  `id` int(11) NOT NULL COMMENT '订单编号',
  `bookId` int(11) NULL DEFAULT NULL COMMENT '教材编号',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `courseId` int(11) NULL DEFAULT NULL COMMENT '课程编号',
  `courseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `sum` int(255) NULL DEFAULT NULL COMMENT '教材数量',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '审核通过时间',
  `type` int(255) NOT NULL COMMENT '状态（备货中、已发货、已收货）',
  `stuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of receive2
-- ----------------------------
INSERT INTO `receive2` VALUES (101, 5002, '企业资源管理', 4003, '企业资源管理', 2, '2023-06-24 16:00:49', 2, 3001);
INSERT INTO `receive2` VALUES (131, 5004, '高等数学', 4002, '高等数学', 5, '2023-06-27 13:15:27', 1, 3003);

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage`  (
  `id` int(11) NULL DEFAULT NULL COMMENT '入库编号',
  `bookId` int(11) NULL DEFAULT NULL COMMENT '教材编号',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教材名称',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `sum` float(255, 0) NULL DEFAULT NULL COMMENT '总价',
  `vendorId` int(11) NULL DEFAULT NULL COMMENT '供应商编号',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '入库时间',
  INDEX `st01`(`bookId`) USING BTREE,
  INDEX `st04`(`vendorId`) USING BTREE,
  CONSTRAINT `st01` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `st04` FOREIGN KEY (`vendorId`) REFERENCES `vendor` (`vendorId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storage
-- ----------------------------
INSERT INTO `storage` VALUES (1, 5001, '数据库系统概论', 1, 29.00, 29, 6001, '2023-06-05 12:26:06');
INSERT INTO `storage` VALUES (2, 5002, '离散数学', 5, 32.00, 128, 6001, '2023-06-13 16:03:00');
INSERT INTO `storage` VALUES (3, 5003, '企业资源管理', 2, 34.00, 68, 6001, '2023-06-24 16:06:00');
INSERT INTO `storage` VALUES (4, 5004, '高等数学', 9, 51.00, 459, 6001, '2023-06-27 13:17:00');
INSERT INTO `storage` VALUES (5, 5001, '数据库系统概论', 10, 29.00, 290, 6002, '2023-09-24 01:23:00');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stuId` int(20) NOT NULL COMMENT '学号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `stuSex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `stuFaculty` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `stuMajor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `stuClass` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `stuPhone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`stuId`) USING BTREE,
  INDEX `s2`(`password`) USING BTREE,
  INDEX `101`(`stuFaculty`) USING BTREE,
  INDEX `102`(`stuMajor`) USING BTREE,
  INDEX `103`(`stuClass`) USING BTREE,
  INDEX `104`(`username`) USING BTREE,
  CONSTRAINT `101` FOREIGN KEY (`stuFaculty`) REFERENCES `grade` (`faculty`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `102` FOREIGN KEY (`stuMajor`) REFERENCES `grade` (`major`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `103` FOREIGN KEY (`stuClass`) REFERENCES `grade` (`grade`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `104` FOREIGN KEY (`username`) REFERENCES `admin` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3001, 'xs01', '123456', '张三', '女', '管理学院', '工程管理', '工程管理20-01班', '12345676432');
INSERT INTO `student` VALUES (3002, 'xs02', '123456', '李思', '女', '土木学院', '土木工程', '土木工程20-01班', '12345678912');
INSERT INTO `student` VALUES (3003, 'xs03', '123456', '王物', '男', '建筑学院', '建筑系', '建筑系21-01班', '12345678945');
INSERT INTO `student` VALUES (3004, 'xs04', '123456', '刘秀', '女', '管理学院', '信息管理与信息系统', '信息管理与信息系统20-01班', '12345678976');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teaId` int(11) NOT NULL COMMENT '工号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teaName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `teaSex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `teaFaculty` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `teaPhone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`teaId`) USING BTREE,
  INDEX `t2`(`password`) USING BTREE,
  INDEX `t02`(`teaFaculty`) USING BTREE,
  INDEX `t01`(`username`) USING BTREE,
  CONSTRAINT `t01` FOREIGN KEY (`username`) REFERENCES `admin` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t02` FOREIGN KEY (`teaFaculty`) REFERENCES `grade` (`faculty`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (2001, 'js01', '1234', '李四', '男', '土木学院', '12345678945');
INSERT INTO `teacher` VALUES (2002, 'js02', '123456', '余词', '女', '管理学院', '12468890522');
INSERT INTO `teacher` VALUES (2003, 'js03', '123456', '顾滴', '女', '管理学院', '12453231124');

-- ----------------------------
-- Table structure for vendor
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor`  (
  `vendorId` int(50) NOT NULL COMMENT '供应商名称',
  `vendorName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商编号',
  `contact` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人名称',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`vendorId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendor
-- ----------------------------
INSERT INTO `vendor` VALUES (6001, '合肥az', '王丽', '12345678942');
INSERT INTO `vendor` VALUES (6002, '广州qw', '奇遇', '11319823198');

-- ----------------------------
-- Triggers structure for table apply1
-- ----------------------------
DROP TRIGGER IF EXISTS `a11`;
delimiter ;;
CREATE TRIGGER `a11` AFTER INSERT ON `apply1` FOR EACH ROW INSERT INTO audit1 (id,bookId,bookName,courseId,courseName,teaId,teaName,number,price,sum,date,type)
SELECT new.id,new.bookId,new.bookName,new.courseId,new.courseName,
       new.teaId,teacher.teaName,
			 new.number,book.price, new.number*book.price,
			 new.date,new.type
FROM teacher,book
where  new.teaId=teacher.teaId and  new.bookId=book.bookId
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table apply1
-- ----------------------------
DROP TRIGGER IF EXISTS `a14`;
delimiter ;;
CREATE TRIGGER `a14` AFTER UPDATE ON `apply1` FOR EACH ROW IF NEW.type = 1 THEN
        INSERT INTO  `order`(id,bookId, bookName, type, reId,store,number,state)
				select new.id,NEW.bookId, NEW.bookName, 0 ,NEW.teaId,inventory.number,new.number,0
				from inventory
				where inventory.bookId=NEW.bookId;
				
				update `prepare`
				set needNum=needNum+new.number
				where new.bookId=bookId;
			
        insert into  receive1(id,bookId,bookName,courseId,courseName,sum,date,type,teaId)
        values( new.id,new.bookId,new.bookName,new.courseId,new.courseName,new.number,now(),0,new.teaId);
END IF
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table apply1
-- ----------------------------
DROP TRIGGER IF EXISTS `a12`;
delimiter ;;
CREATE TRIGGER `a12` AFTER UPDATE ON `apply1` FOR EACH ROW UPDATE audit1 SET 
        bookId = NEW.bookId,
        bookName = NEW.bookName,
        courseId = NEW.courseId,
        courseName = NEW.courseName,
        teaId = NEW.teaId,
        teaName = (SELECT teaName FROM teacher WHERE teaId = NEW.teaId),
        number = NEW.number,
        price = (SELECT price FROM book WHERE bookId = NEW.bookId),
        sum = NEW.number * (SELECT price FROM book WHERE bookId = NEW.bookId),
        date = NEW.date,
				type=NEW.type
    WHERE id = NEW.id
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table apply1
-- ----------------------------
DROP TRIGGER IF EXISTS `a13`;
delimiter ;;
CREATE TRIGGER `a13` AFTER DELETE ON `apply1` FOR EACH ROW DELETE FROM audit1 WHERE id = OLD.id
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table apply2
-- ----------------------------
DROP TRIGGER IF EXISTS `a21`;
delimiter ;;
CREATE TRIGGER `a21` AFTER INSERT ON `apply2` FOR EACH ROW INSERT INTO audit2 (id,bookId,bookName,courseId,courseName,grade,stuId,stuName,number,price,sum,date,type)
SELECT new.id,new.bookId,new.bookName,new.courseId,new.courseName,
       student.stuClass,new.stuId,student.stuName,
			 new.number,book.price, new.number*book.price,
			 new.date, new.type
FROM   student,book
where  new.stuId=student.stuId and  new.bookId=book.bookId
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table apply2
-- ----------------------------
DROP TRIGGER IF EXISTS `a22`;
delimiter ;;
CREATE TRIGGER `a22` AFTER UPDATE ON `apply2` FOR EACH ROW UPDATE audit2 SET 
        bookId = NEW.bookId,
        bookName = NEW.bookName,
        courseId = NEW.courseId,
        courseName = NEW.courseName,
				grade = (SELECT grade FROM student WHERE stuId = NEW.stuId),
        stuId = NEW.stuId,
        stuName = (SELECT stuName FROM student WHERE stuId = NEW.stuId),
        number = NEW.number,
        price = (SELECT price FROM book WHERE bookId = NEW.bookId),
        sum = NEW.number * (SELECT price FROM book WHERE bookId = NEW.bookId),
        date = NEW.date,
        type = NEW.type
    WHERE id = NEW.id
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table apply2
-- ----------------------------
DROP TRIGGER IF EXISTS `a24`;
delimiter ;;
CREATE TRIGGER `a24` AFTER UPDATE ON `apply2` FOR EACH ROW IF NEW.type = 1 THEN
       INSERT INTO  `order`(id,bookId, bookName, type, reId,store,number,state)
				select new.id,NEW.bookId, NEW.bookName, 1 ,NEW.stuId,inventory.number,new.number,0
				from inventory
				where inventory.bookId=NEW.bookId;
			
			  update `prepare`
				set needNum=needNum+new.number
				where new.bookId=bookId;
				
        insert into  receive2(id,bookId,bookName,courseId,courseName,sum,date,type,stuId)
        values( new.id,new.bookId,new.bookName,new.courseId,new.courseName,new.number,now(),0,new.stuId);
END IF
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table apply2
-- ----------------------------
DROP TRIGGER IF EXISTS `a23`;
delimiter ;;
CREATE TRIGGER `a23` AFTER DELETE ON `apply2` FOR EACH ROW DELETE FROM audit2 WHERE id = OLD.id
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table book
-- ----------------------------
DROP TRIGGER IF EXISTS `book1`;
delimiter ;;
CREATE TRIGGER `book1` AFTER INSERT ON `book` FOR EACH ROW begin
insert into inventory(bookId,bookName,number,price,sum)
values(new.bookId,new.bookName,0,new.price,0);
insert into `prepare`(bookId,bookName,`storage`,needNum,suggestNum)
values(new.bookId,new.bookName,0,0,0);
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table book
-- ----------------------------
DROP TRIGGER IF EXISTS `book2`;
delimiter ;;
CREATE TRIGGER `book2` AFTER UPDATE ON `book` FOR EACH ROW begin
update inventory
set bookName=new.bookName,
price=new.price
where bookId=new.bookId;

update `prepare`
set bookName=new.bookName
where bookId=new.bookId;

end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table inventory
-- ----------------------------
DROP TRIGGER IF EXISTS `inventory`;
delimiter ;;
CREATE TRIGGER `inventory` AFTER UPDATE ON `inventory` FOR EACH ROW begin
update `order`
set store=new.number
where bookId=new.bookId;

update `prepare`
set `storage`=new.number
where bookId=NEW.bookId;

end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table storage
-- ----------------------------
DROP TRIGGER IF EXISTS `st01`;
delimiter ;;
CREATE TRIGGER `st01` AFTER INSERT ON `storage` FOR EACH ROW begin
update inventory
set number=number+new.number
where bookId=new.bookId;
update inventory
set sum=number*price
where bookId=new.bookId;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table storage
-- ----------------------------
DROP TRIGGER IF EXISTS `st02`;
delimiter ;;
CREATE TRIGGER `st02` AFTER UPDATE ON `storage` FOR EACH ROW begin
update inventory
set number=number+new.number-old.number
where bookId=new.bookId;
update inventory
set sum=number*price
where bookId=new.bookId;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
