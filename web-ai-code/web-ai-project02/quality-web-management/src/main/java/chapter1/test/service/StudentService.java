package chapter1.test.service;

import chapter1.test.pojo.PageResult;
import chapter1.test.pojo.Student;
import chapter1.test.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    // 分页查询学生列表
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    // 批量删除学生信息
    void deleteByIds(List<Integer> ids);

    // 添加学生信息
    void save(Student student);

    // 根据ID查询学生信息
    Student getInfo(Integer id);

    // 修改学生信息
    void updateById(Student student);

    // 违规处理修改
    void updateViolation(Integer id, Integer violationScore);
}
