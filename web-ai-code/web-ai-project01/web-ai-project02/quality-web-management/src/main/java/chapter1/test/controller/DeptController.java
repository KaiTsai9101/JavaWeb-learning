package chapter1.test.controller;

import chapter1.test.anno.Log;
import chapter1.test.pojo.Dept;
import chapter1.test.pojo.Result;
import chapter1.test.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
// 公共前缀：/depts
@RequestMapping("/depts")
// Controller：接收请求，处理响应
@RestController
public class DeptController {

    // private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts", method = RequestMethod.GET)   // method: 指定请求方式
    @GetMapping// ("/depts")（因为有公共前缀了，这里可以省略） // 等价于@RequestMapping(value = "/depts", method = RequestMethod.GET)
    public Result list(){
        // System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    // 删除部门 - 方式一：使用HttpServletRequest
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) {
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("删除部门：" + id);
//        return Result.success();
//    }

//    // 删除部门 - 方式二：使用@RequestParam
//    // 一旦声明@RequestParam注解，该参数在请求时必须传递，否则会报错（默认 required 为 true）
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
//        System.out.println("删除部门：" + deptId);
//        return Result.success();
//    }

    // 删除部门 - 方式三：省略@RequestParam（前端传递的请求参数名与服务端方法形参名一致）
    @Log
    @DeleteMapping
    public Result delete(Integer id) {
        // System.out.println("删除部门：" + id);
        log.info("删除部门：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    // 新增部门
    // 这里需要在请求体中添加JSON数据，所以需要使用@RequestBody注解
    // 传json数据时，json的键需要和Dept对象中的属性名一致才能成功封装
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {     // @RequestBody：将请求体中的数据映射为Dept对象
        // System.out.println("新增部门：" + dept);
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    // 根据ID查询部门数据
    // 如果路径参数的参数名与方法形参名一致，则路径参数可以省略
    @GetMapping("/{id}")
    // public Result getInfo(@PathVariable Integer id) {
    public Result getInfo(@PathVariable("id") Integer id) {
        // System.out.println("根据ID查询部门：" +  id);
        log.info("根据ID查询部门：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        // System.out.println("修改部门：" + dept);
        log.info("修改部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
