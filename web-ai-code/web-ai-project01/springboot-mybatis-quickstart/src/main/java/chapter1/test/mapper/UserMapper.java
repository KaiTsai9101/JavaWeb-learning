package chapter1.test.mapper;

import chapter1.test.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper     // 应用程序在运行时，会自动的为该接口创建一个实现类对象，并自动将该实现类对象存入IOC容器成为IOC容器的bean对象交给Spring管理
public interface UserMapper {

    // @Select("select * from user")
    public List<User> findAll();        // 因为别的模块里也有User类，所以这里报错，可忽略

    @Delete("delete from user where id = #{id}")
    // public void deleteById(Integer id);
    public Integer deleteById(Integer id);

    @Insert("insert into user(username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
    public void insert(User user);

    // 当查询两个参数时，需要使用@Param注解，#{}中的参数名称必须与@Param注解中指定的名称一致
    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
