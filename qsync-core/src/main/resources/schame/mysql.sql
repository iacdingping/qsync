-- ----------------------------
-- 报关支付类型与平台支付类型对应表
-- ----------------------------
CREATE TABLE `cc_kata_kplus_declare_pay_type`
(
`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
`platform_pay_type`	INT(5) COMMENT '电商平台支付方式 1 paypal 2 skril',
`platform_pay_company_code`	VARCHAR(200) COMMENT '支付公司编码',
`declare_pay_type`	VARCHAR(5) DEFAULT '03' COMMENT '报关支付类型 01:银行卡支付 02:余额支付 03:其他',
`isdeleted` CHAR(1) DEFAULT NULL,
`createdatetime` DATETIME DEFAULT NULL,
`updatedatetime` DATETIME DEFAULT NULL
)ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='报关支付类型与平台支付类型对应表';

INSERT INTO `cc_kata_kplus_declare_pay_type`
VALUES(1, 1, '000001', '03', '0', NOW(), NOW());
INSERT INTO `cc_kata_kplus_declare_pay_type`
VALUES(2, 2, '000002', '03', '0', NOW(), NOW());