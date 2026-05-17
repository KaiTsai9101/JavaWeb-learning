package chapter1.test.mapper;

import chapter1.test.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

// Mapper/Dao：数据访问操作（增删改查）
@Mapper
public interface DeptMapper {

    // 当数据库列名与属性名不一致时，请求数据时会找不到属性
    // 方式一：使用@Results注解
    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    // 查询所有部门数据

    // 方式二：为字段起别名
    // @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc;")

    // 方式三：开启驼峰命名开关（数据库字段名和类属性名会根据驼峰命名匹配）在application.yml中开启
    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    List<Dept> findAll();

    // 根据ID删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    // 新增部门
    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    // 根据ID查询部门
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    // 修改部门
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
