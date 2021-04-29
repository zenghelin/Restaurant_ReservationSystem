/*
 Navicat Premium Data Transfer

 Source Server         : lastest
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : restaurant_reservation_system

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 17/01/2021 12:08:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reservation_info
-- ----------------------------
DROP TABLE IF EXISTS `reservation_info`;
CREATE TABLE `reservation_info`  (
  `reservationID` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
  `telName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reachTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nums` int(11) NOT NULL DEFAULT 1,
  `otherNeed` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '待审核',
  PRIMARY KEY (`reservationID`) USING BTREE,
  INDEX `customer_reservation`(`customerID`) USING BTREE,
  CONSTRAINT `customer_reservation` FOREIGN KEY (`customerID`) REFERENCES `customer_user` (`customerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation_info
-- ----------------------------
INSERT INTO `reservation_info` VALUES (1, 1, '小明', '13281055395', '2020-02-1 17：41：00', 5, '就餐环境安静，包间光线明亮', '待审核');
INSERT INTO `reservation_info` VALUES (2, 1, '二明', '18282684835', '2020-02-5 18：48：00', 2, '靠窗通风', '预约成功');
INSERT INTO `reservation_info` VALUES (3, 2, '二明', '18282684835', '2020-02-5 18：48：00', 2, '靠窗通风', '预约失败');
INSERT INTO `reservation_info` VALUES (4, 2, '三明', '13284156235', '2021-01-01 11：59', 5, '希望温度较高', '待审核');

SET FOREIGN_KEY_CHECKS = 1;
