CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_role_id` (`role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `sys_user`(`id`, `name`, `password`) VALUES (1, 'admin', '$2a$06$Vbtkylrumz6/ozMVE4x0Xuh7yCycKrhZGYrYjY2ejF3CudNhZImjO');
INSERT INTO `sys_user`(`id`, `name`, `password`) VALUES (2, 'zhangsan', '$2a$06$Vbtkylrumz6/ozMVE4x0Xuh7yCycKrhZGYrYjY2ejF3CudNhZImjO');

INSERT INTO `sys_role`(`id`, `name`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `sys_role`(`id`, `name`) VALUES (2, 'ROLE_USER');

INSERT INTO `sys_user_role`(`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `sys_user_role`(`user_id`, `role_id`) VALUES (2, 2);
