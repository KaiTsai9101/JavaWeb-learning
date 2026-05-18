package chapter1.test.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClazzQueryParam {
    private Integer page = 1;       // 页码
    private Integer pageSize = 10;      // 每页展示记录数
    private Integer id; //ID
    private String name;        // 姓名
    private String room;     // 班级教室
    private String masterName;      //班主任姓名
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate beginDate;        // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate endDate;        // 创建时间
    private String status;      //班级状态 - 未开班 , 在读 , 已结课
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH-mm-ss") private LocalDateTime updateTime;          // 修改时间
}
