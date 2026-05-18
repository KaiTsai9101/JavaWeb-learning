package chapter1.test.service.impl;

import chapter1.test.mapper.StudentMapper;
import chapter1.test.pojo.PageResult;
import chapter1.test.pojo.Student;
import chapter1.test.pojo.StudentQueryParam;
import chapter1.test.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    // 分页查询
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        // 分页查询
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        // 执行查询操作
        List<Student> studentList = studentMapper.page(studentQueryParam);
        // 解析查询结果，并封装
        Page<Student> p = (Page<Student>) studentList;
        // 返回结果
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    // 批量删除学生信息
    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    // 添加学生信息
    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.save(student);
    }

    // 根据ID查询学生信息
    @Override
    public Student getInfo(Integer id) {
        Student student = studentMapper.getInfo(id);
        return student;
    }

    // 修改学生信息
    @Override
    public void updateById(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }

    @Override
    public void updateViolation(Integer id, Integer violationScore) {
        Student student = studentMapper.getInfo(id);
        student.setViolationScore((short) (student.getViolationScore() + violationScore));
        student.setViolationCount((short) (student.getViolationCount() + 1));
        studentMapper.updateById(student);
    }
}
