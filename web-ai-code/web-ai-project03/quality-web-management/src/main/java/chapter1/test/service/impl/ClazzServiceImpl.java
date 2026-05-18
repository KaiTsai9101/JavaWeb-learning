package chapter1.test.service.impl;

import chapter1.test.mapper.ClazzMapper;
import chapter1.test.pojo.Clazz;
import chapter1.test.pojo.ClazzQueryParam;
import chapter1.test.pojo.PageResult;
import chapter1.test.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    // 分页查询班级列表
    @Override
//    @LogOperation
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        // 设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        // 执行查询操作
        List<Clazz> clazzList = clazzMapper.page(clazzQueryParam);

        // 计算班级状态
        LocalDate now = LocalDate.now();
        clazzList.forEach(clazz -> {
            if (now.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else if (now.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读中");
            }
        });

        // 如果指定了状态筛选条件，进行过滤
        String statusFilter = clazzQueryParam.getStatus();
        if (statusFilter != null && !statusFilter.isEmpty()) {
            clazzList = clazzList.stream()
                    .filter(clazz -> statusFilter.equals(clazz.getStatus()))
                    .collect(Collectors.toList());
        }

        // 解析查询结果，并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    // 批量删除班级
    @Override
    public void delete(List<Integer> ids) {
        // 批量删除班级基本信息
        clazzMapper.deleteByIds(ids);
    }

    // 保存班级
    @Override
    public void save(Clazz clazz) {
        // 保存班级基本信息
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    // 根据ID查询班级信息
    @Override
    public Clazz getInfo(Integer id) {
        Clazz clazz = clazzMapper.getInfo(id);

        // 计算班级状态
        LocalDate now = LocalDate.now();
        if (now.isAfter(clazz.getEndDate())) {
            clazz.setStatus("已结课");
        } else if (now.isBefore(clazz.getBeginDate())) {
            clazz.setStatus("未开班");
        } else {
            clazz.setStatus("在读中");
        }

        return clazz;
    }

    // 修改班级
    @Override
    public void updateById(Clazz clazz) {
        // 修改班级信息
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    // 查询班级列表
    @Override
    public List<Clazz> list() {
        List<Clazz> clazzList = clazzMapper.list();
        return clazzList;
    }
}