-- 服务类型
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('1', 1, '血压数据检测', 'bloodPressure');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('2', 1, '血糖数据检测', 'bloodSugar');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('3', 1, '健康咨询', 'healthAdvisory');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('4', 1, '健康管理图文报告', 'stageReport');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('5', 1, '专业医生电话回访', 'doctorPhoneVisit');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('6', 1, '慢病管理师定期电话回访', 'customerCarePhoneVisit');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('7', 1, '医师互动', 'doctorAdvisory');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('8', 1, '风险评估', 'riskAssessment');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('9', 1, '生活方式及饮食管理方案', 'lifeStyle');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('10', 1, '身高数据检测', 'height');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('11', 1, '体重数据检测', 'weight');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('12', 1, '体质指数数据检测', 'bmi');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('13', 1, '脂肪率数据检测', 'fatPercentage');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('14', 1, '基础代谢数据检测', 'basalMetabolism');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('15', 1, '水分含量数据检测', 'waterContent');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('16', 1, '腰围数据检测', 'waist');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('17', 1, '臀围数据检测', 'hipline');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('18', 1, '腰臀比数据检测', 'whr');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('19', 1, '血脂数据检测', 'bloodLipid');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('20', 1, '尿酸数据检测', 'uric');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('21', 1, '心电图数据检测', 'ecg');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('22', 1, '血氧数据检测', 'bloodOxygen');
INSERT INTO `service_type` (`id`, `is_active`, `name`, `remark`) VALUES ('23', 1, '中医体质数据检测', 'tcm');

-- 服务包
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('1', null, 1, '免费服务包', 'FREE', null, null);
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('2', '100', 1, '安心服务包', 'AX1', null, '3');
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('3', '200', 1, '安心服务包', 'AX2', null, '6');
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('4', '300', 1, '安心服务包', 'AX3', null, '12');
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('5', '150', 1, '糖心服务包', 'TX1', null, '3');
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('6', '300', 1, '糖心服务包', 'TX2', null, '6');
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('7', '450', 1, '糖心服务包', 'TX3', null, '12');
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('8', '5', 1, '血糖检测', 'CUSTOMIZE', '次', null);
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('9', '2', 1, '血糖试纸', 'CUSTOMIZE', '盒', null);
INSERT INTO `service_package` (`id`, `beans`, `is_active`, `name`, `package_type`, `unit`, `validity`) VALUES ('10', '200', 1, '血糖仪', 'CUSTOMIZE', '台', null);

-- 服务包具体内容
-- 服务包具体内容
-- 免费服务包
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('1', '-1', '0', '1', '1');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('2', '1', '2', '1', '2');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('3', '4', '1', '1', '3');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('4', '1', '0', '1', '10');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('5', '1', '0', '1', '11');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('6', '1', '0', '1', '12');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('7', '1', '0', '1', '13');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('8', '1', '0', '1', '14');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('9', '1', '0', '1', '15');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('10', '1', '0', '1', '16');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('11', '1', '0', '1', '17');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('12', '1', '0', '1', '18');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('13', '1', '2', '1', '19');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('14', '1', '2', '1', '20');

-- 安心三个月
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('15', '-1', '0', '2', '1');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('16', '10', '1', '2', '3');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('17', '1', '2', '2', '4');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('18', '1', '2', '2', '5');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('19', '1', '1', '2', '6');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('20', '4', '1', '2', '7');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('21', '1', '0', '2', '8');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('22', '1', '0', '2', '9');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('23', '1', '2', '2', '10');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('24', '1', '2', '2', '11');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('25', '1', '2', '2', '12');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('26', '1', '2', '2', '13');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('27', '1', '2', '2', '14');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('28', '1', '2', '2', '15');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('29', '1', '2', '2', '16');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('30', '1', '2', '2', '17');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('31', '1', '2', '2', '18');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('32', '1', '2', '2', '19');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('33', '1', '2', '2', '20');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('34', '1', '2', '2', '21');

