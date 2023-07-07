

DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user`(
    `id` INT UNSIGNED AUTO_INCREMENT KEY COMMENT '用户编号',
    `username` VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
    `password` CHAR(32) NOT NULL COMMENT '密码',
    `email` VARCHAR(50) UNIQUE COMMENT '邮箱',
    `age` TINYINT UNSIGNED NOT NULL DEFAULT 18 COMMENT '年龄',
    `sex` ENUM('man','woman','baomi') NOT NULL DEFAULT 'baomi' COMMENT '性别',
    `tel` CHAR(11) UNIQUE COMMENT '电话',
    `addr` VARCHAR(50) DEFAULT 'beijing' COMMENT '地址',
    `card` CHAR(18) UNIQUE COMMENT '身份证号',
    `married` TINYINT(1) DEFAULT 0 COMMENT '0代表未结婚，1代表已结婚',
    `salary` FLOAT(8,2) DEFAULT 0 COMMENT '薪水'
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `operate_log`(
     `id` INT UNSIGNED primary key  auto_increment COMMENT '操作编号',
     `operate_user` INT UNSIGNED COMMENT '操作人id',
     `operate_time` datetime COMMENT '操作时间',
     `class_name` VARCHAR(100)  COMMENT '操作类名',
     `method_name` VARCHAR(100) COMMENT '操作方法名',
     `method_params`VARCHAR(1000) COMMENT '方法参数',
     `return_value` VARCHAR(2000)  COMMENT '返回值',
     `cost_time` bigint  COMMENT '方法执行耗时(ms)'
) comment '日志操作表';

INSERT INTO
    user(id,username,password,age,sex)
VALUES
    (1,'zyq',822,21,'man'),
    (2,'zyd',111,10,'woman'),
    (3,'zjy',222,15,'woman'),
    (4,'qhy',850,17,'woman'),
    (5,'lsq',047,17,'woman'),
    (6,'saq',000,19,'woman');