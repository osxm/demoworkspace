INSERT INTO `user` (`user_id`,`user_name`,`password`) VALUES ('user1', 'User 1', '111111');
INSERT INTO `user` (`user_id`,`user_name`,`password`) VALUES ('user2', 'User 2', '111111');
INSERT INTO `user` (`user_id`,`user_name`,`password`) VALUES ('user3', 'User 3', '111111');

INSERT INTO `role` (`role_id`,`role_name`) VALUES (1, 'Role 1');
INSERT INTO `role` (`role_id`,`role_name`) VALUES (2, 'Role 2');
INSERT INTO `role` (`role_id`,`role_name`) VALUES (3, 'Role 3');


INSERT INTO `permission` (`permission_id`,`permission_name`,`resource_url`,`permission`) VALUES (1, 'users query','/users','user:view');


INSERT INTO `user_role` (`user_id`,`role_id`) VALUES ('user1', 1);
INSERT INTO `user_role` (`user_id`,`role_id`) VALUES ('user2', 2);
INSERT INTO `user_role` (`user_id`,`role_id`) VALUES ('user3', 3);


INSERT INTO `role_permission` (`permission_id`,`role_id`) VALUES (1, 1);
