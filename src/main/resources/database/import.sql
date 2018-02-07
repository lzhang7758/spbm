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


/*Data for the table `sys_permission` */

insert  into `sys_permission`(`permission_id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) values (1,'\0','用户管理',0,'0/','userInfo:view',1,'userInfo/userList');
insert  into `sys_permission`(`permission_id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) values (2,'\0','用户添加',1,'0/1','userInfo:add',2,'userInfo/userAdd');
insert  into `sys_permission`(`permission_id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) values (3,'\0','用户删除',1,'0/1','userInfo:del',2,'userInfo/userDel');

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`available`,`description`,`role`) values (1,'\0','管理员js','admin');
insert  into `sys_role`(`role_id`,`available`,`description`,`role`) values (2,'\0','VIP会员js','vip');
insert  into `sys_role`(`role_id`,`available`,`description`,`role`) values (3,'','testjs','test');

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`rp_id`,`permission_id`,`role_id`) values (1,1,1);
insert  into `sys_role_permission`(`rp_id`,`permission_id`,`role_id`) values (2,2,1);
insert  into `sys_role_permission`(`rp_id`,`permission_id`,`role_id`) values (3,3,2);


/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`ur_id`,`role_id`,`uid`) values (1,1,1);
insert  into `sys_user_role`(`ur_id`,`role_id`,`uid`) values (2,2,1);
insert  into `sys_user_role`(`ur_id`,`role_id`,`uid`) values (3,3,1);

/*Data for the table `user_info` */

insert  into `user_info`(`uid`,`name`,`password`,`salt`,`state`,`username`) values (1,'管理员','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f',0,'admin');
insert  into `user_info`(`uid`,`name`,`password`,`salt`,`state`,`username`) values (2,'张三','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f',0,'zhangsan');
