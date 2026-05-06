package chapter1.test.controller;

import chapter1.test.pojo.User;
import chapter1.test.service.UserService;
import chapter1.test.service.impl.UserServiceImpl;
import cn.hutool.core.io.IoUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    /*
    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        // 加载并读取user.txt文件，获取用户数据
        // 通过获取 该类字节码对象 -> 该类加载器 -> 获取文件的输入流（getResource表示获取该类的资源文件的URL对象加AsStream则获得指定URI输入流对象）
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

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

        // 返回数据(json)
        return userList;
    }
     */
    // 方式一: 属性注入（优点：代码简洁，方便快速开发；缺点：隐藏了类之间的依赖关系、可能破坏类的封装性）
    // @Autowired  // 应用程序运行时，会自动查询该类型的bean对象，并将bean对象赋值给该属性
    // private UserService userService;

    // 方式二: 构造方法注入（优点：能清晰地看到类的依赖关系，提高了代码的安全性；缺点：代码繁琐、如果构造参数过多，可能导致构造函数臃肿）
    // private final UserService userService;
    // @Autowired   // 如果只有一个构造函数（一般也只有一个），则@Autowired可以省略
    // public UserController(UserService userService) {
    //     this.userService = userService;
    // }

    // 方式三: setter方法注入（优点：保证了类的封装性，依赖关系更清晰；缺点：需要额外编写setter方法，增加代码量）
//    private UserService userService;
//    @Autowired
//    // @Qualifier("userServiceImpl")
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    private UserService userService;
    @Resource(name = "userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        // 调用service，获取数据
        List<User> userList = userService.findAll();

        // 返回数据(json)
        return userList;
    }
}
