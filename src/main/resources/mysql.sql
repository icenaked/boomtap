

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

INSERT INTO
    user(id,username,password,age,sex)
VALUES
    (1,'zyq',822,21,'man'),
    (2,'zyd',111,10,'woman'),
    (3,'zjy',222,15,'woman'),
    (4,'qhy',850,17,'woman'),
    (5,'lsq',047,17,'woman'),
    (6,'saq',000,19,'woman');