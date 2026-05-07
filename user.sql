-- 显示所有数据库
show databases;

-- 切换数据库
use db01;

-- 查询当前正在使用的数据库
select database();

-- 创建数据库
create database db02;

-- 删除数据库
drop database db02;

-- 创建 emp 表
create table emp (
    id int unsigned primary key auto_increment comment 'ID，主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 1.男；2.女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位, 1.班主任；2.讲师；3.学工主管；4.教研主管；5.咨询师',
    salary int unsigned comment '薪资',
    entry_date date comment '入职时间',
    image varchar(255) comment '图像',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment = '员工表';

-- 查询当前数据库的所有表
show tables;

-- 查看表结构
desc emp;       -- describe emp;

-- 查询创建表语句
show create table emp;

-- 字段：添加字段 qq varchar(13)
alter table emp add column qq varchar(13);

-- 字段：修改字段 qq 的属性为 varchar(15)
alter table emp modify qq varchar(15);

-- 字段：修改字段 qq 的名称为 qq_num
alter table emp change qq qq_num varchar(15);

-- 字段：删除字段 qq_num
alter table emp drop column qq_num;

-- 修改表名
alter table emp rename to employee;

-- 删除表
drop table employee;

-- 为 emp 表的 username, password, name, gender, phone 字段插入值
insert into emp (username, password , name, gender, phone) values ('admin', '123456', '管理员', 1, '13888888888');

-- 为 emp 表的所有字段插入值
insert into emp values (null, 'admin1', '123456', '管理员', 1, '13888888889', 1, 5000, '2019-01-01', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1819072631,1192867115&fm=26&gp=0.jpg', now(), now());

select * from emp;