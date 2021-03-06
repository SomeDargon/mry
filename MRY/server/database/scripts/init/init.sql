
INSERT INTO system_config(id, key_val, value_val) VALUES
(1, 'AUTHTOKEN_EXPIRED_HOURS', '720'),
(3, 'MEDICAL_ADVICE_CANCLE_HOURS', '72'),
(4, 'CHECK_SAFE_ANSWER_MAX_TIMES', '5'),
(7, 'ADMIN_AUTHTOKEN_EXPIRED_HOURS', '48'),
(8, 'CONSULT_AUTO_COMMENT_HOURS', '168'),
(9, 'SYSTEM_AUTO_COMMENT_CONSULT_STARS', '3'),
(10, 'NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS', '48');



INSERT INTO pay_config(id, key_val, value_val) VALUES
(1, 'PARTNER_ID', '2088911953652335'),
(2, 'SECURITY_KEY','lyqurskj62w7ezypccao66nwu86kaklg'),
(3, 'NOTIFY_URL', 'http://121.42.142.228:8080/app/api/pay/notify'),
(4, 'RETURN_URL', 'http://121.42.142.228:8080/#/patient/payment_return'),
(5, 'SELLER_EMAIL', 'Liang.guo@uyidoctor.com'),
(6, 'MOBILE_NOTIFY_URL', 'http://121.42.142.228:8080/app/api/pay/mobile/notify'),
(7, 'PRIVATE_KEY_KEY','MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALf7YzTPk25nlmoyC3p4kgWXIN/typUFx0dArXXMZ8WfL3zioKMRx0bNw+j/u8rLfjtWABO/Zfjxtwa+lTdOdSwNewfGwwT6EtH0eMF13CA4Z3+dMb7Hi/x1aYIVHZr//1CX/NFJtm/bwNNzjmXBxUBbafOZXiSA1NW7PEq+B+dRAgMBAAECgYEAonvSrrZQF2ZGsf0GpB/NnkBNWVax3hCfYS8ewnVGhILEtr+TbNDrtH1O8vy/xicXkaGvKcGUdlpK8Rrpv1F8Km7hrKKdOlbEDlh3ExvetVXFYks5NFpGPgnJQMrf47ocIBpeXn+W6BhjrWIPJCYLMpJnIg3FqbUwtc3zzRx4XxECQQDkHTsgd8G91ef9SQ788Bpt+l0kT6mL2y+O9ylNJAGmwDrnAijGxIFUin7iaGrzSoegUxRV2HjIBxyOEK4H5wJdAkEAznkNQV/iChnsRIVeV6KXOfMYKfO+9cTV1aWRNsKB9IxU85wfBsoAirUZeyQ6LuZSdqhdiFY1rBA+32FJBJGRhQJAGiS7fQocmzwjvWSdIiIGdWpHOH0kylGRjsoG4r9orQrE9WrK75Tf2aeRyTL8Zuu4xYggAYKwvQQLosCIoYE5RQJAM5LFHtlGauOCwrLVl+pC//Sayo/Z2SXri8wpc5YuQ9lxts/+aAG5FOybisjHx8M8QetYQZ/XFD2SltWEGaIKyQJBAMFEXF1uqwhDhGBvQn9BAHrbqavZ4XSWi912LDcaeC72wLXyWrVOLZwa4WPJrAyy696oJoRqEEeDKAAXQ398ciQ='),
(8, 'PUBLIC_KEY_KEY','MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3+2M0z5NuZ5ZqMgt6eJIFlyDf7cqVBcdHQK11zGfFny984qCjEcdGzcPo/7vKy347VgATv2X48bcGvpU3TnUsDXsHxsME+hLR9HjBddwgOGd/nTG+x4v8dWmCFR2a//9Ql/zRSbZv28DTc45lwcVAW2nzmV4kgNTVuzxKvgfnUQIDAQAB'),
(9,'TOP_THREE_NOTIFY_URL','http://121.42.142.228:8080/app/api/pay/topThreeService/notify'),
(10,'TOP_THREE_RETURN_URL','http://121.42.142.228:8080/#/paytopthree_return'),
(11,'MOBILE_TOP_THREE_NOTIFY_URL','http://121.42.142.228:8080/app/api/pay/topThreeService/mobile/notify');

