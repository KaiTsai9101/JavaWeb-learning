package test.chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 测试类
public class UserServiceTest {

    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("100000200010011011");
        System.out.println(age);
    }

    @Test
    public void testGetGender(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        System.out.println(gender);
    }

    // 断言
    @Test
    public void testGetGenderWithAssert(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000200010011011");
        Assertions.assertEquals("男", gender, "性别获取错误");
    }

    @Test
    public void testGetGenderWithAssert2(){
        UserService userService = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           userService.getGender(null);
        });
    }
}
