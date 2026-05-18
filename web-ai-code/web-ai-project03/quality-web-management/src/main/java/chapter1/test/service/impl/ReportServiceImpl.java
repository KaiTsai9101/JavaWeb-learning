package chapter1.test.service.impl;

import chapter1.test.mapper.EmpMapper;
import chapter1.test.mapper.StudentMapper;
import chapter1.test.pojo.ClazzCount;
import chapter1.test.pojo.JobOption;
import chapter1.test.pojo.Student;
import chapter1.test.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    // 统计员工职位人数
    @Override
    public JobOption getEmpJobData() {
        // 调用Mapper接口，获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();   // map: String(pos=教研主管), Object(num=5)

        // 组装结果，并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    // 统计员工性别人数
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    // 统计员工学历人数
    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    // 统计学生学历人数
    @Override
    public ClazzCount getStudentCountData() {
        List<Map<String, Object>> maps = studentMapper.countStudentData();
        List<Object> clazzList = maps.stream().map(map -> map.get("clazzList")).toList();
        List<Object> dataList = maps.stream().map(map -> map.get("dataList")).toList();
        return new ClazzCount(clazzList, dataList);
    }
}
