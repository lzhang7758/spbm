
CREATE TABLE `user_info` (
  `uid` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `salt` VARCHAR(255) DEFAULT NULL COMMENT '加密密码的盐',
  `state` TINYINT(4) NOT NULL COMMENT '用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.',
  `username` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `available` BIT(1) DEFAULT NULL COMMENT '是否可用,如果不可用将不会添加给用户',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '角色描述,UI界面显示使用',
  `role` VARCHAR(255) DEFAULT NULL COMMENT '角色标识程序中判断使用,如"admin",这个是唯一的:',
  PRIMARY KEY (`role_id`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_permission` (
  `permission_id` INT(11) NOT NULL AUTO_INCREMENT,
  `available` BIT(1) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `parent_id` BIGINT(20) DEFAULT NULL COMMENT '父编号',
  `parent_ids` VARCHAR(255) DEFAULT NULL COMMENT '父编号列表',
  `permission` VARCHAR(255) DEFAULT NULL COMMENT '//权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view',
  `resource_type` ENUM('menu','button') DEFAULT NULL COMMENT '资源类型，[menu|button]',
  `url` VARCHAR(255) DEFAULT NULL COMMENT '资源路径',
  PRIMARY KEY (`permission_id`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user_role` (
  `role_id` INT(11) NOT NULL,
  `uid` INT(11) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role_permission` (
  `permission_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user_info` (`uid`,`username`,`name`,`password`,`salt`,`state`) VALUES ('1', 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);
INSERT INTO `sys_permission` (`permission_id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (1,0,'用户管理',0,'0/','userInfo:view','menu','userInfo/userList');
INSERT INTO `sys_permission` (`permission_id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (2,0,'用户添加',1,'0/1','userInfo:add','button','userInfo/userAdd');
INSERT INTO `sys_permission` (`permission_id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (3,0,'用户删除',1,'0/1','userInfo:del','button','userInfo/userDel');
INSERT INTO `sys_role` (`role_id`,`available`,`description`,`role`) VALUES (1,0,'管理员','admin');
INSERT INTO `sys_role` (`role_id`,`available`,`description`,`role`) VALUES (2,0,'VIP会员','vip');
INSERT INTO `sys_role` (`role_id`,`available`,`description`,`role`) VALUES (3,1,'test','test');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (3,2);
INSERT INTO `sys_user_role` (`role_id`,`uid`) VALUES (1,1);
