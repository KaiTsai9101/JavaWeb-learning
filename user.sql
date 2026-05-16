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

INSERT INTO student VALUES (1,'张三66','2022000001',1,'18800000001','110120000300200001',1,'这是一个地址1号',1,'2021-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-15 16:20:59'),
                           (2,'李四66','2022000002',1,'18800210003','110120000300200002',1,'这是一个地址2号',2,'2022-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (3,'王五66','2022000003',1,'18800013001','110120000300200003',1,'这是一个地址3号',2,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (4,'赵六66','2022000004',1,'18800003211','110120000300200004',1,'这是一个地址4号',3,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (5,'孙七66','2022000005',2,'18800160002','110120000300200005',1,'这是一个地址5号',4,'2020-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (6,'张三77','2022000006',2,'18800000034','110120000300200006',1,'这是一个地址6号',4,'2021-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (7,'李四77','2022000007',1,'18800000067','110120000300200007',1,'这是一个地址7号',4,'2022-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (8,'王五77','2022000008',2,'18800000077','110120000300200008',1,'这是一个地址8号',5,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (9,'赵六77','2022000009',1,'18800000341','110120000300200009',1,'这是一个地址9号',3,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (10,'孙七77','2022000010',1,'18800006571','110120000300200010',1,'这是一个地址10号',2,'2020-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (11,'张三88','2022000011',1,'18800000391','110120000300200011',1,'这是一个地址11号',4,'2021-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:24'),
                           (12,'李四88','2022000012',1,'18800000781','110120000300200018',1,'这是一个地址12号',4,'2022-07-05',3,6,17,'2024-11-14 21:22:19','2024-12-13 14:33:58'),
                           (13,'王五88','2022000013',1,'18800008901','110120000300200013',1,'这是一个地址13号',4,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:21'),
                           (14,'赵六88','2022000014',2,'18800009201','110120000300200014',1,'这是一个地址14号',4,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:17'),
                           (15,'孙七88','2022000015',1,'18800009401','110120000300200015',1,'这是一个地址15号',3,'2020-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (16,'张三99','2022000016',1,'18800008501','110120000300200016',1,'这是一个地址16号',4,'2021-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (17,'李四99','2022000017',2,'18800007601','110120000300200017',1,'这是一个地址17号',2,'2022-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),
                           (18,'王五99','2024001101',1,'13309092345','110110110110110110',0,'这是一个地址18号',5,'2021-07-01',3,2,7,'2024-11-15 16:26:18','2024-11-15 16:40:10');

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

-- 条件查询
select e.*, d.name from emp e left join dept d on e.dept_id = d.id
                   where e.name like concat('%', '张', '%') and e.gender = 1 and e.entry_date between '2000-01-01' and '2020-01-01'
                   order by e.update_time desc;

-- 创建员工日志表
create table emp_log(
    id int unsigned primary key auto_increment comment 'ID, 主键',
    operate_time datetime comment '操作时间',
    info varchar(2000) comment '日志信息'
) comment '员工日志表';

-- 绑定外键
alter table student add constraint fk_clazz_id foreign key (clazz_id) references clazz(id);

alter table clazz add constraint fk_master_id foreign key (master_id) references emp(id);

INSERT INTO quality.clazz (id, name, room, begin_date, end_date, master_id, subject, create_time, update_time) VALUES (6, 'JavaEE就业167期', '325', '2026-11-20', '2026-05-10', 24, 1, '2024-11-15 11:35:46', '2024-12-13 14:31:24');

select c.*, e.name masterName
from clazz c
         left join emp e on c.master_id = e.id
where c.id = 1;


INSERT INTO quality.student (id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) VALUES (16, '张三99', '2022000016', 1, '18800008501', '110120000300200016', 1, '这是一个地址16号', 4, '2021-07-01', 4, 0, 0, '2024-11-14 21:22:19', '2024-11-14 21:22:19');
INSERT INTO quality.student (id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) VALUES (17, '李四99', '2022000017', 2, '18800007601', '110120000300200017', 1, '这是一个地址17号', 2, '2022-07-01', 4, 0, 0, '2024-11-14 21:22:19', '2024-11-14 21:22:19');
INSERT INTO quality.student (id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) VALUES (18, '王五99', '2024001101', 1, '13309092345', '110110110110110110', 0, '这是一个地址18号', 5, '2021-07-01', 3, 2, 7, '2024-11-15 16:26:18', '2024-11-15 16:40:10');

-- 操作日志表
create table operate_log(
    id int unsigned primary key auto_increment comment 'ID',
    operate_emp_id int unsigned comment '操作人ID',
    operate_time datetime comment '操作时间',
    class_name varchar(100) comment '操作的类名',
    method_name varchar(100) comment '操作的方法名',
    method_param varchar(2000) comment '方法参数',
    return_value varchar(2000) comment '返回值',
    cost_time bigint unsigned comment '方法执行耗时，单位：ms'
) comment '操作日志表';