-- 安心半年
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('35', '-1', '0', '3', '1');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('36', '10', '1', '3', '3');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('37', '1', '2', '3', '4');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('38', '1', '2', '3', '5');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('39', '1', '1', '3', '6');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('40', '4', '1', '3', '7');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('41', '1', '0', '3', '8');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('42', '1', '0', '3', '9');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('43', '1', '2', '3', '10');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('44', '1', '2', '3', '11');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('45', '1', '2', '3', '12');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('46', '1', '2', '3', '13');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('47', '1', '2', '3', '14');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('48', '1', '2', '3', '15');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('49', '1', '2', '3', '16');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('50', '1', '2', '3', '17');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('51', '1', '2', '3', '18');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('52', '1', '2', '3', '19');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('53', '1', '2', '3', '20');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('54', '1', '2', '3', '21');

-- 安心一年
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('55', '-1', '0', '4', '1');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('56', '10', '1', '4', '3');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('57', '1', '2', '4', '4');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('58', '1', '2', '4', '5');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('59', '1', '1', '4', '6');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('60', '4', '1', '4', '7');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('61', '1', '0', '4', '8');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('62', '1', '0', '4', '9');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('63', '1', '2', '4', '10');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('64', '1', '2', '4', '11');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('65', '1', '2', '4', '12');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('66', '1', '2', '4', '13');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('67', '1', '2', '4', '14');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('68', '1', '2', '4', '15');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('69', '1', '2', '4', '16');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('70', '1', '2', '4', '17');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('71', '1', '2', '4', '18');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('72', '1', '2', '4', '19');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('73', '1', '2', '4', '20');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('74', '1', '2', '4', '21');

-- 糖心三个月
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('75', '-1', '0', '5', '1');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('76', '8', '1', '5', '2');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('77', '10', '1', '5', '3');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('78', '1', '2', '5', '4');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('79', '1', '2', '5', '5');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('80', '1', '1', '5', '6');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('81', '4', '1', '5', '7');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('82', '1', '0', '5', '8');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('83', '1', '0', '5', '9');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('84', '1', '2', '5', '10');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('85', '1', '2', '5', '11');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('86', '1', '2', '5', '12');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('87', '1', '2', '5', '13');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('88', '1', '2', '5', '14');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('89', '1', '2', '5', '15');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('90', '1', '2', '5', '16');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('91', '1', '2', '5', '17');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('92', '1', '2', '5', '18');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('93', '1', '2', '5', '19');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('94', '1', '2', '5', '20');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('95', '1', '2', '5', '21');

-- 糖心半年
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('96', '-1', '0', '6', '1');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('97', '8', '1', '6', '2');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('98', '10', '1', '6', '3');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('99', '1', '2', '6', '4');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('100', '1', '2', '6', '5');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('101', '1', '1', '6', '6');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('102', '4', '1', '6', '7');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('103', '1', '0', '6', '8');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('104', '1', '0', '6', '9');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('105', '1', '2', '6', '10');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('106', '1', '2', '6', '11');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('107', '1', '2', '6', '12');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('108', '1', '2', '6', '13');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('109', '1', '2', '6', '14');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('110', '1', '2', '6', '15');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('111', '1', '2', '6', '16');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('112', '1', '2', '6', '17');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('113', '1', '2', '6', '18');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('114', '1', '2', '6', '19');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('115', '1', '2', '6', '20');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('116', '1', '2', '6', '21');

-- 糖心一年
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('117', '-1', '0', '7', '1');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('118', '8', '1', '7', '2');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('119', '10', '1', '7', '3');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('120', '1', '2', '7', '4');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('121', '1', '2', '7', '5');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('122', '1', '1', '7', '6');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('123', '4', '1', '7', '7');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('124', '1', '0', '7', '8');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('125', '1', '0', '7', '9');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('126', '1', '2', '7', '10');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('127', '1', '2', '7', '11');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('128', '1', '2', '7', '12');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('129', '1', '2', '7', '13');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('130', '1', '2', '7', '14');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('131', '1', '2', '7', '15');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('132', '1', '2', '7', '16');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('133', '1', '2', '7', '17');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('134', '1', '2', '7', '18');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('135', '1', '2', '7', '19');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('136', '1', '2', '7', '20');
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('137', '1', '2', '7', '21');

