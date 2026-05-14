package chapter1.test.mapper;

import chapter1.test.pojo.Clazz;
import chapter1.test.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    // 条件分页查询班级列表
    List<Clazz> page(ClazzQueryParam clazzQueryParam);

    // 批量删除班级
    void deleteByIds(List<Integer> ids);

    // 添加班级
    @Options(useGeneratedKeys = true, keyProperty = "id")   // Mybatis提供的主键返回
    void insert(Clazz clazz);

    // 根据ID查询班级
    @Select("select c.*, e.name masterName from clazz c left join emp e on master_id = e.id where c.id = #{id}")
    Clazz getInfo(Integer id);

    // 根据ID修改班级信息
    void updateById(Clazz clazz);

    // 查询所有班级信息
    @Select("select * from clazz")
    List<Clazz> list();
}