INSERT INTO admin_user(id, username, password, is_active) VALUES
(1, 'admin', 'fYzrKkz3gHyFJIfPi5a+LuZDJWLUzAEk9MKFfymLYp0LMlcORKiMagYtDPE7MOs7', true);



INSERT INTO province(id, name, is_active) VALUES
(1, '北京市',true),
(2, '广东省',true),
(3, '山东省',true),
(4, '江苏省',true),
(5, '河南省',true),
(6, '上海市',true),
(7, '河北省',true),
(8, '浙江省',true),
(9, '陕西省',true),
(10, '湖南省',true),
(11, '重庆市',true),
(12, '福建省',true),
(13, '天津市',true),
(14, '云南省',true),
(15, '四川省',true),
(16, '广西壮族自治区',true),
(17, '安徽省',true),
(18, '海南省',true),
(19, '江西省',true),
(20, '湖北省',true),
(21, '山西省',true),
(22, '辽宁省',true),
(23, '黑龙江',true),
(24, '内蒙古自治区',true),
(25, '贵州省',true),
(26, '甘肃省',true),
(27, '青海省',true),
(28, '新疆维吾尔自治区',true),
(29, '西藏藏族自治区',true),
(30, '吉林省',true),
(31, '宁夏回族自治区', true);

INSERT INTO city(id, name, province_id, is_active) VALUES
(1, '朝阳区', 1, true),
(2, '海淀区', 1, true),
(3, '通州区', 1, true),
(4, '房山区', 1, true),
(5, '丰台区', 1, true),
(6, '昌平区', 1, true),
(7, '大兴区', 1, true),
(8, '顺义区', 1, true),
(9, '西城区', 1, true),
(10, '延庆县', 1, true),
(11, '石景山区', 1, true),
(12, '宣武区', 1, true),
(13, '怀柔区', 1, true),
(14, '崇文区', 1, true),
(15, '密云县', 1, true),
(16, '东城区', 1, true),
(17, '平谷区', 1, true),
(18, '门头沟区', 1, true),
(19, '广州市', 2, true),
(20, '深圳市', 2, true),
(21, '东莞市', 2, true),
(22, '中山市', 2, true),
(23, '惠州市', 2, true),
(24, '江门市', 2, true),
(25, '珠海市', 2, true),
(26, '汕头市', 2, true),
(27, '佛山市', 2, true),
(28, '湛江市', 2, true),
(29, '河源市', 2, true),
(30, '肇庆市', 2, true),
(31, '清远市', 2, true),
(32, '潮州市', 2, true),
(33, '韶关市', 2, true),
(34, '揭阳市', 2, true),
(35, '阳江市', 2, true),
(36, '梅州市', 2, true),
(37, '云浮市', 2, true),
(38, '茂名市', 2, true),
(39, '汕尾市', 2, true),
(40, '济南市', 3, true),
(41, '青岛市', 3, true),
(42, '临沂市', 3, true),
(43, '济宁市', 3, true),
(44, '菏泽市', 3, true),
(45, '烟台市', 3, true),
(46, '淄博市', 3, true),
(47, '泰安市', 3, true),
(48, '潍坊市', 3, true),
(49, '日照市', 3, true),
(50, '威海市', 3, true),
(51, '滨州市', 3, true),
(52, '东营市', 3, true),
(53, '聊城市', 3, true),
(54, '德州市', 3, true),
(55, '莱芜市', 3, true),
(56, '枣庄市', 3, true),
(57, '南京市', 4, true),
(58, '苏州市', 4, true),
(59, '徐州市', 4, true),
(60, '盐城市', 4, true),
(61, '无锡市', 4, true),
(62, '南通市', 4, true),
(63, '连云港市', 4, true),
(64, '常州市', 4, true),
(65, '镇江市', 4, true),
(66, '扬州市', 4, true),
(67, '淮安市', 4, true),
(68, '泰州市', 4, true),
(69, '宿迁市', 4, true),
(70, '郑州市', 5, true),
(71, '南阳市', 5, true),
(72, '新乡市', 5, true),
(73, '安阳市', 5, true),
(74, '洛阳市', 5, true),
(75, '信阳市', 5, true),
(76, '平顶山市', 5, true),
(77, '周口市', 5, true),
(78, '商丘市', 5, true),
(79, '开封市', 5, true),
(80, '焦作市', 5, true),
(81, '驻马店市', 5, true),
(82, '濮阳市', 5, true),
(83, '三门峡市', 5, true),
(84, '漯河市', 5, true),
(85, '许昌市', 5, true),
(86, '鹤壁市', 5, true),
(87, '济源市', 5, true),
(88, '松江区', 6, true),
(89, '宝山区', 6, true),
(90, '金山区', 6, true),
(91, '嘉定区', 6, true),
(92, '南汇区', 6, true),
(93, '青浦区', 6, true),
(94, '浦东新区', 6, true),
(95, '奉贤区', 6, true),
(96, '徐汇区', 6, true),
(97, '静安区', 6, true),
(98, '闵行区', 6, true),
(99, '黄浦区', 6, true),
(100, '杨浦区', 6, true),
(101, '虹口区', 6, true),
(102, '普陀区', 6, true),
(103, '闸北区', 6, true),
(104, '长宁区', 6, true),
(105, '崇明县', 6, true),
(106, '卢湾区', 6, true),
(107, '石家庄市', 7, true),
(108, '唐山市', 7, true),
(109, '保定市', 7, true),
(110, '邯郸市', 7, true),
(111, '邢台市', 7, true),
(112, '河北区', 7, true),
(113, '沧州市', 7, true),
(114, '秦皇岛市', 7, true),
(115, '张家口市', 7, true),
(116, '衡水市', 7, true),
(117, '廊坊市', 7, true),
(118, '承德市', 7, true),
(119, '杭州市', 8, true),
(120, '宁波市', 8, true),
(121, '温州市', 8, true),
(122, '台州市', 8, true),
(123, '嘉兴市', 8, true),
(124, '金华市', 8, true),
(125, '湖州市', 8, true),
(126, '绍兴市', 8, true),
(127, '舟山市', 8, true),
(128, '丽水市', 8, true),
(129, '衢州市', 8, true),
(130, '西安市', 9, true),
(131, '咸阳市', 9, true),
(132, '宝鸡市', 9, true),
(133, '汉中市', 9, true),
(134, '渭南市', 9, true),
(135, '安康市', 9, true),
(136, '榆林市', 9, true),
(137, '商洛市', 9, true),
(138, '延安市', 9, true),
(139, '铜川市', 9, true),
(140, '长沙市', 10, true),
(141, '邵阳市', 10, true),
(142, '常德市', 10, true),
(143, '衡阳市', 10, true),
(144, '株洲市', 10, true),
(145, '湘潭市', 10, true),
(146, '永州市', 10, true),
(147, '岳阳市', 10, true),
(148, '怀化市', 10, true),
(149, '郴州市', 10, true),
(150, '娄底市', 10, true),
(151, '益阳市', 10, true),
(152, '张家界市', 10, true),
(153, '湘西州', 10, true),
(154, '江北区', 11, true),
(155, '渝北区', 11, true),
(156, '沙坪坝区', 11, true),
(157, '九龙坡区', 11, true),
(158, '万州区', 11, true),
(159, '永川市', 11, true),
(160, '南岸区', 11, true),
(161, '酉阳县', 11, true),
(162, '北碚区', 11, true),
(163, '涪陵区', 11, true),
(164, '秀山县', 11, true),
(165, '巴南区', 11, true),
(166, '渝中区', 11, true),
(167, '石柱县', 11, true),
(168, '忠县', 11, true),
(169, '合川市', 11, true),
(170, '大渡口区', 11, true),
(171, '开县', 11, true),
(172, '长寿区', 11, true),
(173, '荣昌县', 11, true),
(174, '云阳县', 11, true),
(175, '梁平县', 11, true),
(176, '潼南县', 11, true),
(177, '江津市', 11, true),
(178, '彭水县', 11, true),
(179, '綦江县', 11, true),
(180, '璧山县', 11, true),
(181, '黔江区', 11, true),
(182, '大足县', 11, true),
(183, '巫山县', 11, true),
(184, '巫溪县', 11, true),
(185, '垫江县', 11, true),
(186, '丰都县', 11, true),
(187, '武隆县', 11, true),
(188, '万盛区', 11, true),
(189, '铜梁县', 11, true),
(190, '南川市', 11, true),
(191, '奉节县', 11, true),
(192, '双桥区', 11, true),
(193, '城口县　', 11, true),
(194, '福州市', 12, true),
(195, '厦门市', 12, true),
(196, '漳州市', 12, true),
(197, '泉州市', 12, true),
(198, '莆田市', 12, true),
(199, '宁德市', 12, true),
(200, '三明市', 12, true),
(201, '南平市', 12, true),
(202, '龙岩市', 12, true),
(203, '和平区', 13, true),
(204, '北辰区', 13, true),
(205, '河北区', 13, true),
(206, '河西区', 13, true),
(207, '西青区', 13, true),
(208, '津南区', 13, true),
(209, '东丽区', 13, true),
(210, '武清区', 13, true),
(211, '宝坻区', 13, true),
(212, '红桥区', 13, true),
(213, '大港区', 13, true),
(214, '汉沽区', 13, true),
(215, '静海县', 13, true),
(216, '塘沽区', 13, true),
(217, '宁河县', 13, true),
(218, '蓟县', 13, true),
(219, '南开区', 13, true),
(220, '河东区　', 13, true),
(221, '昆明市', 14, true),
(222, '红河州', 14, true),
(223, '大理州', 14, true),
(224, '文山州', 14, true),
(225, '德宏州', 14, true),
(226, '曲靖市', 14, true),
(227, '昭通市', 14, true),
(228, '楚雄州', 14, true),
(229, '保山市', 14, true),
(230, '玉溪市', 14, true),
(231, '丽江地区', 14, true),
(232, '临沧地区', 14, true),
(233, '思茅地区', 14, true),
(234, '西双版纳州', 14, true),
(235, '怒江州', 14, true),
(236, '迪庆州　', 14, true),
(237, '成都市', 15, true),
(238, '绵阳市', 15, true),
(239, '广元市', 15, true),
(240, '达州市', 15, true),
(241, '南充市', 15, true),
(242, '德阳市', 15, true),
(243, '广安市', 15, true),
(244, '阿坝州', 15, true),
(245, '巴中市', 15, true),
(246, '遂宁市', 15, true),
(247, '内江市', 15, true),
(248, '凉山州', 15, true),
(249, '攀枝花市', 15, true),
(250, '乐山市', 15, true),
(251, '自贡市', 15, true),
(252, '泸州市', 15, true),
(253, '雅安市', 15, true),
(254, '宜宾市', 15, true),
(255, '资阳市', 15, true),
(256, '眉山市', 15, true),
(257, '甘孜州　', 15, true),
(258, '南宁市', 16, true),
(259, '柳州市', 16, true),
(260, '桂林市', 16, true),
(261, '贵港市', 16, true),
(262, '玉林市', 16, true),
(263, '北海市', 16, true),
(264, '梧州市', 16, true),
(265, '钦州市', 16, true),
(266, '来宾市', 16, true),
(267, '河池市', 16, true),
(268, '百色市', 16, true),
(269, '贺州市', 16, true),
(270, '崇左市', 16, true),
(271, '防城港市', 16, true),
(272, '合肥市', 17, true),
(273, '芜湖市', 17, true),
(274, '六安市', 17, true),
(275, '宿州市', 17, true),
(276, '阜阳市', 17, true),
(277, '安庆市', 17, true),
(278, '马鞍山市', 17, true),
(279, '蚌埠市', 17, true),
(280, '淮北市', 17, true),
(281, '淮南市', 17, true),
(282, '宣城市', 17, true),
(283, '黄山市', 17, true),
(284, '铜陵市', 17, true),
(285, '亳州市', 17, true),
(286, '池州市', 17, true),
(287, '巢湖市', 17, true),
(288, '滁州市', 17, true),
(289, '海口市', 18, true),
(290, '三亚市', 18, true),
(291, '琼海市', 18, true),
(292, '文昌市', 18, true),
(293, '东方市', 18, true),
(294, '昌江县', 18, true),
(295, '陵水县', 18, true),
(296, '乐东县', 18, true),
(297, '保亭县', 18, true),
(298, '五指山市', 18, true),
(299, '澄迈县', 18, true),
(300, '万宁市', 18, true),
(301, '儋州市', 18, true),
(302, '临高县', 18, true),
(303, '白沙县', 18, true),
(304, '定安县', 18, true),
(305, '琼中县', 18, true),
(306, '屯昌县　', 18, true),
(307, '南昌市', 19, true),
(308, '赣州市', 19, true),
(309, '上饶市', 19, true),
(310, '吉安市', 19, true),
(311, '九江市', 19, true),
(312, '新余市', 19, true),
(313, '抚州市', 19, true),
(314, '宜春市', 19, true),
(315, '景德镇市', 19, true),
(316, '萍乡市', 19, true),
(317, '鹰潭市', 19, true),
(318, '武汉市', 20, true),
(319, '宜昌市', 20, true),
(320, '襄樊市', 20, true),
(321, '荆州市', 20, true),
(322, '恩施州', 20, true),
(323, '黄冈市', 20, true),
(324, '孝感市', 20, true),
(325, '十堰市', 20, true),
(326, '咸宁市', 20, true),
(327, '黄石市', 20, true),
(328, '仙桃市', 20, true),
(329, '天门市', 20, true),
(330, '随州市', 20, true),
(331, '荆门市', 20, true),
(332, '潜江市', 20, true),
(333, '鄂州市', 20, true),
(334, '神农架林区', 20, true),
(335, '太原市', 21, true),
(336, '大同市', 21, true),
(337, '运城市', 21, true),
(338, '长治市', 21, true),
(339, '晋城市', 21, true),
(340, '忻州市', 21, true),
(341, '临汾市', 21, true),
(342, '吕梁市', 21, true),
(343, '晋中市', 21, true),
(344, '阳泉市', 21, true),
(345, '朔州市', 21, true),
(346, '沈阳市', 22, true),
(347, '大连市', 22, true),
(348, '丹东市', 22, true),
(349, '辽阳市', 22, true),
(350, '葫芦岛市', 22, true),
(351, '锦州市', 22, true),
(352, '朝阳市', 22, true),
(353, '营口市', 22, true),
(354, '鞍山市', 22, true),
(355, '抚顺市', 22, true),
(356, '阜新市', 22, true),
(357, '盘锦市', 22, true),
(358, '本溪市', 22, true),
(359, '铁岭市', 22, true),
(360, '哈尔滨市', 23, true),
(361, '大庆市', 23, true),
(362, '齐齐哈尔市', 23, true),
(363, '佳木斯市', 23, true),
(364, '双鸭山市', 23, true),
(365, '牡丹江市', 23, true),
(366, '鸡西市', 23, true),
(367, '黑河市', 23, true),
(368, '绥化市', 23, true),
(369, '鹤岗市', 23, true),
(370, '伊春市', 23, true),
(371, '大兴安岭地区', 23, true),
(372, '七台河市', 23, true),
(373, '呼和浩特市', 24, true),
(374, '赤峰市', 24, true),
(375, '包头市', 24, true),
(376, '通辽市', 24, true),
(377, '鄂尔多斯市', 24, true),
(378, '乌海市', 24, true),
(379, '呼伦贝尔市', 24, true),
(380, '兴安盟', 24, true),
(381, '巴彦淖尔盟', 24, true),
(382, '乌兰察布盟', 24, true),
(383, '锡林郭勒盟', 24, true),
(384, '阿拉善盟', 24, true),
(385, '贵阳市', 25, true),
(386, '黔东南州', 25, true),
(387, '黔南州', 25, true),
(388, '遵义市', 25, true),
(389, '黔西南州', 25, true),
(390, '毕节地区', 25, true),
(391, '铜仁地区', 25, true),
(392, '安顺市', 25, true),
(393, '六盘水市', 25, true),
(394, '兰州市', 26, true),
(395, '天水市', 26, true),
(396, '庆阳市', 26, true),
(397, '武威市', 26, true),
(398, '酒泉市', 26, true),
(399, '张掖市', 26, true),
(400, '陇南地区', 26, true),
(401, '白银市', 26, true),
(402, '定西地区', 26, true),
(403, '平凉市', 26, true),
(404, '嘉峪关市', 26, true),
(405, '临夏回族自治州', 26, true),
(406, '金昌市', 26, true),
(407, '甘南州　', 26, true),
(408, '西宁市', 27, true),
(409, '海西州', 27, true),
(410, '海东地区', 27, true),
(411, '海北州', 27, true),
(412, '果洛州', 27, true),
(413, '玉树州', 27, true),
(414, '黄南藏族自治州', 27, true),
(415, '乌鲁木齐市', 28, true),
(416, '伊犁州', 28, true),
(417, '昌吉州', 28, true),
(418, '石河子市', 28, true),
(419, '哈密地区', 28, true),
(420, '阿克苏地区', 28, true),
(421, '巴音郭楞州', 28, true),
(422, '喀什地区', 28, true),
(423, '塔城地区', 28, true),
(424, '克拉玛依市', 28, true),
(425, '和田地区', 28, true),
(426, '阿勒泰州', 28, true),
(427, '吐鲁番地区', 28, true),
(428, '阿拉尔市', 28, true),
(429, '博尔塔拉州', 28, true),
(430, '五家渠市', 28, true),
(431, '克孜勒苏州', 28, true),
(432, '图木舒克市', 28, true),
(433, '拉萨市', 29, true),
(434, '山南地区', 29, true),
(435, '林芝地区', 29, true),
(436, '日喀则地区', 29, true),
(437, '阿里地区', 29, true),
(438, '昌都地区', 29, true),
(439, '那曲地区', 29, true),
(440, '长春市', 30, true),
(441, '吉林市', 30, true),
(442, '白山市', 30, true),
(443, '延边州', 30, true),
(444, '白城市', 30, true),
(445, '松原市', 30, true),
(446, '辽源市', 30, true),
(447, '通化市', 30, true),
(448, '四平市', 30, true),
(449, '银川市', 31, true),
(450, '吴忠市', 31, true),
(451, '中卫市', 31, true),
(452, '石嘴山市', 31, true),
(453, '固原市', 31, true);

INSERT INTO safe_question(id, question) VALUES
(1, '我的宠物名?'),
(5, '我的小区名?'),
(10, '我最喜欢的城市?'),
(15, '我最喜欢的国家?'),
(20, '我最喜欢的书名?'),
(25, '我最喜欢的运动?'),
(30, '我最喜欢的歌曲?'),
(35, '我最喜欢的电影?'),
(40, '我最喜欢的颜色?'),
(45, '自定义问题');


INSERT INTO `daily_health_check_info_default_warn`(
id
,bloodFatChol
,bloodFatHdl
,bloodFatLdl
,bloodFatTg
,diastolicPressureHigh
,diastolicPressureLow
,fastBloodSugarHigh
,fastBloodSugarLow
,heartRateHigh
,heartRateLow
,postPrandilaSugarHigh
,postPrandilaSugarLow
,systolicPressureHigh
,systolicPressureLow
,urineAcid
,pulseRateLow
,pulseRateHigh
,spo
 ) VALUES
(1,5.72,0.91,3.64,1.7,90,50,5.6,3.9,90,50,8,3.9,150,100,360, 50, 90, 90);






