-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图片信息', '2000', '1', 'pic', 'system/pic/index', 1, 0, 'C', '0', '0', 'system:pic:list', '#', 'admin', sysdate(), '', null, '图片信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图片信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:pic:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图片信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:pic:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图片信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:pic:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图片信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:pic:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('图片信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:pic:export',       '#', 'admin', sysdate(), '', null, '');