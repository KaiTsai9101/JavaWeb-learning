package chapter1.test.controller;

import chapter1.test.pojo.PageResult;
import chapter1.test.pojo.Result;
import chapter1.test.pojo.Student;
import chapter1.test.pojo.StudentQueryParam;
import chapter1.test.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 分页查询
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("分页查询: {}", studentQueryParam);
        PageResult<Student> page = studentService.page(studentQueryParam);
        return Result.success(page);
    }

    // 批量删除学生信息
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除学生信息: {}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    // 添加学生信息
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("保存学生信息: {}", student);
        studentService.save(student);
        return Result.success();
    }

    // 查询学生信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询学生信息: {}", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    // 修改学生信息
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生信息: {}", student);
        studentService.updateById(student);
        return Result.success();
    }

    // 违规处理修改
    @PutMapping("/violation/{id}/{violationScore}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Integer violationScore) {
        log.info("修改学生信息: {}, {}", id, violationScore);
        studentService.updateViolation(id, violationScore);
        return Result.success();
    }


}
