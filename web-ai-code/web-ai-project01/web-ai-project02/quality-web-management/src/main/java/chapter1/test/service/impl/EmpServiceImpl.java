package chapter1.test.service.impl;

import chapter1.test.mapper.EmpMapper;
import chapter1.test.pojo.Emp;
import chapter1.test.pojo.PageResult;
import chapter1.test.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    // 原始分页查询
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        // 调用Mapper接口，查询总记录
//        Long total = empMapper.count();
//
//        // 调用Mapper接口，查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//
//        return new PageResult<Emp>(total, rows);
//    }

    // pagehelper分页查询
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 执行查询操作
        List<Emp> empList = empMapper.list();

        // Page<T> extends ArrayList<T>, ArrayList<T> implements List<T>
        // 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}
