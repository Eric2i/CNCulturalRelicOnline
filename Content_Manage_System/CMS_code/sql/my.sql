drop table if exists message;
create table message
(
    id          bigint(20)   not null auto_increment comment 'ID',
    name        varchar(50)  not null comment '姓名',
    phone       varchar(50)  not null comment '联系方式',
    content     varchar(255) not null comment '内容',
    status      tinyint       default 0 comment '审核状态',
    create_time datetime default now() comment '创建时间',
    primary key (id)
) comment = '留言信息表';

insert into sys_dict_type (dict_name, dict_type, create_time)
values ('审核状态', 'a_type', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('审核中', '0', 'a_type', sysdate()),
       ('通过', '1', 'a_type', sysdate()),
       ('拒绝', '2', 'a_type', sysdate());

drop table if exists pic;
create table pic
(
    id          bigint(20)   not null auto_increment comment 'ID',
    content     varchar(255) not null comment '图片',
    status      tinyint       default 0 comment '审核状态',
    create_time datetime default now() comment '创建时间',
    primary key (id)
) comment = '图片信息表';
drop table if exists video;
create table video
(
    id          bigint(20)   not null auto_increment comment 'ID',
    content     varchar(255) not null comment '视频',
    status      tinyint       default 0 comment '审核状态',
    create_time datetime default now() comment '创建时间',
    primary key (id)
) comment = '视频信息表';