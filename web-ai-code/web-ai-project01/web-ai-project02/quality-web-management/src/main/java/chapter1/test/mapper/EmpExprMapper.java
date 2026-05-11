package chapter1.test.mapper;

import chapter1.test.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    // 批量插入员工工作经历信息
    void insertBatch(List<EmpExpr> exprList);
}