-- 定制服务血糖
INSERT INTO `service_package_detail` (`id`, `count`, `cycle`, `service_package_id`, `service_type_id`) VALUES ('138', '8', null, '8', '2');


-- 异常事件
INSERT INTO abnormal_event(event_type,name,description) VALUES(2,"急性心肌梗死","");

INSERT INTO abnormal_event(event_type,name,description) VALUES(2,"冠心病死亡","");

INSERT INTO abnormal_event(event_type,name,description) VALUES(2,"蛛网膜下腔出血","");

INSERT INTO abnormal_event(event_type,name,description) VALUES(2,"腔隙性脑梗塞","");

INSERT INTO abnormal_event(event_type,name,description) VALUES(2,"脑栓塞","");

INSERT INTO abnormal_event(event_type,name,description) VALUES(2,"心脏性猝死","");

INSERT INTO abnormal_event(event_type,name,description) VALUES(2,"其他血管事件","");



-- 默认报警阈值

-- 默认
INSERT INTO daily_health_check_info_default_warn (
	bloodFatChol,  -- 血胎: 总胆固醇 
	bloodFatHdl,   -- 血胎: 高密度脂蛋白胆固醇
	bloodFatLdl,   -- 血胎: 低密度脂蛋白胆固醇
	bloodFatTg,    -- 血胎: 甘油三酯
	diastolicPressureHigh, -- 血压: 舒张压 最高值
	diastolicPressureLow,  -- 血压: 舒张压 最低值
	fastBloodSugarHigh,   -- 空腹血糖: 最高值
	fastBloodSugarLow,   -- 空腹血糖: 最低值
	heartRateHigh, -- 静息心率: 最高值
	heartRateLow,  -- 静息心率: 最低值
	postPrandilaSugarHigh, -- 餐后血糖: 最高值
	postPrandilaSugarLow, -- 餐后血糖: 最低值
	pulseRateHigh, -- 脉搏: 最高值
	pulseRateLow, -- 脉搏: 最低值
	spo,  -- 血氧饱和度最低值
	systolicPressureHigh,    -- 血压: 收缩压 最高值
	systolicPressureLow, -- 血压: 收缩压 最低值
	urineAcid,   -- 尿酸
	randomSugarLow, -- 随机血糖: 最低值
	randomSugarHigh, -- 随机血糖: 最高值
	type -- 默认报警阈值类型
)
VALUES
	(
		5.72,
		0.91,
		3.64,
		1.7,
		90,
		50,
		5.6,
		3.9,
		90,
		50,
		8,
		3.9,
		90,
		50,
		90,
		150,
		100,
		360,
		3.9,
		8,
		1
 	);


-- 高血压

-- 年龄<65 

INSERT INTO daily_health_check_info_default_warn (
	bloodFatChol,  -- 血胎: 总胆固醇 
	bloodFatHdl,   -- 血胎: 高密度脂蛋白胆固醇
	bloodFatLdl,   -- 血胎: 低密度脂蛋白胆固醇
	bloodFatTg,    -- 血胎: 甘油三酯
	diastolicPressureHigh, -- 血压: 舒张压 最高值
	diastolicPressureLow,  -- 血压: 舒张压 最低值
	fastBloodSugarHigh,   -- 空腹血糖: 最高值
	fastBloodSugarLow,   -- 空腹血糖: 最低值
	heartRateHigh, -- 静息心率: 最高值
	heartRateLow,  -- 静息心率: 最低值
	postPrandilaSugarHigh, -- 餐后血糖: 最高值
	postPrandilaSugarLow, -- 餐后血糖: 最低值
	pulseRateHigh, -- 脉搏: 最高值
	pulseRateLow, -- 脉搏: 最低值
	spo,  -- 血氧饱和度最低值
	systolicPressureHigh,    -- 血压: 收缩压 最高值
	systolicPressureLow, -- 血压: 收缩压 最低值
	urineAcid,   -- 尿酸
	randomSugarLow, -- 随机血糖: 最低值
	randomSugarHigh, -- 随机血糖: 最高值
	type -- 默认报警阈值类型
)
VALUES
	(
		5.72,
		0.91,
		3.64,
		1.7,
		90,
		60,
		5.6,
		3.9,
		90,
		50,
		8,
		3.9,
		90,
		50,
		90,
		140,
		100,
		360,
		3.9,
		8,
		2
 	);



