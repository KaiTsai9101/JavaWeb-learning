package chapter1.test.service;

import chapter1.test.pojo.Emp;
import chapter1.test.pojo.EmpQueryParam;
import chapter1.test.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
}
