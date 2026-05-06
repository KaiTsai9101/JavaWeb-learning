package chapter1.test.dao.impl;

import chapter1.test.dao.UserDao;
import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository  // 将当前类交给IOC容器管理
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        // 加载并读取user.txt文件，获取用户数据
        // 通过获取 该类字节码对象 -> 该类加载器 -> 获取文件的输入流（getResource表示获取该类的资源文件的URL对象加AsStream则获得指定URI输入流对象）
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
