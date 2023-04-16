-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯', '2000', '1', 'article', 'system/article/index', 1, 0, 'C', '0', '0', 'system:article:list', '#', 'admin', sysdate(), '', null, '文章资讯菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:article:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:article:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:article:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:article:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章资讯导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:article:export',       '#', 'admin', sysdate(), '', null, '');