--  年龄>=65 

INSERT INTO daily_health_check_info_default_warn (
	bloodFatChol,  -- 血胎: 总胆固醇 
	bloodFatHdl,   -- 血胎: 高密度脂蛋白胆固醇
	bloodFatLdl,   -- 血胎: 低密度脂蛋白胆固醇
	bloodFatTg,    -- 血胎: 甘油三酯
	diastolicPressureHigh, -- 血压: 舒张压 最高值
	diastolicPressureLow,  -- 血压: 舒张压 最低值
	fastBloodSugarHigh,   -- 空腹血糖: 最高值
	fastBloodSugarLow,   -- 空腹血糖: 最低值
	heartRateHigh, -- 静息心率: 最高值
	heartRateLow,  -- 静息心率: 最低值
	postPrandilaSugarHigh, -- 餐后血糖: 最高值
	postPrandilaSugarLow, -- 餐后血糖: 最低值
	pulseRateHigh, -- 脉搏: 最高值
	pulseRateLow, -- 脉搏: 最低值
	spo,  -- 血氧饱和度最低值
	systolicPressureHigh,    -- 血压: 收缩压 最高值
	systolicPressureLow, -- 血压: 收缩压 最低值
	urineAcid,   -- 尿酸
	randomSugarLow, -- 随机血糖: 最低值
	randomSugarHigh, -- 随机血糖: 最高值
	type -- 默认报警阈值类型
)
VALUES
	(
		5.72,
		0.91,
		3.64,
		1.7,
		90,
		60,
		5.6,
		3.9,
		90,
		50,
		8,
		3.9,
		90,
		50,
		90,
		150,
		100,
		360,
		3.9,
		8,
		3
 	);


--  糖尿病

--  年龄<70

INSERT INTO daily_health_check_info_default_warn (
	bloodFatChol,  -- 血胎: 总胆固醇 
	bloodFatHdl,   -- 血胎: 高密度脂蛋白胆固醇
	bloodFatLdl,   -- 血胎: 低密度脂蛋白胆固醇
	bloodFatTg,    -- 血胎: 甘油三酯
	diastolicPressureHigh, -- 血压: 舒张压 最高值
	diastolicPressureLow,  -- 血压: 舒张压 最低值
	fastBloodSugarHigh,   -- 空腹血糖: 最高值
	fastBloodSugarLow,   -- 空腹血糖: 最低值
	heartRateHigh, -- 静息心率: 最高值
	heartRateLow,  -- 静息心率: 最低值
	postPrandilaSugarHigh, -- 餐后血糖: 最高值
	postPrandilaSugarLow, -- 餐后血糖: 最低值
	pulseRateHigh, -- 脉搏: 最高值
	pulseRateLow, -- 脉搏: 最低值
	spo,  -- 血氧饱和度最低值
	systolicPressureHigh,    -- 血压: 收缩压 最高值
	systolicPressureLow, -- 血压: 收缩压 最低值
	urineAcid,   -- 尿酸
	randomSugarLow, -- 随机血糖: 最低值
	randomSugarHigh, -- 随机血糖: 最高值
	type -- 默认报警阈值类型
)
VALUES
	(
		5.72,  -- 血胎: 总胆固醇
		0.91,   -- 血胎: 高密度脂蛋白胆固醇
		3.64,   -- 血胎: 低密度脂蛋白胆固醇
		1.7,   -- 血胎: 甘油三酯
		90,
		50,
		7.8,
		4.4,
		90,
		50,
		7.8,
		4.4,
		90,
		50,
		90,
		150,
		100,
		360,
		4.4,
		7.8,
		4
 	);

