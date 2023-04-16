drop table if exists category;
create table category
(
    id            bigint      not null auto_increment comment '分类id',
    category_name varchar(50) not null default '' comment '分类名称',
    create_time   datetime             default now() comment '创建时间',
    primary key (id) using btree
) comment '分类表';

drop table if exists area;
create table area
(
    id          bigint      not null auto_increment comment 'id',
    name        varchar(50) not null comment '名称',
    category_id    bigint      comment '分类id',
    address	varchar(255) comment '地址',
    detail      text comment '详情',
    tel         varchar(50) comment '联系方式',
    cover       varchar(255) comment '图片',
    start_time  time comment '开始时间',
    end_time    time comment '结束时间',
    status      tinyint       default 0 comment '状态',
    price       double(10, 2) default 0 comment '价格',
    create_time datetime      default current_timestamp comment '创建时间',
    primary key (id)
) comment ='场地信息表';
insert into playground.area (id, name, category_id, address, detail, tel, cover, start_time, end_time, status, price, create_time)
values  (1, '1号场地', 1, '博文楼', '详情详情详情详情详情详情详情详情详情详情详情', '13154875441', 'https://static.zhipin.com/v2/web/geek/images/we_chat_qr.jpg', '8:49:34', '21:49:37', 0, 50, '2023-04-10 21:49:50');

