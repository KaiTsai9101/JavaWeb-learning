package chapter1.test.mapper;

import chapter1.test.pojo.Emp;
import chapter1.test.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
// 操控员工信息的Mapper
public interface EmpMapper {

//    // 查询总记录
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//    // 分页查询
//    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start}, #{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);
    // 使用pagehelper分页查询
    // @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    // public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    // 条件查询员工信息
    public List<Emp> page(EmpQueryParam empQueryParam);

    // 新增员工基本信息
    @Options(useGeneratedKeys = true, keyProperty = "id")   // Mybatis提供的主键返回
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    // 根据ID批量删除员工信息
    void deleteByIds(List<Integer> ids);

    // 根据ID查询员工信息以及员工的工作经历信息
    Emp getById(Integer id);

    // 根据ID修改员工信息
    void updateByID(Emp emp);

    // 统计员工职位人数
    @MapKey("pos")      // Mybatis误报错误，此注解可不加
    List<Map<String, Object>> countEmpJobData();

    // 统计员工性别人数
    @MapKey("gender")
    List<Map<String, Object>> countEmpGenderData();

    // 查询所有员工（不分页）
    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
    List<Emp> listAll(Emp emp);

    // 登录
    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
