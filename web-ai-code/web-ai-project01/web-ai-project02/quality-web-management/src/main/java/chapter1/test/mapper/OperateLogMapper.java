package chapter1.test.mapper;

import chapter1.test.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    // 插入日志数据
    @Insert("insert into operate_log(operate_emp_id, operate_time, class_name, method_name, method_param, return_value, cost_time) " +
            "values(#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParam}, #{returnValue}, #{costTime})")
    public void insert(OperateLog operateLog);
}