-- 年龄>70

INSERT INTO daily_health_check_info_default_warn (
	bloodFatChol,  -- 血胎: 总胆固醇 
	bloodFatHdl,   -- 血胎: 高密度脂蛋白胆固醇
	bloodFatLdl,   -- 血胎: 低密度脂蛋白胆固醇
	bloodFatTg,    -- 血胎: 甘油三酯
	diastolicPressureHigh, -- 血压: 舒张压 最高值
	diastolicPressureLow,  -- 血压: 舒张压 最低值
	fastBloodSugarHigh,   -- 空腹血糖: 最高值
	fastBloodSugarLow,   -- 空腹血糖: 最低值
	heartRateHigh, -- 静息心率: 最高值
	heartRateLow,  -- 静息心率: 最低值
	postPrandilaSugarHigh, -- 餐后血糖: 最高值
	postPrandilaSugarLow, -- 餐后血糖: 最低值
	pulseRateHigh, -- 脉搏: 最高值
	pulseRateLow, -- 脉搏: 最低值
	spo,  -- 血氧饱和度最低值
	systolicPressureHigh,    -- 血压: 收缩压 最高值
	systolicPressureLow, -- 血压: 收缩压 最低值
	urineAcid,   -- 尿酸
	randomSugarLow, -- 随机血糖: 最低值
	randomSugarHigh, -- 随机血糖: 最高值
	type -- 默认报警阈值类型
)
VALUES
	(
		5.72,  -- 血胎: 总胆固醇
		0.91,   -- 血胎: 高密度脂蛋白胆固醇
		3.64,   -- 血胎: 低密度脂蛋白胆固醇
		1.7,   -- 血胎: 甘油三酯
		90,
		50,
		9,
		6,
		90,
		50,
		9,
		6,
		90,
		50,
		90,
		150,
		100,
		360,
		6,
		9,
		5
 	);


-- 高血压合并糖尿病血糖值

INSERT INTO daily_health_check_info_default_warn (
	bloodFatChol,  -- 血胎: 总胆固醇 
	bloodFatHdl,   -- 血胎: 高密度脂蛋白胆固醇
	bloodFatLdl,   -- 血胎: 低密度脂蛋白胆固醇
	bloodFatTg,    -- 血胎: 甘油三酯
	diastolicPressureHigh, -- 血压: 舒张压 最高值
	diastolicPressureLow,  -- 血压: 舒张压 最低值
	fastBloodSugarHigh,   -- 空腹血糖: 最高值
	fastBloodSugarLow,   -- 空腹血糖: 最低值
	heartRateHigh, -- 静息心率: 最高值
	heartRateLow,  -- 静息心率: 最低值
	postPrandilaSugarHigh, -- 餐后血糖: 最高值
	postPrandilaSugarLow, -- 餐后血糖: 最低值
	pulseRateHigh, -- 脉搏: 最高值
	pulseRateLow, -- 脉搏: 最低值
	spo,  -- 血氧饱和度最低值
	systolicPressureHigh,    -- 血压: 收缩压 最高值
	systolicPressureLow, -- 血压: 收缩压 最低值
	urineAcid,   -- 尿酸
	randomSugarLow, -- 随机血糖: 最低值
	randomSugarHigh, -- 随机血糖: 最高值
	type -- 默认报警阈值类型
)
VALUES
	(
		5.72,  -- 血胎: 总胆固醇
		0.91,   -- 血胎: 高密度脂蛋白胆固醇
		3.64,   -- 血胎: 低密度脂蛋白胆固醇
		1.7,   -- 血胎: 甘油三酯
		80,
		60,
		11.1,
		7,
		90,
		50,
		11.1,
		7,
		90,
		50,
		90,
		130,
		100,
		360,
		7,
		11.1,
		6
 	);



