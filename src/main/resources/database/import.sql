/*Table structure for table `sys_permission` */
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL COMMENT '加密密码的盐',
  `state` tinyint(4) NOT NULL COMMENT '用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.',
  `username` varchar(255) DEFAULT NULL,
  `cre_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `cre_usr` int(11) DEFAULT NULL COMMENT '创建人',
  `upd_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `upd_usr` int(11) DEFAULT NULL COMMENT '更新人',
  `is_delete` INT(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

/*Table structure for table `sys_permission` */
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '父编号列表',
  `permission` varchar(255) DEFAULT NULL COMMENT '//权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view',
  `resource_type` int(11) DEFAULT NULL COMMENT '资源类型，[1=menu|2=button]',
  `url` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `cre_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `cre_usr` int(11) DEFAULT NULL COMMENT '创建人',
  `upd_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `upd_usr` int(11) DEFAULT NULL COMMENT '更新人',
  `is_delete` INT(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL COMMENT '是否可用,如果不可用将不会添加给用户',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述,UI界面显示使用',
  `role` varchar(255) DEFAULT NULL COMMENT '角色标识程序中判断使用,如"admin",这个是唯一的:',
  `cre_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `cre_usr` int(11) DEFAULT NULL COMMENT '创建人',
  `upd_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `upd_usr` int(11) DEFAULT NULL COMMENT '更新人',
  `is_delete` INT(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role_permission` */

CREATE TABLE `sys_role_permission` (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `cre_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `cre_usr` int(11) DEFAULT NULL COMMENT '创建人',
  `upd_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `upd_usr` int(11) DEFAULT NULL COMMENT '更新人',
  `is_delete` INT(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `cre_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `cre_usr` int(11) DEFAULT NULL COMMENT '创建人',
  `upd_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `upd_usr` int(11) DEFAULT NULL COMMENT '更新人',
  `is_delete` INT(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;