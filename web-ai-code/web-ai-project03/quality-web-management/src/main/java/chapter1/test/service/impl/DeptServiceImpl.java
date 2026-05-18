package chapter1.test.service.impl;

import chapter1.test.mapper.DeptMapper;
import chapter1.test.pojo.Dept;
import chapter1.test.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// Service：业务处理
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        // 补全基础属性（前端只给了部门名，这里需要补全创建时间和更新时间）
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        // 调用Mapper
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        // 补全更新时间
        dept.setUpdateTime(LocalDateTime.now());

        // 调用Mapper
        deptMapper.update(dept);
    }
}
