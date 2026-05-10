package chapter1.test.service;

import chapter1.test.pojo.Emp;
import chapter1.test.pojo.PageResult;

public interface EmpService {
    /*
        分页查询
        page：当前页码
        pageSize：每页显示记录数
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}
