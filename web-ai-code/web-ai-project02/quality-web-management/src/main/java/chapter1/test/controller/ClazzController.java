package chapter1.test.controller;

import chapter1.test.pojo.Clazz;
import chapter1.test.pojo.ClazzQueryParam;
import chapter1.test.pojo.PageResult;
import chapter1.test.pojo.Result;
import chapter1.test.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzes")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    // 分页查询班级列表
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询班级: {}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    // 删除班级
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除班级: {}", ids);
        clazzService.delete(ids);
        return Result.success();
    }

    // 保存班级信息
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("保存班级: {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    // 修改班级信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询班级: {}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    // 修改班级信息
    @PutMapping
    public Result updateById(@RequestBody Clazz clazz) {
        log.info("修改班级: {}", clazz);
        clazzService.updateById(clazz);
        return Result.success();
    }

    // 查询所有班级列表
    @GetMapping("/list")
    public Result list() {
        log.info("查询所有班级列表");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }
}
