package chapter1.test.service.impl;

import chapter1.test.mapper.EmpExprMapper;
import chapter1.test.mapper.EmpMapper;
import chapter1.test.pojo.*;
import chapter1.test.service.EmpLogService;
import chapter1.test.service.EmpService;
import chapter1.test.utils.JwtUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;
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
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 执行查询操作
        List<Emp> empList = empMapper.page(empQueryParam);

        // Page<T> extends ArrayList<T>, ArrayList<T> implements List<T>
        // 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})  // 事务管理 - 默认出现运行时异常RuntimeException时，回滚事务
    @Override
    public void save(Emp emp) {
        try {
            // 保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            // 保存员工工作经历信息
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)){
                // 遍历集合，为empId赋值
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工：" + emp);
            empLogService.insertLog(empLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        // 批量删除员工基本信息
        empMapper.deleteByIds(ids);

        // 批量删除员工工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        // 根据ID修改员工信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateByID(emp);

        // 根据ID修改员工工作经历信息
        // 先根据员工ID删除原有的工作经历信息
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        // 再添加这个员工新的工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    // 查询所有员工列表
    @Override
    public List<Emp> listAll(Emp emp) {
        return empMapper.listAll(emp);
    }

    // 登录
    @Override
    public LoginInfo login(Emp emp) {
        // 调用mapper接口，根据用户名和密码查询员工信息
        Emp e = empMapper.selectByUsernameAndPassword(emp);

        // 判断是否存在这个员工，如果存在，则返回登录信息
        if (e != null){
            log.info("登录成功，员工信息: {}", e);

            // 生成JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String token = JwtUtils.generateToken(claims);

            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), token);
        }

        // 不存在，则返回null
        return null;
    }
}
