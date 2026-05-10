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

create database quality;

use quality;

create table dept (
    id int unsigned primary key auto_increment comment 'ID, 主键',
    name varchar(10) not null unique comment '部门名称',
    create_time datetime default null comment '创建时间',
    update_time datetime default null comment '修改时间'
) comment '部门表';

insert into dept values
(1, '学工部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
(2, '教研部', '2024-09-25 09:47:40', '2024-09-09 15:17:04'),
(3, '咨询部', '2024-09-25 09:47:40', '2024-09-30 21:26:24'),
(4, '就业部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
(5, '人事部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
(6, '行政部', '2024-11-30 20:56:37', '2024-09-30 20:56:37');

-- 查询全部部门
select id, name, create_time, update_time from dept order by update_time desc;

-- 根据ID更新部门数据
update dept set name = '', dept.update_time = '' where id = '';

-- 员工表
create table emp(
    id int unsigned primary key auto_increment comment 'ID, 主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 1:男, 2:女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位, 1 班主任, 2 讲师, 3 学工主管, 4 校验主管, 5 咨询师',
    salary int unsigned comment '薪资',
    image varchar(255) comment '头像',
    entry_date date comment '入职日期',
    dept_id int unsigned comment '部门ID',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';

insert into emp values
(1, 'zhangsan', '123456', '张三', 1, '13309090001', 4, 15000, 'F:/javaweb-learning/img/1.gif', '2000-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(2, 'lisi', '123456', '李四', 2, '13309090002', 2, 8600, 'F:/javaweb-learning/img/1.png', '2015-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(3, 'wangwu', '123456', '王五', 1, '13309090003', 2, 8900, 'F:/javaweb-learning/img/1.gif', '2008-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(4, 'zhaoliu', '123456', '赵六', 2, '13309090004', 2, 9200, 'F:/javaweb-learning/img/1.png', '2007-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(5, 'sunqi', '123456', '孙七', 1, '13309090005', 3, 9500, 'F:/javaweb-learning/img/1.gif', '2012-12-05', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(6, 'zhangsan2', '123456', '张三2', 1, '13309090006', 4, 15000, 'F:/javaweb-learning/img/1.gif', '2000-01-01', NULL, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(7, 'lisi2', '123456', '李四2', 2, '13309090007', 2, 8600, 'F:/javaweb-learning/img/1.png', '2015-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(8, 'wangwu2', '123456', '王五2', 1, '13309090008', 2, 8900, 'F:/javaweb-learning/img/1.gif', '2008-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(9, 'zhaoliu2', '123456', '赵六2', 2, '13309090009', 2, 9200, 'F:/javaweb-learning/img/1.png', '2007-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(10, 'sunqi2', '123456', '孙七2', 1, '13309090010', 3, 9500, 'F:/javaweb-learning/img/1.gif', '2012-12-05', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(11, 'zhangsan3', '123456', '张三3', 1, '13309090011', 4, 15000, 'F:/javaweb-learning/img/1.gif', '2000-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(12, 'lisi3', '123456', '李四3', 2, '13309090012', 2, 8600, 'F:/javaweb-learning/img/1.png', '2015-01-01', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(13, 'wangwu3', '123456', '王五3', 1, '13309090013', 2, 8900, 'F:/javaweb-learning/img/1.gif', '2008-05-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(14, 'zhaoliu3', '123456', '赵六3', 2, '13309090014', 2, 9200, 'F:/javaweb-learning/img/1.png', '2007-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(15, 'sunqi3', '123456', '孙七3', 1, '13309090015', 3, 9500, 'F:/javaweb-learning/img/1.gif', '2012-12-05', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(16, 'zhangsan4', '123456', '张三4', 1, '13309090016', 4, 15000, 'F:/javaweb-learning/img/1.gif', '2000-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(17, 'lisi4', '123456', '李四4', 2, '13309090017', 2, 8600, 'F:/javaweb-learning/img/1.png', '2015-01-01', 4, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(18, 'wangwu4', '123456', '王五4', 1, '13309090018', 2, 8900, 'F:/javaweb-learning/img/1.gif', '2008-05-01', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(19, 'zhaoliu4', '123456', '赵六4', 2, '13309090019', 2, 9200, 'F:/javaweb-learning/img/1.png', '2007-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(20, 'sunqi4', '123456', '孙七4', 1, '13309090020', 3, 9500, 'F:/javaweb-learning/img/1.gif', '2012-12-05', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33');

create table emp_expr(
    id int unsigned primary key auto_increment comment 'ID, 主键',
    emp_id int unsigned comment '员工ID',
    begin date comment '开始时间',
    end date comment '结束时间',
    company varchar(50) comment '公司名称',
    job varchar(50) comment '职位'
) comment '工作经历';

-- 查询所有员工信息，以及该员工归属的部门名称
select e.*, d.name from emp e left join dept d on e.dept_id = d.id;

-- 查询第1页，每页展示5条数据
select e.*, d.name from emp e left join dept d on e.dept_id = d.id limit 5;

-- 查询第2页，每页展示5条数据
select e.*, d.name from emp e left join dept d on e.dept_id = d.id limit 5, 5;