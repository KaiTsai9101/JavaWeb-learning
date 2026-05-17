package chapter1.test.service;

import chapter1.test.pojo.ClazzCount;
import chapter1.test.pojo.JobOption;
import chapter1.test.pojo.Student;

import java.util.List;
import java.util.Map;

public interface ReportService {
    // 统计员工职位人数
    JobOption getEmpJobData();

    // 统计员工性别人数
    List<Map<String, Object>> getEmpGenderData();

    // 统计员工学历数
    List<Map<String, Object>> getStudentDegreeData();

    // 统计员工学历人数
    ClazzCount getStudentCountData();
}
