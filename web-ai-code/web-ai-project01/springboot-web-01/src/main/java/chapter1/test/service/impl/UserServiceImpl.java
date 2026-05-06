package chapter1.test.service.impl;

import chapter1.test.dao.UserDao;
import chapter1.test.pojo.User;
import chapter1.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service  // 将当前类交给IOC容器管理
public class UserServiceImpl implements UserService {

    @Autowired  // 应用程序运行时，会自动查询该类型的bean对象，并将bean对象赋值给该属性
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        // 调用dao，获取数据
        List<String> lines = userDao.findAll();

        // 解析用户信息，封装为User对象 -> list集合
        List<User> userList = lines.stream().map(line -> {
            String[] split = line.split(",");
            Integer id = Integer.parseInt(split[0]);        // 将数组中的字符串转为int
            String username = split[1];
            String password = split[2];
            String name = split[3];
            Integer age = Integer.parseInt(split[4]);       // 将数组中的字符串转为int
            LocalDateTime updateTime = LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);         // 因为User中已经写了@AllArgsConstructor，所以这里可以直接写参数
        }).toList();        // 转换为list集合

        return userList;
    }
}
