package chapter1.test;

import chapter1.test.mapper.UserMapper;
import chapter1.test.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest     // SpringBoot测试类 - 当前测试类中的测试方法运行时，会启动springboot项目 - IOC容器
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired      // DI 注入
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(5);
        System.out.println("执行完毕，影响的记录数：" + i);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "user1", "123456", "张三", 20);
        userMapper.insert(user);
    }

    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("user3", "123456");
        System.out.println(user);
    }
}
