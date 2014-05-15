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


ALTER TABLE `cc_kata_kplus_transportation` ADD `type` INT(4) COMMENT '1 邮政小包 2 快件 3 EMS';

ALTER TABLE `cc_kata_kplus_order_transport` ADD `addressor_country` VARCHAR(50) COMMENT '发件人国别';
ALTER TABLE `cc_kata_kplus_order_transport` ADD `addressor_name` VARCHAR(200) COMMENT '发件人姓名';


ALTER TABLE `cc_kata_kplus_transportationcompany` ADD `code` VARCHAR(40) COMMENT '物流企业编号';
ALTER TABLE `cc_kata_kplus_transportationcompany` ADD `zip_code` VARCHAR(10) COMMENT '物流企业邮编';

ALTER TABLE `cc_kata_kplus_commodity` ADD `tariff` VARCHAR(20) COMMENT '行邮税号 必须已备案，且与参数说明文档中的行邮税号中的税号一致';
ALTER TABLE `cc_kata_kplus_commodity` ADD `sales_country` VARCHAR(50) COMMENT '产销国';
ALTER TABLE `cc_kata_kplus_commodity` ADD `unit` VARCHAR(50) COMMENT '申报计量单位 见计量单位代码';

ALTER TABLE `kata_kplus_member` ADD `certificates_type` VARCHAR(50) COMMENT '证件类型 01:身份证（试点期间只能是身份证） 02:护照 03:其他';
ALTER TABLE `kata_kplus_member` ADD `certificates` VARCHAR(50) COMMENT '证件号码';

ALTER TABLE `cc_kata_kplus_order` ADD `logistics_state` INT(5) COMMENT '物流跟踪状态 10 启运 20 抵港 30 到货 40 离开 50 签收';
ALTER TABLE `cc_kata_kplus_order` ADD `station_code` VARCHAR(20) COMMENT '场站代码';
ALTER TABLE `cc_kata_kplus_order` ADD `license_plate_number` VARCHAR(10) COMMENT '车牌号码';
