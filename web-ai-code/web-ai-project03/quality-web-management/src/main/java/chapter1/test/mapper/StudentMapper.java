package chapter1.test.mapper;

import chapter1.test.pojo.Student;
import chapter1.test.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    // 分页查询
    List<Student> page(StudentQueryParam studentQueryParam);

    // 批量删除学生信息
    void deleteByIds(List<Integer> ids);

    // 添加学生信息
    void save(Student student);

    // 查询学生信息
    @Select("select s.*, c.name clazzName from student s left join clazz c on s.clazz_id = c.id where s.id = #{id}")
    Student getInfo(Integer id);

    // 修改学生信息
    void updateById(Student student);

    // 统计学生学历人数
    @MapKey("degree")
    List<Map<String, Object>> countStudentDegreeData();

    // 统计学生信息
    @MapKey("clazzList")
    List<Map<String, Object>> countStudentData();
}
