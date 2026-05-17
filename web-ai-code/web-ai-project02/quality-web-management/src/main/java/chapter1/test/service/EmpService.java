package chapter1.test.service;

import chapter1.test.pojo.Emp;
import chapter1.test.pojo.EmpQueryParam;
import chapter1.test.pojo.LoginInfo;
import chapter1.test.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /*
        分页查询
        page：当前页码
        pageSize：每页显示记录数
     */
    // PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    // 新增员工信息
    void save(Emp emp);

    // 批量删除员工信息
    void delete(List<Integer> ids);

    // 根据ID查询员工信息
    Emp getInfo(Integer id);

    // 修改员工信息
    void update(Emp emp);

    // 查询所有员工信息
    List<Emp> listAll(Emp emp);

    // 登录
    LoginInfo login(Emp emp);
}
