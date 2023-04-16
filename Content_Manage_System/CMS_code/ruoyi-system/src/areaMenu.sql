-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('场地信息', '2000', '1', 'area', 'system/area/index', 1, 0, 'C', '0', '0', 'system:area:list', '#', 'admin', sysdate(), '', null, '场地信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('场地信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:area:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('场地信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:area:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('场地信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:area:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('场地信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:area:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('场地信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:area:export',       '#', 'admin', sysdate(), '', null, '');