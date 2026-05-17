package chapter1.test.service;

import chapter1.test.pojo.Clazz;
import chapter1.test.pojo.ClazzQueryParam;
import chapter1.test.pojo.PageResult;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClazzService {

    // 分页查询班级列表
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    // 删除班级
    void delete(List<Integer> ids);

    // 保存班级
    void save(Clazz clazz);

    // 根据ID查询班级信息
    Clazz getInfo(Integer id);

    // 修改班级信息
    void updateById(Clazz clazz);

    // 查询所有班级信息
    List<Clazz> list();
}