delete
from sys_dict_data
where dict_type='a_status';
insert into sys_dict_type (dict_name, dict_type, create_time)
values ('场地状态', 'a_status', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('空闲', '0', 'a_status', sysdate()),
       ('占用', '1', 'a_status', sysdate()),
       ('维修', '2', 'a_status', sysdate());

drop table if exists equipment;
create table equipment
(
    id          bigint      not null auto_increment comment 'id',
    name        varchar(50) not null comment '名称',
    category_id    bigint      comment '分类id',
    detail      text comment '详情',
    cover       varchar(255) comment '图片',
    price       double(10, 2) default 0 comment '价格',
    num      int comment '数量',
    num1      int default 0 comment '已用数量',
    create_time datetime      default current_timestamp comment '创建时间',
    primary key (id)
) comment ='器材信息表';

drop table if exists appointment;
create table appointment
(
    id          bigint not null auto_increment comment 'id',
    item_id     bigint comment '项目id',
    user_id     bigint comment '用户id',
    username    varchar(50) comment '用户名',
    type     tinyint comment '类型',
    price       double(10, 2) comment '价格',
    num      int comment '数量',
    total_price       double(10, 2) comment '总价',
    start_time  datetime comment '开始时间',
    end_time    datetime comment '结束时间',
    status      tinyint       default 0 comment '支付状态',
    status1      tinyint      comment '状态',
    create_time datetime default current_timestamp comment '创建时间',
    primary key (id)
) comment ='预约记录表';


drop trigger if exists add_appointment;
CREATE TRIGGER add_appointment
    BEFORE INSERT
    ON appointment
    FOR EACH ROW
BEGIN
    IF NEW.type=0 THEN
        update area set status=1 where id = NEW.item_id; #场地占用
    END IF;
    IF NEW.type=1 THEN
        update equipment set num1=num1 + NEW.num where id = NEW.item_id; #已用数量增加
        SET NEW.status1=4; #预约状态使用中
    END IF;
END;
# 结束使用，场地未占用，器材已用数量减少
drop trigger if exists end_appointment;
CREATE TRIGGER end_appointment
    BEFORE UPDATE
    ON appointment
    FOR EACH ROW
BEGIN
    IF NEW.status1=5 THEN
        IF NEW.type=0 THEN
            update area set status=0 where id = NEW.item_id; #场地占用
        END IF;
        IF NEW.type=1 THEN
            update equipment set num1=num1 - NEW.num where id = NEW.item_id; #已用数量增加
            SET NEW.status1=5; #预约状态
        END IF;
        IF NEW.type=2 THEN
            SET NEW.status1=5; #预约状态
        END IF;
    END IF;
END;

insert into sys_dict_type (dict_name, dict_type, create_time)
values ('预约类型', 'a_type', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('场地', '0', 'a_type', sysdate()),
       ('器材', '1', 'a_type', sysdate()),
       ('教练', '2', 'a_type', sysdate());

insert into sys_dict_type (dict_name, dict_type, create_time)
values ('支付状态', 'pay_status', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('未支付', '0', 'pay_status', sysdate()),
       ('已支付', '1', 'pay_status', sysdate());

insert into sys_dict_type (dict_name, dict_type, create_time)
values ('预约状态', 'a_status1', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('已申请', '0', 'a_status1', sysdate()),
       ('同意', '1', 'a_status1', sysdate()),
       ('拒绝', '2', 'a_status1', sysdate()),
       ('上课中', '3', 'a_status1', sysdate()),
       ('使用中', '4', 'a_status1', sysdate()),
       ('结束', '5', 'a_status1', sysdate());

drop table if exists message;
create table message
(
    id          bigint(20)   not null auto_increment comment 'ID',
    name        varchar(50)  not null comment '姓名',
    phone       varchar(50)  not null comment '联系方式',
    content     varchar(255) not null comment '内容',
    create_time datetime default now() comment '创建时间',
    primary key (id)
) comment = '留言信息表';

drop table if exists article;
create table article
(
    id          bigint not null auto_increment comment '主键id',
    title       varchar(255) comment '标题',
    cover       varchar(255) comment '主图',
    content     text comment '内容',
    views       int         default 0 comment '浏览次数',
    create_by   varchar(64) default '' comment '创建者',
    create_time datetime    default current_timestamp comment '创建时间',
    primary key (id) using btree
) comment '文章资讯表';
INSERT INTO article
VALUES (1, '这个周末去上海的老街寻觅美食吧！',
        'http://www.517njl.com/uploads/2023/02/13/d363d44c37644faebd88b5d871837f07.jpg',
        '庄行老街庄行老街是奉贤区保存较好、富有江南水乡神韵的明清建筑一条街，东街汪家故居、李雪亭宅、褚泾庙旧址、油车弄刁家古宅、混堂弄何六其宅、王家宅等古建筑更是古声古色',
        9, 'admin', '2023-02-27 17:38:13'),
       (2, '这个周末去上海的老街寻觅美食吧！',
        'http://www.517njl.com/uploads/2023/02/13/d363d44c37644faebd88b5d871837f07.jpg',
        '庄行老街庄行老街是奉贤区保存较好、富有江南水乡神韵的明清建筑一条街，东街汪家故居、李雪亭宅、褚泾庙旧址、油车弄刁家古宅、混堂弄何六其宅、王家宅等古建筑更是古声古色',
        10, 'admin', '2023-02-27 17:38:13'),
       (3, '这个周末去上海的老街寻觅美食吧！',
        'http://www.517njl.com/uploads/2023/02/13/d363d44c37644faebd88b5d871837f07.jpg',
        '庄行老街庄行老街是奉贤区保存较好、富有江南水乡神韵的明清建筑一条街，东街汪家故居、李雪亭宅、褚泾庙旧址、油车弄刁家古宅、混堂弄何六其宅、王家宅等古建筑更是古声古色',
        6, 'admin', '2023-02-27 17:38:13'),
       (4, '这个周末去上海的老街寻觅美食吧！',
        'http://www.517njl.com/uploads/2023/02/13/d363d44c37644faebd88b5d871837f07.jpg',
        '庄行老街庄行老街是奉贤区保存较好、富有江南水乡神韵的明清建筑一条街，东街汪家故居、李雪亭宅、褚泾庙旧址、油车弄刁家古宅、混堂弄何六其宅、王家宅等古建筑更是古声古色',
        5, 'admin', '2023-02-27 17:38:13'),
       (5, '这个周末去上海的老街寻觅美食吧！',
        'http://www.517njl.com/uploads/2023/02/13/d363d44c37644faebd88b5d871837f07.jpg',
        '庄行老街庄行老街是奉贤区保存较好、富有江南水乡神韵的明清建筑一条街，东街汪家故居、李雪亭宅、褚泾庙旧址、油车弄刁家古宅、混堂弄何六其宅、王家宅等古建筑更是古声古色',
        0, 'admin', '2023-02-27 17:38:13'),
       (6, '这个周末去上海的老街寻觅美食吧！',
        'http://www.517njl.com/uploads/2023/02/13/d363d44c37644faebd88b5d871837f07.jpg',
        '庄行老街庄行老街是奉贤区保存较好、富有江南水乡神韵的明清建筑一条街，东街汪家故居、李雪亭宅、褚泾庙旧址、油车弄刁家古宅、混堂弄何六其宅、王家宅等古建筑更是古声古色',
        0, 'admin', '2023-02-27 17:38:13'),
       (7, '这个周末去上海的老街寻觅美食吧！',
        'http://www.517njl.com/uploads/2023/02/13/d363d44c37644faebd88b5d871837f07.jpg',
        '庄行老街庄行老街是奉贤区保存较好、富有江南水乡神韵的明清建筑一条街，东街汪家故居、李雪亭宅、褚泾庙旧址、油车弄刁家古宅、混堂弄何六其宅、王家宅等古建筑更是古声古色',
        2, 'admin', '2023-02-27 17:38:13');


drop table if exists comment;
create table comment
(
    id                     bigint(20) not null auto_increment comment 'ID',
    item_id                bigint(20) comment '项目ID',
    type                tinyint comment '类型',
    comment_user_id        bigint(20) comment '评论用户ID',
    comment_user_nick_name varchar(255) comment '评论用户',
    comment_user_avatar    varchar(255) comment '评论用户头像',
    target_user_id         bigint(20) comment '被评论用户ID',
    target_user_nick_name  varchar(255) comment '被评论用户',
    target_user_avatar     varchar(255) comment '被评论用户头像',
    content                varchar(255) comment '评论内容',
    create_date            datetime default now() comment '评论时间',
    recommend              tinyint  default 0 comment '是否精选',
    primary key (id)
) comment '评论信息表';


drop table if exists product;
create table product
(
    id          bigint unsigned not null auto_increment comment '商品表主键id',
    name        varchar(200)    not null default '' comment '商品名',
    cover       varchar(200)             default '' comment '商品主图',
    intro       varchar(200)    not null default '' comment '商品简介',
    price       double(8, 2)    not null default 1 comment '价格',
    status      tinyint         not null default 0 comment '商品上架状态（0：下架，1：上架）',
    create_time datetime                 default now() comment '创建时间',
    primary key (id)
) comment '商品表';
insert into sys_dict_type (dict_name, dict_type, create_time)
values ('商品上架状态', 'p_status', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('下架', '0', 'p_status', sysdate()),
       ('上架', '1', 'p_status', sysdate());