-- 药物信息

INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("依那普利","日",2,"mg","伊苏(依那普利)","5-10",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("依那普利","日",2,"mg","悦宁定(依那普利)","5-10",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("贝那普利","日",2,"mg","洛汀新（贝那普利）","5-10",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("福辛普利","日",2,"mg","蒙诺（福辛普利）","10",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("赖诺普利","日",2,"mg","捷赐瑞（赖诺普利）","10-20",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("卡托普利","日",2,"mg","开博通（卡托普利）","12.5-25",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("雷米普利","日",2,"mg","雷米普利（瑞泰)","2.5-10",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("培哚普利","日",2,"mg","培哚普利（雅施达）","4",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("氯沙坦","日",2,"mg","氯沙坦（科素亚）","50-200",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("厄贝沙坦","日",2,"mg","厄贝沙坦（安博维）","150",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("厄贝沙坦","日",2,"mg","厄贝沙坦（伊泰青胶囊）","75-150",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("缬沙坦","日",2,"mg","缬沙坦（代文胶囊）","80-160",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("缬沙坦","日",2,"mg","缬沙坦（穗悦胶囊）","80-160",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("替米沙坦","日",2,"mg","替米沙坦（美卡素片）","80",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("坎地沙坦","日",2,"mg","坎地沙坦（必洛斯）","4-8",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("坎地沙坦","日",2,"mg","坎地沙坦（维尔亚）","4",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("美托洛尔","日",2,"mg","美托洛尔（倍他乐克）","25-100",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("美托洛尔缓释片","日",2,"mg","美托洛尔缓释片（倍他乐克缓释片）","47.5-95",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("氯沙坦氢氯噻嗪","日",2,"mg","氯沙坦氢氯噻嗪（海捷亚）","62.5-125",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("厄贝沙坦氢氯噻嗪","日",2,"mg","厄贝沙坦氢氯噻嗪（安博诺）","162.5",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,name,single_dose,using_frequency) VALUES("培哚普利吲达帕胺片","日",2,"mg","培哚普利吲达帕胺片（百普乐）","5.25-10.5",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("格列齐特缓释片","日",1,"mg","达美康(格列齐特缓释片)","30-120",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("格列齐特片","日",1,"mg","达美康(格列齐特片)","80",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("格列吡嗪控释片","日",1,"mg","瑞易宁(格列吡嗪控释片)","5",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("格列吡嗪片","日",1,"mg","美吡哒(格列吡嗪片)","5",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("格列喹酮片","日",1,"mg","糖适平（格列喹酮片）","30",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("格列美脲片","日",1,"mg","亚莫利（格列美脲片）","30",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("格列美脲片","日",1,"mg","伊瑞（格列美脲片）","30-120",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("二甲双胍片","日",1,"g","格华止（二甲双胍片）","0.5",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("二甲双胍片","日",1,"g","美迪康（二甲双胍片）","0.5",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("二甲双胍缓释片","日",1,"mg","卜可（二甲双胍缓释片）","0.5",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("阿卡波糖片","日",1,"mg","拜糖平（阿卡波糖片）","50",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("阿卡波糖片","日",1,"mg","卡博平（阿卡波糖片）","50",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("伏格列波糖片","日",1,"mg","倍欣（伏格列波糖片）","0.2",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("瑞格列奈","日",1,"mg","诺和龙（瑞格列奈）","2",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("瑞格列奈","日",1,"mg","孚来迪（瑞格列奈）","2",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("那格列奈","日",1,"mg","唐力（那格列奈）","120",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("诺和灵R，优泌林R、甘舒霖R","日",1,"U","重组人胰岛素注射液（诺和灵R，优泌林R、甘舒霖R）","300",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("门冬胰岛素","日",1,"U","门冬胰岛素","30",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("赖脯胰岛素注射液","日",1,"U","亚莫利（格列美脲片）","300",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("门冬胰岛素30注射液","日",1,"U","亚莫利（格列美脲片）","300",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("赖脯胰岛素25注射液","日",1,"U","亚莫利（格列美脲片）","300",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("甘精胰岛素注射液（来得时、长秀霖）","日",1,"U","亚莫利（格列美脲片）","300",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("苯磺酸氨氯地平","日",2,"mg","苯磺酸氨氯地平（络活喜）","5",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("苯磺酸氨氯地平","日",2,"mg","苯磺酸氨氯地平（压氏达)","5",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("苯磺酸氨氯地平","日",2,"mg","苯磺酸氨氯地平（西络宁）","5",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("苯磺酸左旋氨氯地平","日",2,"mg","苯磺酸左旋氨氯地平（施慧达）","2.5",1);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("甲磺酸氨氯地平","日",2,"mg","甲磺酸氨氯地平（欣洛平）","5-10",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("拉西地平","日",2,"mg","拉西地平（乐息平）","4",3);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("非洛地平缓释片","日",2,"mg","非洛地平缓释片（波依定）","2.5-10",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("硝苯地平控释片","日",2,"mg","硝苯地平控释片（拜新同）","30-60",2);
INSERT INTO medicine(chemical_name,frequency_unit,medicine_type,medicine_unit,NAME,single_dose,using_frequency) VALUES("硝苯地平缓释片","日",2,"mg","硝苯地平缓释片（圣通平）","10-30",3);

-- 添加原有的资深专家到所属团队
INSERT INTO header_health_group (doctor_header_id,health_group_id, create_time,is_active) SELECT a.id, a.health_group_for_headers_id, a.create_date, a.is_active FROM doctor a WHERE a.health_group_for_headers_id IS NOT NULL;

-- 配置用户默认服务次数
INSERT INTO customer_service_detail (id, blood_pressure, blood_sugar, health_advisory) SELECT id, '-1', '1', '4' FROM customer;

-- 配置用户默认报警阈值
INSERT INTO daily_health_check_info_warn (
	id,
	systolicPressureLow,
	systolicPressureHigh,
	diastolicPressureLow,
	diastolicPressureHigh,
	fastBloodSugarLow,
	fastBloodSugarHigh,
	postPrandilaSugarLow,
	postPrandilaSugarHigh,
	heartRateLow,
	heartRateHigh,
	urineAcid,
	bloodFatChol,
	bloodFatTg,
	bloodFatLdl,
	bloodFatHdl,
	pulseRateLow,
	pulseRateHigh,
	spo,
	randomSugarLow,
	randomSugarHigh
) SELECT
	c.id,
	d.systolicPressureLow,
	d.systolicPressureHigh,
	d.diastolicPressureLow,
	d.diastolicPressureHigh,
	d.fastBloodSugarLow,
	d.fastBloodSugarHigh,
	d.postPrandilaSugarLow,
	d.postPrandilaSugarHigh,
	d.heartRateLow,
	d.heartRateHigh,
	d.urineAcid,
	d.bloodFatChol,
	d.bloodFatTg,
	d.bloodFatLdl,
	d.bloodFatHdl,
	d.pulseRateLow,
	d.pulseRateHigh,
	d.spo,
	d.randomSugarLow,
	d.randomSugarHigh
FROM
	customer AS c,
	daily_health_check_info_default_warn AS d
WHERE
	d.type = 1;

-- 配置手机端启动时候的欢迎图片
INSERT  INTO `mainpagepic`(`id`,`type`,`url`,`createTime`) VALUES (1,'iPhone4','http://121.42.142.228:8080/pics/business/images/welcome/iPhone4.png',NULL),(2,'iPhone5','http://121.42.142.228:8080/pics/business/images/welcome/iPhone5.png',NULL),(3,'iPhone6','http://121.42.142.228:8080/pics/business/images/welcome/iPhone6.png',NULL),(4,'iPhone6p','http://121.42.142.228:8080/pics/business/images/welcome/iPhone6p.png',NULL),(6,'Android','http://121.42.142.228:8080/pics/business/images/welcome/android.png',NULL);

-- 健康数据表默认非监护人
UPDATE daily_health_check_info SET logasguaridan=false;

-- 关联用户服务次数表，关联用户默认报警阈值表，设置用户为免费用户，设置用户可以手机号登录
UPDATE customer SET customer_service_id = id, check_info_warn_id=id, is_free = '1', phone_login_valid = 1;

-- 手机号重复的用户设置不可用手机号登录
UPDATE customer SET phone_login_valid = 0 WHERE phone_number IN (SELECT temp_table.phone FROM (SELECT c.phone_number AS phone FROM customer c GROUP BY c.phone_number HAVING COUNT(c.phone_number) > 1) AS temp_table);

-- 设置用户的主管医生
update customer set attending_doctor_id = 22 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 4 and f.attending_doctor_id is null and f.id < 1000) as temp);
update customer set attending_doctor_id = 23 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 4 and f.attending_doctor_id is null and f.id >= 1000 and f.id <1800) as temp);
update customer set attending_doctor_id = 24 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 4 and f.attending_doctor_id is null and f.id >= 1800 and f.id <3100) as temp);
update customer set attending_doctor_id = 25 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 4 and f.attending_doctor_id is null and f.id >= 3100 and f.id <3900) as temp);
update customer set attending_doctor_id = 37 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 4 and f.attending_doctor_id is null and f.id >= 3900) as temp);

update customer set attending_doctor_id = 13 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 3 and f.attending_doctor_id is null and f.id < 650) as temp);
update customer set attending_doctor_id = 14 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 3 and f.attending_doctor_id is null and f.id >= 650 and f.id <1100) as temp);
update customer set attending_doctor_id = 15 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 3 and f.attending_doctor_id is null and f.id >= 1100 and f.id <1760) as temp);
update customer set attending_doctor_id = 16 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 3 and f.attending_doctor_id is null and f.id >= 1760 and f.id <2900) as temp);
update customer set attending_doctor_id = 84 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 3 and f.attending_doctor_id is null and f.id >= 2900 and f.id <3600) as temp);
update customer set attending_doctor_id = 85 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 3 and f.attending_doctor_id is null and f.id >= 3600) as temp);

update customer set attending_doctor_id = 78 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 10 and f.attending_doctor_id is null and f.id < 4229) as temp);
update customer set attending_doctor_id = 79 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 10 and f.attending_doctor_id is null and f.id >= 4229 and f.id <4240) as temp);
update customer set attending_doctor_id = 80 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 10 and f.attending_doctor_id is null and f.id >= 4240 and f.id <4258) as temp);
update customer set attending_doctor_id = 82 where id in (select id from (select f.id from customer_health_group e inner join customer f on e.customer_id = f.id where e.health_group_id = 10 and f.attending_doctor_id is null and f.id >= 4258) as temp);

-- 设置是否是监护人提交的互动（咨询），默认false:用户自己提交的
UPDATE  medical_consultation SET is_guardian=FALSE;

-- 删除2.0的默认报警阈值
DELETE FROM daily_health_check_info_default_warn WHERE ISNULL(type);

-- 删除customerDevice表里的 device_id
alter table `customer_device` drop column device_id;

-- 设置用户表手机号可空
alter table customer modify phone_number VARCHAR(20) null;

-- 删除原有资深专家与团队的关系：字段（health_group_for_headers_id）
ALTER TABLE doctor DROP FOREIGN KEY FK_t1xi82669b7rqimjibvcxk8ut;
ALTER TABLE doctor DROP COLUMN health_group_for_headers_id;

-- 修复 "提交健康报告" 输入字符限制
alter table diagnosis_report modify  COLUMN comment1 varchar(1024);
alter table diagnosis_report modify  COLUMN comment2 varchar(1024);
alter table diagnosis_report modify  COLUMN comment3 varchar(1024);
